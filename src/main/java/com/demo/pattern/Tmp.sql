concat(substr('{yyyymmdd}',1,4),'-',substr('${yyyymmdd}',5,2),'-',substr('${yyyymmdd}',7,2), ' 00:00:00')
concat(substr('{yyyymmdd}',1,4),'-',substr('${yyyymmdd}',5,2),'-',substr('${yyyymmdd}',7,2), ' 00:00:00')

--短信相关业务的理解及中间表制作
--1）短信常见分类（两类：验证与营销，通道(发送账号)没有细分 只有根据文案去分）
--2）receivestatus  短信返回码，可以分析短信异常情况，null后续林聪处理，上线补丁
--3）短信发送流程 是  业务方调用客户端 --> 珍爱的短信服务(网关) --> 第三方短信集成商网关 --> 具体运营商总网关 --> 运营商各省网关  --> 基站 --> 用户手机
-- 运营商各省网关     这个环节都属于 地方网关  报备 是在  --> 第三方短信集成商网关 -->  这个环节做的事情
drop table if exists tmp.dwd_sms_common_d_tmp00_${yyyymmdd};
create table if not exists tmp.dwd_sms_common_d_tmp00_${yyyymmdd}
as
select
    id
    ,date_format(sendtime,'yyyyMMdd') senddate
    ,t1.account
    ,t3.remark
    ,t3.tag
    ,t3.businesstype
    ,channeltag
    ,memberid
    ,t1.phone
    ,content
    ,case when content like '%验证码%' then '验证码类'
          when content like '%百万话费%' then '续费送话费短信'
          when content like '%刚刚给你发了封邮件%' then '信使短信'
          when content like '%您的珍心会员服务将于7天后到期%' then 'pc续费唤回短信'
          when content like '%苹果支付遇到困难%' then 'iOS支付唤回'
          when content like '%支付遇到问题%'
            or content like '%尊享珍心会员2.7折特惠，机不可失%'
            or content like '%往前一步即幸福%'
            then 'IOS五次未下单短信唤回'
          when content like '%附近有3位会员对你很感兴趣，你们匹配度达87%%'
            or content like '%附近3位会员对你很感兴趣，你们匹配度达87%%'
            or content like '%好久不见，最近有几位附近的%喜欢了你，快点击%'
            or content like '%你好，我也在%工作，平时爱好%，离你很近，可以聊聊吗？点击%'
            then '注册当天导量短信'
          when content like '%在吗？我觉得我们很合适，但你怎么还不回复我的消息呢？%' then '注册第三天导量短信'
          when content like '%快去给TA回信吧，不要让TA等太久哦%' or content like '%TA似乎对你感兴趣哦！快去看看吧，别让缘分溜走%' then '新注册短信运营短信'
          when content like '%茫茫人海不知何处寻找，线下牵线帮你忙。资深红娘老师一对一服务，海量优质会员供你匹配，高端专场活动等你报名%' then '到店导量测试短信'
          else '其他短信' end smstype
    ,sendcount
    ,t1.sendstatus
    ,sendtime
    ,t1.smsid
    ,t2.statustime  receivetime
    ,t2.sendstatus receivestatus
    ,case when t2.smsid is not null and t2.sendstatus='DELIVRD' then 1 else 0 end istouch
    ,case when t2.smsid is not null and t2.sendstatus='DELIVRD' then unix_timestamp(t2.statustime) - unix_timestamp(sendtime) else 0 end time_diff
from
(
     select
          id
          ,account
          ,channeltag
          ,memberid
          ,phone
          ,content
          ,sendcount
          ,sendstatus
          ,sendtime
          ,smsid  --不唯一
      from common_ods.ods_sms_log_d
     where data_date = ${yyyymmdd}
) t1
left join
(
     select
         smsid
         ,phone
         ,statustime
         ,sendstatus  --0076短信没有报备  1241运营商通道问题
     from common_ods.ods_sms_status_log_d
    where data_date = ${yyyymmdd}
) t2
on t1.smsid=t2.smsid and t1.phone=t2.phone
left join(
    select
          account
          ,remark
          ,tag
          ,businesstype
     from common_dim.dim_sms_account
) t3
on t1.account=t3.account
;

--总体重新分类（保留部分历史分类）
drop table if exists tmp.dwd_sms_common_d_tmp01_${yyyymmdd};
create table if not exists tmp.dwd_sms_common_d_tmp01_${yyyymmdd}
as
select *
    ,case when (businesstype='珍爱网' and account='zhenai_youlian') then '珍爱网【优恋空间】'
        when (businesstype='珍爱网' and account in ('zhenai_sweet','zhenai_sweet_verify')) then '珍爱网【甜蜜约会】'
        when (businesstype='珍爱网' and account='zhenai_crm' and content rlike '优恋空间') then '珍爱网【优恋空间】'
        when (businesstype='珍爱网' and content rlike '有位已到店|珍爱优恋空间精英版|优恋空间') then '珍爱网【优恋空间】'
        when (businesstype='珍爱网' and content rlike '甜蜜约会') then '珍爱网【甜蜜约会】'
        when (businesstype='珍爱网' and account in ('zhenai_crm20','zhenai_crm')) then '珍爱网【线下crm】'
        when (businesstype='珍爱网' and smstype ='其他短信' and content not rlike '【珍爱网】') then '珍爱网【crm】'
        when  businesstype='珍爱网' then '珍爱【app】'
        else  businesstype end type
from tmp.dwd_sms_common_d_tmp00_${yyyymmdd}
;

-- 短信内容清洗（分业务）
drop table if exists tmp.dwd_sms_common_d_tmp02_${yyyymmdd};
create table if not exists tmp.dwd_sms_common_d_tmp02_${yyyymmdd}
as
select *
      ,case when (type='趣约会' and smstype='其他短信' and content rlike '诚邀你回归') then '直播间运营'
            when (type='趣约会' and smstype='其他短信' and content rlike '情人节专属表白|周年庆') then '节日运营'
            when (type='趣约会' and smstype='其他短信' and content rlike 'VIP|vip|会员助您寻爱') then '用户唤回'
            when (type='趣约会' and smstype='其他短信' and content rlike '保级') then '直播间运营'
            when (type='趣约会' and smstype='其他短信' and content rlike '审核不通过|恭喜|审核未通过') then '资料审核'
            when (type='趣约会' and smstype='其他短信' and content rlike '开通权限|权限|新徒弟') then '直播间运营'
            when (type='趣约会' and smstype='其他短信' and content rlike '认识她|了解他|认识他|了解他') then '用户唤回'
            when (type='趣约会' and smstype='注册当天导量短信') then '用户唤回'
            when (type='趣约会' and smstype in ('iOS支付唤回','IOS五次未下单短信唤回')) then '支付唤回'
            when  type='趣约会' then smstype
            when (type='珍爱【app】' and smstype ='其他短信' and content rlike '珍爱信使') then '珍爱信使'
            when (type='珍爱【app】' and smstype ='其他短信' and content rlike '视频相亲') then '直播间运营'
            when (type='珍爱【app】' and smstype ='其他短信' and content rlike '审核') then '资料审核'
            when (type='珍爱【app】' and smstype ='其他短信' and content rlike '点此下载珍爱网客户端|下载') then '客户端下载'
            when (type='珍爱【app】' and smstype ='其他短信' and content rlike '开通珍心会员|解锁') then '支付唤回'
            when (type='珍爱【app】' and smstype ='其他短信' and content rlike '珍心会员8折|珍心会员限时8折|珍心会员八折') then '节日运营'
            when (type='珍爱【app】' and smstype ='其他短信' and content rlike '查看我的资料|快看看|打开查看吧') then '用户唤回'
            when (type='珍爱【app】' and smstype ='其他短信' and content not rlike '【珍爱网】') then '其他短信'
            when (type='珍爱【app】' and smstype ='其他短信' and content rlike '【珍爱网】') then '其他'
            when (type='珍爱【app】' and smstype in ('iOS支付唤回','IOS五次未下单短信唤回')) then '支付唤回'
            when (type='珍爱【app】' and smstype='注册当天导量短信') then '用户唤回'
            when (type='珍爱【app】' and smstype in ('验证码类','其他短信')) then smstype
            when  type='珍爱【app】' then smstype
            when (type='珍爱网【优恋空间】' and smstype='验证码类')  then smstype
            when (type='珍爱网【优恋空间】' and smstype='其他短信' and content rlike '完成见面|开启专属服务|购买年费会员成功') then '服务通知'
            when (type='珍爱网【优恋空间】' and smstype='其他短信' and content rlike '审核') then '资料审核'
            when (type='珍爱网【优恋空间】' and smstype='其他短信') then '日常运营'
            when  type='珍爱网【优恋空间】' then  smstype
            when (type='珍爱网【crm】' and smstype='验证码类') then smstype
            when (type='珍爱网【crm】' and smstype='其他短信' and content rlike '完成见面|成功签单|签定金单')  then '服务通知'
            when (type='珍爱网【crm】' and smstype='其他短信' and content like '%已成为会员%的红娘%') then '服务通知'
            when (type='珍爱网【crm】' and smstype='其他短信') then '日常运营'
            when  type='珍爱网【crm】'  then  smstype
            else smstype end as type_business
from tmp.dwd_sms_common_d_tmp01_${yyyymmdd}
;

alter table common_dwd.dwd_sms_common_d drop if exists partition(data_date=${yyyymmdd});
insert overwrite table common_dwd.dwd_sms_common_d partition(data_date = ${yyyymmdd})
select  t1.id
       ,t1.senddate
       ,t1.account
       ,t1.remark
       ,t1.tag
       ,t1.businesstype
       ,t1.channeltag
       ,t1.memberid
       ,t1.phone
       ,t1.content
       ,t1.smstype
       ,t1.sendcount
       ,t1.sendstatus
       ,t1.sendtime
       ,t1.smsid
       ,t1.receivetime
       ,t1.receivestatus
       ,t1.istouch
       ,t1.time_diff
       ,t1.type
       ,t1.type_business
       ,t2.workerid
from tmp.dwd_sms_common_d_tmp02_${yyyymmdd} t1
left join
(
    select smsid,workerid,memberid
    from common_ods.ods_sms_crm_d
    where data_date=${yyyymmdd}
    and date_format(sendtime,'yyyyMMdd')=${yyyymmdd}
    group by  smsid,workerid,memberid
)t2
on t1.memberid=t2.memberid and t1.smsid=t2.smsid
;

drop table if exists tmp.dwd_sms_common_d_tmp00_${yesterday};
drop table if exists tmp.dwd_sms_common_d_tmp01_${yesterday};
drop table if exists tmp.dwd_sms_common_d_tmp02_${yesterday};




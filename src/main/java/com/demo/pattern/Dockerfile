FROM guanhuaihai/lnmp:v1.0.0.001

MAINTAINER guanhuaihai@gmai.com

WORKDIR /www

EXPOSE 80

EXPOSE 22

RUN git clone git@codeup.aliyun.com:5fb21c4ae89148238ce80dbe/hebar/crm-laravel8-server.git

RUN cd crm-laravel8-server && composer install

RUN chmod -R 755 /www \
    && chown -R www:www /www

CMD systemctl start redis


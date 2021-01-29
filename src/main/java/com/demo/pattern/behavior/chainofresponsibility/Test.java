package com.demo.pattern.behavior.chainofresponsibility;

import com.demo.pattern.behavior.chainofresponsibility.leader.DepartmentLeader;
import com.demo.pattern.behavior.chainofresponsibility.leader.HrLeader;
import com.demo.pattern.behavior.chainofresponsibility.leader.TeamLeader;

/**
 * @author huaihai.guan
 * @since 2021/1/26 15:07
 */
public class Test {

    public static void main(String[] args) {
       com.demo.pattern.behavior.chainofresponsibility.Interviewee interviewee = new Interviewee("张三");

        HrLeader hr = new HrLeader("小美");
        DepartmentLeader departmentLeader = new DepartmentLeader("老张");
        departmentLeader.setNextInterviewer(hr);
        TeamLeader teamLeader = new TeamLeader("老刘");
        teamLeader.setNextInterviewer(departmentLeader);

        teamLeader.handleInterview(interviewee);
    }
}

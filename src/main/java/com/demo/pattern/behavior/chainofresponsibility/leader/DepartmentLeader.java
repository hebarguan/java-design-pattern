package com.demo.pattern.behavior.chainofresponsibility.leader;

import com.demo.pattern.behavior.chainofresponsibility.Interviewee;
import com.demo.pattern.behavior.chainofresponsibility.Interviewer;

import java.util.Random;

/**
 * @author huaihai.guan
 * @since 2021/1/26 14:59
 */
public class DepartmentLeader extends Interviewer {

    public DepartmentLeader(String name) {
        super(name);
    }

    public void handleInterview(Interviewee interviewee) {
        interviewee.setDepartmentLeaderOpinion(new Random().nextBoolean());
        if (interviewee.isDepartmentLeaderOpinion()) {

            System.out.println("DepartmentLeader " + this.interviewerName + " 通过");
            this.nextInterviewer.handleInterview(interviewee);
        } else {

            System.out.println("DepartmentLeader " + this.interviewerName + " 不通过");
        }
    }
}

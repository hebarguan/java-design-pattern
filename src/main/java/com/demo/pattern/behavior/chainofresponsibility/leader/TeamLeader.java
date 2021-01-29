package com.demo.pattern.behavior.chainofresponsibility.leader;

import com.demo.pattern.behavior.chainofresponsibility.Interviewee;
import com.demo.pattern.behavior.chainofresponsibility.Interviewer;

import java.util.Random;

/**
 * @author huaihai.guan
 * @since 2021/1/26 14:55
 */
public class TeamLeader extends Interviewer {

    public TeamLeader(String name) {
        super(name);
    }

    public void handleInterview(Interviewee interviewee) {
        interviewee.setTeamLeaderOpinion(new Random().nextBoolean());
        if (interviewee.isTeamLeaderOpinion()) {

            System.out.println("TeamLeader " + this.interviewerName + " 通过");
            this.nextInterviewer.handleInterview(interviewee);
        } else {

            System.out.println("TeamLeader " + this.interviewerName + " 不通过");
        }
    }
}

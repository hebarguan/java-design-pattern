package com.demo.pattern.behavior.chainofresponsibility.leader;

import com.demo.pattern.behavior.chainofresponsibility.Interviewee;
import com.demo.pattern.behavior.chainofresponsibility.Interviewer;

import java.util.Random;

/**
 * @author huaihai.guan
 * @since 2021/1/26 15:00
 */
public class HrLeader extends Interviewer {

    public HrLeader(String name) {
        super(name);
    }

    public void handleInterview(Interviewee interviewee) {
        interviewee.setHrOpinion(new Random().nextBoolean());
        if (interviewee.isHrOpinion()) {

            System.out.println("Hr " + this.interviewerName + " 通过，恭喜" + interviewee.getName() + "拿到Offer了");
        } else {

            System.out.println("Hr " + this.interviewerName + " 不通过");
        }
    }
}

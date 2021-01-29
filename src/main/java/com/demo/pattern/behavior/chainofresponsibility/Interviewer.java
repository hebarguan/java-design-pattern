package com.demo.pattern.behavior.chainofresponsibility;

/**
 * @author huaihai.guan
 * @since 2021/1/26 14:48
 */
public abstract class Interviewer {

    protected String interviewerName;

    protected Interviewer nextInterviewer;

    public Interviewer(String name) {
        interviewerName = name;
    }

    public void setNextInterviewer(Interviewer nextInterviewer) {
        this.nextInterviewer = nextInterviewer;
    }

    public abstract void handleInterview(Interviewee interviewee);
}

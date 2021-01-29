package com.demo.pattern.behavior.chainofresponsibility;

/**
 * @author huaihai.guan
 * @since 2021/1/26 14:52
 */
public class Interviewee {

    private String name;

    private boolean teamLeaderOpinion;

    private boolean departmentLeaderOpinion;

    private boolean hrOpinion;

    Interviewee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isTeamLeaderOpinion() {
        return teamLeaderOpinion;
    }

    public void setTeamLeaderOpinion(boolean teamLeaderOpinion) {
        this.teamLeaderOpinion = teamLeaderOpinion;
    }

    public boolean isDepartmentLeaderOpinion() {
        return departmentLeaderOpinion;
    }

    public void setDepartmentLeaderOpinion(boolean departmentLeaderOpinion) {
        this.departmentLeaderOpinion = departmentLeaderOpinion;
    }

    public boolean isHrOpinion() {
        return hrOpinion;
    }

    public void setHrOpinion(boolean hrOpinion) {
        this.hrOpinion = hrOpinion;
    }
}

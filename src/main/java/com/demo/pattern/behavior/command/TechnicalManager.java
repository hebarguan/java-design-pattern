package com.demo.pattern.behavior.command;

/**
 * @author huaihai.guan
 * @since 2021/1/25 10:55
 */
class TechnicalManager {

    private String manager;

    private Command command;

    TechnicalManager(String manager, Command command) {
        this.manager = manager;
        this.command = command;
    }

    void action(Requirement requirement) {
        this.command.execute(this.manager, requirement);
    }

}

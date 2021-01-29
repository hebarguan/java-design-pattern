package com.demo.pattern.behavior.command;

/**
 * @author huaihai.guan
 * @since 2021/1/25 10:31
 */
public abstract class Command {

    public Developer developer;

    public Command(Developer developer) {
        this.developer = developer;
    }

    public abstract void execute(String manager, Requirement requirement);
}

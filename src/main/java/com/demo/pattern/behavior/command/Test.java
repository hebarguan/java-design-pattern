package com.demo.pattern.behavior.command;

import com.demo.pattern.behavior.command.command.DevelopCommand;
import com.demo.pattern.behavior.command.command.SuspendCommand;

/**
 * @author huaihai.guan
 * @since 2021/1/25 11:01
 */
public class Test {

    public static void main(String[] args) {
        Requirement requirement = new Requirement();

        Developer developer = new Developer("张三");
        DevelopCommand developCommand = new DevelopCommand(developer);

        TechnicalManager manager = new TechnicalManager("管理员", developCommand);
        manager.action(requirement);

        SuspendCommand suspendCommand = new SuspendCommand(developer);
        TechnicalManager manager1 = new TechnicalManager("管理员2", suspendCommand);
        manager1.action(requirement);

    }
}

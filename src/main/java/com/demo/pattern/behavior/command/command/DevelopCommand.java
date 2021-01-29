package com.demo.pattern.behavior.command.command;

import com.demo.pattern.behavior.command.Command;
import com.demo.pattern.behavior.command.Developer;
import com.demo.pattern.behavior.command.Requirement;

/**
 * @author huaihai.guan
 * @since 2021/1/25 10:32
 */
public class DevelopCommand extends Command {

    public DevelopCommand(Developer developer) {
        super(developer);
    }

    @Override
    public void execute(String manager, Requirement requirement) {
        System.out.println(manager + "发出开发命令");
        this.developer.execute(requirement);
    }

}

package ua.goit.projectmanager.controller;

import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.service.handler.CommandHandler;
import ua.goit.projectmanager.view.View;


import java.util.Map;
import java.util.Optional;


public class ControllerImpl implements Controller {

    private View view;
    private Map<String, Command> commands;
    private CommandHandler handler;


    public ControllerImpl(View view) {
        this.view = view;
        this.commands = Command.of(view);
        this.handler = CommandHandler.of();
    }


    @Override
    public void run() {
        System.out.println("Welcome");
        while (true) {
            view.write("Write help for list of commands");
            handler.handle(view.read(), commands);
        }
    }
}


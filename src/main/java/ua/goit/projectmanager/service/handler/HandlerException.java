package ua.goit.projectmanager.service.handler;

import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.view.View;

import java.util.Map;

public class HandlerException extends CommandHandler {
    public HandlerException() {
        super(null);
    }



    @Override
    protected void apply(String command, Map<String, Command> commands) {
        throw new RuntimeException("Command " + command + " not found");
    }

    @Override
    protected boolean isApplicable(String command,  Map<String, Command> commands) {
        return true;
    }
}

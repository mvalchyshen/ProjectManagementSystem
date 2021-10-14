package ua.goit.projectmanager.service.handler;

import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.service.commands.ExitCommand;
import ua.goit.projectmanager.view.View;

import java.util.Map;
import java.util.Optional;

public class ExitCommandHandler extends CommandHandler{


    public ExitCommandHandler(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String command, Map<String, Command> commands) {
        Optional.ofNullable(commands.get(command)).ifPresent(Command::process);
    }

    @Override
    protected boolean isApplicable(String command,  Map<String, Command> commands) {
        return "exit".equalsIgnoreCase(command);
    }
}

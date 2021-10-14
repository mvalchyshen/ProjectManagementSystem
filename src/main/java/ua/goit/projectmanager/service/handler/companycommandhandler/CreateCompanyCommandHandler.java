package ua.goit.projectmanager.service.handler.companycommandhandler;

import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.service.handler.CommandHandler;

import java.util.Map;
import java.util.Optional;

public class CreateCompanyCommandHandler extends CommandHandler {


    public CreateCompanyCommandHandler(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String command, Map<String, Command> commands) {
        Optional.ofNullable(commands.get(command)).ifPresent(Command::process);
    }

    @Override
    protected boolean isApplicable(String command, Map<String, Command> commands) {
        return "create_company".equalsIgnoreCase(command);
    }
}

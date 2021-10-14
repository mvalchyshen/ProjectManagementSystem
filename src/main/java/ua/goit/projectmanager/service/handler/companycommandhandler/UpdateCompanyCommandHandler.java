package ua.goit.projectmanager.service.handler.companycommandhandler;

import ua.goit.projectmanager.model.Company;
import ua.goit.projectmanager.service.BaseService;
import ua.goit.projectmanager.service.ServiceFactory;
import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.service.handler.CommandHandler;
import ua.goit.projectmanager.view.View;

import java.util.Map;
import java.util.Optional;

public class UpdateCompanyCommandHandler extends CommandHandler {


    public UpdateCompanyCommandHandler(CommandHandler handler) {
        super(handler);
    }

    @Override
    protected void apply(String command, Map<String, Command> commands) {
        Optional.ofNullable(commands.get(command)).ifPresent(Command::process);
    }

    @Override
    protected boolean isApplicable(String command, Map<String, Command> commands) {
        return "update_company".equalsIgnoreCase(command);
    }
}

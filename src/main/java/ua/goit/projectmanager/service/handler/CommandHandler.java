package ua.goit.projectmanager.service.handler;

import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.service.handler.companycommandhandler.CreateCompanyCommandHandler;
import ua.goit.projectmanager.service.handler.companycommandhandler.DeleteCompanyCommandHandler;
import ua.goit.projectmanager.service.handler.companycommandhandler.ReadCompanyCommandHandler;
import ua.goit.projectmanager.service.handler.companycommandhandler.UpdateCompanyCommandHandler;

import java.util.Map;

public abstract class CommandHandler {

    private final CommandHandler handler;

    public CommandHandler(CommandHandler handler) {
        this.handler = handler;
    }

    protected abstract void apply(String command, Map<String, Command> commands);

    protected abstract boolean isApplicable(String command, Map<String, Command> commands);

    public final void handle(String command, Map<String, Command> commands) {
        if (isApplicable(command, commands)) apply(command,commands);
        else handler.handle(command,commands);
    }

    public static CommandHandler of() {
        return new CreateCompanyCommandHandler(new ReadCompanyCommandHandler(new UpdateCompanyCommandHandler(new DeleteCompanyCommandHandler(
                new ExitCommandHandler(new HelpCommandHandler(new HandlerException()))))));
    }
}

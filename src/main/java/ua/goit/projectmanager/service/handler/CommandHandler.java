package ua.goit.projectmanager.service.handler;


import ua.goit.projectmanager.service.handler.crud.CrudCompanyHandler;
import ua.goit.projectmanager.service.handler.crud.CrudProjectHandler;
import ua.goit.projectmanager.view.View;

public abstract class CommandHandler {
    private final CommandHandler commandHandler;


    public CommandHandler(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public static CommandHandler of() {
        return new CrudProjectHandler(new CrudCompanyHandler(new HandlerExit(new HandlerHelp(new HandlerException()))));
    }

    protected abstract boolean isApplicable(String command);
    protected abstract void apply(String command, View view);

    public void handle(String command, View view){
        if (isApplicable(command)) apply(command,view);
        else commandHandler.handle(command,view);
    }
}

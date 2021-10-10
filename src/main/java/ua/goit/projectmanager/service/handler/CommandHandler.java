package ua.goit.projectmanager.service.handler;

public abstract class CommandHandler {

    private final CommandHandler handler;

    public CommandHandler(CommandHandler handler) {
        this.handler = handler;
    }

    protected abstract void apply(String command, String table);
    protected abstract boolean isApplicable(String command, String table);

    public final void handle(String command, String table) {
        if (isApplicable(command,table)) apply(command,table);
        else handler.handle(command,table);
    }

    public static CommandHandler of() {
        return new HandlerCreate(new HandlerUpdate(new HandlerRead(new HandlerDelete(new HandlerException()))));
    }

}

package ua.goit.projectmanager.service.handler;

public class HandlerDelete extends CommandHandler {

    public HandlerDelete(CommandHandler handler) {
        super(handler);
    }
    @Override
    protected void apply(String command, String table) {

    }

    @Override
    protected boolean isApplicable(String command, String table) {
        return false;
    }
}

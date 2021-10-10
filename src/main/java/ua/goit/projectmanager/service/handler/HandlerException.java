package ua.goit.projectmanager.service.handler;

public class HandlerException extends CommandHandler{

    public HandlerException() {
        super(null);
    }
    @Override
    protected void apply(String command, String table) {
        throw new RuntimeException("Command '" + command + "' not found");
    }

    @Override
    protected boolean isApplicable(String command, String table) {
        return true;
    }
}

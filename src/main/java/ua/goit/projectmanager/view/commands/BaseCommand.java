package ua.goit.projectmanager.view.commands;

public interface BaseCommand {
    void execute();
    String getName();
    boolean canHandle(String command);
}

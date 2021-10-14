package ua.goit.projectmanager.service.commands;

import ua.goit.projectmanager.model.Company;
import ua.goit.projectmanager.service.ServiceFactory;
import ua.goit.projectmanager.view.View;

import java.util.Map;

public class ExitCommand implements Command {

    private final View view;


    public ExitCommand(View view, Map<String, Command> commands) {
        this.view = view;
    }

    @Override
    public void process() {
        view.write("Bye bye");
        System.exit(0);
    }

    @Override
    public String commandName() {
        return "exit";
    }

    @Override
    public String description() {
        return "stop the app";
    }
}

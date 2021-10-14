package ua.goit.projectmanager.service.commands;

import ua.goit.projectmanager.view.View;

import java.util.Map;
import java.util.stream.Collectors;

public class HelpCommand implements Command {

    private View view;
    private Map<String, Command> commands;

    public HelpCommand(View view, Map<String, Command> commands) {
        this.view = view;
        this.commands = commands;
    }

    @Override
    public void process() {
        view.write(commands.values().stream()
                .map(command -> String.join(" -> ", command.commandName(),command.description()))
                .sorted()
                .collect(Collectors.joining("\n")));
    }

    @Override
    public String commandName() {
        return "help";
    }

    @Override
    public String description() {
        return "list of commands";
    }
}

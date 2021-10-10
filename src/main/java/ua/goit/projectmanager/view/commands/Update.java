package ua.goit.projectmanager.view.commands;

import lombok.Getter;

@Getter
public class Update implements BaseCommand {

    private final String name = "update";
    @Override
    public void execute() {

    }

    @Override
    public boolean canHandle(String command) {
        return name.equalsIgnoreCase(command);
    }
}

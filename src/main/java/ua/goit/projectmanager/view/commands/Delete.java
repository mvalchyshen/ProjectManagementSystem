package ua.goit.projectmanager.view.commands;

import lombok.Getter;

@Getter
public class Delete implements BaseCommand{
    private final String name = "help";

    @Override
    public void execute() {

    }

    @Override
    public boolean canHandle(String command) {
        return false;
    }
}

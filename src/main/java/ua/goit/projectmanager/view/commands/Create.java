package ua.goit.projectmanager.view.commands;

import lombok.Getter;

@Getter
public class Create implements BaseCommand {

    private final String name = "create";
    @Override
    public void execute() {

    }

    @Override
    public boolean canHandle(String command) {
        return false;
    }

}

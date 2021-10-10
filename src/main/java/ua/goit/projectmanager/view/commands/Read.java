package ua.goit.projectmanager.view.commands;

import lombok.Getter;

@Getter
public class Read implements BaseCommand{

    private final String name = "get";
    @Override
    public void execute() {

    }

    @Override
    public boolean canHandle(String command) {
        return false;
    }
}

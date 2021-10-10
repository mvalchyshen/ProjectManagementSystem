package ua.goit.projectmanager.view.commands;

import lombok.Getter;
import ua.goit.projectmanager.view.View;

@Getter
public class Help implements BaseCommand{

    private final String name = "help";
    private View view;

    public Help() {
        view = View.of();
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean canHandle(String command) {
        return false;
    }
}

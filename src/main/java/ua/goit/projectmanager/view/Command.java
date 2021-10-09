package ua.goit.projectmanager.view;


public enum Command {
    HELP("help"),
    SAVE("save"),
    READ("read"),
    DELETE("delete"),
    UPDATE("update");

    private String name;

    Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

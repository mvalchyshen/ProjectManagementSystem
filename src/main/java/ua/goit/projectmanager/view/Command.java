package ua.goit.projectmanager.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Command {
    HELP("help"),
    SAVE("save"),
    READ("read"),
    DELETE("delete"),
    UPDATE("update");

    private String name;
}

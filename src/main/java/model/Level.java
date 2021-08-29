package model;

public enum Level {
    JUNIOR("Junior"),
    MEDIUM("Medium"),
    SENIOR("Senior");

    private String name;
    private Level(String name) {
        this.name = name;
    }
}

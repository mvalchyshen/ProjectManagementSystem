package model;

public enum Language {
    JAVA("Java"),
    CPLUSPLUS("C++"),
    CSHARP("C#");

    private String name;

    private Language(String name) {
        this.name = name;
    }
}

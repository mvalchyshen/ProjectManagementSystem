package model;

import lombok.Data;
import lombok.Getter;

@Getter
public enum Language {
    JAVA("Java"),
    CPLUSPLUS("C++"),
    CSHARP("C#"),
    JS("JS");

    private String name;

    private Language(String name) {
        this.name = name;
    }


}

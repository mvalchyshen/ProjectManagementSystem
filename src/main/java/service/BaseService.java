package service;

import model.BaseEntity;
import model.Developer;
import model.Project;

import java.util.List;

public interface BaseService {
    Long sumOfSalariesAtProject(Project project);
    List<Developer> developersList();
    List<Developer> javaDevelopersList();
    List<Developer> middleLevelList();
    List<Project> projectList();
}

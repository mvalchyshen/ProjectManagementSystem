package ua.goit.projectmanager.service;

import ua.goit.projectmanager.model.Project;

import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements BaseService<Project, Long> {
    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public Optional<Project> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long aLong) {

    }
}

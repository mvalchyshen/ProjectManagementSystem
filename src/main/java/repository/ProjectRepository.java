package repository;

import model.Project;

import java.util.List;
import java.util.Optional;

public class ProjectRepository implements BaseRepository<Project, Long> {
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

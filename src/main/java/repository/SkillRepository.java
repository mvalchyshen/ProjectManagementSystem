package repository;

import model.Skill;

import java.util.List;
import java.util.Optional;

public class SkillRepository implements BaseRepository<Skill, Long> {
    @Override
    public Skill save(Skill skill) {
        return null;
    }

    @Override
    public List<Skill> getAll() {
        return null;
    }

    @Override
    public Optional<Skill> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long aLong) {

    }
}

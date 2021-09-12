package repository;

import conrtroller.DataBaseConnection;
import lombok.SneakyThrows;
import model.Level;
import model.Project;
import model.Skill;
import util.PropertiesLoader;

import javax.persistence.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SkillRepository implements BaseRepository<Skill, Long> {
    private Connection connection;
    private String schemeName;
    private String tableName;

    private PreparedStatement create;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement getById;
    private PreparedStatement getAll;

    @SneakyThrows
    public SkillRepository() {
        this.connection = DataBaseConnection.getInstance().getConnection();
        this.schemeName = PropertiesLoader.getProperty("db.name");
        this.tableName = Project.class.getAnnotation(Table.class).name();
        this.create = connection.prepareStatement("INSERT INTO " + schemeName + "." + tableName + " (language,level) VALUES(?,?)");
        this.update = connection.prepareStatement("UPDATE " + schemeName + "." + tableName + " SET language = ?,level = ? where (id_skill = ?)");
        this.delete = connection.prepareStatement("DELETE FROM" + schemeName + "." + tableName + " WHERE (id_skill = ?)");
        this.getById = connection.prepareStatement("SELECT * FROM " + schemeName + "." + tableName + " WHERE (id_skill = ?)");
        this.getAll = connection.prepareStatement("SELECT * FROM " + schemeName + "." + tableName);
    }

    @SneakyThrows
    @Override
    public Skill save(Skill skill) {
        if (skill.getId() == null || !getById(skill.getId()).isPresent()) {
            create.setString(1, skill.getLanguage());
            create.setString(2, skill.getLevel().name());
            create.executeUpdate();
        } else {
            update.setString(1, skill.getLanguage());
            update.setString(2, skill.getLevel().name());
            update.setLong(3, skill.getId());
            update.executeUpdate();
        }
        return getById(skill.getId()).get();
    }


    @SneakyThrows
    @Override
    public List<Skill> getAll() {
        ResultSet resultSet = getAll.executeQuery();
        List<Skill> skills = new ArrayList<>();
        while (resultSet.next()) {
            Skill skill = Skill.builder()
                    .id(resultSet.getLong("id_skill"))
                    .language(resultSet.getString("language"))
                    .level(Level.valueOf(resultSet.getString("level")))
                    .build();
            skills.add(skill);
        }
        return skills;
    }

    @SneakyThrows
    @Override
    public Optional<Skill> getById(Long id) {
        getById.setLong(1, id);
        ResultSet resultSet = getById.executeQuery();
        Skill skill = Skill.builder()
                .id(resultSet.getLong("id_skill"))
                .language(resultSet.getString("language"))
                .level(Level.valueOf(resultSet.getString("level")))
                .build();
        if (skill == null) {
            return Optional.empty();
        }
        return Optional.of(skill);
    }

    @SneakyThrows
    @Override
    public void deleteById(Long id) {
        if (id == null || !getById(id).isPresent()) {
            throw new NoSuchElementException("Skill with " + id + " is not found");
        } else {
            delete.setLong(1, id);
            delete.executeUpdate();
        }
    }
}

package repository;

import util.DataBaseConnection;
import lombok.SneakyThrows;
import model.Project;
import util.PropertiesLoader;

import javax.persistence.Table;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ProjectRepository implements BaseRepository<Project, Long> {
    private Connection connection;
    private String schemeName;
    private String tableName;

    private PreparedStatement create;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement getById;
    private PreparedStatement getAll;

    @SneakyThrows
    public ProjectRepository() {
        this.connection = DataBaseConnection.getInstance().getConnection();
        this.schemeName = PropertiesLoader.getProperty("db.name");
        this.tableName = Project.class.getAnnotation(Table.class).name();
        this.create = connection.prepareStatement("INSERT INTO " + schemeName + "." + tableName + " (name_project,cost) VALUES(?,?)");
        this.update = connection.prepareStatement("UPDATE " + schemeName + "." + tableName + " SET name_project = ?,cost = ? where (id_project = ?)");
        this.delete = connection.prepareStatement("DELETE FROM" + schemeName + "." + tableName + " WHERE (id_project = ?)");
        this.getById = connection.prepareStatement("SELECT * FROM " + schemeName + "." + tableName + " WHERE (id_project = ?)");
        this.getAll = connection.prepareStatement("SELECT * FROM " + schemeName + "." + tableName);
    }

    @SneakyThrows
    @Override
    public Project save(Project project) {
        if (project.getId() == null || getById(project.getId()).isEmpty()) {
            create.setString(1, project.getName());
            create.executeUpdate();
        } else {
            update.setString(1, project.getName());
            update.setInt(2, project.getCost());
            update.setLong(3, project.getId());
            update.executeUpdate();
        }
        return getById(project.getId()).get();
    }


    @SneakyThrows
    @Override
    public List<Project> getAll() {
        ResultSet resultSet = getAll.executeQuery();
        List<Project> projects = new ArrayList<>();
        while (resultSet.next()) {
            Project project = Project.builder()
                    .id(resultSet.getLong("id_project"))
                    .name(resultSet.getString("name_project"))
                    .cost(resultSet.getInt("cost"))
                    .build();
            projects.add(project);
        }
        return projects;
    }

    @SneakyThrows
    @Override
    public Optional<Project> getById(Long id) {
        getById.setLong(1, id);
        ResultSet resultSet = getById.executeQuery();
        Project project = null;
        while (resultSet.next()) {
            project = Project.builder()
                    .id(resultSet.getLong("id_project"))
                    .name(resultSet.getString("name_project"))
                    .cost(resultSet.getInt("cost"))
                    .build();
        }
        if (project == null) {
            return Optional.empty();
        }
        return Optional.of(project);
    }

    @SneakyThrows
    @Override
    public void deleteById(Long id) {
        if (id == null || getById(id).isEmpty()) {
            throw new NoSuchElementException("Project with " + id + " is not found");
        } else {
            delete.setLong(1, id);
            delete.executeUpdate();
        }
    }
    @SneakyThrows
    @Override
    public void close() throws IOException {
        connection.close();
    }
}

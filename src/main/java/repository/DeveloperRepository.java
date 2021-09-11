package repository;

import conrtroller.DataBaseConnection;
import lombok.SneakyThrows;
import model.Customer;
import model.Developer;
import util.PropertiesLoader;

import javax.persistence.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class DeveloperRepository implements BaseRepository<Developer, Long> {
    private Connection connection;
    private String schemeName;
    private String tableName;

    private PreparedStatement create;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement getById;
    private PreparedStatement getAllById;

    @SneakyThrows
    public DeveloperRepository() {
        this.connection = DataBaseConnection.getInstance().getConnection();
        this.schemeName = PropertiesLoader.getProperty("db.name");
        this.tableName = Developer.class.getAnnotation(Table.class).name();
        this.create = connection.prepareStatement("INSERT INTO " + schemeName + "." + tableName + " (name_developer,age,salary) VALUES(?,?,?)");
        this.update = connection.prepareStatement("UPDATE " + schemeName + "." + tableName + " SET name_developer = ?,age = ?,salary = ? where (id_customer = ?)");
        this.delete = connection.prepareStatement("DELETE FROM" + schemeName + "." + tableName + " WHERE (id_developer = ?)");
        this.getById = connection.prepareStatement("SELECT * FROM " + schemeName + "." + tableName + " WHERE (id_developer = ?)");
        this.getAllById = connection.prepareStatement("SELECT * FROM " + schemeName + "." + tableName);
    }

    @SneakyThrows
    @Override
    public Developer save(Developer developer) {
        if (developer.getId() == null || !getById(developer.getId()).isPresent()) {
            create.setString(1, developer.getName());
            create.executeUpdate();
        } else {
            update.setString(1, developer.getName());
            update.setLong(2, developer.getId());
            update.executeUpdate();
        }
        return getById(developer.getId()).get();
    }


    @SneakyThrows
    @Override
    public List<Developer> getAll() {
        ResultSet resultSet = getAllById.executeQuery();
        List<Developer> companies = new ArrayList<>();
        while (resultSet.next()) {
            Developer customer = Developer.builder()
                    .id(resultSet.getLong("id_developer"))
                    .name(resultSet.getString("name_developer"))
                    .age(resultSet.getInt("age"))
                    .salary(resultSet.getInt("salary"))
                    .build();
            companies.add(customer);
        }
        return companies;
    }

    @SneakyThrows
    @Override
    public Optional<Developer> getById(Long id) {
        getById.setLong(1, id);
        ResultSet resultSet = getById.executeQuery();
        Developer developer = Developer.builder()
                .id(resultSet.getLong("id_developer"))
                .name(resultSet.getString("name_developer"))
                .age(resultSet.getInt("age"))
                .salary(resultSet.getInt("salary"))
                .build();
        if (developer == null) {
            return Optional.empty();
        }
        return Optional.of(developer);
    }

    @SneakyThrows
    @Override
    public void deleteById(Long id) {
        if (id == null || !getById(id).isPresent()) {
            throw new NoSuchElementException("Company with " + id + " is not found");
        } else {
            delete.setLong(1, id);
            delete.executeUpdate();
        }
    }
}

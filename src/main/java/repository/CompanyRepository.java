package repository;

import conrtroller.DataBaseConnection;
import lombok.SneakyThrows;
import model.Company;
import util.PropertiesLoader;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CompanyRepository implements BaseRepository<Company,Long>{

    private Connection connection;
    private String schemeName;
    private String tableName;

    private PreparedStatement create;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement getById;
    private PreparedStatement getAllById;

    @SneakyThrows
    public CompanyRepository() {
        this.connection = DataBaseConnection.getInstance().getConnection();
        this.schemeName = PropertiesLoader.getProperty("db.name");
        this.tableName = Company.class.getAnnotation(Table.class).name();
        this.create = connection.prepareStatement("INSERT INTO " + schemeName +"."+tableName+ " (name_company) VALUES(?)");
        this.update = connection.prepareStatement("UPDATE " + schemeName + "." + tableName + " SET name_company=? where (id_company = ?)");
        this.delete = connection.prepareStatement("DELETE FROM" + schemeName + "." + tableName +" WHERE (id_company = ?)" );
        this.getById = connection.prepareStatement("SELECT * FROM " + schemeName + "." + tableName + " WHERE (id_company = ?)");
        this.getAllById = connection.prepareStatement("SELECT * FROM " +schemeName + "." + tableName);
    }

    @SneakyThrows
    @Override
    public Company save(Company company) {
        if (company.getId() == null || !getById(company.getId()).isPresent()) {
            create.setString(1, company.getName());
            create.executeUpdate();
        } else {
            update.setString(1,company.getName());
            update.setLong(2,company.getId());
            update.executeUpdate();
        }
        return getById(company.getId()).get();
    }


    @SneakyThrows
    @Override
    public List<Company> getAll() {
        ResultSet resultSet = getAllById.executeQuery();
        List<Company> companies = new ArrayList<>();
        while (resultSet.next()) {
            Company company = Company.builder()
                    .id(resultSet.getLong("id_company"))
                    .name(resultSet.getString("name_company"))
                    .build();
            companies.add(company);
        }
        return companies;
    }
    @SneakyThrows
    @Override
    public Optional<Company> getById(Long id) {
        getById.setLong(1,id);
        ResultSet resultSet = getById.executeQuery();
        Company company = Company.builder()
                .id(resultSet.getLong("id_company"))
                .name(resultSet.getString("name_company"))
                .build();
        if (company == null) {
            return Optional.empty();
        }
        return Optional.of(company);
    }
    @SneakyThrows
    @Override
    public void deleteById(Long id) {
        if (id == null || !getById(id).isPresent()) {
            throw new NoSuchElementException("Company with " + id + " is not found");
        } else {
            delete.setLong(1,id);
            delete.executeUpdate();
        }
    }
}

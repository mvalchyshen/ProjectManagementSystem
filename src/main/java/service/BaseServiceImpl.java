package service;

import conrtroller.DataBaseConnection;
import model.Developer;
import model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class BaseServiceImpl implements BaseService{

    private PreparedStatement preparedStatement;
    private Connection connection;

    public BaseServiceImpl() {
        this.connection = DataBaseConnection.getInstance().getConnection();
    }
    @Override
    public Long sumOfSalariesAtProject(Project project) {
        return null;
    }

    @Override
    public List<Developer> developersList() {
        return null;
    }

    @Override
    public List<Developer> javaDevelopersList() {
        return null;
    }

    @Override
    public List<Developer> middleLevelList() {
        return null;
    }

    @Override
    public List<Project> projectList() {
        return null;
    }
}

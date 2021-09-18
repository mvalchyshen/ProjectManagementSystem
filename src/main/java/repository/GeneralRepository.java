package repository;

import util.DataBaseConnection;
import model.BaseEntity;
import util.PropertiesLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class GeneralRepository<T extends BaseEntity<ID>, ID> implements BaseRepository<T, ID> {

    private Connection connection;
    private String schemeName;
    private PreparedStatement createPreparedStatement;
    private PreparedStatement updatePreparedStatement;
    private PreparedStatement deletePreparedStatement;
    private PreparedStatement getByIdPreparedStatement;

    public GeneralRepository() {
        this.connection = DataBaseConnection.getInstance().getConnection();
        this.schemeName = PropertiesLoader.getProperty("db.name");
    }

//    public T save(T t){}
//    List<T> saveAll(){}
//    List<T> getAll(){}
//    Optional<T> getById(ID id){}
//    void deleteById(ID id){}
}

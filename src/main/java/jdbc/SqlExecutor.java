package jdbc;

import conrtroller.DataBaseConnection;
import model.Company;
import model.Level;
import model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlExecutor {

    public static void main(String[] args) throws Exception {
        try (DataBaseConnection dataBaseConnection = DataBaseConnection.getInstance()) {
            Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO goit_hw_db.skills (language, level)" +
                            " VALUES (?,?)");
//            preparedStatement.setLong(1,10);
            preparedStatement.setString(1, "Java");
            preparedStatement.setString(2, Level.Junior.name());
            Statement statement = connection.createStatement();
            int i = preparedStatement.executeUpdate();
            String sql = "SELECT * FROM goit_hw_db.companies where id_company = 1";
//            ResultSet resultSet = statement.executeQuery(sql);
//            PreparedStatement preparedStatement1 = connection.prepareStatement("DELETE FROM goit_hw_db.skills WHERE id_skill = ?");
//            preparedStatement1.setLong(1,10);
//            preparedStatement1.executeUpdate();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Company> skills = new ArrayList<>();
            while (resultSet.next()) {
                Company company = Company.builder()
                        .id(resultSet.getLong("id_company"))
                        .name(resultSet.getString("name_company"))
                        .build();
                skills.add(company);
            }
            System.out.println(skills);


        }
    }
}

package jdbc;

import conrtroller.DataBaseConnection;
import model.Language;
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
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("INSERT INTO goit_hw_db.skills (id_skill, language, level)" +
//                            " VALUES (?,?,?)");
//            preparedStatement.setLong(1,10);
//            preparedStatement.setObject(2, Language.CPLUSPLUS);
//            preparedStatement.setObject(3, Level.JUNIOR);
            Statement statement = connection.createStatement();
//            int i = preparedStatement.executeUpdate();
            String sql = "SELECT * FROM goit_hw_db.skills";
            ResultSet resultSet = statement.executeQuery(sql);


            List<Skill> skills = new ArrayList<>();
            while (resultSet.next()) {
                Skill skill = Skill.builder()
                        .id(resultSet.getLong("id_skill"))
//                        .language(Language.valueOf(resultSet.getString("language")))
                        .level(Level.valueOf(resultSet.getString("level")))
                        .build();
                skills.add(skill);
            }
            System.out.println(skills);


        }
    }
}

package jdbc;

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
                    .prepareStatement("INSERT INTO test.user (name, surname, email)" +
                            " VALUES (?,?,?)");
            preparedStatement.setString(1, "User");
            preparedStatement.setString(2, "uzer");
            preparedStatement.setString(3, "uzer@google.com");
            Statement statement = connection.createStatement();
            int i = preparedStatement.executeUpdate();
            String sql = "SELECT * FROM test.user";
            ResultSet resultSet = statement.executeQuery(sql);


            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .email(resultSet.getString("email"))
                        .build();
                users.add(user);
            }
            System.out.println(users);
            System.out.println(i);

        }
    }
}

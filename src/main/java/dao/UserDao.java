package dao;

import config.Database;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Database database = new Database();

    public User save(User user) throws SQLException {

        Connection connection = database.getConnection();

        String sql = "INSERT INTO user(first_name, last_name, email) VALUES (?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());

        statement.executeUpdate();

        return user;
    }

    public void update(User user) throws SQLException {
        Connection connection = database.getConnection();
        String sql = "UPDATE user SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());
        statement.setInt(4, user.getId());

        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        Connection connection = database.getConnection();
        String sql = "DELETE FROM user WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        statement.executeUpdate();
    }

    public User findById(int id) throws SQLException {
        Connection connection = database.getConnection();
        String sql = "SELECT id, first_name, last_name, email FROM user WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        User user = null;

        while (result.next()){
            id = result.getInt("id");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String email = result.getString("email");
            user = new User(id, firstName, lastName, email);
        }
        return user;
    }

    public List<User> findAll() throws SQLException {
        Connection connection = database.getConnection();
        String sql = "SELECT id, first_name, last_name, email FROM user";

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet result = statement.executeQuery();
        User user = null;
        List<User> list = new ArrayList<>();

        while (result.next()){
            int id = result.getInt("id");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String email = result.getString("email");
            user = new User(id, firstName, lastName, email);
            list.add(user);
        }
        return list;
    }
}

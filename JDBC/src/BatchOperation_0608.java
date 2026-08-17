import java.sql.*;

public class BatchOperation_0608 {
    private static final String url = "jdbc:mysql://localhost:3306/college";
    private static final String username = "root";
    private static final String pswd = "password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, pswd);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from student");
            CallableStatement cs = connection.prepareCall("{CALL InsertStudent(?,?,?,?)}");

//student 1
            cs.setString(1, "Fahad");
            cs.setString(2, "fahad@gmail.com");
            cs.setInt(3, 18);
            cs.setString(4, "B.Tech");
            cs.addBatch();

// Student 2
            cs.setString(1, "Shiv");
            cs.setString(2, "shiv@gmail.com");
            cs.setInt(3, 19);
            cs.setString(4, "B.Tech CSE");
            cs.addBatch();

// Student 3
            cs.setString(1, "Rahul");
            cs.setString(2, "rahul@gmail.com");
            cs.setInt(3, 20);
            cs.setString(4, "BCA");
            cs.addBatch();

            cs.executeBatch();


            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email") + " " +
                                rs.getInt("age") + " " +
                                rs.getString("course")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

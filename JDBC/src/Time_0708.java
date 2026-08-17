import java.sql.*;

public class Time_0708 {
    public static void main(String[] args){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println(e.getMessage());
    }
//        CREATE TABLE employee (
//                id INT AUTO_INCREMENT PRIMARY KEY,
//                name VARCHAR(40),
//                login_time TIME
//        );

        try{
        String query="insert into employeeTime (name,login_time) values(?,?)";
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","password");
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1,"FAHAD");
        Time time=Time.valueOf("09:30:15");
        preparedStatement.setTime(2,time);
        int rowsAffected=preparedStatement.executeUpdate();
        if(rowsAffected>0){
            System.out.println("---------- " +rowsAffected+" Rows Affected ----------");
        }else System.out.println("---------- No Data Added ----------");

        connection.close();
    } catch (
    SQLException e) {
        System.out.println(e.getMessage());
    }

}
}

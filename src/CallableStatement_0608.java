
import java.sql.*;

public class CallableStatement_0608 {
    private static final String url="jdbc:mysql://localhost:3306/college";
    private static final String username="root";
    private static final String pswd="password";


    //to use Callable statement we have to make procedure in sql

//    DELIMITER //
//
//    CREATE PROCEDURE InsertStudent(
//            IN p_name VARCHAR(100),
//    IN p_email VARCHAR(100),
//    IN p_age INT,
//    IN p_course VARCHAR(50)
//)
//    BEGIN
//    INSERT INTO student(name, email, age, course)
//    VALUES(p_name, p_email, p_age, p_course);
//    END //
//
//            DELIMITER ;

    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            Connection connection=DriverManager.getConnection(url,username,pswd);
            PreparedStatement preparedStatement=connection.prepareStatement("Select * from student");
            CallableStatement callableStatement=connection.prepareCall("{CALL InsertStudent(?,?,?,?)}");

            callableStatement.setString(1,"Fahad");
            callableStatement.setString(2,"Fahad123@gmail.com");
            callableStatement.setInt(3,18);
            callableStatement.setString(4,"B.Tech");

           int rowsAffected= callableStatement.executeUpdate();
           if(rowsAffected>0){
               System.out.println("Record Inserted");
           }else{
               System.out.println("Insertion Failed");
           }

            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email") + " " +
                                rs.getInt("age") + " " +
                                rs.getString("course")
                );
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }




    }
}
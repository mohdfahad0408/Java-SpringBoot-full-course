import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeStamp_0708 {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


//        create table orders(
//                id int primary key auto_increment,
//                name varchar(100),
//                created_at timestamp
//                     );

        try{
            String query="insert into orders (name,created_at) values(?,?)";
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","password");
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,"FAHAD");

            LocalDateTime  currentTime=LocalDateTime.now();
            Timestamp timestamp=Timestamp.valueOf(currentTime);
            preparedStatement.setTimestamp(2,timestamp);
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

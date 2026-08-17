import java.sql.*;

public class Date_0708 {
    //DOB=2008-08-04
    //Date=Year,month,Day
    //Time=Hour,Minute,Second
    //DateTime= 2026-08-07 14:35:45
    //Timestamp= auto Stores current timeStamp
    public static void main(String[] args){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
//        CREATE TABLE employee (
//                id INT AUTO_INCREMENT PRIMARY KEY,
//                name VARCHAR(100),
//                dob DATE
//        );


        try{
            String query="insert into employee (name,dob) values(?,?)";
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","password");
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,"FAHAD");
            Date date= Date.valueOf("2008-08-04");
            preparedStatement.setDate(2,date);
            int rowsAffected=preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("---------- " +rowsAffected+" Rows Affected ----------");
            }else System.out.println("---------- No Data Added ----------");

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

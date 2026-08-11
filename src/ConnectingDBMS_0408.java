import java.sql.*;
import java.util.Scanner;

public class ConnectingDBMS_0408 {
    private static final String url="jdbc:mysql://localhost:3306/college";
    private static final String username="root";
    private static final String pswd="password";


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Class -> Java ki class
            // forName()  -> Is class ko memory me load karo
            // com.mysql.cj.jdbc.Driver -> MySQL Driver ka naam
            }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection= DriverManager.getConnection(url,username,pswd);
            //yaha driver manager database se connection bana rha hai
            Statement statement=connection.createStatement();

            System.out.println("enter id to update");
            int updateId=sc.nextInt();


            String q1="delete from students where email='shiv@gmail.com'";
            String q2="UPDATE students SET age = 21 WHERE id = 1";

            //yaha pr ham id aaise use kre g warna sql injection ho jae g
            String q5="UPDATE students SET age = 21 WHERE id = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(q5);
            preparedStatement.setInt(1,updateId);
            preparedStatement.executeUpdate();

            String q0=String.format("Insert into students(name,email,age,course) values(?,?,?,?)");
            PreparedStatement ps=connection.prepareStatement(q0);
            ps.setString(1,"md Fhaad");
            ps.setString(2,"mdfhd@gmail.com");
            ps.setString(4,"nothing");
            ps.setInt(3,55);
            ps.executeUpdate();


            String q3=String.format( "Insert into students(name,email,age,course) values('%s','%s',%d,'%s')","shiv","shiv@gmail.com",20,"Btech");
            String q4="select * from students";

            //jab bhi table mai koi bhi data mai change aaega to executeUpdate() ise krege
            statement.executeUpdate(q1);
            statement.executeUpdate(q2);

            int rowsAffected=statement.executeUpdate(q3);
            if(rowsAffected>0){
                System.out.println("Data Added Successfully");
            }else System.out.println("Error in adding data");


            //jab bhi koi data ko fetch krna hai ja koi operation jismai data manupulate na hora ho tab executeQuery()
            ResultSet resultSet=statement.executeQuery(q4);
            //data ko print krre ab
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                String course = resultSet.getString("course");

                System.out.println("ID      : " + id);
                System.out.println("Name    : " + name);
                System.out.println("Email   : " + email);
                System.out.println("Age     : " + age);
                System.out.println("Course  : " + course);
                System.out.println("----------------------------");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}

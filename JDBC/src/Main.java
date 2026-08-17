import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class Main {


    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Properties properties=new Properties();
        try{
            FileInputStream fs=new FileInputStream("src//config.properties");
            properties.load(fs);
            String url=properties.getProperty("url");
            String password=properties.getProperty("password");
            String username=properties.getProperty("username");

            Connection connection= DriverManager.getConnection(url,username,password);

            String qry="insert into emp (name,department) values (?,?)";
            PreparedStatement ps=connection.prepareStatement(qry);
            System.out.println("------Enter Employee Name-------");
            String uname=sc.nextLine();
            System.out.println("------Enter Employee Dept-------");
            String udept=sc.nextLine();

            ps.setString(1,uname);
            ps.setString(2,udept);

            ps.executeUpdate();

            PreparedStatement preparedStatement=connection.prepareStatement("Select * from emp");
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getInt("empid") + " " +
                                rs.getString("name") + " " +
                                rs.getString("department")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

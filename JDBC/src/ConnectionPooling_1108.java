import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionPooling_1108 {
    //Need External Library = HikariCp
    private static final String url="jdbc:mysql://localhost:3306/college";
    private static final String username="root";
    private static final String pswd="password";

    public static void  main(String[] args){
        //Create HikariCP configuration
        HikariConfig Config =new HikariConfig();

        //Database details
        Config.setJdbcUrl(url);
        Config.setUsername(username);
        Config.setPassword(pswd);

        //connection pool setting
        Config.setMinimumIdle(2);
        Config.setMaximumPoolSize(5);

        //Create connection pool
        HikariDataSource dataSource=new HikariDataSource(Config);

        try(Connection connection=dataSource.getConnection()) {
            System.out.println("----------------- Connection Obtained ----------------");

            String sql="select * from student";

            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("Name: "+rs.getString("name"));
                System.out.println("Email: "+rs.getString("email"));
                System.out.println("Age: "+rs.getInt("age"));
                System.out.println("Course: "+rs.getString("course"));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

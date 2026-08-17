import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FileHandling_1108 {
    public  static  void  main(String[] args){
        Properties properties =new Properties();

        try{
            FileInputStream fis=new FileInputStream("src//config.properties");
            properties.load(fis);
            String url=properties.getProperty("url");
            String username=properties.getProperty("username");
            String password= properties.getProperty("password");


            Connection connection= DriverManager.getConnection(url,username,password);

            System.out.println("-----Database connected-----");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

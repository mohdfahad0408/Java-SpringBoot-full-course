import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.*;

public class Lobs_1008 {
    //LOBs in JDBC -> CLOB and BLOB
    //LOB=> large Object
    //A LOB is used is when we want to store a large amount of data inside a database.

    //CLOB+ character Large Object=> Large Text => resume ,article,book etx
    // BLOB= binary Large Object =>Image ,video etc

//    create table if not exists  employee(
//            id int primary key auto_increment,
//            name varchar(100),
//    resume longtext,
//    photo longblob
//        );

    private static final String url="jdbc:mysql://localhost:3306/college";
    private static final String username="root";
    private static final String pswd="password";
    public static void main(String[] args){
        String query="insert  into employee (name,resume,photo) values (?,?,?)";

        String name="FAHAD";
        String resume="//Users//fahad//Desktop//Mohd_Fahad_Resume.pdf.pdf";
        String photo="//Users//fahad//Downloads/" +
                "/MohdFahad.png";
        try{
            Connection connection=DriverManager.getConnection(url,username,pswd);
            PreparedStatement preparedStatement=connection.prepareStatement(query);

            FileReader fileReader=new FileReader(resume);
            FileInputStream fileInputStream=new FileInputStream(photo);

            preparedStatement.setString(1,name);
            preparedStatement.setCharacterStream(2,fileReader);
            preparedStatement.setBinaryStream(3,fileInputStream);

            int rows=preparedStatement.executeUpdate();
            if(rows>0){
                System.out.println("----------Data Added Successfully----------");
            }else{
                System.out.println("----------No dat Added----------");
            }

            connection.close();
            preparedStatement.close();
            fileInputStream.close();
            fileReader.close();
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }

    }
}
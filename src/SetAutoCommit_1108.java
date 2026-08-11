
//setAutoCommit(true)-> automatically save
//setAutoCommit(false)-> do not save automatically
//query 1-> query 2-> both success ? commit: rollback

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetAutoCommit_1108 {
    private static final String url="jdbc:mysql://localhost:3306/college";
    private static final String username="root";
    private static final String pswd="password";
    static void main(String[] args) {

//        use college;
//        create table account(
//                id int primary key,
//                name varchar(100),
//                balance double
//            );

        Connection connection=null;
        try{
            connection= DriverManager.getConnection(url,username,pswd);
            connection.setAutoCommit(false);

            String withdrawlSQL="update account set balance=balance-? where id=?";
            String depositeSQL="update account set balance=balance-? where id=?";


            PreparedStatement withdrawl=connection.prepareStatement(withdrawlSQL);
            withdrawl.setDouble(1,500);
            withdrawl.setInt(2,1);

            PreparedStatement deposite=connection.prepareStatement(depositeSQL);
            deposite.setDouble(1,1000);
            deposite.setInt(2,2);


            // Execute both queries
            withdrawl.executeUpdate();
            deposite.executeUpdate();

            //both operation success
            connection.commit();

            System.out.println("---------Transaction Successful--------");


        } catch (SQLException e) {
            System.out.println(e.getMessage());

            try{
                if(connection !=null){
                    connection.rollback();
                }
            }catch (Exception rollback){
                System.out.println(rollback.getMessage());
            }
        }


    }

}

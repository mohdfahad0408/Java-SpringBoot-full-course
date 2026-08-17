package insert;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {
        //Used to do configuration from resources/Hibernate.cfg.xml
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();


        //inserting data into student
        Student student=new Student();
        student.setName("John");
        student.setAge(25);

        session.persist(student);//same as insert into student

        Student student2 = new Student();
        student2.setName("Mike");
        student2.setAge(22);
        session.persist(student2);

        // Student 3
        Student student3 = new Student();
        student3.setName("Sarah");
        student3.setAge(24);
        session.persist(student3);

        // Student 4
        Student student4 = new Student();
        student4.setName("David");
        student4.setAge(21);
        session.persist(student4);


        transaction.commit();

        session.close();
        sessionFactory.close();
        System.out.println("------Student Saved-------");
    }
}

package org.example;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        //Entering data into table

        Student student = new Student("Test", 12);

        session.persist(student);// same as insert into

        transaction.commit();
        session.close();


    }

}

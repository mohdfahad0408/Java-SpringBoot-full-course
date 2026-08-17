package org.example;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MergeDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, 11);
        student.setAge(99);
        student.setName("FAAAH");
        session.merge(student);
        transaction.commit();
        session.close();
        System.out.println("----------Data Updated--------");

    }
}

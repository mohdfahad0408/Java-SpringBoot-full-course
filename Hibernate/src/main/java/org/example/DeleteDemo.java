package org.example;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteDemo {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Student student=session.get(Student.class,4);
        if(student!=null){
            session.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
        transaction.commit();
    }


}

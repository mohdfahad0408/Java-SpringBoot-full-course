package org.example;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RefreshDemo {
    public static void main(String[] args) {
        //Refresh Is used to refresh and get the current data before doing any update
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Student student=session.get(Student.class,2);
        System.out.println("Original Object :"+student.getName()); //Will print previous name
        student.setName("Roman");
        System.out.println("After changing Object :"+student.getName());// will print roman cause it has done hanges in session factory but since we have not commited so the db will still have previous name hence we get diff name
        session.refresh(student); // refreshing to get current data in database
        System.out.println("After Refresh Object :"+student.getName());
    }
}

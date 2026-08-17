package org.example;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FindDemo {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();

        Student student=session.find(Student.class,2);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getId());
        session.close();

        //get=read
        //persist=create
        //merge=update
        //remove=delete

    }
}

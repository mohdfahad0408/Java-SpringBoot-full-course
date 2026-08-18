package org.example;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommitAndRollback {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Student student1=session.get(Student.class,1);
        Student student2=session.get(Student.class,2);

        student1.setAge(-10);
        session.merge(student1);
        student2.setAge(12);
        session.merge(student2);
        if(student1.getAge()<0 || student2.getAge()<0){
            transaction.rollback();
            System.out.println("----Data Rollback due to error ---");
        }else{
            transaction.commit();
            System.out.println("------Data Saved-----");
        }
    }
}

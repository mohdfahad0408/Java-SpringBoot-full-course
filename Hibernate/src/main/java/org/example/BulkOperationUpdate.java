package org.example;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class BulkOperationUpdate {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Query<Student> query=session.createQuery("update Student set age=age+1");

        query.executeUpdate();
        System.out.println("Data Updated");
        transaction.commit();
    }
}

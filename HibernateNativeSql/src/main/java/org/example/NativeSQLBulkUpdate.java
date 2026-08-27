package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class NativeSQLBulkUpdate {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        NativeQuery<Student> nativeQuery= session.createNativeQuery("Update student set course='Spring boot' where course ='Java'", Student.class);
        int updateCount= nativeQuery.executeUpdate();
        transaction.commit();
        System.out.println("---"+updateCount +" : Rows Affected---");
        session.close();
    }

}

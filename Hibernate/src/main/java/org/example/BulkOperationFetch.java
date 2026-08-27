package org.example;

import model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class BulkOperationFetch {
    //We use HQL(HIbernate query language)
    // it is used to do bulk operation
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Query<Student> query=session.createQuery(
                "from Student",Student.class
        );
        List<Student> students=query.getResultList();

        for (Student student:students){
            System.out.println(student.getId()+" "+student.getName()+" "+student.getAge());
        }

        session.close();
    }
}

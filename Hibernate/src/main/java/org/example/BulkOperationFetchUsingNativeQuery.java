package org.example;

import model.Student;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class BulkOperationFetchUsingNativeQuery {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        NativeQuery<Student> nativeQuery = session.createNativeQuery(
                "SELECT * FROM students",
                Student.class
        );

        List<Student> students = nativeQuery.getResultList();

        for (Student student : students) {
            System.out.println(
                    student.getId() + " " +
                            student.getName() + " " +
                            student.getAge()
            );
        }

        session.close();
    }
}
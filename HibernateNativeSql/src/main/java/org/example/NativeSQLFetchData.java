package org.example;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class NativeSQLFetchData {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();

        NativeQuery<Student> nativeQuery=session.createNativeQuery("select * from student", Student.class);
        List<Student> stu=nativeQuery.getResultList();
        System.out.println("st");

        for (Student s : stu) {
            System.out.print(s.getId() + "-------");
            System.out.print(s.getName() + "-------");
            System.out.print(s.getCourse() + "-------");
            System.out.print(s.getStatus() + "-------");
            System.out.println(s.getRegistration_date());

        }


        session.close();
    }
}

package com.kortov.hibernate;

import com.kortov.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student", Student.class).getResultList();
            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName='Doe'",Student.class).getResultList();
            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'", Student.class).getResultList();
            System.out.println("\n\nStudents who have last name of Doe or first name Daffy");
            displayStudents(students);

            students = session.createQuery("from Student s where s.email LIKE '%luv2code.com'",Student.class).getResultList();
            System.out.println("\n\nStudents who email ends with luv2code.com");
            displayStudents(students);

            students = session.createQuery("from Student s where s.email LIKE '%gmail.com'",Student.class).getResultList();
            System.out.println("\n\nStudents who email ends with gmail.com");
            displayStudents(students);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

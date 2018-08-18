package com.kortov.hibernate;

import com.kortov.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating 3 student objects...");
            Student tempStudent1 = new Student("John", "Doe", "john@kortov.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@kortov.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@kortov.com");
            session.beginTransaction();
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            sessionFactory.close();
        }
    }
}

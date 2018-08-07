package com.kortov.hibernate;

import com.kortov.hibernate.entity.Course;
import com.kortov.hibernate.entity.Instructor;
import com.kortov.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            int id = 1;
            Query<Instructor> query = session.createQuery("select i from Instructor i " +
                    "join fetch i.courses " +
                    "where i.id=:theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", id);
            Instructor instructor = query.getSingleResult();
            session.getTransaction().commit();
            System.out.println("Session is closed");
            System.out.println("Courses: " + instructor.getCourses());
            System.out.println("luv2code: Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

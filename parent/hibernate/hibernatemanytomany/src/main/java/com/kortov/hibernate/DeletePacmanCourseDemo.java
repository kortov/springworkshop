package com.kortov.hibernate;

import com.kortov.hibernate.entity.Course;
import com.kortov.hibernate.entity.Instructor;
import com.kortov.hibernate.entity.InstructorDetail;
import com.kortov.hibernate.entity.Review;
import com.kortov.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            int courseId = 10;
            Course course = session.get(Course.class, courseId);
            System.out.println("Deleting the course: " + course);
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

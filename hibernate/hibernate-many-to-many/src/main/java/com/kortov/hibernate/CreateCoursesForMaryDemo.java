package com.kortov.hibernate;

import com.kortov.hibernate.entity.Course;
import com.kortov.hibernate.entity.Instructor;
import com.kortov.hibernate.entity.InstructorDetail;
import com.kortov.hibernate.entity.Review;
import com.kortov.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesForMaryDemo {
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
            int studentId = 2;
            Student student = session.get(Student.class, studentId);
            System.out.println("\nLoaded student: " + student);
            System.out.println("Courses: " + student.getCourses());
            Course course1 = new Course("Rubik's cube");
            Course course2 = new Course("Atari 2600");
            course1.addStudent(student);
            course2.addStudent(student);
            System.out.println("Saving courses...");
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

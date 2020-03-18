package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor.class)
        .addAnnotatedClass(InstructorDetail.class)
        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

//            Instructor temInstructor =
//                    new Instructor("Chad","Darby","Darby@luv2Code.com");
//
//            InstructorDetail tempInstructorDetail =
//                    new InstructorDetail(
//                            "http://www.luv2code.com/youtube",
//                            "Luv2Code!!!");

            Instructor temInstructor =
                    new Instructor("Madu","Patel","madu@luv2Code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.youtube.com",
                            "Guitar!!!!");

            temInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor : " + temInstructor);
            session.save(temInstructor);

            session.getTransaction().commit();

            System.out.println("Done");


        }
        finally {
            factory.close();
        }

    }
}

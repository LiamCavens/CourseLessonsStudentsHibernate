package db;

import models.Course;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCourse {

    private static Session session;

    //This = Course, Something = Student
    public static List<Student> getStudentsFromCourse(Course course){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> results = null;
        try {
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("course", course));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


//This = Course, Something = Lesson
    public static List<Lesson> getLessonsFromCourse(Course course) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> results = null;
        try {
            Criteria criteria = session.createCriteria(Lesson.class);
            criteria.add(Restrictions.eq("course", course));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}

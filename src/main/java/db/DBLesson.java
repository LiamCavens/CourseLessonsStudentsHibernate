package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBLesson {

    private static Session session;

    //This = Lesson, Something = Student
    public static List<Student> getStudentsFromLesson(Lesson lesson) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> results = null;
        try {
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("lesson", lesson));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}

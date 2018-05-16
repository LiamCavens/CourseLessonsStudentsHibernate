import db.DBCourse;
import db.DBHelper;
import models.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        GregorianCalendar startDate1 = new GregorianCalendar(2018, 3, 25);
        GregorianCalendar startDate2 = new GregorianCalendar(2018, 4, 12);
        GregorianCalendar endDate1 = new GregorianCalendar(2018, 7, 13);
        GregorianCalendar endDate2 = new GregorianCalendar(2018, 11, 23);

        Course course1 = new Course("Engineering", CourseLevel.HND, startDate1, endDate1);
        Course course2 = new Course("Harp Isn't In The String Fam", CourseLevel.BSC, startDate2, endDate2);

        Instructor instructor1 = new Instructor("Super Upul", Coolness.SUPERCOOL);
        Instructor instructor2 = new Instructor("Boy George", Coolness.PRETTYCOOL);

        Lesson lesson1 = new Lesson("Fluid Dynamics", 34, course1, instructor1);
        Lesson lesson2 = new Lesson("Advanced Maths", 38, course1, instructor1);
        Lesson lesson3 = new Lesson("Advanced Harps", 23, course2, instructor2);
        Lesson lesson4 = new Lesson("Piano Is A Keyboard", 11, course2, instructor2);

        Student student1 = new Student("Elton John", 55, 3012, course1);
        Student student2 = new Student("Stevie Wonder", 49, 1487, course1);
        Student student3 = new Student("Codezy", 32, 1122, course2);
        Student student4 = new Student("Aldo Russo", 28, 1337, course2);

        DBHelper.saveOrUpdate(course1);
        DBHelper.saveOrUpdate(course2);
        DBHelper.saveOrUpdate(instructor1);
        DBHelper.saveOrUpdate(instructor2);
        DBHelper.saveOrUpdate(lesson1);
        DBHelper.saveOrUpdate(lesson2);
        DBHelper.saveOrUpdate(lesson3);
        DBHelper.saveOrUpdate(lesson4);
        DBHelper.saveOrUpdate(student1);
        DBHelper.saveOrUpdate(student2);
        DBHelper.saveOrUpdate(student3);
        DBHelper.saveOrUpdate(student4);

        List<Student> engineeringStudents = DBCourse.getStudentsFromCourse(course1);
        List<Lesson> coursesLessons = DBCourse.getLessonsFromCourse(course1);

        List<Course> gotCourses = DBHelper.getAll(Course.class);
    }
}

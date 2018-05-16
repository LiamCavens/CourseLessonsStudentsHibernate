package models;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {

    private int id;
    private String courseName;
    private CourseLevel courseLevel;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private Set<Student> students;
    private Set<Lesson> lessons;

    public Course() {
    }

    public Course(String courseName, CourseLevel courseLevel, GregorianCalendar startDate, GregorianCalendar endDate) {
        this.courseName = courseName;
        this.courseLevel = courseLevel;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Enumerated(EnumType.STRING)
    public CourseLevel getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(CourseLevel courseLevel) {
        this.courseLevel = courseLevel;
    }

    @OneToMany(mappedBy = "course")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "course")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Column(name="start_date")
    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    @Column(name="end_date")
    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }
}

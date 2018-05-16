package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lessons")
public class Lesson {

    private int id;
    private String lessonTitle;
    private int classroomNumber;
    private Course course;
    private Instructor instructor;
    private Set<Student> students;

    public Lesson() {
    }

    public Lesson(String lessonTitle, int classroomNumber, Course course, Instructor instructor) {
        this.lessonTitle = lessonTitle;
        this.classroomNumber = classroomNumber;
        this.course = course;
        this.instructor = instructor;
        this.students = new HashSet<Student>();
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

    @Column(name="lesson_title")
    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    @Column(name="classroom_number")
    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="student_lesson",
            inverseJoinColumns = {@JoinColumn(name="student_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name="lesson_id", nullable = false, updatable = false)}
    )
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @ManyToOne
    @JoinColumn(name="instructor_id", nullable = false)
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}

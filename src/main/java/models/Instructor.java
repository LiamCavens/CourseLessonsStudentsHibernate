package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="instructors")
public class Instructor {

    private int id;
    private String name;
    private Coolness coolness;
    private Set<Lesson> lessons;

    public Instructor() {
    }

    public Instructor(String name, Coolness coolness) {
        this.name = name;
        this.coolness = coolness;
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

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public Coolness getCoolness() {
        return coolness;
    }

    public void setCoolness(Coolness coolness) {
        this.coolness = coolness;
    }

    @OneToMany(mappedBy = "instructor")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}

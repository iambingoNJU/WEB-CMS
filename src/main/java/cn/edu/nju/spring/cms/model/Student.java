package cn.edu.nju.spring.cms.model;

import javax.persistence.*;

/**
 * Created by bingo on 2017/6/20.
 */

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "major")
    private String major;
    @Column(name = "grade_usual")
    private Double grade_usual;
    @Column(name = "grade_homework")
    private Double grade_homework;
    @Column(name = "grade_exam")
    private Double grade_exam;

    public Student() {}
    public Student(String id, String name, String major, Double grade_usual, Double grade_homework, Double grade_exam) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade_usual = grade_usual;
        this.grade_homework = grade_homework;
        this.grade_exam = grade_exam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGrade_usual() {
        return grade_usual;
    }

    public void setGrade_usual(Double grade_usual) {
        this.grade_usual = grade_usual;
    }

    public Double getGrade_homework() {
        return grade_homework;
    }

    public void setGrade_homework(Double grade_homework) {
        this.grade_homework = grade_homework;
    }

    public Double getGrade_exam() {
        return grade_exam;
    }

    public void setGrade_exam(Double grade_exam) {
        this.grade_exam = grade_exam;
    }
}

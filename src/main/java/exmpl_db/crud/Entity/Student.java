package exmpl_db.crud.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//@Entity
//@Table (name ="test_students")
public class Student {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", unique = true)
    private String name;

   // @Column(name = "surname")
    private String surname;

    @Column(name = "avg_grade", nullable = false)
    private Double avgGrade;

    @Transient
    private LocalDateTime createdDate;

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Student() {}

    public Student(String name, String surname, Double avrGrade) {
        this.name = name;
        this.surname = surname;
        this.avgGrade = avgGrade;
        createdDate = LocalDateTime.now();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAvrGrade() {
        return avgGrade;
    }

    public void setAvrGrade(Double avrGrade) {
        this.avgGrade = avgGrade;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", avg_Grade=" + avgGrade +
                ", createdDate=" + createdDate +
                '}';
    }
}

package exmpl_db.relationships.one_to_one;


import jakarta.persistence.*;
// класс для создания паспортов студентов в таблицу passports
@Entity
@Table(name="passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "email")
    private String email;

    @Column (name = "height")
    private Integer height;

    @Column (name = "eye_color")
    private String eyeColor;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Student student;


    public Passport() {
    }

    public Passport(String email, Integer height, String eyeColor) {
        this.email = email;
        this.height = height;
        this.eyeColor = eyeColor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }
}

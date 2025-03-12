package exmpl_db.crud.jpa_crud;

import exmpl_db.crud.Entity.Student;
import jakarta.persistence.*;
// поиск студента
public class Find_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-training");
        EntityManager entityManager = factory.createEntityManager();

        Student student = null;

        try {
            student = entityManager.find(Student.class, 5);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            factory.close();
        }
        System.out.println(student);


    }
}

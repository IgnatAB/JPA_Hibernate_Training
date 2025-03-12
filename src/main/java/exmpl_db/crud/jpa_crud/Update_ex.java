package exmpl_db.crud.jpa_crud;

import exmpl_db.crud.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
// класс для изменения данных
public class Update_ex {
    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-training");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Student student = null;

        try {
            transaction.begin();
            student = entityManager.find(Student.class, 2);
            student.setSurname("Vasechkin");
            transaction.commit();
        } catch (
                Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
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

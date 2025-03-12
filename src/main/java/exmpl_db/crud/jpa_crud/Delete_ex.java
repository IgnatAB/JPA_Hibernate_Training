package exmpl_db.crud.jpa_crud;

import exmpl_db.crud.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
// удалениу строки из таблицы
public class Delete_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-training");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Student student = null;

        try{
            transaction.begin();
            student = entityManager.find(Student.class, 6);
            entityManager.remove(student);

            transaction.commit();

        } catch (Exception e) {
            if (transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if(entityManager!=null){
                entityManager.close();
            }
            factory.close();
        }
        System.out.println(student);

    }
}

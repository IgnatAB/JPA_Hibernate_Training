package exmpl_db.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneUni {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-training");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();
//            PERSIST
//            Student student1 = new Student("Isaac", "Sharp", 9.8);
//            Passport passport1 = new Passport("isaac.sharp@yahoo.com", 185, "blue");
//            student1.setPassport(passport1);


           // entityManager.persist(passport1);
//            entityManager. persist(student1);

            //FIND
//            Student student2 = null;
//            student2 = entityManager.find(Student.class, 100);
//            System.out.println(student2);
//            System.out.println(student2.getPassport());

            //REMOVE
            Student student3 =entityManager.find(Student.class, 4);
            entityManager.remove(student3);
            transaction.commit();

        } catch (Exception e) {
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

        ;
    }


}

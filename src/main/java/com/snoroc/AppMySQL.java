package com.snoroc;

import com.snoroc.service.CreditService;
import jakarta.persistence.*;

public class AppMySQL {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-demo-local-mysql");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        //GraphService.runGraph(entityManager);
        //CreditService.testFetch(entityManager);
        CreditService.testProcedure(entityManager);

        entityTransaction.commit();

    }
}

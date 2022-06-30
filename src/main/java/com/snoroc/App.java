package com.snoroc;

import com.snoroc.service.GraphService;
import jakarta.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-demo-local");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        GraphService.runGraph(entityManager);

        entityTransaction.commit();

    }
}

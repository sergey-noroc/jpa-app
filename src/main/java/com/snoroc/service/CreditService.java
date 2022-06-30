package com.snoroc.service;

import com.snoroc.domain.CreditTransaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;

import java.util.List;

public class CreditService {

    public static void findAll(EntityManager entityManager) {
        entityManager.createQuery("select cc from CreditCard cc").getResultList();
    }

    public static void findCardTransactions(EntityManager entityManager) {
        List<CreditTransaction> transactions = entityManager
                .createQuery("select ct from CreditTransaction ct", CreditTransaction.class).getResultList();
        transactions.stream().forEach(creditTransaction -> System.out.println(creditTransaction.getPlace()));
    }

    public static void testFetch(EntityManager entityManager) {
        entityManager
                .createQuery("select ct from CreditTransaction ct join fetch ct.creditCard", CreditTransaction.class).getResultList();
    }

    public static void testProcedure(EntityManager entityManager) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("calculate");
        query.setParameter("type", "MASTER");
        query.execute();
        int sum = (int) query.getOutputParameterValue("sum");
        System.out.println(sum);
    }
}

package com.snoroc.service;

import com.snoroc.domain.CreditCard;
import com.snoroc.domain.CreditTransaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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

    public static void estUpdate(EntityManager entityManager) {
        CreditCard creditCard = entityManager.find(CreditCard.class, 1L);
        creditCard.setBalance(5000);

        System.out.println(creditCard);
    }

    public static void testMultipleFields(EntityManager entityManager) {
        List<Tuple> query = entityManager.createQuery("select cc.owner from CreditCard cc", Tuple.class).getResultList();
        query.stream().forEach(tuple -> System.out.println(tuple));
    }

    public static void testCriteria(EntityManager entityManager) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CreditCard> query = cb.createQuery(CreditCard.class);
        Root<CreditCard> root = query.from(CreditCard.class);
        TypedQuery<CreditCard> typedQuery = entityManager.createQuery(query);
        typedQuery.getResultList();
    }
}

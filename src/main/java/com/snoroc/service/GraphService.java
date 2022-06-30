package com.snoroc.service;

import jakarta.persistence.EntityManager;

public class GraphService {

    public static void runGraph(EntityManager entityManager) {
        //LAZY
        entityManager.createQuery("select p from Post p").getResultList();

        //EAGER for images and tags
        entityManager
                .createQuery("select p from Post p where p.title = :title order by p.title desc")
                .setParameter("title", "Hello")
                .setHint("javax.persistence.fetchgraph", entityManager.getEntityGraph("post-entity-graph"))
                .getResultList();
    }
}

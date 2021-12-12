package br.ufes.dwws.eventlistener.infrastructure.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class JPAPersistence {

    @PersistenceContext
    private EntityManager em;

    protected JPAPersistence() {
    }

    protected EntityManager getEntityManager() {
        return em;
    }
}

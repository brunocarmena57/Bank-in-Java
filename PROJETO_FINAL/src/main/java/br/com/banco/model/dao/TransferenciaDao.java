package br.com.banco.model.dao;

import br.com.banco.model.entity.TransferenciaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TransferenciaDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco-manager");
    private static EntityManager em = emf.createEntityManager();

    public static void efetuarTransferencia(TransferenciaEntity transferenciaEntity) {
        try{
            em.getTransaction().begin();
            em.persist(transferenciaEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

}

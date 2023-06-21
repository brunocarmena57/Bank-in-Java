package br.com.banco.model.dao;

import br.com.banco.model.entity.ContaEntity;
import br.com.banco.model.entity.PessoaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContaDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco-manager");
    private static EntityManager em = emf.createEntityManager();

    public void cadastraConta(ContaEntity contaEntity) {
        try{
            em.getTransaction().begin();
            em.persist(contaEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void alteraConta(ContaEntity contaEntity) {
        try{
            em.getTransaction().begin();
            em.merge(contaEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public ContaEntity buscarConta(int id) {
        try {
            em.getTransaction().begin();
            ContaEntity contaEntity = em.find(ContaEntity.class, id);
            em.getTransaction().commit();
            return contaEntity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }

    public ContaEntity buscarConta(PessoaEntity pessoaEntity) {
        try {
            em.getTransaction().begin();
            ContaEntity contaEntity = (ContaEntity) em.createNativeQuery("select * from conta where pessoa_id = :pessoa_id", ContaEntity.class)
                    .setParameter("pessoa_id", pessoaEntity.getId())
                    .getSingleResult();
            em.getTransaction().commit();
            return contaEntity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }

    public void deletaConta(ContaEntity contaEntity) {
        try {
            em.getTransaction().begin();
            contaEntity = em.merge(contaEntity);
            em.remove(contaEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }
    }

}

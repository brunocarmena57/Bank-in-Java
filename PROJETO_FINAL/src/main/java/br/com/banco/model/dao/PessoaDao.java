package br.com.banco.model.dao;

import br.com.banco.model.entity.ContaEntity;
import br.com.banco.model.entity.PessoaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco-manager");
    private static EntityManager em = emf.createEntityManager();

    public void createPessoa(PessoaEntity pessoaEntity) {
        try{
            em.getTransaction().begin();
            em.persist(pessoaEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public PessoaEntity buscaPessoa(int id) {
        try {
            em.getTransaction().begin();
            PessoaEntity pessoaEntity = em.find(PessoaEntity.class, id);
            em.getTransaction().commit();
            return pessoaEntity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }

    public PessoaEntity buscaPessoa(String nome) {
        try {
            em.getTransaction().begin();
            PessoaEntity pessoaEntity = (PessoaEntity) em.createNativeQuery("select * from pessoa where nome = :nome", PessoaEntity.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
            em.getTransaction().commit();
            return pessoaEntity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }

    public List<PessoaEntity> buscaPessoas() {
        try {
            em.getTransaction().begin();
            List<PessoaEntity> pessoaEntity = em.createNativeQuery("select * from pessoa", PessoaEntity.class).getResultList();
            em.getTransaction().commit();
            return pessoaEntity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }

    public void alteraPessoa(PessoaEntity pessoaEntity) {
        try{
            em.getTransaction().begin();
            em.merge(pessoaEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void deletaPessoa(PessoaEntity pessoaEntity) {
        try {
            em.getTransaction().begin();
            pessoaEntity = em.merge(pessoaEntity);
            em.remove(pessoaEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }
    }

}

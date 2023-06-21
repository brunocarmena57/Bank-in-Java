package br.com.banco.model.dao;

import br.com.banco.model.entity.BancoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BancoDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco-manager");
    private static EntityManager em = emf.createEntityManager();

    public void adicionarSaldo(BancoEntity bancoEntity) {
        try{
            em.getTransaction().begin();
            em.persist(bancoEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public float buscarSaldo() {
        try {
            float valorTotal = 0f;
            em.getTransaction().begin();
            List<BancoEntity> bancoEntity = em.createNativeQuery("select * from banco", BancoEntity.class).getResultList();
            em.getTransaction().commit();
            for (BancoEntity valor: bancoEntity) {
                valorTotal+=valor.getSaldo();
            }
            return valorTotal;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return 0f;
        }
    }
}

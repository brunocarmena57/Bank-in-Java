package br.com.banco.model.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "banco")
public class BancoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    private int id;

    private float saldo;

    public int getId() {
        return id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(float saldo) {
        this.saldo += saldo;
    }

}

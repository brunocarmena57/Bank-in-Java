package br.com.banco.model.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "conta")
public class ContaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    private int id;

    private float saldo;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    public PessoaEntity pessoaEntity;

    public PessoaEntity getPessoaEntity() {
        return pessoaEntity;
    }

    public void setPessoaEntity(PessoaEntity pessoaEntity) {
        this.pessoaEntity = pessoaEntity;
    }

    public int getId() {
        return id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}

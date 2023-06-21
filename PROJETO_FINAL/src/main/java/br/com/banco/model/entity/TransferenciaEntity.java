package br.com.banco.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "transferencia")
public class TransferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    private int id;

    @OneToOne
    @JoinColumn(name = "conta_envia_id")
    public PessoaEntity pessoaEntityEnvia;

    @OneToOne
    @JoinColumn(name = "conta_recebe_id")
    public PessoaEntity pessoaEntityRecebe;

    private float valor;


    public PessoaEntity getPessoaEntityEnvia() {
        return pessoaEntityEnvia;
    }

    public void setPessoaEntityEnvia(PessoaEntity pessoaEntityEnvia) {
        this.pessoaEntityEnvia = pessoaEntityEnvia;
    }

    public PessoaEntity getPessoaEntityRecebe() {
        return pessoaEntityRecebe;
    }

    public void setPessoaEntityRecebe(PessoaEntity pessoaEntityRecebe) {
        this.pessoaEntityRecebe = pessoaEntityRecebe;
    }


    public int getId() {
        return id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}

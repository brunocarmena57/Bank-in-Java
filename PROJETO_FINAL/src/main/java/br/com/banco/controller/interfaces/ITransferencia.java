package br.com.banco.controller.interfaces;

import br.com.banco.model.entity.PessoaEntity;

public interface ITransferencia {

    void efetuarTransferencia(float valor, PessoaEntity pessoaEnviar, PessoaEntity pessoaReceber);

}

package br.com.banco.controller.interfaces;

import br.com.banco.model.entity.ContaEntity;
import br.com.banco.model.entity.PessoaEntity;

public interface IContaController {

    void criarConta(ContaEntity contaEntity);

    ContaEntity buscarConta(int id);

    ContaEntity buscarConta(PessoaEntity pessoaEntity);

    void atualizarConta(ContaEntity contaEntity);

    void deletarConta(ContaEntity contaEntity);

}

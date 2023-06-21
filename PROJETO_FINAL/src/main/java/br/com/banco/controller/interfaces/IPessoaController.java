package br.com.banco.controller.interfaces;

import br.com.banco.model.entity.PessoaEntity;

import java.util.List;

public interface IPessoaController {

    void criarPessoa(PessoaEntity pessoaEntity);

    PessoaEntity buscarPessoa(int id);

    PessoaEntity buscarPessoa(String nome);

    List<PessoaEntity> buscarTodas();

    void atualizarPessoa(PessoaEntity pessoaEntity);

    void deletarPessoa(PessoaEntity pessoaEntity);

}

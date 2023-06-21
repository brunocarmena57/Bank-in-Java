package br.com.banco.controller;

import br.com.banco.controller.interfaces.IPessoaController;
import br.com.banco.model.dao.PessoaDao;
import br.com.banco.model.entity.PessoaEntity;

import java.util.List;

public class PessoaController implements IPessoaController {

    private PessoaDao pessoaDao = new PessoaDao();

    public void criarPessoa(PessoaEntity pessoaEntity) {
        pessoaDao.createPessoa(pessoaEntity);
    }

    public PessoaEntity buscarPessoa(int id) {
        return pessoaDao.buscaPessoa(id);
    }

    public PessoaEntity buscarPessoa(String nome) {
        return pessoaDao.buscaPessoa(nome);
    }

    public List<PessoaEntity> buscarTodas() {
        return pessoaDao.buscaPessoas();
    }

    public void atualizarPessoa(PessoaEntity pessoaEntity) {
        pessoaDao.alteraPessoa(pessoaEntity);
    }

    public void deletarPessoa(PessoaEntity pessoaEntity) {
        pessoaDao.deletaPessoa(pessoaEntity);
    }

}

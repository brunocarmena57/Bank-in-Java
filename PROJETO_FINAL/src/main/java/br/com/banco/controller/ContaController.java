package br.com.banco.controller;

import br.com.banco.controller.interfaces.IContaController;
import br.com.banco.model.dao.ContaDao;
import br.com.banco.model.entity.ContaEntity;
import br.com.banco.model.entity.PessoaEntity;

public class ContaController implements IContaController {
    private ContaDao contaDao = new ContaDao();

    @Override
    public void criarConta(ContaEntity contaEntity) {
        contaDao.cadastraConta(contaEntity);
    }

    @Override
    public ContaEntity buscarConta(int id) {
        return contaDao.buscarConta(id);
    }

    @Override
    public ContaEntity buscarConta(PessoaEntity pessoaEntity) {
        return contaDao.buscarConta(pessoaEntity);
    }

    @Override
    public void atualizarConta(ContaEntity contaEntity) {
        contaDao.alteraConta(contaEntity);
    }

    @Override
    public void deletarConta(ContaEntity contaEntity) {
        contaDao.deletaConta(contaEntity);
    }
}

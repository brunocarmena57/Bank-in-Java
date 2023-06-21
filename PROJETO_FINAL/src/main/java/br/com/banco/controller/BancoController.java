package br.com.banco.controller;

import br.com.banco.model.dao.BancoDao;
import br.com.banco.model.entity.BancoEntity;

public class BancoController {

    private static BancoDao bancoDao = new BancoDao();

    public void adicionarSaldo(BancoEntity bancoEntity) {
        bancoDao.adicionarSaldo(bancoEntity);
    }

    public float buscarSaldo() {
        return bancoDao.buscarSaldo();
    }

}

package br.com.banco.controller;

import br.com.banco.controller.interfaces.ITransferencia;
import br.com.banco.model.dao.TransferenciaDao;
import br.com.banco.model.entity.BancoEntity;
import br.com.banco.model.entity.ContaEntity;
import br.com.banco.model.entity.PessoaEntity;
import br.com.banco.model.entity.TransferenciaEntity;

public class TransferenciaPersonalizadaController extends TransferenciaAbstract implements ITransferencia {
    private static ContaController contaController = new ContaController();
    private static BancoController bancoController = new BancoController();

    public TransferenciaPersonalizadaController() {
        super(0);
    }

    public TransferenciaPersonalizadaController(float valueTaxaFixa) {
        super(valueTaxaFixa);
    }

    float taxaTransferencia(float valor) {
        return 0;
    }

    public void efetuarTransferencia(float valor, PessoaEntity pessoaEnviar, PessoaEntity pessoaReceber) {
        ContaEntity contaEnviar = contaController.buscarConta(pessoaEnviar);
        ContaEntity contaReceber = contaController.buscarConta(pessoaReceber);

        TransferenciaEntity transferenciaEntity = new TransferenciaEntity();
        transferenciaEntity.setValor(valor);
        transferenciaEntity.setPessoaEntityEnvia(pessoaEnviar);
        transferenciaEntity.setPessoaEntityRecebe(pessoaReceber);

        BancoEntity bancoEntity = new BancoEntity();
        bancoEntity.adicionarSaldo(getValueTaxaFixa());
        bancoController.adicionarSaldo(bancoEntity);

        contaEnviar.setSaldo(contaEnviar.getSaldo() - valor);

        contaReceber.setSaldo(contaReceber.getSaldo() + (valor-getValueTaxaFixa()));
        contaController.atualizarConta(contaEnviar);
        contaController.atualizarConta(contaReceber);
        TransferenciaDao.efetuarTransferencia(transferenciaEntity);
    }

}

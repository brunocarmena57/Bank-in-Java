package br.com.banco.view;

import br.com.banco.controller.*;
import br.com.banco.controller.interfaces.IContaController;
import br.com.banco.controller.interfaces.IPessoaController;
import br.com.banco.model.entity.ContaEntity;
import br.com.banco.model.entity.PessoaEntity;

import java.util.Scanner;

public class MenuBanco {
    private IPessoaController pessoaController = new PessoaController();
    private static IContaController contaController = new ContaController();
    private static TransferenciaPixController transferenciaPixController = new TransferenciaPixController();
    private static TransferenciaTedController transferenciaTedController = new TransferenciaTedController();
    private static TransferenciaPersonalizadaController transferenciaPersonalizadaController;
    private static BancoController bancoController = new BancoController();

    private Scanner scanner;

    private void limparLog() {
        System.out.println("########################################");
        System.out.println("########################################");
    }

    public MenuBanco() {
        this.scanner = new Scanner(System.in);
    }

    private void criarConta() {
        limparLog();

        System.out.println("Digite o nome da pessoa para nova conta:");
        String nomePessoa = scanner.next();
        scanner.nextLine();

        PessoaEntity pessoaEntity = pessoaController.buscarPessoa(nomePessoa);

        System.out.println("Digite o valor inicial da conta:");
        float saldoPessoa = scanner.nextFloat();
        scanner.nextLine();

        ContaEntity contaEntity = new ContaEntity();
        contaEntity.setPessoaEntity(pessoaEntity);
        contaEntity.setSaldo(saldoPessoa);
        contaController.criarConta(contaEntity);

        System.out.println("Conta criada com sucesso!");
        limparLog();
    }

    private void deletarConta() {
        limparLog();
        System.out.println("Digite o nome da conta a ser excluída:");
        String nomePessoa = scanner.next();

        PessoaEntity pessoaEntity = pessoaController.buscarPessoa(nomePessoa);
        ContaEntity contaExcluir = contaController.buscarConta(pessoaEntity);
        contaController.deletarConta(contaExcluir);

        System.out.println("Conta deletada com sucesso!");
        limparLog();
    }

    private void conta() {
        System.out.println("----------- MENU Conta -----------");
        System.out.println("1. Criar");
        System.out.println("2. Excluir");
        System.out.println("----------------------------");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                criarConta();
                break;
            case 2:
                deletarConta();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }

    private void criarPessoa() {
        limparLog();

        System.out.println("Digite o nome da pessoa:");
        String nomePessoa = scanner.next();
        scanner.nextLine();

        if (nomePessoa.isEmpty()) {
            System.out.println("Erro: O nome não pode estar vazio!");
        return;
        }

        System.out.println("Digite a idade da pessoa:");
        int idadePessoa = scanner.nextInt();
        scanner.nextLine();

        if (idadePessoa < 18 || idadePessoa > 100) {
            System.out.println("Erro: A idade da pessoa deve estar entre 18 e 100 anos!");
        return;
    } 
    

        System.out.println("Digite o email da pessoa:");
        String emailPessoa = scanner.next();
        scanner.nextLine();

        System.out.println("Digite o cep da pessoa:");
        int cepPessoa = scanner.nextInt();
        scanner.nextLine();

        if (Integer.toString(cepPessoa).length() != 8) {
            System.out.println("Erro: O CEP deve ser um número de 8 dígitos!");
        return;
    }

        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setNome(nomePessoa);
        pessoaEntity.setIdade(idadePessoa);
        pessoaEntity.setEmail(emailPessoa);
        pessoaEntity.setCep(cepPessoa);

        pessoaController.criarPessoa(pessoaEntity);
        System.out.println("Pessoa criada com sucesso!");
        limparLog();
    }

    private void obterPessoa() {
        limparLog();

        System.out.println("Digite o nome da pessoa:");
        String nomePessoa = scanner.next();
        scanner.nextLine();

        PessoaEntity pessoaEntity = pessoaController.buscarPessoa(nomePessoa);
        System.out.println("A pessoa informada (" + pessoaEntity.getNome() + ") tem atualmente " + pessoaEntity.getIdade() + " anos de idade e o email é:" + pessoaEntity.getEmail() + " com CEP número: " + pessoaEntity.getCep());

        limparLog();
    }

    private void alterarPessoa() {
        limparLog();

        System.out.println("Digite o id da pessoa que deseja alterar:");
        int idPessoaAntiga = scanner.nextInt();
        scanner.nextLine();

        PessoaEntity pessoaEntity = pessoaController.buscarPessoa(idPessoaAntiga);

        System.out.println("Digite o nome da pessoa:");
        String nomePessoa = scanner.next();
        scanner.nextLine();

        pessoaEntity.setNome(nomePessoa);

        System.out.println("Digite a idade da pessoa:");
        int idadePessoa = scanner.nextInt();
        scanner.nextLine();

        pessoaEntity.setIdade(idadePessoa);

        System.out.println("Digite o email da pessoa:");
        String emailPessoa = scanner.next();
        scanner.nextLine();

        pessoaEntity.setEmail(emailPessoa);

        System.out.println("Digite o cep da pessoa:");
        int cepPessoa = scanner.nextInt();
        scanner.nextLine();

        pessoaEntity.setCep(cepPessoa);

        pessoaController.atualizarPessoa(pessoaEntity);
        System.out.println("Pessoa alterada com sucesso!");
        limparLog();
    }

    private void deletarPessoa() {
        limparLog();

        System.out.println("Digite o nome da pessoa a ser excluída:");
        String nomePessoa = scanner.nextLine();
        PessoaEntity pessoaEntity = pessoaController.buscarPessoa(nomePessoa);
        pessoaController.deletarPessoa(pessoaEntity);
        System.out.println("Pessoa excluida com sucesso!");
        limparLog();
    }

    private void obterTodasPessoas() {
        limparLog();
        System.out.println("Pessoas salvas no banco de dados:");
        for (PessoaEntity pessoaEntity : pessoaController.buscarTodas()) {
            System.out.println("    - " + pessoaEntity.getNome());
        }
        limparLog();
        System.out.println("Todos retornos do bancos foram exibidos!");
        limparLog();
    }

    private void pessoa() {
        System.out.println("----------- MENU Pessoa -----------");
        System.out.println("1. Criar");
        System.out.println("2. ObterDados");
        System.out.println("3. Editar");
        System.out.println("4. Excluir");
        System.out.println("5. Buscar todas pessoas");
        System.out.println("----------------------------");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                criarPessoa();
                break;
            case 2:
                obterPessoa();
                break;
            case 3:
                alterarPessoa();
                break;
            case 4:
                deletarPessoa();
                break;

            case 5:
                obterTodasPessoas();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }

    private void criarTransferencia() {
        limparLog();

        System.out.println("Digite o nome da sua conta:");
        String nomeConta = scanner.next();
        scanner.nextLine();

        PessoaEntity pessoaEnviarEntity = pessoaController.buscarPessoa(nomeConta);

        System.out.println("Digite o nome da pessoa que vai receber:");
        String nomePessoa = scanner.next();
        scanner.nextLine();

        PessoaEntity pessoaReceberEntity = pessoaController.buscarPessoa(nomePessoa);

        System.out.println("Digite o tipo de transferencia (1 = pix, 2 = ted, 3 = taxa personalizada):");
        int tipoTransferencia = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o valor a ser transferido:");
        float valorTransferir = scanner.nextInt();
        scanner.nextLine();

        switch(tipoTransferencia){
            case 1: transferenciaPixController.efetuarTransferencia(valorTransferir, pessoaEnviarEntity, pessoaReceberEntity); break;
            case 2: transferenciaTedController.efetuarTransferencia(valorTransferir, pessoaEnviarEntity, pessoaReceberEntity); break;
            case 3:
                transferenciaPersonalizadaController = new TransferenciaPersonalizadaController(5);
                transferenciaPersonalizadaController.efetuarTransferencia(valorTransferir, pessoaEnviarEntity, pessoaReceberEntity);
                break;
        }

        System.out.println("Transferencia feita com sucesso!");
        limparLog();
    }

    private void transferencia() {
        criarTransferencia();
    }

    private void verExtrato() {
        System.out.println("Digite o nome da conta para consultar o saldo:");
        String nomeConta = scanner.next();
        scanner.nextLine();
        PessoaEntity pessoaEntity = pessoaController.buscarPessoa(nomeConta);
        ContaEntity contaEntity = contaController.buscarConta(pessoaEntity);
        limparLog();
        System.out.println(pessoaEntity.getNome() + " tem um total de R$" + contaEntity.getSaldo() + " em sua conta!");
        limparLog();
    }

    private void verExtratoBanco() {
        limparLog();
        System.out.println("Atualmente o nosso banco tem um total de R$" + bancoController.buscarSaldo() + " em juros guardados!");
        limparLog();
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("----------- MENU -----------");
            System.out.println("1. Pessoa");
            System.out.println("2. Conta");
            System.out.println("3. Transferir");
            System.out.println("4. Ver extrato");
            System.out.println("5. Total imposto obtido no banco");
            System.out.println("6. Sair");
            System.out.println("----------------------------");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    pessoa();
                    break;
                case 2:
                    conta();
                    break;
                case 3:
                    transferencia();
                    break;
                case 4:
                    verExtrato();
                    break;
                case 5:
                    verExtratoBanco();
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}

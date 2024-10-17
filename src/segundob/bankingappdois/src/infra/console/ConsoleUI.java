package src.segundob.bankingappdois.src.infra.console;

import java.util.Scanner;

import src.segundob.bankingappdois.src.domain.dto.LoginDTO;
import src.segundob.bankingappdois.src.domain.dto.UserAccountDTO;
import src.segundob.bankingappdois.src.domain.repositories.IUserInterface;

public class ConsoleUI implements IUserInterface {

    private Scanner input = new Scanner(System.in);

    @Override
    public Integer showInitialScreenMenu() {
        System.out.println("MENU BANKIM SANDRO");
        System.out.println("[1] Logar");
        System.out.println("[2] Criar conta");
        System.out.println("[3] Sair");

        Integer option = input.nextInt();

        return option;
    }

    @Override
    public Integer showHomeMenu(String userName) {
        System.out.println("Bem vindo " + userName);
        System.out.println("[1] Gerar PIX");
        System.out.println("[2] Consultar boleto");
        System.out.println("[3] Pagar boleto");

        Integer option = input.nextInt();

        return option;
    }

    @Override
    public LoginDTO getLoginData() {
        LoginDTO loginData = new LoginDTO();

        input.nextLine();

        System.out.println("Informe seu documento:");
        String document = input.nextLine();

        System.out.println("Informe sua senha:");
        String password = input.nextLine();

        loginData.setDocument(document);
        loginData.setPassword(password);

        return loginData;
    }

    @Override
    public UserAccountDTO getCreateUserData() {
        UserAccountDTO dto = new UserAccountDTO();

        System.out.println("Informe seu documento:");
        String documento = input.nextLine();

        dto.setDocument(documento);

        return dto;
    }

    @Override
    public void showErrorMsg(String msg) {
        System.out.println("Erro!!!" + msg);
    }

    @Override
    public void showExitMessage() {
        System.out.println("Obrigado por utilizar o banco!");
    }

}

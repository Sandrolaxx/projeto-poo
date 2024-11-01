package com.fag.infra.swing;

import javax.swing.JOptionPane;

import com.fag.domain.repositories.IUserInterface;

public class SwingUserInterface implements IUserInterface {

    @Override
    public Integer showInitialScreenMenu() {
        String menu = "----------BANCO BALA SANDROLAXX--------\n"
                .concat("[1] Login\n")
                .concat("[2] Cadastro\n")
                .concat("[3] Sair");

        String escolha = JOptionPane.showInputDialog(
                null,
                menu,
                "🏦Menu Inicial do Banco Bala",
                JOptionPane.INFORMATION_MESSAGE);

        return Integer.parseInt(escolha);
    }

}

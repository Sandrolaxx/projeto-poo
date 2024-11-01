package com.fag;

import com.fag.domain.repositories.IUserInterface;
import com.fag.infra.console.ConsoleUserInterface;
import com.fag.infra.swing.SwingUserInterface;

public class Main {
    public static void main(String[] args) {
        ConsoleUserInterface consoleUI = new ConsoleUserInterface();
        SwingUserInterface swing = new SwingUserInterface();
    }

}
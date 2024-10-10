package src.segundob.bankingapp.src;

import src.segundob.bankingapp.src.infra.console.ConsoleUI;
import src.segundob.bankingapp.src.infra.testdb.UserTestDBRepository;
import src.segundob.bankingapp.src.service.Application;

public class Main {

    public static void main(String[] args) {

        Application app = new Application();

        ConsoleUI consoleUI = new ConsoleUI();
        UserTestDBRepository userRepo = new UserTestDBRepository();

        app.execute(consoleUI, userRepo);

    }

}

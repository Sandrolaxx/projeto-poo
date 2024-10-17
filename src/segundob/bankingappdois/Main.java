package src.segundob.bankingappdois;

import src.segundob.bankingappdois.src.infra.console.ConsoleUI;
import src.segundob.bankingappdois.src.infra.testdb.UserTestDBRepository;
import src.segundob.bankingappdois.src.services.Application;

public class Main {

    public static void main(String[] args) {

        Application app = new Application();

        ConsoleUI consoleUI = new ConsoleUI();
        UserTestDBRepository userRepo = new UserTestDBRepository();

        app.execute(consoleUI, userRepo);

    }

}

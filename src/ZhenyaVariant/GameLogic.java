package ZhenyaVariant;
import java.util.Objects;
import java.util.Scanner;

public class GameLogic {
    private final Field field = new Field();
    private final Scanner scanner = new Scanner(System.in);

    private final String X_SYMBOL = "X";
    private final String O_SYMBOL = "O";

    public void startGame() {
        while (Objects.isNull(checkWinner())) {
            //Get first user input
            int firstUserChoice = getUserInput();
            field.setValue(firstUserChoice, X_SYMBOL);
            //Get second user input
            int secondUserChoice = getUserInput();
            field.setValue(secondUserChoice, O_SYMBOL);
        }
    }

    private int getUserInput() {
        field.showField();
        System.out.println("Enter index: ");
        int choice = scanner.nextInt();
        while (!validateUserInput(choice)) {
            System.out.println("Enter index: ");
            choice = scanner.nextInt();
        }
        return choice;
    }

    private boolean validateUserInput(int choice) {
        return choice >= 1 && choice <= 9 && field.getValue(choice) == null;
    }

    private String checkWinner() {
        return null;
    }

}

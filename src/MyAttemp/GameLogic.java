package MyAttemp;

import java.util.Objects;
import java.util.Scanner;

public class GameLogic {
    private final String X_SIMBOL = "X";
    private final String O_SIMBOL = "O";
    private final Scanner scanner = new Scanner(System.in);
    private final GameField field = new GameField();

    public void startGame(){
        while (Objects.isNull(checkWinner())){
            //Get first user input
            int firstUserChoice = getUserInput();
            field.setValues(firstUserChoice,X_SIMBOL);
            //Get second user input
            int secondUserChoice = getUserInput();
            field.setValues(secondUserChoice,O_SIMBOL);
        }
    }
    private int getUserInput(){
        field.showGameField();
        System.out.println("Enter index: ");
        int choice = scanner.nextInt();
        while(!validateUser(choice)){
            choice = scanner.nextInt();
            System.out.println("Enter index: ");
        }
        return choice;
    }
    private boolean validateUser(int choice){
        return choice >= 1 && choice <= 9 && field.getValues(choice) == null;
    }
    private String checkWinner(){
        String theSame = field.VALUES[0];
        for (int i = 0; i < field.VALUES.length; i++) {
            if (field.VALUES[i] == theSame){
                theSame = field.VALUES[i];
                System.out.println(theSame);
            }
        }
        return null;
    }
    private void isWinnerX(){
        if (ifWinnerX()){
            System.out.println("Winner is 'X' ");
        }
    }
    private void isWinnerO(){
        if (ifWinnerO()){
            System.out.println("Winner is '0' ");
        }
    }
    private void isDraw(){
        if (!validateUser(9)){
            System.out.println("Draw ");
        }
    }
    public boolean ifWinnerX(){
        return field.getValues(0).equals("X")&&field.getValues(1).equals("X")&&field.getValues(2).equals("X") ||
                field.getValues(3).equals("X")&&field.getValues(4).equals("X")&&field.getValues(5).equals("X") ||
                field.getValues(6).equals("X")&&field.getValues(7).equals("X")&&field.getValues(8).equals("X") ||

                field.getValues(0).equals("X") && field.getValues(3).equals("X") && field.getValues(6).equals("X") ||
                field.getValues(1).equals("X") && field.getValues(4).equals("X") && field.getValues(7).equals("X") ||
                field.getValues(2).equals("X") && field.getValues(5).equals("X") && field.getValues(8).equals("X") ||

                field.getValues(0).equals("X") && field.getValues(4).equals("X") && field.getValues(8).equals("X") ||
                field.getValues(2).equals("X") && field.getValues(4).equals("X") && field.getValues(6).equals("X");
    }
    public boolean ifWinnerO(){
        return field.getValues(0).equals("O")&&field.getValues(1).equals("O")&&field.getValues(2).equals("O") ||
                field.getValues(3).equals("O")&&field.getValues(4).equals("O")&&field.getValues(5).equals("O") ||
                field.getValues(6).equals("O")&&field.getValues(7).equals("O")&&field.getValues(8).equals("O") ||

                field.getValues(0).equals("O") && field.getValues(3).equals("O") && field.getValues(6).equals("O") ||
                field.getValues(1).equals("O") && field.getValues(4).equals("O") && field.getValues(7).equals("O") ||
                field.getValues(2).equals("O") && field.getValues(5).equals("O") && field.getValues(8).equals("O") ||

                field.getValues(0).equals("O") && field.getValues(4).equals("O") && field.getValues(8).equals("O") ||
                field.getValues(2).equals("O") && field.getValues(4).equals("O") && field.getValues(6).equals("O");
    }

}

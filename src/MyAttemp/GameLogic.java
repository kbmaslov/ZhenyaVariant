package MyAttemp;

import java.util.Objects;
import java.util.Scanner;

public class GameLogic {
    private final String X_SYMBOL = " X ";
    private final String O_SYMBOL = " O ";
    private int StatusGame;
    private final int INPROGRESS = 0, DRAW = 1, WINNER_X = 3, WINNER_O = 4;
    private final Scanner scanner = new Scanner(System.in);
    private final GameField field = new GameField();


    private void findOutWinner() {
        startGame();
        do {
            getUserInput();
            analyzeStatus();
            field.showField();
            if (StatusGame == WINNER_X) {
                System.out.println("Выиграл 'X'");
            } else if (StatusGame == WINNER_O) {
                System.out.println("Выиграл '0'");
            } else if (StatusGame == DRAW) {
                System.out.println("Ничья");
            }

        } while (StatusGame == INPROGRESS);
    }

    public void startGame() {
        field.createGameField();
        while (Objects.isNull(checkWinner2())) {
            //Get first user input
            int firstUserChoice = getUserInput();
            field.setValues(firstUserChoice, X_SYMBOL);
            //Get second user input
            int secondUserChoice = getUserInput();
            field.setValues(secondUserChoice, O_SYMBOL);
        }

    }

    private int getUserInput() {
        field.showField();
        System.out.println("Enter index from 1 to 9 : ");
        int choice = scanner.nextInt();
        while (!validateUser(choice)) {
            choice = scanner.nextInt();
            System.out.println("Enter wrong index,try again ! ");
        }
        return choice - 1;
    }

    private boolean validateUser(int choice) {
        return choice >= 1 && choice <= 10 && field.getValues(choice - 1) == field.getEMPTY();
    }

    //private String checkWinner(){return null;}
    private String checkWinner2(){
        int counterX =0;

        if (    field.getValues(0).equals(X_SYMBOL)&&field.getValues(1).equals(X_SYMBOL)&&field.getValues(2).equals(X_SYMBOL) ||
                field.getValues(3).equals(X_SYMBOL)&&field.getValues(4).equals(X_SYMBOL)&&field.getValues(5).equals(X_SYMBOL) ||
                field.getValues(6).equals(X_SYMBOL)&&field.getValues(7).equals(X_SYMBOL)&&field.getValues(8).equals(X_SYMBOL) ||

                field.getValues(0).equals(X_SYMBOL) && field.getValues(3).equals(X_SYMBOL) && field.getValues(6).equals(X_SYMBOL) ||
                field.getValues(1).equals(X_SYMBOL) && field.getValues(4).equals(X_SYMBOL) && field.getValues(7).equals(X_SYMBOL) ||
                field.getValues(2).equals(X_SYMBOL) && field.getValues(5).equals(X_SYMBOL) && field.getValues(8).equals(X_SYMBOL) ||

                field.getValues(0).equals(X_SYMBOL) && field.getValues(4).equals(X_SYMBOL) && field.getValues(8).equals(X_SYMBOL)
                || field.getValues(2).equals(X_SYMBOL) && field.getValues(4).equals(X_SYMBOL) && field.getValues(6).equals(X_SYMBOL)){
            counterX++;
        }
        if (counterX == 3){
            return X_SYMBOL;
        }

        int counterO = 0;
        if (    field.getValues(0).equals(O_SYMBOL)&&field.getValues(1).equals(O_SYMBOL)&&field.getValues(2).equals(O_SYMBOL) ||
                field.getValues(3).equals(O_SYMBOL)&&field.getValues(4).equals(O_SYMBOL)&&field.getValues(5).equals(O_SYMBOL) ||
                field.getValues(6).equals(O_SYMBOL)&&field.getValues(7).equals(O_SYMBOL)&&field.getValues(8).equals(O_SYMBOL) ||

                field.getValues(0).equals(O_SYMBOL) && field.getValues(3).equals(O_SYMBOL) && field.getValues(6).equals(O_SYMBOL) ||
                field.getValues(1).equals(O_SYMBOL) && field.getValues(4).equals(O_SYMBOL) && field.getValues(7).equals(O_SYMBOL) ||
                field.getValues(2).equals(O_SYMBOL) && field.getValues(5).equals(O_SYMBOL) && field.getValues(8).equals(O_SYMBOL) ||

                field.getValues(0).equals(O_SYMBOL) && field.getValues(4).equals(O_SYMBOL) && field.getValues(8).equals(O_SYMBOL) ||
                field.getValues(2).equals(O_SYMBOL) && field.getValues(4).equals(O_SYMBOL) && field.getValues(6).equals(O_SYMBOL)){
            counterO++;
        }
        if (counterO == 3){
            return O_SYMBOL;
        }
        return field.getEMPTY();
    }

    private boolean checkFieldEmpty() {
        for (int i = 0; i < field.VALUES.length; i++) {
            if (field.getValues(i).equals(field.getEMPTY()) && !field.getValues(i).equals(X_SYMBOL) && !field.getValues(i).equals(O_SYMBOL)) {
                return false;
            }
        }
        return true;
    }

    private void analyzeStatus() {
        String winner = checkWinner2();
        if (winner.equals(X_SYMBOL)) {
            StatusGame = WINNER_X;
        } else if (winner.equals(O_SYMBOL)) {
            StatusGame = WINNER_O;
        } else if (checkFieldEmpty()) {
            StatusGame = DRAW;
        } else {
            StatusGame = INPROGRESS;
        }
    }
}
    /*
    private boolean ifWinnerX(){
        return field.getValues(0).equals("X")&&field.getValues(1).equals("X")&&field.getValues(2).equals("X") ||
                field.getValues(3).equals("X")&&field.getValues(4).equals("X")&&field.getValues(5).equals("X") ||
                field.getValues(6).equals("X")&&field.getValues(7).equals("X")&&field.getValues(8).equals("X") ||

                field.getValues(0).equals("X") && field.getValues(3).equals("X") && field.getValues(6).equals("X") ||
                field.getValues(1).equals("X") && field.getValues(4).equals("X") && field.getValues(7).equals("X") ||
                field.getValues(2).equals("X") && field.getValues(5).equals("X") && field.getValues(8).equals("X") ||

                field.getValues(0).equals("X") && field.getValues(4).equals("X") && field.getValues(8).equals("X") ||
                field.getValues(2).equals("X") && field.getValues(4).equals("X") && field.getValues(6).equals("X");
    }
    private boolean ifWinnerO(){
        return field.getValues(0).equals("O")&&field.getValues(1).equals("O")&&field.getValues(2).equals("O") ||
                field.getValues(3).equals("O")&&field.getValues(4).equals("O")&&field.getValues(5).equals("O") ||
                field.getValues(6).equals("O")&&field.getValues(7).equals("O")&&field.getValues(8).equals("O") ||

                field.getValues(0).equals("O") && field.getValues(3).equals("O") && field.getValues(6).equals("O") ||
                field.getValues(1).equals("O") && field.getValues(4).equals("O") && field.getValues(7).equals("O") ||
                field.getValues(2).equals("O") && field.getValues(5).equals("O") && field.getValues(8).equals("O") ||

                field.getValues(0).equals("O") && field.getValues(4).equals("O") && field.getValues(8).equals("O") ||
                field.getValues(2).equals("O") && field.getValues(4).equals("O") && field.getValues(6).equals("O");
    }


     private String checkWinner2(){
        int counter =0;
        for (int i = 0; i < 9; i++) {
            if (field.getValues(i).equals(X_SYMBOL) && !field.getValues(i).equals(O_SYMBOL) && !field.getValues(i).equals(field.getEMPTY())){
                counter++;
            }
        }
        if (counter == 3){
            return X_SIMBOL;
        }
        counter = 0;
        for (int i = 0; i < 9; i++) {
            if (field.getValues(i).equals(O_SYMBOL) && !field.getValues(i).equals(X_SYMBOL) && !field.getValues(i).equals(field.getEMPTY())){
                counter++;
            }
        }
        if (counter == 3){
            return O_SIMBOL;
        }
        return null;
    }



    private String checkWinner(){
        int counterX =0;

        if (    field.getValues(0).equals(X_SYMBOL)&&field.getValues(1).equals(X_SYMBOL)&&field.getValues(2).equals(X_SYMBOL) ||
                field.getValues(3).equals(X_SYMBOL)&&field.getValues(4).equals(X_SYMBOL)&&field.getValues(5).equals(X_SYMBOL) ||
                field.getValues(6).equals(X_SYMBOL)&&field.getValues(7).equals(X_SYMBOL)&&field.getValues(8).equals(X_SYMBOL) ||

                field.getValues(0).equals(X_SYMBOL) && field.getValues(3).equals(X_SYMBOL) && field.getValues(6).equals(X_SYMBOL) ||
                field.getValues(1).equals(X_SYMBOL) && field.getValues(4).equals(X_SYMBOL) && field.getValues(7).equals(X_SYMBOL) ||
                field.getValues(2).equals(X_SYMBOL) && field.getValues(5).equals(X_SYMBOL) && field.getValues(8).equals(X_SYMBOL) ||

                field.getValues(0).equals(X_SYMBOL) && field.getValues(4).equals(X_SYMBOL) && field.getValues(8).equals(X_SYMBOL)
                || field.getValues(2).equals(X_SYMBOL) && field.getValues(4).equals(X_SYMBOL) && field.getValues(6).equals(X_SYMBOL)){
            counterX++;
        }
        if (counterX == 3){
            return X_SYMBOL;
        }

        int counterO = 0;
        if (    field.getValues(0).equals(O_SYMBOL)&&field.getValues(1).equals(O_SYMBOL)&&field.getValues(2).equals(O_SYMBOL) ||
                field.getValues(3).equals(O_SYMBOL)&&field.getValues(4).equals(O_SYMBOL)&&field.getValues(5).equals(O_SYMBOL) ||
                field.getValues(6).equals(O_SYMBOL)&&field.getValues(7).equals(O_SYMBOL)&&field.getValues(8).equals(O_SYMBOL) ||

                field.getValues(0).equals(O_SYMBOL) && field.getValues(3).equals(O_SYMBOL) && field.getValues(6).equals(O_SYMBOL) ||
                field.getValues(1).equals(O_SYMBOL) && field.getValues(4).equals(O_SYMBOL) && field.getValues(7).equals(O_SYMBOL) ||
                field.getValues(2).equals(O_SYMBOL) && field.getValues(5).equals(O_SYMBOL) && field.getValues(8).equals(O_SYMBOL) ||

                field.getValues(0).equals(O_SYMBOL) && field.getValues(4).equals(O_SYMBOL) && field.getValues(8).equals(O_SYMBOL) ||
                field.getValues(2).equals(O_SYMBOL) && field.getValues(4).equals(O_SYMBOL) && field.getValues(6).equals(O_SYMBOL)){
            counterO++;
        }
        if (counterO == 3){
            return O_SYMBOL;
        }
        return null;
    }
     */


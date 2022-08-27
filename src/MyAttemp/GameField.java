package MyAttemp;


public class GameField {
    public final String[]VALUES = new String[9];
    private final String SYMBOL_EMPTY = " . ";
    public void createGameField(){
        System.out.println("Game Field: ");
        for (int i =0; i < VALUES.length; i++) {
            VALUES[i] = SYMBOL_EMPTY;
            }
    }
    public void showField(){
        for (int i = 0; i < VALUES.length; i++) {
            System.out.print(VALUES[i] + " ");
            if (i == 2 || i == 5){
                System.out.println();
            }
        }
        System.out.println();
    }
    public void setValues(int index,String value){this.VALUES[index] = value;}
    public String getValues(int index){return VALUES[index];}

    public String getEMPTY() {
        return SYMBOL_EMPTY;
    }

}

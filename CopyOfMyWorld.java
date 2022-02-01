import greenfoot.*;
import java.util.*;

/**
 * CandyFlush
 * 
 * @author Jonas Zehnder & Daniel
 * @version 0.1
 */

public class CopyOfMyWorld extends World
{
    private int gridSize = 8;
    private Field[][] fields = new Field[gridSize][gridSize];
    public ShuffleButton shuffleButton = new ShuffleButton();
    private ArrayList<Field> toDelete = new ArrayList<Field>();
    
    public CopyOfMyWorld(){
        super(800, 850, 1);
        prepare();
        checkFields();
    }
    private void prepare(){
        for(int x = 0; x < fields.length; x++){
            for(int y = 0; y < fields[0].length; y++){
                Field myField = new Field();
                addObject(myField, (x * 90 + 90),(y * 90 + 90));
                fields[x][y] = myField;
            }
        }
        addObject(shuffleButton, 400, 800);
    }
    public void shuffleFields(){
        fields = fields;
        Random random = new Random();
        for (int i = fields.length - 1; i > 0; i--) {
            for (int j = fields[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);
                Field temp = fields[i][j];
                fields[i][j] = fields[m][n];
                fields[m][n] = temp;
            }
        }
        for(int x = 0; x < fields.length; x++){
            for(int y = 0; y < fields[x].length; y++){
                fields[x][y].setLocation(fields[x][y].getX(), fields[x][y].getY());
            } 
        }
    }
    private void checkFields(){
        //check horizontally
        for(int y=0; y<20; y++){
            for(Field field : checkField('h')){
                removeObject(field);
            }
            //check vertically
            for(Field field : checkField('v')){
                removeObject(field);
            }
        }
    }
    private ArrayList<Field> checkField(char dir){
        int z;
        int xf;
        int yf;
        int countFieldsInRow;
        Colour currentColour = fields[0][0].getColour();
        ArrayList<Field> markToDeleteFields = new ArrayList<Field>();
        for(int y = 0; y < gridSize; y++){ 
            countFieldsInRow = 1;
            for(int x = 0; x < gridSize; x++){ 
                if(dir == 'v'){
                    yf = x;
                    xf = y;
                }else{
                    yf = y;
                    xf = x;
                }
                if(!(y == 0 && x == 0)){
                    if(currentColour == fields[xf][yf].getColour()){
                        markToDeleteFields.add(fields[xf][yf]);
                        if(countFieldsInRow == 3){
                            return markToDeleteFields;
                        }
                        countFieldsInRow++;
                    }else{
                        currentColour = fields[xf][yf].getColour(); 
                        markToDeleteFields.clear();
                        countFieldsInRow = 1;
                    }  
                }
            }
        }  
        return markToDeleteFields;
    }
}

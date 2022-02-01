import greenfoot.*;
import java.util.*;

/**
 * CandyFlush
 * 
 * @author Jonas Zehnder & Daniel
 * @version 0.1
 */

public class MyWorld extends World
{
    public Field[][] fields = new Field[4][4];
    private Field[][] fieldsTemp = new Field[8][8];
    public ShuffleButton shuffleButton = new ShuffleButton();
    private ArrayList<Field> toDelete = new ArrayList<Field>();
    
    public MyWorld()
    {
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
        fieldsTemp = fields;
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
                fields[x][y].setLocation(fieldsTemp[x][y].getX(), fieldsTemp[x][y].getY());
            } 
        }
    }
    public boolean checkGamePossiblity(){
        Colour colourTemp;
        for(int i = 0; i < fields.length; i++){
            for(int j = 0; j < fields[i].length; j++){
                if(i == 1){
                    //top
                }
                if(i == fields.length-1){
                    //bottom
                }
                if(j == 1){
                    //left
                }
                if(j == fields[i].length-1){
                    //right
                }
                    /*    
                    colourTemp = fields[i][j].getColour();
                        if(colourTemp == fields[i][j].getColour()){
                    }
                    */
            }
        }
        return true;
    }
    private void checkFields(){
        toDelete.clear();
        int countFieldsInRow;
        Colour currentColour; 
        //check horizontally
        for(int y = 0; y < fields.length; y++){
            for(int x = 0; x < fields[0].length; x++){
                countFieldsInRow = 0;
                currentColour = fields[x][y].getColour();   
                for(int i = 0; i < fields[0].length - x; i++){
                    if(fields[x + i][y].getColour() == currentColour){
                        countFieldsInRow++;
                    } else {
                        break;
                    }
                }
                if(countFieldsInRow >= 3){
                    markToDeleteFields(x, y, countFieldsInRow, 'h');
                }
            }
        }
        //check vertically
        for(int x = 0; x < fields[0].length; x++){
            for(int y = 0; y < fields.length; y++){
                countFieldsInRow = 0;
                currentColour = fields[x][y].getColour();
                for(int i = 0; i < fields.length - y; i++){
                    if(fields[x][y + i].getColour() == currentColour){
                        countFieldsInRow++;
                    } else {
                        break;
                    }
                }
                if(countFieldsInRow >= 3){
                    markToDeleteFields(x, y, countFieldsInRow, 'v');
                }
            }
        }
        deleteFields();
    }
    private void markToDeleteFields(int x, int y, int range, char direction){
        int j = 0;
        for(int i = 0; i < range; i++){
            if(direction == 'v'){
                j = i;
                i = 0;
            }
            if(!toDelete.contains(fields[x + i][y + j])){
                toDelete.add(fields[x + i][y + j]);
                //removeObject(fields[x + i][y + j]);
            }
        }
    }
    private void deleteFields(){
        for(int i = 0; i < toDelete.size(); i++){
            removeObject(toDelete.get(i));
        }
    }
    private void checkFieldsBelow(){
        for(int x = 0; x < fields.length; x++){
            
        }
    }
}
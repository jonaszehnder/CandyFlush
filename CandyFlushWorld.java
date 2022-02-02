import greenfoot.*;
import java.util.*;

/**
 * CandyFlush
 * 
 * @author Jonas Zehnder & Daniel
 * @version 0.1
 */

public class CandyFlushWorld extends World
{
    public Field[][] fields = new Field[8][8];
    private Field[][] fieldsTemp = new Field[8][8];
    public ShuffleButton shuffleButton = new ShuffleButton();
    private ArrayList<Field> toDelete = new ArrayList<Field>();
    private Field fieldOneTemp;
    private Field fieldTwoTemp;
    public static int points;
    public static int turns;
    public CandyFlushWorld()
    {
        super(800, 850, 1);
        prepare();
    }
    private void prepare(){
        for(int x = 0; x < fields.length; x++){
            for(int y = 0; y < fields[0].length; y++){
                Field myField = new Field(x, y);
                addObject(myField, (x * 90 + 90),(y * 90 + 90));
                fields[x][y] = myField;
            }
        }
        addObject(shuffleButton, 400, 800);
        Score myScore = new Score();
        points = 0;
        addObject(myScore, 720, 10);
        turns = 10;
        Turns myTurns = new Turns();
        addObject(myTurns, 60, 10);
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
            for(int y = 0; y < fields.length; y++){
                fields[x][y].setLocation(fieldsTemp[x][y].getX(), fieldsTemp[x][y].getY());
            } 
        }
    }
    public void checkFields(char dir){
        toDelete.clear();
        int countFieldsInRow;
        Colour currentColour;
        int z;
        for(int y = 0; y < fields.length; y++){
            for(int x = 0; x < fields.length; x++){
                if(fields[x][x] != null){
                    if(dir == 'v'){
                        z = x;
                        x = y;
                        y = z;
                    }
                    countFieldsInRow = 0;
                    currentColour = fields[x][y].getColour();
                    for(int i = 0; i < fields[0].length - x; i++){
                        if(fields[x + i][y].getColour() == currentColour){
                            countFieldsInRow++;
                        } else {
                            break;
                        }
                    }
                    if(countFieldsInRow > 2){
                        markToDeleteFields(x, y, countFieldsInRow, 'h');
                    }
                }
            }
        }
        if(dir != 'z'){
            deleteFields();
        }
    }
    private void markToDeleteFields(int x, int y, int range, char dir){
        int j = 0;
        int z;
        points += range;
        for(int i = 0; i < range; i++){
            if(dir == 'v'){
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
        int xTemp;
        int yTemp;
        int xTempGrid;
        int yTempGrid;
        for(int i = 0; i < toDelete.size(); i++){
            fields[toDelete.get(i).getXPlace()][toDelete.get(i).getYPlace()] = null;
            xTemp = toDelete.get(i).getXPlace();
            yTemp = toDelete.get(i).getYPlace();
            xTempGrid = toDelete.get(i).getX();
            yTempGrid = toDelete.get(i).getY();
            removeObject(toDelete.get(i));
            Field myField = new Field(xTemp, yTemp);
            Greenfoot.delay(3);
            addObject(myField, xTempGrid, yTempGrid);
            fields[xTemp][yTemp] = myField;
        }
        checkFields('z');
    }
    public void setClickedTiles(Field field){
        if(fieldOneTemp == null){
            fieldOneTemp = field;
        }
        else{
            fieldTwoTemp = field;
            if(fieldOneTemp.getXPlace() + 1 == fieldTwoTemp.getXPlace() && fieldOneTemp.getYPlace() == fieldTwoTemp.getYPlace() || 
               fieldOneTemp.getXPlace() - 1 == fieldTwoTemp.getXPlace() && fieldOneTemp.getYPlace() == fieldTwoTemp.getYPlace() ||
               fieldOneTemp.getYPlace() + 1 == fieldTwoTemp.getYPlace() && fieldOneTemp.getXPlace() == fieldTwoTemp.getXPlace() || 
               fieldOneTemp.getYPlace() - 1 == fieldTwoTemp.getYPlace() && fieldOneTemp.getXPlace() == fieldTwoTemp.getXPlace()){
                swapFields(); 
            }else{
                fieldOneTemp.setColour(fieldOneTemp.getColour());
                fieldTwoTemp.setColour(fieldTwoTemp.getColour());
                fieldOneTemp = null;
                fieldTwoTemp = null;
            }
        }
    }
    private void swapFields(){
        turns--;
        Field fieldTemp = new Field(0, 0);
        fieldTemp.setColour(fieldOneTemp.getColour());
        fieldOneTemp.setColour(fieldTwoTemp.getColour());
        fieldTwoTemp.setColour(fieldTemp.getColour());
        fieldOneTemp = null;
        fieldTwoTemp = null;
        checkFields('h');
        if(turns == 0){
            GameOver gameOverScreen = new GameOver();
            addObject(gameOverScreen, 390, 350);
        }
    }
}
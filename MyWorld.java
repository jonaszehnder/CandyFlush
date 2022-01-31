import greenfoot.*;
import java.util.*;

/**
 * CandyFlush
 * 
 * @author Jonas Zehnder
 * @version 0.1
 */

public class MyWorld extends World
{
    public Field[][] fields = new Field[8][8];
    private Field[][] fieldsTemp = new Field[8][8];
    public ShuffleButton shuffleButton = new ShuffleButton();
    
    public MyWorld()
    {
        super(800, 850, 1);
        prepare();
    }
    
    private void prepare(){
        int arrayCounter = 0;
        for(int x = 1; x <= 8; x++){
            for(int y = 1; y <= 8; y++){
                Field myField = new Field();
                addObject(myField, (x * 90),(y * 90));
                fields[x][y] = myField;
                arrayCounter++;
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
        for(int i = 0; i < fields.size(); i++){
            if((i % 8) == 0 || i == 0){
                //left
                colourTemp = fields.get(i).getColour();
                for(int factor = 1; factor < 8; factor++){
                    if(colourTemp == fields.get(i-8*factor).getColour()){
                    }
                }
            } else if(((i+1) % 8) == 0){
                //right
            } else if(i >= 0 && i <= 7){
                //top
            }else if(i >= 56 && i <= 63){
                //bottom
            }else{
                //everything else
            }
        }
        return true;
    }
}
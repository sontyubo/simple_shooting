package src;
import java.util.*;

/**
 * Board
 */
public class Board {
    int height = 0;
    int width = 0;
    ArrayList<Moval> container = new ArrayList<Moval>();
    ArrayList<String> field = new ArrayList<String>();

    public Board(int h, int w){
        this.height = h;
        this.width = w;
    }

    private init_field(){
        for(int i=0; i<this.height; i++){
            ArrayList<String> blank = new ArrayList<String>();
            blank = " " * this.width;
            this.field.add(null)
        }
    }
    
    public void addContainer(Moval m){
        this.container.add(m);
    }

    public void deleteMoval(Moval m){
        this.container.add(m);
    }
    
    public void printField(){
        for(int i=0; i<this.height; i++){
            for(int j= 0; j<this.width; j++){
                if(j == this.width - 1){
                    System.out.println(this.field[i][j]);
                }else{
                    System.out.print(this.field[i][j]);
                }
            }
        }
    }
}
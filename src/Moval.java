package src;

public abstract class Moval {
    int x = 0;
    int y = 0;

    public void setX(int value){
        this.x = value;
    }

    public void setY(int value){
        this.y = value;
    }

    public int[] getPosition(){
        int position[] = {this.y, this.x};
        return position;
    }
}

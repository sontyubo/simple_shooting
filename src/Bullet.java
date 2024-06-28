package src;

public class Bullet extends Moval{
    public void progress(){
        int[] position = getPosition();
        int y = position[0];
        setY(y-1);;
    }
}

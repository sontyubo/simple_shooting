package src;

public class PlayGame {
    
    public static void main(String[] args) {
        Board B = new Board(10, 10);

        Enemy E = new Enemy();

        B.addContainer(E);

        System.out.println();
    }
    
}

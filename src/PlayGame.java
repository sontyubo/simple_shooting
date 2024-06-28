package src;
import java.util.Scanner;

public class PlayGame {
    
    public static void main(String[] args) {
        Board B = new Board(15, 9);

        int cnt = 0;
        while (true) {
            //標準入力
            Scanner sc = new Scanner(System.in);
            String order = sc.next();

            // 各オブジェクトの更新
            B.relax(order);

            // 点描
            B.printField();

            if(cnt > 200){
                break;
            }
            cnt++;
        }


        System.out.println(" --- 終了 ----");
    }
    
}

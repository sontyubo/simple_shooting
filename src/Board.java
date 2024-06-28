package src;
import java.util.*;

/**
 * Board
 */
public class Board {

    // field
    int height = 0;
    int width = 0;
    int[] player;
    int[] fortress = new int [2];
    ArrayList<Enemy> enemy = new ArrayList<>();
    ArrayList<Bullet> bullet = new ArrayList<>();
    String[][] field;

    // コンストラクタ
    public Board(int h, int w){
        this.height = h;
        this.width = w;
        this.player = new int[]{h-1, w/2};
        this.fortress = new int[]{0, w/2};
        field = new String[h][w];
        init_field();
    }

    // メソッド
    private void init_field(){
        for(int i=0; i<this.height; i++){
            for(int j= 0; j<this.width; j++){

                if(i % (this.height-1) == 0 && j % (this.width-1) == 0){
                    this.field[i][j] = "+";
                }else if(i == 0 || i == this.height-1){
                    this.field[i][j] = "-";
                }else if(j == 0 || j == this.width-1){
                    this.field[i][j] = "|";
                }else{
                    this.field[i][j] = " ";
                }
            }
        }
    }

    private void set_field(){
        // プレイヤー
        int[] p_p = this.player;
        this.field[p_p[0]][p_p[1]] = "P";
    
        // fortress
        int[] f_p = this.fortress;
        this.field[f_p[0]][f_p[1]] = "F";

        // エネミー
        if(enemy.size() != 0){
            Enemy enemy = this.enemy.getFirst();
            int[] e_p = enemy.getPosition();
            this.field[e_p[0]][e_p[1]] = "@";
        }


        // バレット
        for(Bullet b : this.bullet){
            int[] b_p = b.getPosition();
            this.field[b_p[0]][b_p[1]] = "*";
        }
    }

    public void relax(String order){
        // 入力の確認
        if(order.equals("i")){
            Bullet blt = new Bullet();
            int[] player_position = this.player;
            blt.setY(player_position[0] - 1);
            blt.setX(player_position[1]);
            this.bullet.add(blt);

        }else if(order.equals("j")){
            if(this.player[1] > 0){
                this.player[1] -= 1;
            }

        }else if(order.equals("k")){
            }

        else if(order.equals("l")){
            if(this.player[1] < this.width-1){
                this.player[1] += 1;
            }
        }

        // 全ての物体を動かす
        //// エネミーの射出
        if(this.enemy.size() == 0){
            int[] fortress_position = this.fortress;
            Enemy enm = new Enemy();
            enm.setY(fortress_position[0] + 1);
            enm.setX(fortress_position[1]);
            this.enemy.add(enm);
        }

        //// エネミーを動かす
        for(Enemy e : this.enemy){
            e.progress();
        }

        //// 弾を動かす
        for(Bullet b : this.bullet){
            b.progress();
        }

        // 超えているオブジェクトの削除
        eliminate_moval();

        // fieldを初期化
        init_field();

        // fieldに物体の位置を反映
        set_field();
    }

    public void eliminate_moval(){
    //   // エネミー
    //    for(Enemy e : this.enemy){
    //         int[] enemy_position = e.getPosition();
    //         if(enemy_position[0] == this.height - 1){
    //             this.enemy.remove(0);
    //         }
    //     }
        // エネミー
        Iterator<Enemy> enemyIterator = this.enemy.iterator();
        while (enemyIterator.hasNext()) {
            Enemy e = enemyIterator.next();
            int[] enemy_position = e.getPosition();
            if(enemy_position[0] == this.height - 1){
                enemyIterator.remove();
            }
        }

        // 弾
        // for(Bullet b : bullet){
        //     int[] bullet_position = b.getPosition();
        //     if(bullet_position[0] == 0){
        //         int index = this.enemy.indexOf(b);
        //         this.enemy.remove(index);
        //     }
        // }
        Iterator<Bullet> bulletIterator = this.bullet.iterator();
        while (bulletIterator.hasNext()) {
            Bullet b = bulletIterator.next();
            int[] bullet_position = b.getPosition();
            if(bullet_position[0] == 0){
                bulletIterator.remove();
            }
        }   
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
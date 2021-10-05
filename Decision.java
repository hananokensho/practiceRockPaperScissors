
import java.util.InputMismatchException;
import java.util.Scanner;

public class Decision {
    Player player;
    Pair pair;

    // フィールドにインスタンスを代入
    public Decision(Player player , Pair pair) {
        this.player = player;
        this.pair = pair;
    }
    // あいこの場合の処理
    public void inputNum() {
        System.out.print("あいこでっ >");
        //　プレイヤーのシグナル
        Scanner sc = new Scanner(System.in);
        pair.setMySignal();
        try {
            int num = sc.nextInt();
            if (num > 0 && num < 4) {
//                this.playerMySignal = num;
                player.setMySignal(num);
            } else {
                System.out.println("------正しい値を入力してください------");
                inputNum();
            }
        } catch (InputMismatchException e) {
            System.out.println("------正しい値を入力してください------");
            inputNum();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("------正しい値を入力してください------");
            inputNum();
        }
    }

    public void firstInputNum() {
        System.out.println("1:[グー] 2:[チョキ] 3:[パー]のどれかの数字を入力してください。");
        System.out.print("最初はグー！じゃんけんっ > ");
        //　プレイヤーのシグナル
        Scanner sc = new Scanner(System.in);
        try {
            int num = sc.nextInt();
            if (num > 0 && num < 4) {
//                this.playerMySignal = num;
                player.setMySignal(num);
            } else {
                System.out.println("------正しい値を入力してください------");
                inputNum();
            }
        } catch (InputMismatchException e) {
            System.out.println("------正しい値を入力してください------");
            inputNum();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("------正しい値を入力してください------");
            inputNum();
        }
    }

    public String decisionResult() {
        if (player.getMySignal() == pair.getMySignal()) {
            return "あいこ";
        } else if ((player.getMySignal() == 1) && (pair.getMySignal() ==2) ||
                (player.getMySignal() == 3) && (pair.getMySignal() == 1) ||
                (player.getMySignal() == 2) && (pair.getMySignal() == 3)){
            return "勝ち";
        } else if ((player.getMySignal() == 3) && (pair.getMySignal() == 2) ||
                (player.getMySignal() == 2) && (pair.getMySignal() == 1) ||
                (player.getMySignal() == 1) && (pair.getMySignal() == 3)) {
            return "負け";
        }
        return "測定不能";
    }

    public boolean winOrLoseDecision(String decisionResult, Pair pair) {
        if (decisionResult.equals("あいこ")) {
            return drawProcess(pair);
        } else if (decisionResult.equals("勝ち")) {
            return true;
        }
            return false;
    }

    // あいこの場合勝敗がつくまで繰り返す
    public boolean drawProcess(Pair pair) {
        boolean winOrLoseDecision = false;
        boolean winUntil = false;
        while (!winUntil) {
            inputNum();
            // 相手のシグナルをランダムで生成
            pair.setMySignal();
            // 判定
            String decisionResult = decisionResult();
            if(decisionResult.equals("勝ち")){
                winUntil = true;
                winOrLoseDecision = true;
            }else if (decisionResult.equals("負け")){
                winUntil = true;
                winOrLoseDecision = false;
            }
        }
        if(winOrLoseDecision){
            return true;
        }
        return false;
    }
}



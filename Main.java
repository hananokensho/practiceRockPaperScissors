
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pair pair = new Pair();
        Player player = new Player();
        Decision decision = new Decision(player , pair);
        int totalCount = 0;
        System.out.println("[じゃんけんゲーム]");
        System.out.println("何回連続勝てるかな？");
        boolean continuous = false;
        while (!continuous) {
            decision.firstInputNum();
            // 相手のシグナルをランダムで生成
            pair.setMySignal();
            // あいこ,勝ち,負けの判定
            String decisionResult = decision.decisionResult();
            // あいこの場合は勝敗がつくまで繰り返す
            if (decision.winOrLoseDecision(decisionResult, pair)) {
                totalCount++;
                System.out.println("勝ちました！");
                System.out.println("次の試合を始めます！");
            } else {
                System.out.println("負けました。残念。");
                continuous = true;
            }
        }
        System.out.println(totalCount + "回連続で勝ちました");
        System.out.println("終了します");
    }
}


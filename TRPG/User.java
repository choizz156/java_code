import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class User {


    String name;
    String att;
    String def;
    String hp;


    void user_info(String name, String att, String def, String hp) {
        this.name = name;
        this.att = att;
        this.def = def;
        this.hp = hp;
    }

    String[] user_create() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("유닛 이름을 입력해 주세요.");
        String name = scanner.nextLine();
        System.out.print("유닛 공격력을 입력해 주세요.");
        String att = scanner.nextLine();
        System.out.print("유닛 방어력을 입력해 주세요.");
        String def = scanner.nextLine();
        System.out.print("유닛 체력을 입력해 주세요.");
        String hp = scanner.nextLine();

        this.user_info(name, att, def, hp);

        String[] input = {name, att, def, hp};
        return input;
    }

    void user_print(String[] input) {

        System.out.println("\n생성된 유닛 정보는 다음과 같습니다.");
        System.out.println(input[0] + " 유짓이 게임에 참여하였습니다.");
        System.out.println("공격력 : " + input[1]);
        System.out.println("방어력 : " + input[2]);
        System.out.println("체력 : " + input[3]);
        System.out.println("-----------------------");

    }


    int[] user_info_int(String[] strs) {
        int[] chstrs = new int[3];

        for (int i = 0; i <= 2; i++) {
            chstrs[i] =
                    Integer.parseInt(strs[i + 1]);
        }

        return chstrs;
    }

    int attack(int[] myinfo, int[] enemyinfo) {

        String unitName = this.name;

        if (enemyinfo[2] > 0) {
            System.out.println(unitName + "유닛이 공격하였습니다.");
            enemyinfo[2] = enemyinfo[2] - (myinfo[0] / enemyinfo[1]); // 적군 체력
            double a = Math.floor(enemyinfo[2]);
            if(a < 0){
                return 0;
            }
            System.out.println("상대 유닛의 남은 체력은" + enemyinfo[2] + "입니다.");
            System.out.println("-----------------------");

        }
        return enemyinfo[2];
    }
    int attack2(int[] myinfo, int[] enemyinfo) {

        String unitName = this.name;

        if (myinfo[2] > 0) {
            System.out.println("적 " + unitName + " 유닛이 공격하였습니다.");
            myinfo[2] = myinfo[2] - (enemyinfo[0] / myinfo[1]);
            double a = Math.floor(enemyinfo[2]);
            if(a < 0){
                return 0;
            }
            System.out.println("나의 유닛의 남은 체력은" + myinfo[2] + "입니다.");
            System.out.println("-----------------------");
        }
        return myinfo[2];
    }
}

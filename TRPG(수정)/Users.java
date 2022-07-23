import java.util.Scanner;

public class Users {
    String name;
    String att;
    String def;
    String hp;
    String[] input;

    void userInfo(String name, String att, String def, String hp) {
        this.name = name;
        this.att = att;
        this.def = def;
        this.hp = hp;
        String[] userInput = {name, att, def, hp};
        this.input = userInput;
    }

    String[] userCreate() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("유닛 이름을 입력해 주세요.");
        String unitName = scanner.nextLine();
        System.out.print("유닛 공격력을 입력해 주세요.");
        String unitAtt = scanner.nextLine();
        System.out.print("유닛 방어력을 입력해 주세요.");
        String unitDef = scanner.nextLine();
        System.out.print("유닛 체력을 입력해 주세요.");
        String unitHp = scanner.nextLine();

        String[] userInput = {unitName, unitAtt, unitDef, unitHp};
        this.userInfo(unitName, unitAtt, unitDef, unitHp);

        return userInput;
    }

    void userPrint(String[] input) {

        System.out.println("\n생성된 유닛 정보는 다음과 같습니다.");
        System.out.println(input[0] + " 유짓이 게임에 참여하였습니다.");
        System.out.println("공격력 : " + input[1]);
        System.out.println("방어력 : " + input[2]);
        System.out.println("체력 : " + input[3]);
        System.out.println("-----------------------");

    }

    int[] userInfoInt(String[] strs) {
        int[] chstrs = new int[3];

        for (int i = 0; i <= 2; i++) {
            chstrs[i] =
                    Integer.parseInt(strs[i + 1]);
        }
        return chstrs;
    }

    public int[] list() {
        int[] list = new int[3];
        list = userInfoInt(input);

        return list;
    }

    int attack(int[] myinfo, int[] enemyinfo) {

        String unitName = this.name;

        if (enemyinfo[2] > 0) {
            System.out.println(unitName + "유닛이 공격하였습니다.");
            enemyinfo[2] = enemyinfo[2] - (myinfo[0] / enemyinfo[1]); // 적군 체력
            int a = (int) Math.floor(enemyinfo[2]);
            if (a <= 0) {
                System.out.println("상대 유닛의 남은 체력은 0입니다.");
                System.out.println("상대 유닛이 죽었습니다.");
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
            int a = (int) Math.floor(myinfo[2]);
            if (a < 0) {
                System.out.println("나의 남은 체력은 0입니다.");
                System.out.println("나 유닛이 죽었습니다.");
                return 0;
            }
            System.out.println("나의 유닛의 남은 체력은" + myinfo[2] + "입니다.");
            System.out.println("-----------------------");
        }
        return myinfo[2];
    }
}

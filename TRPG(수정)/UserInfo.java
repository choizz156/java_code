import java.util.Scanner;

public class UserInfo {
    String name;
    String attack;
    String defence;
    String hp;
    String[] input;
    String[] userChoice;

    public void setUserInfo() {
        userChoice = userCreate();
        userPrint(userChoice);
    }

    void userInfo(String name, String attack, String defence, String hp) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.hp = hp;
        this.input = new String[]{name, attack, defence, hp};

    }

    String[] userCreate() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("유닛 이름을 입력해 주세요. ");
        String unitName = scanner.nextLine();
        System.out.print("유닛 공격력을 입력해 주세요. ");
        String unitAttack = scanner.nextLine();
        System.out.print("유닛 방어력을 입력해 주세요. ");
        String unitDefence = scanner.nextLine();
        System.out.print("유닛 체력을 입력해 주세요. ");
        String unitHp = scanner.nextLine();

        String[] unit = {unitName, unitAttack, unitDefence, unitHp};
        this.userInfo(unitName, unitAttack, unitDefence, unitHp);

        return unit;
    }

    void userPrint(String[] input) {

        System.out.println("\n생성된 유닛 정보는 다음과 같습니다.");
        System.out.println(input[0] + " 유짓이 게임에 참여하였습니다.");
        System.out.println("공격력 : " + input[1]);
        System.out.println("방어력 : " + input[2]);
        System.out.println("체력 : " + input[3]);
        System.out.println("-----------------------");

    }

    public int[] getUnitInfo(String[] str) {
        int[] unitInfo = new int[3];

        for (int i = 0; i <= 2; i++) {
            unitInfo[i] =
                    Integer.parseInt(str[i + 1]);
        }
        return unitInfo;
    }

    public int attacked(int[] firstUnit, int[] secondUnit) {

        String unitName = this.name;

        if (secondUnit[2] > 0) {
            System.out.println(unitName + " 유닛이 공격하였습니다.");
            secondUnit[2] = secondUnit[2] - (firstUnit[0] / secondUnit[1]); // 적군 체력

            if (secondUnit[2] <= 0) {
                System.out.println("적 유닛의 남은 체력은 0입니다.");
                System.out.println("유닛이 죽었습니다.");
                return 0;
            }
            System.out.println("적 유닛의 남은 체력은" + secondUnit[2] + "입니다.");
            System.out.println("-----------------------");

        }
        return secondUnit[2];
    }

}

public class Starcraft {
    public static void main(String[] args) {
        System.out.println("스타를 시작합니다.");

        System.out.println("자신의 유닛 정보를 입력해주세요. ");
        UserInfo user1 = new UserInfo();
        user1.setUserInfo();

        System.out.println("상대 유닛 정보를 입력해 주세요 ");
        UserInfo user2 = new UserInfo();
        user2.setUserInfo();

        int[] user1Turn = user1.getUnitInfo(user1.input);
        int[] user2Turn = user2.getUnitInfo(user2.input);


        while (user1Turn[2]> 0 && user2Turn[2] > 0) {
           int user2Hp = user1.attacked(user1Turn, user2Turn);
            if (user2Hp == 0) {
                break;
            }
            int user1Hp = user2.attacked(user2Turn, user1Turn);
            if (user1Hp == 0) {
                break;
            }
        }
        System.out.println("게임이 종료되었습니다.");
    }
}


public class Starcraft1 {
    public static void main(String[] args) {
        System.out.println("스타를 시작합니다.");

        System.out.println("자신의 유닛 정보를 입력해주세요. ");
        UserInfo user1 = new User1();
        user1.setUserInfo();

        System.out.println("상대 유닛 정보를 입력해 주세요 ");
        UserInfo user2 = new User2();
        user2.setUserInfo();

        int[] user1Turn = user1.getUnitInfo(user1.input);
        int[] uesr2Turn = user2.getUnitInfo(user2.input);


        int user1Hp = user1Turn[2];
        int user2Hp = uesr2Turn[2];
        while (user1Hp > 0 && user2Hp > 0) {
            user1.attacked(user1Turn, uesr2Turn);
            if (user2Hp == 0) {
                break;
            }
            user2.attacked(uesr2Turn, user1Turn);
            if (user1Hp == 0) {
                break;
            }
        }
        System.out.println("게임이 종료되었습니다.");
    }
}
// 배열
// this 사용
// 메서드 결과값

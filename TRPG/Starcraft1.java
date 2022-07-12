public class Starcraft1 {
    public static void main(String[] args) {
        System.out.println("스타를 시작합니다.");

        System.out.println("자신의 유닛 정보를 입력해주세요.");
        User1 user1 = new User1();
        user1.infom();

        System.out.println("상대 유닛 정보를 입력해 주세요");
        User2 user2 = new User2();
        user2.infom();


        int[] my = user1.list();
        int[] your = user2.list();


        while( my[2]> 0 && your[2] > 0) {
            user1.attack(my, your);
             if(your[2]==0){
                 break;
             }
            user2.attack2(my, your);
             if(my[2]==0){
                 break;
             }
        }

        System.out.println("게임이 종료되었습니다.");


    }
}
// 배열
// this 사용
// 메서드 결과값

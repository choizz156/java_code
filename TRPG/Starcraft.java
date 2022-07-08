import com.sun.security.jgss.GSSUtil;

public class Starcraft {
    public static void main(String[] args) {
        System.out.println("스타를 시작합니다.");

        System.out.println("자신의 유닛 정보를 입력해주세요.");
        RPG user = new RPG();

        String[] user_info = new String[4];
        user_info = user.user_create();ß
        user.user_print(user_info);

        System.out.println("상대 유닛 정보를 입력해 주세요");
        RPG user2 = new RPG();
        String[] user2_info = new String[4];
        user2_info = user2.user_create();
        user2.user_print(user2_info);


        int[] my = new int[3];
        int[] enemy = new int[3];
        my = user.user_info_int(user_info);
        enemy = user.user_info_int(user2_info);



        while( my[2] > 0 && enemy[2] > 0) {
            user.attack(my, enemy);
             if(enemy[2]==0){
                 break;
             }
            user2.attack2(my, enemy);
             if(my[2]==0){
                 break;
             }
        }

        System.out.println("다 죽음ㄱ 끝났음");


    }
}
// 배열
// this 사용
// 메서드 결과값

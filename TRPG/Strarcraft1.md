코드스테이츠 부트캠프에서 실습으로 나온 TRPG코딩을 혼자서 해봤다. 객체지향을 공부하기 시작하면서 처음으로 코딩을 해본 것인데 부족한 것이 있으면 추후에 리팩토링 하도록 해보자.
## 사고 흐름
### 1단계
- 일단 1대1 게임이므로 유저가 2명있어야 한다.
- 나의 유닛 정보와 상대의 유닛 정보를 출력한다.
- 1대1 턴제로 한 번씩 돌아가면서 공격하고 체력이 0이 되면 끝난다.
### 2단계
구체적으로 어떻게 코딩을 할지 순서를 정했다.
1. 객체를 만들 클래스를 따로 구성하기로 했다.
2. User 클래스 안에 게임이 진행될 때 필요한 멤버변수나 메소드를 넣는다.
 	- 멤버 변수는 유닛이름(name),공격력(att),방어력(def),체력(hp)으로 유닛을 생성할 때 필요한 속성들을 정했다.
    - 메소드로 유닛 정보를 전달받을 메소드(user_creat), 전달받은 메소드를 멤버 변수로 할당할 메소드(user_info), 유닛 정보를 출력할 메소드(user_print), 유닛의 정보를 정수 배열로 저장할 메소드(user_info_int), 유닛들의 공격을 하게할 메소드 (attack)들로 메소드를 정했다.
## 코드


```java
import com.sun.security.jgss.GSSUtil;

public class Starcraft {
    public static void main(String[] args) {   // 메인 메서드.
        System.out.println("스타를 시작합니다.");

        System.out.println("자신의 유닛 정보를 입력해주세요.");
        User user = new User(); //객체생성

        String[] user_info = new String[4];//유저가 만든 정보를 가지고 오기위해 새로운 배열을 만든다.
        user_info = user.user_create();// user_create에서 리턴한 유저의 정보 배열을 새로운 배열에 넣는다.
        user.user_print(user_info); // 그 배열을 출력한다.

        System.out.println("상대 유닛 정보를 입력해 주세요");
        User user2 = new User(); // 상대 객체도 만든다.
        String[] user2_info = new String[4];// 나머지 과정은 위와 동일하하다.
        user2_info = user2.user_create();
        user2.user_print(user2_info);

----------------------------------------
        
        int[] my = new int[3]; // 나의 유닛정보를 정수표현만 담기 위한 배열을 만든다.
        int[] enemy = new int[3];// 적의 정보를 정소표현만 담기 위한 배열을 만든다,.
        my = user.user_info_int(user_info);//나의 유닛 정보 배열을 넣어서 정수 부분만 새로운 배열에 담는다,
        enemy = user.user_info_int(user2_info);적의 유닛 정보 배열을 넣어서 정수 부분만 새로운 배열에 담는다.


------------------------------------------
        while( my[2] > 0 && enemy[2] > 0) {/*서로 한 턴씩 공격을 반복하기 위해 체력이 0이 되면 끝나도록 조건을 단 
        while반복문을 생성한다.*/
            
            user.attack(my, enemy);//나부터 공격한다.
             if(enemy[2]==0){//만약 적의 체력이 0이되면 반복문을 빠져나오도록 한다.
                 break;
             }
            user2.attack2(my, enemy);//내가 공격한 후 적이 공격한다.
             if(my[2]==0){ // 나의 체력이 0이면 반복문이 빠져나온다.
                 break;
             }
        }

        System.out.println("경기가 종료됐습니다.");//게임이 종료된다.


    }
}
```
------------------
```java
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class User{


    String name; //멤버변수 선언
    String att;
    String def;
    String hp;


    String[] user_create() {

        Scanner scanner = new Scanner(System.in); //정보를 입력 받기위해 Scanner클래스를 사용한다.

        System.out.print("유닛 이름을 입력해 주세요.");
        String name = scanner.nextLine(); // 입력 받은 정보를 변수에 할당한다.
        System.out.print("유닛 공격력을 입력해 주세요.");
        String att = scanner.nextLine();
        System.out.print("유닛 방어력을 입력해 주세요.");
        String def = scanner.nextLine();
        System.out.print("유닛 체력을 입력해 주세요.");
        String hp = scanner.nextLine();

        this.user_info(name, att, def, hp); //  입력받은 정보를 클래스 내의 멤버 변수로 사용하기 위해서 this 키워드를 사용한다.  

        String[] input = {name, att, def, hp}; // 입력받은 정보를 배열로 만든다.
        return input; // 배열을 출력한다.
    }
    
    void user_info(String name, String att, String def, String hp) { 
    //입력받은 정보를 멤버변수에 할당하기 위한 메소드
   // 생성자를 쓰기가 좀 힘들어서 이런식으로 하는 게 좋아보인다.
        this.name = name;
        this.att = att;
        this.def = def;
        this.hp = hp;
    }

    

    void user_print(String[] input) { 
    //user_create에서 리턴한 배열을 넣어서 콘솔에 출력할 수 있게 한다.

        System.out.println("\n생성된 유닛 정보는 다음과 같습니다.");
        System.out.println(input[0] + " 유짓이 게임에 참여하였습니다.");
        System.out.println("공격력 : " + input[1]);
        System.out.println("방어력 : " + input[2]);
        System.out.println("체력 : " + input[3]);
        System.out.println("-----------------------");

    }

/// 유저의 정보를 입력받아 콘솔에 출력하기까지 과정.
------------------------------------------------------
/// 여기부터 공격을 하기 위한 과정
    

    int[] user_info_int(String[] strs) 
    {// 유닛 정보에서 유닛이름을 제외한 나머지를 새로운 배열로 만든다.
        int[] chstrs = new int[3]; 
        // 새로운 배열을 만든다. 공격력 방어력 체력 3가지 정보이므로 크기가 3인 배열을 만든다. 
        //String 타입으로 저장돼 있으므로 int로 바꿔줘야 나중에 계산할 수 았다.

        for (int i = 0; i <= 2; i++) { // 배열의 요소를 가지고와 새로운 배열에 저장해야 하므로 for반복문을 사용
            chstrs[i] =//i의 값에 맞춰 인덱스를 설정.
                    Integer.parseInt(strs[i + 1]);// String타입을 int타입으로 바꿔준다. 이 메소드로 들어오는 배열은 유닛이름이 포함돼 있으므로 i의 값에 1을 더해서 정수표현만 배열에 저장되게 한다.
        }

        return chstrs; // 정수 배열을 리턴한다.
    }
    

    int attack(int[] myinfo, int[] enemyinfo) {//나의 유닛이 공격할때 사용하는 메소드를 만든다.

        String unitName = this.name; // user객체에서 입력받은 이름 멤버변수를 사용한다.

        if (enemyinfo[2] > 0) {/* 체력이 0이거나 음수가 나오면 유닛이 죽은 것 이므로 
         0보다 클때에 공격 정보가 출력되게 한다.*/
            System.out.println(unitName + "유닛이 공격하였습니다.");
            enemyinfo[2] = enemyinfo[2] - (myinfo[0] / enemyinfo[1]); // 적군 체력
            double a = Math.floor(enemyinfo[2]);//적군의 체력이 소숫점까지 나오면 소수자리를 없앤다.
            if(a < 0){/*적군 체력이 음수가 나올수도 있다. 체력이 0이나오면 조건문에 들어갈 필요없이 바로 리턴한다.*/
                return 0;//그때는 0을 리턴하자.
            }
            System.out.println("상대 유닛의 남은 체력은" + enemyinfo[2] + "입니다.");
            System.out.println("-----------------------");

        }
        return enemyinfo[2]; // 적군 체력을 리턴한다.
    }
    
   //위와 동일한다. 이것은 적 유닛이 나를 때렸을때이다.
   int attack2(int[] myinfo, int[] enemyinfo) {

        String unitName = this.name;

        if (myinfo[2] > 0) {
            System.out.println("적 " + unitName + " 유닛이 공격하였습니다.");
            myinfo[2] = myinfo[2] - (enemyinfo[0] / myinfo[1]);
            double a = Math.floor(enemyinfo[2]);
            if(a < 0){
                return 0;
            }
            System.out.println("나의 유닛의 남은 체력은 " + myinfo[2] + " 입니다.");
            System.out.println("-----------------------");
        }
        return myinfo[2];
    }
}
```
-----------

## 후기
> 처음에 혼자 해보겠다는 객기(?)를 부려서 ~~삽질~~을 3시간 동안 한것 같다. 그래서 어느 정도의 힌트를 받아 6시간 정도 걸려서 결과를 도출했다.

> 사실 정보를 받을 때 배열을 쓴다는 생각도 못했었다. 정보의 양이 적어서 그렇게 생각했던 것 같다.
> 배열을 써서 그런지 더 오래 걸린 것 같긴 하지만 배열에 대해 조금 더 이해할 수 있었다. 
> 내가 코딩한 배열 표현이 어떤 Array메소드로 더 짧게 표현할 수도 있을 것 같다는 생각을 많이 했다. 
> 다음에 리팩토링을 해보도록 해야겠다.

> 인스턴스와 메소드의 개념도 이전보다 더 이해할 수 있었다.

> 변수들 이름을 정하는 것이 생각보다 힘들었다 어떻게 하면 다른 사람이 봤을때 잘 알아 볼 수 있을까 생각하면서 변수나 메서드 이름을 정했는데 아직 많이 서투른 것 같다.

> 내가 실수한 부분이 너무 많아서 일일이 다 적을 수가 없다. 나중에는 이런 부분들도 꼼꼼히 기록해야 겠다.

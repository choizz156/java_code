## 객체지향을 공부한 후 살짝 리팩토링
> 상속을 이용해서 살짝 리팩토링을 해보았다. 2명의 유저이기 때문에 User1과 User2 클래스를 만든 뒤 기존의 Users 클래스를 확장하도록 했다. 그 후 새롭게 만든 2개의 클래스에 유닛 정보를 인출하는 데이터를 넣었다. main메서드가 조금 깔끔해졌다.

> main 메소드에 있던 유닛의 정수들을 배열로 만드는 코드들은 Users안으로 메소드 형태로 넣어서
각각의 객체가 메소드를 사용할 수 있게 했다.

## 더 해야할 것
> main 메서드의 마지막 반복문을 어떤 식으로 정리해야 할지 아직 모르겠다. main메서드에서 빼고 클래스 내에 메서드로 만들어야 할 것 같기도 하다. 


## 코드(수정한 부분만)
```java
public class Starcraft1 {
    public static void main(String[] args) {
        System.out.println("스타를 시작합니다.");

        System.out.println("자신의 유닛 정보를 입력해주세요.");
        User1 user1 = new User1();
        user1.infom(); // 기존의 코드들을 User1의 클래스에 넣어 메서드로 만들었다.

        System.out.println("상대 유닛 정보를 입력해 주세요");
        User2 user2 = new User2();
        user2.infom(); // 마찬가지다.


        int[] my = user1.list(); // 정수 배열을 Users 클래스 내 메소드로 만들게 해서 각 객체들이 쓸 수 있게 했다.
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
```
--------------
새로운 클래스를 만들어 상속받게 하고 안에다 메소드를 넣었다.
```java
class User1 extends Users { 
    String[] user_info;
    public void infom() {
        String[] user_info = new String[4];
        user_info = user_create();
        user_print(user_info);
    }
```

```java
public class User2 extends Users {
    String[] user2_info;
    public void infom() {
        String[] user2_info = new String[4];
        user2_info = user_create();
        user_print(user2_info);
    }
}
```
----------
```java

public class Users {


    String name;
    String att;
    String def;
    String hp;

    String[] input; // list()안에 배열을 넣기위해 필드로 만든다.

   ...
    
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
        return this.input = input; // this 키워드를 써서 리턴된 배열을 필드에 할당한다.
    }

  ...

    기존 배열에서 정수배열을 새롭게 만드는 메서드를 만들어서 넣었다.

    public int[] list() {
        int[] list = new int[3];
        list = user_info_int(input);

        return list;
    }
   ...

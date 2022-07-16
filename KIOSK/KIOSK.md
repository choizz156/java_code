## 사고 흐름
### 1단계 
- Menu라는 상위 항목에 포함되는 음식들이 있다.
- Menu 클래스를 만들거 음식 클래스(
A,B,C,D)를 만들어서 음식 클래스가 Menu클래스를 확장하도록 한다.
- 이렇게 하면 안의 정보가 바뀌어도 형식은 유지 될 수 있다.
- Customer 클래스를 만들어 객체가 하려는 행동을 메소드로 만든다.
### 2단계
- 각 클래스 내에서 객체가 해야할 행동들의 메서드를 생각했다.
- Customer는 메뉴를 선택(select)하고 수량을 정한다(count). 그리고 얼마를 지불(pay)해야 하는지 전해 받는다.
- Menu는 이름과 가격 그리고 최대주문수량이 있다. Menu 클래스에 생성자를 만들어서 인스턴스 변수에 각각을 저장할 수 있도록 한다.
- Menu를 상속받는 클래스들은 super()를 이용해 
상위 클래스의 인스턴스에 각각 자신의 정보를 저장한다.

```java
package Kiosks;

import java.util.Scanner;

public class Kiosk {
    public static void main(String[] args) {
        System.out.println("김밥천국에 오신걸 환영합니다.");
        System.out.println("=========================");


        Customer customer = new Customer();
        int price = customer.select();//리턴받은 값을 변수에 저장한다.
        int count = customer.count();
        customer.pay(price,count); // 음식의 가격과 주문량을 통해 총 가격을 출력한다.

    }
}

```
```java
 class Customer {
    A a = new A(); // Customer클래스에서 음식의 객체를 사용하기 위해 클래스 안에다 객체를 만든다.
    B b = new B();
    C c = new C();
    D d = new D();

    int num; // customer가 입력한 수를 클래스내에서 필드로 저장하여 사용한다.
    int menuPrice; // 메소드 내에서 여러번 할당 값이 바뀌는 변수는 필드로 만들어서 사용한다.
    int maxCount;
    Scanner scanner = new
    Scanner(System.in);// 값을 입력받는 객체를 생성한다.

    public int select() { // 메뉴를 선택하는 메소드.

        System.out.println("원하시는 메뉴의 번호를 입력해주세요.");
        System.out.println("1) " + a + " 2) " + b + " 3) " + c + " 4) " + d); // 각각 음식 클래스의 객체들의 정보를 문자열로 추출한다.

        int num = scanner.nextInt(); //입력받은 값을 num변수에 저장한다.
        this.num = num; //num값을 필드값으로 저장한다.
      

        if (num == 1) { // num 값에 따른 음식의 가격을 할당한다.
            menuPrice = a.price;
        }
        else if (num == 2) {
            menuPrice = b.price;
        }
        else if (num == 3) {
            menuPrice = c.price;
        }
        else if (num == 4) {
            menuPrice = d.price;
        } else if(num > 4 || num <1) { // 만약 보기에 없는 숫자가 나오면 재실행시킨다.
            System.out.println("메뉴에 포함된 번호를 입력해주세요.\n");
            select();//재실행
        }

        return menuPrice; //num값에 맞는 가격을 리턴한다.

    }
----------------------------
    public int count() {// 주문량을 입력하는 메서드
        System.out.println("선택하신 메뉴의 수량을 입력하여 주세요.");


        if (num == 1) {//num 필드를 이용해서 num값에 맞는 음식의 최대수량을 maxCount에 저장한다.
            maxCount = a.count;
        } else if (num == 2) {
            maxCount = b.count;
        } else if (num == 3) {
            maxCount = c.count;
        } else if (num == 4) {
            maxCount = d.count;
        }

        System.out.println("※ 최대 주문 가능 수량 " + maxCount);

        int count = scanner.nextInt(); //입력받은 수량을 count변수에 저장한다.
        if (count > maxCount) {// count가 최대 주문수량을 넘으면 메서드를 재실행한다.
            System.out.println(count + "개는 입력하실 수 없습니다.");
            System.out.println("수량 선택 화면으로 돌아갑니다.");
            count();
        }
        return count; //주문량을 저장한다.
    }

    public void pay(int price, int count){// 총 가격을 만드는 메서드
        int amount = price * count; //c 총 금액을 가격과 양을 곱해서 만든다. 
        System.out.println("주문하신 메뉴의 총 금액은 " + amount+"원 입니다.");
        System.out.println("이용해주셔서 감사합니다.");
    }
}
```

```java
package Kiosks;

public class Menu {
    int price; // 음식들의 가격필드
    String name; // 음식 이름 필드
    int count; // 음식 주문가능갯수 필드를 
    만들어 저장한다.

    public Menu(int price, String name, int count) {//생성자를 만들어 각각 음식들의 정보를 저장할 수 있게 한다.
        this.price = price;
        this.name = name;
        this.count = count;
    }
}

class A extends Menu { //Menu를 상속한다.

    public A() { 
        super(1000, "김밥" ,99); //super()를 통해 음식의 정보들을 Menu클래스에 저장한다.
    }

    public String toString() {//클래스에서 만들어질 객체의 정보를 문자열로 표현한다.
        return String.format("%s(%d)", name, price);
    }
}

class B extends Menu {

    public B() {
        super(1500, "참치 김밥",99);
    }

    public String toString() {
        return String.format("%s(%d)", name, price);
    }
}

class C extends Menu {

    public C() {
        super(1000, "충무 김밥",50);
    }

    public String toString() {
        return String.format("%s(%d)", name, price);
    }
}

class D extends Menu {

    public D() {
        super(2000, "떡볶이",99);
    }

    public String toString() {
        return String.format("%s(%d)", name, price);
    }
}
```
## 후기
> 객체지향을 배우고 나서 처음 실습이었는데 상속의 중요성을 알 수 있었다.

> 재귀의 개념을 사용했는데 재귀는 stack메모리에 저장되기 때문에 결국 처음에 리턴된 값이 나중에 저장되어 나온다는 사실을 알 수 있었다.
 그래서 return값을 어떻게 설정하느냐가 중요했다. select()메소드에서 return값이 menuPrice값이었다. 처음에 이 변수를 0을 할당하고 시작하다 보니 재귀가 되면서 계속 0이 출력됐다.
num값을 잘못 입력하면  select()메소드가 재실행되는데 이때 처음 실행한 return값이 0으로 저장되는 것이다.

|2번째 메소드 실행 < 리턴값이 음식 값으로 저장됨. |
|----------------|
| 1번째 메소드 실행 < 리턴값이 0이 저장됨.|

>이렇게 stack 형식으로 재귀가 되는데
출력 값은 2번째 메소드부터 출력되고 그다음 첫 번재 메서드가 출력된다. 그런데 첫 번째 메소드 리턴 값이 0이라(변수에 0을 할당) 0이 리턴된 것이다.
> 클래스 내에서 메서드 안에 변수를 선언하고 특정 값을 할당했을 때, 그 변수가 반복되서 사용되며 값이 변한다면 처음 할당한 값이 나올 가능성이 있다. 이럴 경우는 클래스 내에서 인스턴스 변수로 선언하고 사용하면 값이 초기화 되지 않는다.

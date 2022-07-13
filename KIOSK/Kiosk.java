package Kiosks;

import java.util.Scanner;

public class Kiosk {
    public static void main(String[] args) {
        System.out.println("김밥천국에 오신걸 환영합니다.");
        System.out.println("=========================");


        Customer customer = new Customer();
        int price = customer.select();
        int count = customer.count();
        customer.pay(price,count);

    }
}

class Customer {
    A a = new A();
    B b = new B();
    C c = new C();
    D d = new D();

    int num;
    int menuPrice;

    int maxCount;
    Scanner scanner = new Scanner(System.in);

    public int select() {

        System.out.println("원하시는 메뉴의 번호를 입력해주세요.");
        System.out.println("1) " + a + " 2) " + b + " 3) " + c + " 4) " + d);

        int num = scanner.nextInt();
        this.num = num;


//        if(num <=0 || num > 4){
//            System.out.println("df");
//            select();
//        }
//
//        if (num == 1) {
//            menuPrice = a.price;
//        }
//        else if (num == 2) {
//           menuPrice = b.price;
//        }
//        else if (num == 3) {
//            menuPrice = c.price;
//        }
//        else if (num == 4) {
//            menuPrice = d.price;
//
//        }


                if (num == 1) {
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
        } else if(num > 4 || num <1) {
            System.out.println("메뉴에 포함된 번호를 입력해주세요.\n");
            select();
        }

        return menuPrice;

    }

    public int count() {
        System.out.println("선택하신 메뉴의 수량을 입력하여 주세요.");


        if (num == 1) {
            maxCount = a.count;
        } else if (num == 2) {
            maxCount = b.count;
        } else if (num == 3) {
            maxCount = c.count;
        } else if (num == 4) {
            maxCount = d.count;
        }

        System.out.println("※ 최대 주문 가능 수량 " + maxCount);

        int count = scanner.nextInt();
        if (count > maxCount) {
            System.out.println(count + "개는 입력하실 수 없습니다.");
            System.out.println("수량 선택 화면으로 돌아갑니다.");
            count();
        }
        return count;
    }

    public void pay(int x, int y){
        int result = x * y;
        System.out.println("주문하신 메뉴의 총 금액은 " + result+"원 입니다.");
        System.out.println("이용해주셔서 감사합니다.");
    }
}

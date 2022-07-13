package Kiosks;

public class Menu {
    int price;
    String name;

    int count;

    public Menu(int price, String name, int count) {
        this.price = price;
        this.name = name;
        this.count = count;
    }
}

class A extends Menu {

    public A() {
        super(1000, "김밥" ,99);
    }

    public String toString() {
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

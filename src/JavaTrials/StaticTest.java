package JavaTrials;

class A {
    static void testA() {
        System.out.println("test JavaTrials.A");
    }
    public void testAA(){
        System.out.println("test AA");
    }
}

class B extends A {
    public static void testA() {
        System.out.println("test JavaTrials.B");
    }
    @Override
    public void testAA(){
        System.out.println("test BB");
    }
}

public class StaticTest {

    public static void main(String[] args) {
        A.testA();
        B.testA();
        A a = new A();
        B b = new B();
        a.testA();
        b.testA();
        System.out.println("");

        a.testAA();
        b.testAA();
        System.out.println("");

        a=b;
        a.testA();
        a.testAA();
    }
}


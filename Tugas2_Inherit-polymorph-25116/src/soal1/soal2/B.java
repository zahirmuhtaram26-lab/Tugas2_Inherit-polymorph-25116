package soal2;

public class B extends A {

    int nilai = 5;

    B() {
        super();
        System.out.println("B dibuat, nilai=" + nilai);
    }

    @Override
    void init() {
        System.out.println("init B, nilai=" + nilai);
    }
}
package exceptions_lec;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.sum(2, 2);
        test.mult(2, 2);
        test.div(2, 2);
        test.sub(2, 2);

    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int mult(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

}

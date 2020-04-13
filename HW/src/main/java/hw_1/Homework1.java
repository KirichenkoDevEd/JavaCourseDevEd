package hw_1;

/**
 * My first class in DevEd!
 */
public class Homework1 {

    /**
     * Method returns sum of arguments.
     *
     * @param firstNumber  The first number to add.
     * @param secondNumber The second number to add.
     * @return Sum of numbers.
     */
    public int getSum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * Method tests the getSum method.
     *
     * @return True, if getSum is ok, otherwise - false.
     */
    public boolean testSum() {
        Homework1 homework1 = new Homework1();
        boolean isOk = false;
        int result = homework1.getSum(2, 2);
        if (result == 4) {
            isOk = true;
        }
        return isOk;
    }

    /**
     * Public static void main - runs the program.
     *
     * @param args args
     */
    public static void main(String[] args) {
        Homework1 homework1 = new Homework1();
        System.out.println("2 + 2 = " + homework1.getSum(2, 2));
        if (homework1.testSum()) {
            System.out.println('\n' + "Method is ok!");
        }
    }
}

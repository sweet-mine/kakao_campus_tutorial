package calc;
import java.util.Queue;
import java.util.LinkedList;

public class Calculator_lv2 {
    private Queue<Integer> resultQueue = new LinkedList<Integer>();

    public int calculate (int num1, int num2, char oper){
        if (oper == '+') return num1 + num2;
        else if (oper == '-') return num1 - num2;
        else if (oper == '*') return num1 * num2;
        else return num1 / num2;
    }

    public int get() {
        return resultQueue.element();
    }

    public void set(int a) {
        resultQueue.add(a);
    }

    public void remove() {
        resultQueue.remove();
    }

    public boolean isEmpty() {
        return resultQueue.isEmpty();
    }
}

package calc;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;

// 연산자 enum
enum Operator {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE
}

//  enum, generic, lambda를 활용한 계산기 클래스
class Calculator_lv3 {
    private Queue<Double> resultQueue = new LinkedList<>();

    public <T extends Number> double calculate (T num1, T num2, Operator oper){
        double number1 = num1.doubleValue();
        double number2 = num2.doubleValue();
        if (oper == Operator.PLUS) return number1 + number2;
        else if (oper == Operator.MINUS) return number1 - number2;
        else if (oper == Operator.MULTIPLY) return number1 * number2;
        else return number1 / number2;
    }

    public double get() {
        return resultQueue.element();
    }

    public void set(double a) {
        resultQueue.add(a);
    }

    public void remove() {
        resultQueue.remove();
    }

    public boolean isEmpty() {
        return resultQueue.isEmpty();
    }

    public List<Double> findAboveValue(double value) {
        List<Double> myList = resultQueue.stream()
                .filter(num -> num > value)
                .collect(Collectors.toList());
        return myList;
    }
}


// Calculator_lv3 클래스를 활용하여 사칙연산 및 기능 테스트
public class useClass_lv3 {
    public static void main(String[] args){
        int num1, num2;
        double num3, num4;
        double result;
        String operName;
        String str;
        Scanner sc = new Scanner(System.in);
        Calculator_lv3 myCalc = new Calculator_lv3();
        Operator oper;
        int above = 10;

        while(true) {
            System.out.print("사칙연산 기호 입력(PLUS, MINUS, MULTIPLY, DIVIDE) : ");
            operName = sc.next();

            try {
                oper = Operator.valueOf(operName);
            }catch(Exception e) {
                System.out.println("올바른 기호를 입력하세요.");
                continue;
            }

            System.out.print("첫번째 정수 입력 : ");
            num1 = sc.nextInt();
            System.out.print("두번째 정수 입력 : ");
            num2 = sc.nextInt();
            System.out.print("세번째 소수 입력 : ");
            num3 = sc.nextDouble();
            System.out.print("네번째 소수 입력 : ");
            num4 = sc.nextDouble();

            if ((num2 == 0 || num4 == 0.0) && oper == Operator.DIVIDE) {
                System.out.println("0으로는 나눌 수 없습니다");
                continue;
            }

            result = myCalc.calculate(num1, num2, oper);
            myCalc.set(result);
            System.out.printf("정수 계산 결과 = %f, Queue에 저장했습니다.\n", result);
            result = myCalc.calculate(num3, num4, oper);
            myCalc.set(result);
            System.out.printf("소수 계산 결과 = %f, Queue에 저장했습니다.\n", result);

            System.out.println("10보다 큰 값 : " + myCalc.findAboveValue(above));

            System.out.print("종료하시겠습니까?(no or exit) : ");
            str = sc.next();
            if (str.equals("exit")) break;
        }
    }
}
package calc;
import java.util.Scanner;

// Calculator_lv2 클래스를 활용하여 사칙연산 및 기능 테스트
public class useClass_lv2 {
    public static void main(String[] args){
        char oper;
        int num1, num2, result;
        String str;
        Scanner sc = new Scanner(System.in);
        Calculator_lv2 myCalc = new Calculator_lv2();

        while(true) {
            System.out.print("사칙연산 기호 입력 : ");
            oper = sc.next().charAt(0);
            if (oper != '+' && oper != '-' && oper != '*' && oper != '/') {
                System.out.println("올바른 사칙연산 기호를 입력하세요");
                continue;
            }

            System.out.print("첫번째 숫자 입력 : ");
            num1 = sc.nextInt();
            System.out.print("두번째 숫자 입력 : ");
            num2 = sc.nextInt();
            if (num2 == 0 && oper == '/') {
                System.out.println("0으로는 나눌 수 업습니다");
                continue;
            }

            result = myCalc.calculate(num1, num2, oper);

            myCalc.set(result);
            System.out.println(result + " 큐에 삽입함");
            if(!myCalc.isEmpty()) {
                result = myCalc.get();
                System.out.println(result + " 큐에서 읽어옴");
            }
            else System.out.println("비어있습니다.");

            myCalc.remove();
            System.out.println("큐 pop");
            if(!myCalc.isEmpty()) {
                result = myCalc.get();
                System.out.println(result + " 큐에서 읽어옴");
            }
            else System.out.println("비어있습니다.");


            System.out.printf("계산 결과 = %d\n", result);
            System.out.print("종료하시겠습니까?(no or exit) : ");
            str = sc.next();
            if (str.equals("exit")) break;
        }
    }
}

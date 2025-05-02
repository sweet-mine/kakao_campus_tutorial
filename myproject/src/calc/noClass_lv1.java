package calc;
import java.util.Scanner;

public class noClass_lv1 {
    public static void main(String[] args){
        char oper;
        int num1, num2, result;
        String str;
        Scanner sc = new Scanner(System.in);

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

            if (oper == '+') result = num1 + num2;
            else if (oper == '-') result = num1 - num2;
            else if (oper == '*') result = num1 * num2;
            else result = num1 / num2;

            System.out.printf("계산 결과 = %d\n", result);
            System.out.print("종료하시겠습니까?(no or exit) : ");
            str = sc.next();
            if (str.equals("exit")) break;
        }
    }
}

package Utils;

import java.util.Scanner;

public class InputUtil {
    public static String getText(String title){
        System.out.println(title);
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        return answer;
    }

    public static int getNumber(String number){
        System.out.println(number);
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        return answer;
    }
}

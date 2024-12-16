package freshman22233.simulate.numericStringFormatting_3;

import java.util.Scanner;

/**
 * Numeric String Formating
 * Problem description
 * 小M在工作时遇到了一个问题，他需要将用户输入的不带千分位逗号的数字字符串转换为带千分位逗号的格式，
 * 并且保留小数部分。小M还发现，有时候输入的数字字符串前面会有无用的 0，这些也需要精简掉。请你帮助小M编写程序，完成这个任务。
 * Little M encountered a problem at work.
 * He needed to convert the digital string entered by the user
 * without a thousandth comma into a format with a thousandth comma
 * and retain the decimal part.
 * Little M also discovered that sometimes
 * there are useless 0 in front of the entered numeric strings,
 * and these also need to be streamlined.
 * Please help Xiao M write a program to complete this task.
 */
public class Main {
    public static String solution(String s) {
        //1. split into integral and decimal parts if a decimal point exists
        String integralPart, decimalPart = "";
        if (s.contains(".")){
            String[] parts = s.split("\\.");
            integralPart = parts[0];
            decimalPart = parts.length>1 ? parts[1] : "";
        }else {
            integralPart = s;
        }

        // 2. Remove leading zeros from the integral part
        integralPart = integralPart.replaceFirst("^0+(?!$)", "");
        if (integralPart.isEmpty()){
            integralPart = "0";
        }

        //3.Insert commas into the integral part
        StringBuilder sb = new StringBuilder(integralPart);
        int length = sb.length();
        for (int i = length - 3 ; i > 0 ; i-=3){
            sb.insert(i, ',');
        }

        //4.Reattach the decimal part
        if (!decimalPart.isEmpty()){
            sb.append(".").append(decimalPart);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("987654321").equals("987,654,321"));
    }
}
package src.Programmers.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args){

        int m = 4620;

        int a = m / 1000;
        int b = (m % 1000) / 500;
        int c = (m % 500) / 100;
        int d = (m % 100) / 10;

        System.out.printf("%d, %d, %d, %d", a, b, c, d);
    }

}

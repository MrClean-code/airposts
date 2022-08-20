package org.airsoft;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Parse parse;
    private static int n;
    private static String str;
    private static String quit;
    private static Scanner scanner;
    private static Search search;
    private static List<String> list;
    private static boolean flag;

    public static void main(String[] args) {
        parse = new Parse();
        search = new Search();

        list = parse.parseFileToList();
        flag = true;
        do {
            System.out.print("Введите колонку из файла (от 1): ");
            scanner = new Scanner(System.in);
            n = scanner.nextInt();
            n--;

            System.out.print("Введите строку: ");
            scanner = new Scanner(System.in);
            str = scanner.next();

            search.findColumnAndContains(list, n, str);

            System.out.println();
            System.out.println("Введите !quit для выхода, или все что угодно для продолжения: ");
            quit = scanner.next();
            if (quit.contains("!quit")) {
                flag = false;
            }
        }
        while (flag == true);
        list = null;

        System.out.println();
        System.err.println("Exit Program");
    }
}
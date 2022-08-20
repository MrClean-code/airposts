package org.airsoft;

import java.util.*;

public class Search {
    private String[] mas;
    private String str;

    public void findColumnAndContains(List<String> list, int n, String findStr) {
        int count = 0;
        boolean flag = false;
        long start = System.nanoTime();
        for (String str : list) {
            mas = str.split(",");
            flag = mas[n].toLowerCase().contains(findStr.toLowerCase());
            if (flag && str.isEmpty() == false) {
                findRowContains(mas, n);
                count++;
            }
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Количество строк: " + count);
        System.err.println("мс: " + elapsed / 1000000);
    }

    public void findRowContains(String[] mas, int n) {
        String temp = "";
        str = mas[n];
        String str1 = str.toLowerCase();
        String result = str1.replaceAll("^\"|\"$", "");

        for (int i = 0; i < mas.length - 1; i++) {
            String strMas1 = mas[i].toLowerCase().replaceAll("^\"|\"$", "");
            String strMas2 = mas[i + 1].toLowerCase().replaceAll("^\"|\"$", "");

            if (strMas1.contains(result) == false &&
                    (strMas2.contains(result) || result.contains(strMas2))) {
                temp = mas[i];
                mas[i] = mas[i + 1];
                mas[i + 1] = temp;
            }
        }
        printMas(mas);
    }

    public void printMas(String[] masRes) {
        System.out.print(str + ",");
        for (int i = 0; i < masRes.length; i++) {
            if (i != masRes.length - 1) {
                System.out.print(masRes[i].concat(","));
            } else {
                System.out.println(masRes[i]);
            }
        }
    }

}
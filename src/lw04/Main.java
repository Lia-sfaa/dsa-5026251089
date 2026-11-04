package lw04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scLia = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = scLia.nextInt();
        int[] values = new int[n];
        for (int i=0; i<n; i++) {
            values[i] = scLia.nextInt();
        }

        int count = 0;
        for (int i=1; i<n; i++) {
            if (count < 3) {
                int key = values[i];
                int j = i - 1;
                while (j >= 0 && values[j] < key) {
                    values[j + 1] = values[j];
                    j--;
                }
                values[j + 1] = key;
                count++;
            } else {
                break;
            }
        }

        for (int i=0; i<n; i++) {
            if (i>0) System.out.print(" ");
            System.out.print(values[i]);
        }
        System.out.println();

        int m = scLia.nextInt();
        for (int i=0; i<m; i++) {
            int target = scLia.nextInt();
            int index = 0;
            boolean found = false;

            for (int j=0; j<n; j++) {
                if (values[j] == target) {
                    index = j;
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println(target + ": FOUND at index " + index);
            } else {
                System.out.println(target + ": NOT FOUND");
            }  
        }
        scLia.close();
    }
}

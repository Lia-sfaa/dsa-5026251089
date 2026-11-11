package lw04.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scLia = new Scanner (Main.class.getResourceAsStream("parcels.txt"));

        int n = scLia.nextInt();
        int[] parcels = new int[n];

        for (int i=0; i<n; i++) {
            parcels[i] = scLia.nextInt();
        }

        int m = scLia.nextInt();
        int[] targets = new int[m];

        for (int i=0; i<m; i++) {
            targets[i] = scLia.nextInt();
        }

        scLia.close();

        for (int i=0; i<2; i++) {
            for (int j=0; j<n-1-i; j++) {
                if (parcels[j] < parcels[j+1]) {
                    int temp = parcels[j];
                    parcels[j] = parcels[j+1];
                    parcels[j+1] = temp;
                }
            }
        }

        int[] after2Passes = new int[n];

        for (int i=0; i<n; i++) {
            after2Passes[i] = parcels[i];
        }

        for (int i=2; i<n-1; i++) {
            for (int j=0; j<n-1-i; j++) {
                if (parcels[j] < parcels[j+1]) {
                    int temp = parcels[j];
                    parcels[j] = parcels[j+1];
                    parcels[j+1] = temp;
                }
            }
        } 

        System.out.println();
        System.out.println("==== After 2 Passes ====");

        for (int i=0; i<n; i++) {
            if (i>0) 
                System.out.print(" ");
            System.out.print(after2Passes[i]);
        } 

        System.out.println();
        System.out.println();
        System.out.println("==== Fully Sorted ====");

        for (int i=0; i<n; i++) {
            if (i>0) 
                System.out.print(" ");
            System.out.print(parcels[i]);
        }

        System.out.println();
        System.out.println();
        System.out.println("==== Search Results ====");

        for (int t=0; t<m; t++) {
            int low = 0;
            int high = n-1;
            int step = 0;
            int found = -1;

            while (low <= high) {
                int mid = (low + high) / 2;
                step++;

                if (parcels[mid] == targets[t]) {
                    found = mid;
                    break;
                } else if (parcels[mid] < targets[t]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (found != -1) {
                System.out.println(targets[t] + ": FOUND at index " + found + " (steps: " + step + ")");
            } else {
                System.out.println(targets[t] + ": NOT FOUND (steps: " + step + ")");
            }
        }

        System.out.println();
    }
}

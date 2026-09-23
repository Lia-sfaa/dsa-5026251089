package lw01.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        List<PrintJob> printJobs = new ArrayList<>();

        try {
           
            File file = new File("src/lw01/prelab/jobs.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String type = scanner.next();
                String id = scanner.next();
                int pages = scanner.nextInt();

                if (type.equals("MONO")) {
                    printJobs.add(new MonoPrint(id, pages));
                } else if (type.equals("COLOUR")) {
                    printJobs.add(new ColourPrint(id, pages));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File jobs.txt tidak ditemukan.");
            return;
        }

        for (PrintJob job : printJobs) {
            System.out.println(job.summary());
        }
    }
}

// package lw01.prelab;

// import java.util.ArrayList;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
//         ArrayList<PrintJob> jobs = new ArrayList<PrintJob>();

//         while (scanner.hasNext()) {
//             String type = scanner.next();
//             String id = scanner.next();
//             int pages = scanner.nextInt();

//             if (type == "MONO") {
//                 jobs.add(new MonoPrint(id, pages));
//             } else if (type == "COLOUR") {
//                 jobs.add(new ColourPrint(id, pages));
//             }
//         }
//         scanner.close();

//         for (PrintJob job : jobs) {
//             System.out.println(job.summary());
//         }

//     }
// }
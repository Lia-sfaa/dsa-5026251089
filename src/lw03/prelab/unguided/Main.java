package lw03.prelab.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner registrations = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Scanner checkins = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        Set<String> registered = new LinkedHashSet<String>();
        while (registrations.hasNext()) {
            String id = registrations.next();
            registered.add(id);
        }
        registrations.close();

        Set<String> checkedIn = new LinkedHashSet<String>();

        List<String> results = new ArrayList<String>();
        int rejected = 0;

        while (checkins.hasNext()) {
            String id = checkins.next();

            if (!registered.contains(id)) {
                results.add(id + ": Rejected (not registered)");
                rejected++;
            } else if (checkedIn.contains(id)) {
                results.add(id + ": Rejected (already checked in)");
                rejected++;
            } else {
                checkedIn.add(id);
                results.add(id + ": Checked in");
            }
        }
        checkins.close();

        System.out.println("===== Event Check-In Results =====");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registered.size());
        System.out.println("Successful check-ins: " + checkedIn.size());
        System.out.println("Absent students: " + (registered.size() - checkedIn.size()));
        System.out.println("Rejected attempts: " + rejected);
    }
}
package lw03.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner p1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        
        List<String> song = new ArrayList<>();
        while (p1.hasNextLine()) {
            String line = p1.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            
            if (type.equals("ADD")) {
                String title = parts[1];
                song.add(title);

            }else if (type.equals("INSERT")) {
                int index = Integer.parseInt(parts[1]);
                String title = parts[2];
                song.add(index, title);

            }else{
                String title = parts[1];
                song.remove(title);
            }
        }
        System.out.println("=== Problem 1 ===");
        System.out.println("Total Songs: " + song.size());

        for ( int i = 0; i < song.size(); i++) {
            System.out.println((i + 1) + ": " + song.get(i));
        }
        p1.close();

        Scanner p2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        Set<String> participants = new LinkedHashSet<>();
        int duplicate = 0;
        int total = 0;

        while (p2.hasNextLine()) {
            String name = p2.nextLine();
            if (participants.contains(name)) {
                duplicate++;
            }else{
                participants.add(name);
                total++;
            }
        }
        System.out.println("=== Problem 2 ===");
        System.out.println("Unique Participants: " + total);
        
        for (int i = 0; i < participants.size(); i++) {
            System.out.println((i + 1) + ". " + participants.toArray()[i]);
        }
        System.out.println("Duplicate registrations: " + duplicate);

        p2.close();
        
        Scanner p3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0;
        
        while (p3.hasNextLine()) {
            String line = p3.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {
                if (inventory.containsKey(product)) {
                    inventory.put(product, inventory.get(product) + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    inventory.put(product, inventory.get(product) - quantity);
                } else {
                    failed++;
                }
            }
        }
        System.out.println("=== Problem 3 ===");

        for (String product : inventory.keySet()) {
            System.out.println(product + ": " + inventory.get(product));
        }

        System.out.println("Failed Sales: " + failed);
        p3.close();

    }
}

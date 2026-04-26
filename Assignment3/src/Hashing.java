//Hashing (Modulo)
//"Creating a fast-access cache for a web server's session tokens."
//
//Insert your dataset into a Hash Table of size M=7 using h(k) = k mod 7. Show the resulting table and resolve any collisions using the Linear Probing method.
import java.util.Arrays;

public class Hashing {

    public static void main(String[] args) {
        int M = 7;

        Integer[] hashTable = new Integer[M];
        int[] dataset = {54, 70, 93, 77, 94, 22, 15, 45, 40, 85};

        System.out.println("Initializing Hash Table of size M = " + M + "\n");

        for (int key : dataset) {
            System.out.println("--- Inserting " + key + " ---");

            int initialHash = key % M;
            System.out.println("h(" + key + ") = " + key + " mod " + M + " = " + initialHash);

            int currentSlot = initialHash;
            boolean isInserted = false;

            for (int i = 0; i < M; i++) {
                if (hashTable[currentSlot] == null) {
                    hashTable[currentSlot] = key;

                    if (i == 0) {
                        System.out.println("Slot [" + currentSlot + "] is empty. Successfully inserted " + key + ".");
                    } else {
                        System.out.println("Slot [" + currentSlot + "] is empty. Inserted " + key + " after collision(s).");
                    }

                    isInserted = true;
                    break;

                } else {
                    System.out.println("Collision at slot [" + currentSlot + "] (Occupied by " + hashTable[currentSlot] + "). Probing next slot");
                    currentSlot = (currentSlot + 1) % M;
                }
            }
            if (!isInserted) {
                System.out.println("\nERROR: Hash Table Overflow! The table is completely full.");
                System.out.println("Cannot insert " + key + " or any remaining elements.");
                break;
            }
            System.out.println("Current Table State: " + Arrays.toString(hashTable) + "\n");
        }
        System.out.println("FINAL HASH TABLE RESULT:");
        for (int i = 0; i < M; i++) {
            String value = (hashTable[i] == null) ? "Empty" : String.valueOf(hashTable[i]);
            System.out.println("Index [" + i + "] -> " + value);
        }
    }
}
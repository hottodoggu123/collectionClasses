import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class collectionClasses {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> paperStack = new Stack<>();
        boolean validInput = false;

        //welcome message
        System.out.println(ANSI_YELLOW + ANSI_BOLD +
            "\n╔═══════════════════════════════════════════════════════════╗" +
            "\n║             FEU-TECH PRINTING SERVICES SYSTEM             ║" +
            "\n╚═══════════════════════════════════════════════════════════╝" + ANSI_RESET);

        while (!validInput) {
            try {
                //paperstack input
                System.out.println("Enter 10 document IDs to be processed (separated by spaces): ");
                
                String input = scanner.nextLine().trim();
                String[] numbers = input.split("\\s+");

                if (numbers.length != 10) {
                    throw new IllegalArgumentException("Please enter exactly 10 document IDs.");
                }

                //parse each number
                for (String number : numbers) {
                    int documentNo = Integer.parseInt(number);
                    if (documentNo < 0) {
                        throw new IllegalArgumentException("Document IDs must be positive numbers only.");
                    }
                    paperStack.push(documentNo);
                }
                validInput = true;

            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "Error: " + e.getMessage() + "\n" + ANSI_RESET);
                paperStack.clear();
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Error: Invalid input. Please try again.\n" + ANSI_RESET);
                paperStack.clear();
            }
        }

        // //checking if its a stack
        // System.out.println("\nContents of the stack:");
        // for (Integer document : paperStack) {
        //     System.out.println("Document ID: " + document);
        // }
       
        // paperStack.pop();
        // paperStack.pop();

        // System.out.println("\nContents of the stack:");
        // for (Integer document : paperStack) {
        //     System.out.println("Document ID: " + document);
        // }
        
        try {
            //sending paperstack to the print queue
            Queue<Integer> scanAndPrintQueue = new LinkedList<>();
            while (!paperStack.isEmpty()) {
                int document = paperStack.pop();
                scanAndPrintQueue.add(document);
            }

            // //test print scanAndPrintQueue with watermark
            // System.out.println("Contents of scanAndPrintQueue (with watermark):");
            // for (Integer doc : scanAndPrintQueue) {
            //     System.out.println("FEU-TECH | " + doc);
            // }

            // scanAndPrintQueue.remove();
            // scanAndPrintQueue.remove();

            // System.out.println("Contents of scanAndPrintQueue (with watermark):");
            // for (Integer doc : scanAndPrintQueue) {
            //     System.out.println("FEU-TECH | " + doc);
            // }

            //placing into a linked list paperlist
            LinkedList<Integer> paperList = new LinkedList<>();
            while (!scanAndPrintQueue.isEmpty()) {
                int document = scanAndPrintQueue.poll();
                paperList.add(document);
            }

            // //test print paperList
            // System.out.println("Contents of paperList:");
            // for (Integer doc : paperList) {
            //     System.out.println("FEU-TECH | " + doc);
            // }

            // paperList.remove();
            // paperList.remove();

            // System.out.println("Contents of paperList:");
            // for (Integer doc : paperList) {
            //     System.out.println("FEU-TECH | " + doc);
            // }

            //transferring from paperlist to verification queue
            Queue<Integer> verificationQueue = new LinkedList<>();
            while (!paperList.isEmpty()) {
                int document = paperList.removeFirst();
                verificationQueue.add(document);
            }

            //displaying the verification queue
            System.out.println("═════════════════════════════════════════════════════════════");
            System.out.println("All documents verified:");
            while (!verificationQueue.isEmpty()) {
                System.out.println("Document ID: FEU-TECH | " + verificationQueue.poll());
            }
            System.out.println("═════════════════════════════════════════════════════════════");
            System.out.println(ANSI_GREEN + ANSI_BOLD + "All documents have been digitized and verified. Thank you!\n" + ANSI_RESET);

        } finally {
            scanner.close();
        }
    }
}
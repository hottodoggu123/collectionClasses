import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PrintingServicesSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> paperStack = new Stack<>();
        
        // Step 1: Collect documents by pushing them into the paperStack
        System.out.println("Enter 10 document IDs to be digitized (scanned):");
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter document no " + i + ": ");
            int documentNo = scanner.nextInt();
            paperStack.push(documentNo);
        }

        // Step 2: Transfer all documents from paperStack to scanAndPrintQueue
        Queue<Integer> scanAndPrintQueue = new LinkedList<>();
        while (!paperStack.isEmpty()) {
            int document = paperStack.pop();
            scanAndPrintQueue.add(document);
        }
        
        // Step 3: Transfer all documents from scanAndPrintQueue to paperList
        LinkedList<Integer> paperList = new LinkedList<>();
        while (!scanAndPrintQueue.isEmpty()) {
            int document = scanAndPrintQueue.poll();
            paperList.add(document);
        }

        // Step 4: Transfer all documents from paperList to verificationQueue
        Queue<Integer> verificationQueue = new LinkedList<>();
        while (!paperList.isEmpty()) {
            int document = paperList.removeFirst();
            verificationQueue.add(document);
        }

        // Display all contents of the verificationQueue
        System.out.println("\nAll documents in the verification queue:");
        while (!verificationQueue.isEmpty()) {
            System.out.println("Document ID: " + verificationQueue.poll());
        }
        
        scanner.close();
    }
}

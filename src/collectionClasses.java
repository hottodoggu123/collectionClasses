import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class collectionClasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> paperStack = new Stack<>();

        //paperstack input
        System.out.println("================================================");
        System.out.println("Enter 10 document IDs to be digitized (scanned)");
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter document no " + i + ": ");
            int documentNo = scanner.nextInt();
            paperStack.push(documentNo);
        }

        //sending paperstack to the print queue
        Queue<Integer> scanAndPrintQueue = new LinkedList<>();
        while (!paperStack.isEmpty()) {
            int document = paperStack.pop();
            scanAndPrintQueue.add(document);
        }

        //placing into a linked list paperlist
        LinkedList<Integer> paperList = new LinkedList<>();
        while (!scanAndPrintQueue.isEmpty()) {
            int document = scanAndPrintQueue.poll();
            paperList.add(document);
        }

        //transferring from paperlist to verification queue
        Queue<Integer> verificationQueue = new LinkedList<>();
        while (!paperList.isEmpty()) {
            int document = paperList.removeFirst();
            verificationQueue.add(document);
        }

        //displaying the verification queue
        System.out.println("================================================");
        System.out.println("All documents in the verification queue:");
        while (!verificationQueue.isEmpty()) {
            System.out.println("Document ID: " + verificationQueue.poll());
        }
        System.out.println("================================================");
        System.out.println("All documents have been digitized and verified. Thank you!\n");
        scanner.close();
    }
}
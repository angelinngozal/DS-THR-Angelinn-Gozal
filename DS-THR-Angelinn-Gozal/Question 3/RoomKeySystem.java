import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Borrower {
    String borrowerName;
    int keyNumber;
    int priorityValue;

    public Borrower(String borrowerName, int keyNumber, int priorityValue) {
        this.borrowerName = borrowerName;
        this.keyNumber = keyNumber;
        this.priorityValue = priorityValue;
    }
}

public class RoomKeySystem {

    public static void main(String[] arguments) {
        Scanner inputScanner = new Scanner(System.in);

        int totalKeys = Integer.parseInt(inputScanner.nextLine());

        String[] keyNumbersInput = inputScanner.nextLine().split(" ");
        String[] borrowerDataInput = inputScanner.nextLine().split(" ");
        String[] priorityInput = inputScanner.nextLine().split(" ");

        List<Borrower> borrowerList = new ArrayList<>();

        int borrowerIndex = 0;
        int priorityIndex = 0;

        while (borrowerIndex < borrowerDataInput.length) {
            String borrowerName = borrowerDataInput[borrowerIndex];
            int keyNumber = Integer.parseInt(borrowerDataInput[borrowerIndex + 1]);
            int priorityValue = Integer.parseInt(priorityInput[priorityIndex]);

            borrowerList.add(new Borrower(borrowerName, keyNumber, priorityValue));

            borrowerIndex += 2;
            priorityIndex += 1;
        }

        // Sort berdasarkan priority (ascending)
        borrowerList.sort((firstBorrower, secondBorrower) ->
                Integer.compare(firstBorrower.priorityValue, secondBorrower.priorityValue)
        );

        // Output langsung sesuai urutan hasil sort
        for (Borrower borrower : borrowerList) {
            System.out.println(borrower.borrowerName + " | " + borrower.keyNumber);
        }
    }
}
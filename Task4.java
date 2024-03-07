//      Task 4
//Hotel Reservation System


import java.util.Scanner;

public class Task4 {
    private static final int numberOfRooms = 5;
    private static final int[] roomIds = new int[numberOfRooms];
    private static final String[] roomTypes = new String[numberOfRooms];
    private static final boolean[] roomAvailabilities = new boolean[numberOfRooms];

    static {
        initializeRooms();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome! Please Enter:\n\"1\" " +
                "To Search For Available Rooms\n\"2\" " +
                "To Make A Reservation\n\"3\" " +
                "To View Booking Details\n\"4\" " +
                "To Exit");

        int choice = scan.nextInt();

        while (choice!=4) {
            switch (choice) {
                case 1:
                    System.out.println("Available Rooms:");
                    displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter the room number to reserve: ");
                    int roomId = scan.nextInt();
                    makeReservation(roomId);
                    break;
                case 3:
                    System.out.println("Booking Details:");
                    displayBookingDetails();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println("Welcome! Please Enter:\n\"1\" To Search For Available Rooms\n\"2\" To Make A Reservation\n\"3\" To View Booking Details\n\"4\" To Exit");
            choice = scan.nextInt();
        }
        System.out.println("Hotel Reservation System closed as per request");
    }

    private static void initializeRooms() {
        for (int i = 0; i < numberOfRooms; i++) {
            roomIds[i] = i + 1;
            roomTypes[i] = (i < 3) ? "Standard" : "Deluxe";
            roomAvailabilities[i] = true;
        }
    }

    private static void displayAvailableRooms() {
        for (int i = 0; i < numberOfRooms; i++) {
            if (roomAvailabilities[i]) {
                System.out.println("Room " + roomIds[i] + " - " + roomTypes[i] + " - " +
                        (roomAvailabilities[i] ? "Available" : "Booked"));
            }
        }
    }

    private static void makeReservation(int roomId) {
        if (roomId >= 1 && roomId <= numberOfRooms && roomAvailabilities[roomId - 1]) {
            roomAvailabilities[roomId - 1] = false;
            System.out.println("Room " + roomIds[roomId - 1] + " (Category: " + roomTypes[roomId - 1] +
                    ") booked successfully.");

            if (processPayment()) {
                System.out.println("Payment successful...Reservation confirmed!");
            } else {
                System.out.println("Payment failed...Reservation canceled!");
                roomAvailabilities[roomId - 1] = true;
            }
        } else {
            System.out.println("Sorry! Invalid room number.");
        }
    }

    private static boolean processPayment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Proceed with the Payment: $");
        double amount = sc.nextDouble();

        System.out.println("Processing payment...");

        return Math.random() < 0.8;
    }

    private static void displayBookingDetails() {
        for (int i = 0; i < numberOfRooms; i++) {
            System.out.println("Room " + roomIds[i] + " (Category: " + roomTypes[i] + ") - " +
                    (roomAvailabilities[i] ? "Available" : "Booked"));
        }
    }
}

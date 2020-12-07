package program5;

import java.util.Scanner;

class Program5 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        Hotel hotel1 = new Hotel();
        Hotel hotel2 = new Hotel();
        Hotel hotel3 = new Hotel();

        int option = 0;

        Hotel hotel = null;

        do // Main Menu System
        {
            //Pick hotel menu
            do {
                hotel1.showName("BATES");
                hotel1.seeRooms();
                hotel2.showName("NORMAN");
                hotel2.seeRooms();
                hotel3.showName("NORMA");
                hotel3.seeRooms();
                System.out.println(" 1 Hotel Bates");
                System.out.println(" 2 Hotel Norman");
                System.out.println(" 3 Hotel Norma");
                System.out.println("-------------------");
                System.out.print("Please choose an option: ");
                option = input.nextInt();
            } while (option < 1 || option > 3);

            if (option == 1) {
                hotel = hotel1;
                option = 0;
            } else if (option == 2) {
                hotel = hotel2;
                option = 0;
            } else if (option == 3) {
                hotel = hotel3;
                option = 0;
            }

            do // Check-in/Check-out Validation
            {
                System.out.println();
                System.out.println("-------------------");
                System.out.println(" 1 Check in");
                System.out.println(" 2 Check out");
                System.out.println(" 3 Just looking");
                System.out.println("-------------------");
                System.out.print("Please choose an option: ");
                option = input.nextInt();
            } while (option < 1 || option > 3);

            if (option == 1) {
                hotel.checkIn();
            }
            if (option == 2) {
                hotel.checkOut();
            }
        } while (true); // End of Main Menu System

    }
}

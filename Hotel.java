package program5;

import java.util.Random;
import java.util.Scanner;

class Hotel {

    private int rooms[][][] = new int[5][6][3]; // down, across, up
    private int room = 0;

    public Hotel() // Default Constructor
    {

        for (int u = 0; u < 3; ++u) // up
        {
            for (int d = 0; d < 5; ++d) // down
            {
                for (int a = 0; a < 6; ++a) // across
                {
                    Random r = new Random();
                    int rInt = r.nextInt((3-1)+1)+1;//Generate random int between 1-3 to determine if room is booked or not
                    if (rInt < 3) {
                        rooms[d][a][u] = (a + 1) + d * 6 + u * 30; // Room Count across, down, then up
                    } else {
                        rooms[d][a][u] = 0;
                    }

                }
            }
        }
    }

    public void showName(String name) {
        System.out.println();
        System.out.println("                        ---------------------");
        System.out.printf("                             HOTEL %s\n", name);
        System.out.println("                        ---------------------");
        System.out.println();
    }

    public void seeRooms() {
        System.out.print("        1st Floor     ");
        System.out.print("        2nd Floor     ");
        System.out.print("        3rd Floor");
        System.out.println();
        System.out.println();

        for (int d = 0; d < 5; ++d) // down
        {
            System.out.print(" | ");
            for (int u = 0; u < 3; ++u) // up
            {
                for (int a = 0; a < 6; ++a) // across
                {
                    if (rooms[d][a][u] < 10) {
                        if(rooms[d][a][u] == 0){ //If the room is occupied then set the print output to --
                            System.out.print(" --");
                        }else{
                            System.out.printf(" 0%d", rooms[d][a][u]); // Print across, up, then down
                        }
                        
                        
                    } else {
                        System.out.printf(" %d", rooms[d][a][u]); // Print across, up, then down
                    }
                }
                System.out.print("  | ");
            }
            System.out.println();
        }
    }

    public void checkIn() {
        int chosen;

        Scanner input = new Scanner(System.in);

        if (room == 0) // you do not have a room booked yet -- one room/hotel
        {
            do {
                System.out.println();
                System.out.print("Enter a room to check in to: ");
                chosen = input.nextInt();
            } while (chosen < 1 || chosen > 90);

            for (int d = 0; d < 5; ++d) // down
            {
                for (int a = 0; a < 6; ++a) // across
                {
                    for (int u = 0; u < 3; ++u) // up
                    {
                        if (rooms[d][a][u] == chosen) {
                            rooms[d][a][u] = 0; // store 0 instead of -1 for marking room
                            room = chosen; // store the room -- one room/hotel
                            System.out.println("The room has been successfully booked.");
                        }
                    }
                }
            }

            if (room == 0) {
                System.out.println("Sorry, that room is occupied.");
            }
        } else {
            System.out.println("You already have a room booked at this hotel.");
        }
    }

    public void checkOut() {
        Scanner input = new Scanner(System.in);

        if (room > 0) // you have a room booked -- one room/hotel
        {
            for (int d = 0; d < 5; ++d) // down
            {
                for (int a = 0; a < 6; ++a) // across
                {
                    for (int u = 0; u < 3; ++u) // up
                    {
                        if (rooms[d][a][u] == 0) {
                            rooms[d][a][u] = room;
                            room = 0; // reset room -- none booked
                            System.out.println();
                            System.out.println("Thank you for staying with us.");
                            System.out.println("Your charge was $75 for the room.");
                        }
                    }
                }
            }
        } else {
            System.out.println("Sorry, couldn't find your room.");
        }
    }
};

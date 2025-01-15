package org.example.menu;

import org.example.dataBase.CinemaDB;
import org.example.models.Tickets;

import java.util.ArrayList;
import java.util.Scanner;

public class AppRun extends Menu{
    int input = -1;
    Scanner scanner = new Scanner(System.in);

    public AppRun() {}
    public void StartApplication() {
        DisplayWelcome();

        while(input != 0) {
            DisplayMenu();
            System.out.print("\nSelect an option: ");
            input = scanner.nextInt();

            switch(input) {
                case 0:
                    CloseDBConnection();
                    System.exit(0);
                    break;
                case 1:
                    DisplayPersonalInfo();
                    DisplayMovieList();
                    DisplayChosenMovie();
                    DisplayPayCheck();
                    break;
                case 2:
                    DisplayCancelReservation();
                    break;
                case 3:
                    DisplaySales();
                    break;
            }
        }
    }
}

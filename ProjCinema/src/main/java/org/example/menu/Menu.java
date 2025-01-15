package org.example.menu;

import java.sql.SQLException;
import java.util.Scanner;
import org.example.models.*;
import org.example.dataBase.*;
import java.util.ArrayList;

public class Menu {
    final private Scanner scanner = new Scanner(System.in);
    CinemaDB cinemaDB = new CinemaDB();
    int input = -1;

    ArrayList<Movies> movies = new ArrayList<>();
    ArrayList<Customers> customers = new ArrayList<>();
    ArrayList<Tickets> tickets = new ArrayList<>();

    Customers customer = new Customers();
    Movies chosenMovie = new Movies();
    int payCheck = 0;
    int totalPayments = 0;

    public void DisplayWelcome() {
        System.out.println("\n=====Welcome to CinemaDBxProj!=====");
        System.out.println("~ here you can reserve your seat in seconds! ~");
        cinemaDB.executeRestartCustomers();
    }
    public void DisplayMenu() {
        System.out.println("\n\n=====MENU=====");
        System.out.println("1. Ticket Reservation");
        System.out.println("2. Cancel Reservation");
        System.out.println("3. Sales");
        System.out.println("0. Exit");
    }
    public void DisplayPersonalInfo() {
        System.out.println("\nPersonal Information:\n~needed for ticket reservation~\n");
        System.out.println("Please provide the following information:");

        System.out.print("Enter your first name: ");
        String name = scanner.next();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.next();

        customer.SetName(name);
        customer.SetAge(age);
        customer.SetPhoneNumber(phoneNumber);

        cinemaDB.executeInsertCustomers("INSERT INTO clienti (nume, varsta, numar_telefon) VALUES (?, ?, ?)", customer);
    }
    public void DisplayMovieList() {
        System.out.println("\n=====MOVIE LIST=====\n");
        cinemaDB.executeSelectMovies("SELECT * FROM filme", movies);
        for(Movies movie : movies) {
            System.out.println(movie);
        }
    }
    public void DisplayChosenMovie() {
        System.out.print("Select an option: ");
        input = scanner.nextInt();
        input--;

        System.out.print("\n================\nCHOSEN MOVIE: ");
        System.out.println("| " + movies.get(input).GetTitle() +" | "+ movies.get(input).GetGenre() +" | "+ movies.get(input).GetDuration() +"min |"+ "\n================");

        chosenMovie = movies.get(input);
    }
    public void DisplayPayCheck() {
        System.out.println("\n=====PAY CHECK=====\n");

        if(customer.GetAge() > 18) {
            payCheck = 26;
        }
        else {
            payCheck = 22;
        }

        System.out.print("Total Amount: " + payCheck + " lei");
        String pay = "";
        while(!pay.equals("pay")) {
            System.out.print("\nTo Proceed Payment Please Type 'pay': ");
            pay = scanner.next();
            if(!pay.equals("pay")) {
                System.out.println("\n~INCOMPLETE TRANSACTION~");
            }
        }
        System.out.println("\n~COMPLETED TRANSACTION~");

        Tickets ticket = new Tickets();
        ticket.SetCustomerName(customer.GetName());
        ticket.SetMovieTitle(chosenMovie.GetTitle());
        ticket.SetTicketPrice(payCheck);
        tickets.add(ticket);
        totalPayments += payCheck;
    }
    public void DisplayCancelReservation() {
        if(tickets.isEmpty()){
            System.out.println("~NO RESERVATION YET~");
        }
        else {
        System.out.println("\n~Reservation List~\n");
        int index = 1;
        for(Tickets ticketOutput : tickets) {
            System.out.println(index + ". " + ticketOutput);
            index++;
        }

        System.out.print("\nType in Reservation to be Canceled: ");
        input = scanner.nextInt();
        input--;
        totalPayments -= tickets.get(input).GetTicketPrice();
        tickets.remove(input);
        System.out.println("\n~RESERVATION CANCELED~\n");
        }
    }
    public void DisplaySales() {
        System.out.println("\n=====SOLD TICKETS=====\n");
        int index = 1;
        for(Tickets ticketOutput : tickets) {
            System.out.println(index + ". " + ticketOutput);
            index++;
        }
        System.out.print("SOLD EQUALS: " + totalPayments + " lei");
    }
    public void CloseDBConnection() {
        try {
            cinemaDB.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

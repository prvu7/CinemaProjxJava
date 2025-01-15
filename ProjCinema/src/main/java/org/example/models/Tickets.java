package org.example.models;

import org.example.interfaces.ITickets;

public class Tickets implements ITickets {
    private String customerName;
    private String movieTitle;
    private int ticketPrice;

    //Constructors
    public Tickets() {}

    //Getters
    public String GetCustomerName() {
        return customerName;
    }
    public String GetMovieTitle() {
        return movieTitle;
    }
    public int GetTicketPrice() {
        return ticketPrice;
    }

    //Setters
    public void SetCustomerName(String idCustomer) {
        this.customerName = idCustomer;
    }
    public void SetMovieTitle(String idMovie) {
        this.movieTitle = idMovie;
    }
    public void SetTicketPrice(int price) {
        this.ticketPrice = price;
    }

    @Override
    public String toString() {
        return "| " + customerName + " | " + movieTitle + " | " + ticketPrice + " lei |";
    }
}

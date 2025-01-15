package org.example.interfaces;

public interface ITickets {
    public String GetCustomerName();
    public String GetMovieTitle();
    public int GetTicketPrice();

    //Setters
    public void SetCustomerName(String customerName);
    public void SetMovieTitle(String movieTitle);
    public void SetTicketPrice(int ticketPrice);
}

package ticket.booking.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    private String password;

    private String hashedPassword;

    private String userID;

    private List<Ticket> ticketsBooked;

    //constructor
    public User(String name, String password, String hashedPassword, String userID, List<Ticket> ticketsBooked) {
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.userID = userID;
        this.ticketsBooked = ticketsBooked;
    }

    //default constructor
    public User(){}

    //getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public List<Ticket> getTicketsBooked() {
        return ticketsBooked;
    }

    public String getUserID() {
        return userID;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    //printing ticket

    public void printTickets(){
        for(int i=0;i<ticketsBooked.size();i++){
            System.out.println(ticketsBooked.get(i).getTicketInfo());
        }
    }
}

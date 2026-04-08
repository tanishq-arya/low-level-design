package Jira;

public class Client {

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();

        User alice = new User("u1", "Alice");
        User bob = new User("u2", "Bob");
        Ticket ticket = ticketService.createTicket("title 1", "desc 1", alice);

        ticketService.assignTicket(ticket.getId(), bob);
    }
}

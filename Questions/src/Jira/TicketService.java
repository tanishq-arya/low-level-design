package Jira;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TicketService {
    Map<String, Ticket> ticketStore = new HashMap<>();

    Ticket createTicket(String title, String desc, User reporter) {
        Ticket ticket = new Ticket(title, desc);
        ticket.reporter = reporter;

        ticketStore.put(ticket.getId(), ticket);
        System.out.println("Ticket created Id: " + ticket.getId());
        return ticket;
    }

    void assignTicket(String ticketId, User user) {
        System.out.println("Ticket: " + ticketId + " assigned to: " + user.name);
        ticketStore.get(ticketId).assign(user);
    }

    void updateTicket(String ticketId, Status status) {
        ticketStore.get(ticketId).updateStatus(status);
    }

    void addComment(String ticketId, Comment comment) {
        ticketStore.get(ticketId).addComment(comment);
    }
}

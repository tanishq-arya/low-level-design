package StackOverflow;

public class Vote {
    private final User voter;
    private final Votable.VoteType type;

    public Vote(User voter, Votable.VoteType type) {
        this.voter = voter;
        this.type = type;
    }

    public User getVoter() {
        return voter;
    }

    public Votable.VoteType getType() {
        return type;
    }
}
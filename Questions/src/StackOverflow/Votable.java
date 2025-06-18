package StackOverflow;

public interface Votable {
    enum VoteType {
        UP_VOTE, DOWN_VOTE
    }

    void vote(User voter, VoteType type);
    int getVoteCount();
}
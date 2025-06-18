package StackOverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer implements Votable, Commentable{
    private String content;
    private User author;
    private Question question;
    private boolean isAccepted = false;

    private List<Comment> comments = new ArrayList<>();
    private Map<User, VoteType> votes = new HashMap<>();

    public Answer(Question question, User author, String content) {
        this.question = question;
        this.author = author;
        this.content = content;

        System.out.println(this);
    }

    public User getAuthor() {
        return author;
    }

    public void markAsAccepted() {
        isAccepted = true;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void vote(User voter, VoteType type) {
        votes.put(voter, type);
        int delta = (type == VoteType.UP_VOTE) ? 10 : -2;
        author.updateReputation(delta);
    }

    @Override
    public int getVoteCount() {
        int count = 0;
        for (VoteType type : votes.values()) {
            count += (type == VoteType.UP_VOTE) ? 1 : -1;
        }
        return count;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "content='" + content + '\'' +
                ", author=" + author +
                ", question=" + question.getTitle() +
                ", isAccepted=" + isAccepted +
                ", comments=" + comments +
                ", votes=" + votes +
                '}';
    }
}
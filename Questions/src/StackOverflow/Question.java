package StackOverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question implements Votable, Commentable {
    // Values for a question
    private final String title;
    private final String content;
    private final User author;
    private final List<Answer> answers = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();
    private final List<Tag> tags = new ArrayList<>();
    private final Map<User, VoteType> votes = new HashMap<>();
    private Answer acceptedAnswer = null; // answer which is shown [max votes]

    public Question(String title, String content, List<Tag> tags, User author) {
        this.title = title;
        this.content = content;
        this.tags.addAll(tags);
        this.author = author;
        System.out.println("Question posted:\n" + this);
    }

    // Answers
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void acceptAnswer(Answer answer) {
        if (answers.contains(answer)) {
            System.out.println("Answer accepted. Author: " + answer.getAuthor());
            acceptedAnswer = answer;
            answer.markAsAccepted();
            answer.getAuthor().updateReputation(15); // hard-code value
        }
    }

    public String getTitle() {
        return title;
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
        int delta = (type == VoteType.UP_VOTE) ? 10 : -2; // example
        author.updateReputation(delta);
    }

    @Override
    public int getVoteCount() {
        int count = 0;
        for (VoteType type: votes.values()) {
            count += (type == VoteType.UP_VOTE) ? 1 : -1;
        }
        return count;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", answers=" + answers +
                ", comments=" + comments +
                ", tags=" + tags +
                ", votes=" + votes +
                ", acceptedAnswer=" + acceptedAnswer +
                '}';
    }
}
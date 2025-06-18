package StackOverflow;

public class Comment {
    private final String content;
    private final User author;

    public Comment(String content, User author) {
        this.content = content;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }
}
package StackOverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final String emailId;
    private int reputation;

    private final List<Question> questions = new ArrayList<>();

    public User(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
        this.reputation = 0;
    }

    public void askQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void updateReputation(int delta) {
        reputation += delta;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public int getReputation() {
        return reputation;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", reputation=" + reputation +
                '}';
    }


}
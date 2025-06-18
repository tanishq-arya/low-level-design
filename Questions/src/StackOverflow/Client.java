package StackOverflow;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // Create users
        User alice = new User("Alice", "alice@gmail.com");
        User bob = new User("Bob", "bob@yahoo.com");

        // Create a tags for question
        Tag javaTag = new Tag("Java");
        Tag programmingTag = new Tag("Programming");

        // Post question
        Question question = new Question("What is Java ?", "Explain basics of Java.", List.of(javaTag, programmingTag), alice);
        alice.askQuestion(question);
        System.out.println("Questions by Alice: " + alice.getQuestions());

        // Post answer
        Answer answer = new Answer(question, bob, "Java is a programming language.");
        question.addAnswer(answer);

        // Voting
        question.vote(alice, Votable.VoteType.UP_VOTE); // Alice voted up her question
        answer.vote(alice, Votable.VoteType.UP_VOTE); // Alice voted up her answer

        // Accept answer
        question.acceptAnswer(answer); // Bob's answer is accepted and his reputation increases

        System.out.println("Alice's reputation: " + alice.getReputation());
        System.out.println("Bob's reputation: " + bob.getReputation());
    }
}
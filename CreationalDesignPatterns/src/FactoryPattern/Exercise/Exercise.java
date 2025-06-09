// This class handles the creation of document instances based on user input.

package FactoryPattern.Exercise;

import java.util.Scanner;

public class Exercise {
    
    // Do not modify the run method. It is designed to handle user input for creating document instances based on user commands.
    public void run() {
        
        Scanner sc = new Scanner(System.in);

        String documentType = sc.nextLine();

        try {
            // TODO: Create a document instance using the DocumentFactory based on user input
            Document document = DocumentFactory.createDocument(documentType);
            
            // TODO: Display the type of the created document instance
            document.displayType();
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        sc.close();
    }
}
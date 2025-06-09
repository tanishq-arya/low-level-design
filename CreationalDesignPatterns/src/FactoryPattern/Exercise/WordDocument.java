// This class represents a Word document type.

package FactoryPattern.Exercise;

public class WordDocument extends Document {
    
    @Override
    public void displayType() {
        System.out.println("Creating a Word Document");
    }
}
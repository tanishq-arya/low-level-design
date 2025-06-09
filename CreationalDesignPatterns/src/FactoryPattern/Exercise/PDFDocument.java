// This class represents a PDF document type.

package FactoryPattern.Exercise;

public class PDFDocument extends Document {
    
    @Override
    public void displayType() {
        System.out.println("Creating a PDF Document");
    }
}
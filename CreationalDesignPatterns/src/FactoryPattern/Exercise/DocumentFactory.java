// This factory class is responsible for creating instances of different document types.

package FactoryPattern.Exercise;

public class DocumentFactory {
    
    public static Document createDocument(String type) {

        return switch (type.toLowerCase()) {
            case "pdf" ->
                // TODO: Return a new instance of PDFDocument
                    new PDFDocument();
            case "word" ->
                // TODO: Return a new instance of WordDocument
                    new WordDocument();
            case "html" ->
                // TODO: Return a new instance of HTMLDocument
                    new HTMLDocument();
            default -> throw new IllegalArgumentException("Unknown document type: " + type);
        };
    }
}
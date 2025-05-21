package TemplateMethodPattern;

abstract class DataParser {
    // Template method / Skeleton -> defines the steps of the algorithm
    public final void parse() {
        openFile();
        parseData();
        closeFile();
    }

    protected void openFile() {
        System.out.println("Opening file.");
    }

    protected void closeFile() {
        System.out.println("Closing file.");
    }

    // Child must provide implementation for this fn.
    protected abstract void parseData();
}

class CSVParser2 extends DataParser {
    @Override
    protected void parseData() {
        System.out.println("Parsing CSV data");
    }
}

class JSONParser2 extends DataParser {
    @Override
    protected void parseData() {
        System.out.println("Parsing JSON data");
    }
}

public class WithTemplateMethod {
    public static void main(String[] args) {
        DataParser csvParser = new CSVParser2();
        DataParser jsonParser = new JSONParser2();

        // Executing the template method
        csvParser.parse();
        jsonParser.parse();
    }
}
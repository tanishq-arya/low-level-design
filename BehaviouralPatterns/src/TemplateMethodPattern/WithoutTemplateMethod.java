package TemplateMethodPattern;

// CSV Parser
class CSVParser {
    public void parse() {
        openFile();

        // CSV specific parsing logic
        System.out.println("Parsing a CSV file");

        closeFile();
    }

    private void openFile() {
        System.out.println("Opening file");
    }

    private void closeFile() {
        System.out.println("Closing file");
    }
}

// Json Parser
class JSONParser {
    public void parse() {
        openFile();

        // JSON specific parsing logic
        System.out.println("Parsing a JSON file");

        closeFile();
    }

    private void openFile() {
        System.out.println("Opening file");
    }

    private void closeFile() {
        System.out.println("Closing file");
    }
}


public class WithoutTemplateMethod {
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();
        JSONParser jsonParser = new JSONParser();

        csvParser.parse();
        jsonParser.parse();

        // Problems:
        // 1. Redundant code --> common code is repeated
        // 2. Some code might be missed / all parsers follow same structure
    }
}
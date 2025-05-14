package ISP.BadCode;

public class SimplePrinter implements Machine{
    @Override
    public void print(Document doc) {
        System.out.println("Printer -> Printing document ...");
    }

    // This works -> but violates ISP
    // As printer class is burdened with un-necessary functions
    @Override
    public void scan(Document doc) {
        throw new UnsupportedOperationException("Scan not supported.");
    }

    @Override
    public void copy(Document doc) {
        throw new UnsupportedOperationException("Copy not supported.");
    }
}

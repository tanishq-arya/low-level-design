package ISP.GoodCode;

public class SimplePrinter implements Printer{
    // Now we've segregated the functions into separate interfaces.
    @Override
    public void print(Document doc) {
        System.out.println("SimplePrinter -> Printing document ...");
    }
}

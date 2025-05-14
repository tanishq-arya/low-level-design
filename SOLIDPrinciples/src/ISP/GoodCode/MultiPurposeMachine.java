package ISP.GoodCode;

public class MultiPurposeMachine implements Printer, Scanner, Copier{
    @Override
    public void print(Document doc) {
        System.out.println("MPM -> Printing document ...");
    }

    @Override
    public void scan(Document doc) {
        System.out.println("MPM -> Scanning document ...");
    }

    @Override
    public void copy(Document doc) {
        System.out.println("MPM -> Copying document ...");
    }
}

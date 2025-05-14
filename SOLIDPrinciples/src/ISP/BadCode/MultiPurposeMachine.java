package ISP.BadCode;

public class MultiPurposeMachine implements Machine{
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

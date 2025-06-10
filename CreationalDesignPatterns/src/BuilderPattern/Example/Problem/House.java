package BuilderPattern.Example.Problem;

public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private boolean hasGarden;

    // Constructor
    public House(String foundation) {
        this.foundation = foundation;
    }

    // Can't do constructor overloading
    // Can't create this 2nd constructor
//    public House(String roof) {
//        this.roof = roof;
//    }

    // Worst case -> N parameters -> 2^N constructors

    public House(String foundation, String structure, String roof, boolean hasGarage, boolean hasGarden) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
        this.hasGarage = hasGarage;
        this.hasSwimmingPool = false; // default value for all houses
        this.hasGarden = hasGarden;
    }

    @Override
    public String toString() {
        return "House{" +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                ", hasGarage=" + hasGarage +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", hasGarden=" + hasGarden +
                '}';
    }
}
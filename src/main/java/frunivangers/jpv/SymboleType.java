package frunivangers.jpv;

public class SymboleType {

    private final int id;

    public SymboleType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SymboleType{" +
                "id=" + id +
                '}';
    }
}

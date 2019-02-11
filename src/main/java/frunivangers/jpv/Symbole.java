package frunivangers.jpv;

public class Symbole {
	private final SymboleType symboleType;
	private final Variante variante;
	
	public Symbole(SymboleType symboleType, Variante variante) {
		this.symboleType = symboleType;
		this.variante =variante;
	}

    public SymboleType getSymboleType() {
        return symboleType;
    }

	public int getId() {
		return this.getSymboleType().getId();
	}

	public Variante getVariante() {
		return variante;
	}

	@Override
	public String toString() {
		return "Symbole{" +
				 symboleType.getId() +
				", " + variante.getId() +
				'}';
	}
}

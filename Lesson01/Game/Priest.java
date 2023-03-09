package Game;

public class Priest extends BaseHero {
    private int elixir;
    private int maxEilxir;

    public Priest() {
        super(String.format("Hero_Priest #%d", ++Priest.number),
                Priest.rnd.nextInt(100, 200));
        this.maxEilxir = Priest.rnd.nextInt(50, 150);
        this.elixir = maxEilxir;
    }

    public String getInfo() {
        return String.format("%s Eilxir: %d", super.getInfo(), this.elixir);
    }
}

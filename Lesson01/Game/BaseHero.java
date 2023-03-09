package Game;

import java.util.Random;

public class BaseHero {
    protected static int number;
    protected static Random rnd;

    protected String name;
    protected int hp;
    protected int maxHp;

    static {
        BaseHero.number = 0;
        BaseHero.rnd = new Random();
    }

    public BaseHero(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public BaseHero() {
        this(String.format("Hero_Priest #%d", ++BaseHero.number), // почему Hero_Priest ?
                BaseHero.rnd.nextInt(100, 200));
    }

    public String getInfo() {
        return String.format("Name: %s  Hp: %d  Type: %s",
                this.name, this.hp, this.getClass().getSimpleName());
    }

    // public void healed(int Hp) {
    // this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp; // Hp - ???
    // }

    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }

    public void attack(BaseHero target) {
        int damage = BaseHero.rnd.nextInt(10, 20);
        target.getDamage(damage);
    }
}

package model;

public class PokemonAttack {

    private String name;
    private int attackPower;
    private PokemonType type;

    public PokemonAttack(int attackPower, String name, PokemonType type) {
        this.attackPower = attackPower;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }
}

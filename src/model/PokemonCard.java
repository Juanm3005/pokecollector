package model;

public class PokemonCard {

    private String name;
    private PokemonType type;
    private int healthpoints;
    private PokemonAttack[] attacks;

    //constructor
    public PokemonCard(String name, PokemonType type, int healthpoints, PokemonAttack attack) {
        this.name = name;
        this.type = type;
        this.healthpoints = healthpoints;
        attacks = new PokemonAttack[2];
        addAttack(attack);
    }

 

    public boolean addAttack(PokemonAttack newAttack){

        for (int i = 0; i < attacks.length; i++) {
            if(attacks[i] != null){
                attacks[i] = newAttack;
                return true;
                
            }
        }
        return false;
    }



    public String getName() {
        return name;
    }
                                           


    public void setName(String name) {
        this.name = name;
    }



    public PokemonType getType() {
        return type;
    }



    public void setType(PokemonType type) {
        this.type = type;
    }



    public int getHealthpoints() {
        return healthpoints;
    }



    public void setHealthpoints(int healthpoints) {
        this.healthpoints = healthpoints;
    }



    public PokemonAttack[] getAttacks() {
        return attacks;
    }



    public void setAttacks(PokemonAttack[] attacks) {
        this.attacks = attacks;
    }

}

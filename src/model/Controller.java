package model;

import java.util.ArrayList;

public class Controller {

    private ArrayList<PokemonCard> collection;

    public Controller() {
        collection = new ArrayList<PokemonCard>();
        testData();
    }

    public void clearCard(int numCarta) {
        collection.remove(numCarta);
    }

    public void addAttack(int numCard, String nameAttack, int typeAttack, int attackPower) {

        PokemonType[] types = PokemonType.values();
        PokemonAttack[] attacks = collection.get(numCard - 1).getAttacks();

        if (typeAttack > PokemonType.values().length || typeAttack < 0) {
            typeAttack = 3;
        }
        PokemonType pokemonTypeAttack = types[typeAttack - 1];

        attacks[1] = new PokemonAttack(attackPower, nameAttack, pokemonTypeAttack);

        collection.get(numCard - 11).setAttacks(attacks);

    }

    public static String Show_list(int[] lista) {

        StringBuilder resultado = new StringBuilder("\n ");
        for (int numero : lista) {
            resultado.append(numero).append(" \n ");
        }

        // Imprimir el resultado
        String list = resultado.toString();
        return list;
    }

    /**
     * Descripcion: Guarda una carta en el arreglo collection pre: El arreglo
     * collection debe estar inicializado pos: El arreglo collection queda con
     * una nueva carta agregada
     *
     * @param name String, nombre de la carta
     * @param type int, typo de car
     * @param healthpoints int, puntos de vida de la carta
     * @param attackpower int, puntos de ataque de la carta
     * @return boolean, true si logra agregar la carta, false si no se logra
     * (memoria llena)
     */
    public boolean savePokemonCard(String name, int type, int healthpoints, String attackName, int attackpower, int attackType) {

        PokemonType[] types = PokemonType.values();
        if (type > PokemonType.values().length || type < 0) {
            type = 3;
        }

        if (attackType > PokemonType.values().length || attackType < 0) {
            attackType = 3;
        }

        PokemonType pokemonType = types[type - 1];

        PokemonType pokemonTypeAttack = types[attackType - 1];

        PokemonCard newCard = new PokemonCard(name, pokemonType, healthpoints, new PokemonAttack(attackpower, attackName, pokemonTypeAttack));
        for (int i = 0; i < collection.size(); i++) {
            collection.add(newCard);
        }
        return false;
    }

    /**
     * Descripcion: carga en la coleccion alguna}s cartas pre: El arreglo
     * collection debe estar inicializado pos: El arreglo collection queda con 2
     * cartas cargadas
     */
    public void testData() {
        collection.add(new PokemonCard("pikachu", PokemonType.ELECTRICO, 30, new PokemonAttack(80, "impacTrueno", PokemonType.FUEGO)));
        collection.add(new PokemonCard("charmander", PokemonType.FUEGO, 50, new PokemonAttack(50, "ascuas", PokemonType.ELECTRICO)));
    }

    /**
     * descripcion:
     *
     * @return
     */
    public String getPokemonTypeList() {
        PokemonType[] types = PokemonType.values();
        String list = "Tpos Registrados: \n";
        for (int i = 0; i < types.length; i++) {
            list += (i + 1) + ". " + types[i] + "\n";
        }
        return list;
    }

    public boolean modifyPokemonCard(int numCarta, int atributoModificar, String change) {
        numCarta -= 1;

        if (numCarta <= collection.size()) {

            switch (atributoModificar) {
                case 1:
                    collection.get(numCarta).setName(change);
                    break;
                case 2:
                    int type = Integer.parseInt(change);

                    PokemonType[] types = PokemonType.values();
                    if (type > PokemonType.values().length || type < 0) {
                        type = 3;
                    }
                    PokemonType temp = types[type - 1];
                    collection.get(numCarta).setType(temp);
                    break;
                case 3:

                    collection.get(numCarta).setHealthPoing(Integer.parseInt(change));

                    break;

                default:
                    return false;
            }

        } else {
            return false;
        }
        return true;
    }

    public String getList() {
        String lista = "";

        for (int i = 0; i < collection.size(); i++) {
            lista += (i + 1) + ")" + " " + collection.get(i).get_name() + " " + collection.get(i).get_type() + " " + collection.get(i).get_healthpoints() + " " + collection.get(i).get_Attacks() + "\n";

        }
        return lista;
    }

}

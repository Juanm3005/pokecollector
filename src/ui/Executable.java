package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private static Scanner input;
    private static Controller control;

    public static void main(String[] args) {
        initializer();
        control.testData();
        menu();
    }

    public static void initializer() {
        input = new Scanner(System.in);
        control = new Controller();
    }

    public static void menu() {

        int opcion= 0;
        do{
            System.out.println("1) registrar carta");
            System.out.println("2) Mostrar cartas registradas");
            System.out.println("3) Modificar cartas");
            System.out.println("4) Añadir ataque");
            System.out.println("0) Salir");

            System.out.println("ingrese que quiere hacer: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    registerPokemonCard();
                    break;
                case 2:
                    System.out.println(control.getList());
                    break;
                case 3:
                    modificarPokemonCard();
                    break;

                case 4:
                    añadirAtaque();
                default:
                    throw new AssertionError();
            }
        }while(opcion!=0);
    }

    public static void añadirAtaque(){
        System.out.println("ingrese el numero de la carta");
        int numCard = input.nextInt();

        System.out.println("ingrese el nombre del ataque");
        String attackName = input.nextLine();
        attackName = input.nextLine();

        System.out.println("ingrese el poder de ataque: ");
        int attackPower = input.nextInt();
        
        System.out.println(control.getPokemonTypeList());
        System.out.println("ingrese el tipo de ataque");
        int typeAttack = input.nextInt();
    }

    public static void registerPokemonCard() {
        System.out.println("digite el nombre de la carta");
        String name = input.nextLine();

        System.out.println(control.getPokemonTypeList());
        System.out.println("digite el tipo de pokemon");
        int type = input.nextInt();

        System.out.println("ingrese los puntos de vida del pokemon");
        int hP = input.nextInt();

        System.out.println("ingrese el poder de ataque del pokemon ");
        int aP = input.nextInt();

        System.out.println("ingrese el nombre del ataque del pokemon");
        String nA = input.nextLine();

        System.out.println(control.getPokemonTypeList());
        System.out.println("ingrese el tipo de ataque");
        int aT = input.nextInt();

        boolean resultado = control.savePokemonCard(name, type, hP, nA, aP, aT);
        if (resultado) {
            System.out.println("carta guardada exitosamente");
        } else {
            System.out.println("error, memoria llena");
        }

    }

    public static void modificarPokemonCard() {
        System.out.println(control.getList());
        int numberCarta, atributo;
        String change;

        System.out.println("ingrese la posicion de la carta que desea modificar: ");
        numberCarta = input.nextInt();

        System.out.println("ingrese el atributo de la carta que desea modificar \n1. Nombre\n2 Tipo \n3Hp ");
        atributo = input.nextInt();

        System.out.println("ingrese el nuevo valor del atributo");
        if (atributo == 2) {
            System.out.println(control.getPokemonTypeList());
        }
        change = input.nextLine();
        change = input.nextLine();

        boolean mensaje = control.modifyPokemonCard(numberCarta, atributo, change);
        if (mensaje) {
            System.out.println("la carta se guardo con exito");
        } else {
            System.out.println("error al guardar la carta");
        }
    }

}

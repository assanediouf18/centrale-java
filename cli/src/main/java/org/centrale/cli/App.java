package org.centrale.cli;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("welcome to the app");

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir votre choix");
        int choix = sc.nextInt();
        System.out.println(choix);

    }

}

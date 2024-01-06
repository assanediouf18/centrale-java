package org.centrale.cli;

import java.util.Scanner;
import org.centrale.domain.Pierre;

public class App {

    public static void main(String[] args) {
        System.out.println("welcome to the app");

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir votre choix");
        int choix = sc.nextInt();
        System.out.println(choix);
        Pierre pierre = new Pierre();

    }

}

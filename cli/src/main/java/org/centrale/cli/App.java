package org.centrale.cli;

import org.centrale.domain.newsletter.*;
import org.centrale.domain.shifumi.Hand;
import org.centrale.domain.shifumi.HandFactory;
import org.centrale.domain.shifumi.Pierre;
import org.centrale.domain.shifumi.Shifumi;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App.NewsletterExample();
    }

    public static void PierreFeuilleCiseau() {
        System.out.println("Bienvenue sur le CLI du Pierre - Feuille - Ciseau");

        Shifumi jeu = new Shifumi();

        Scanner sc = new Scanner(System.in);
        while(!jeu.isOver()) {
            System.out.println("Pour jouer, tapez Pierre, Feuille ou Ciseaux.");
            System.out.println("Veuillez saisir votre choix");
            String choix = sc.nextLine();
            Hand playerHand = HandFactory.from(choix);
            System.out.println("Tu joues " + playerHand.getHandName());
            Hand randomHand = jeu.getRandomHand();
            System.out.println("Le programme joue " + randomHand.getHandName());
            switch(jeu.playRound(playerHand, randomHand)) {
                case 1:
                    System.out.println("Bravo ! Tu as gagné !");
                    break;
                case -1:
                    System.out.println("Dommage, tu as perdu");
                    break;
                default:
                    System.out.println("Egalité");
            };
        }

        if(jeu.didPlayerWin()) {
            System.out.println("Bravo, tu as gagné le plus de manches");
        } else {
            System.out.println("Tu as perdu, est-ce que tu veux prendre ta revanche ?");
        }
    }

    public static void NewsletterExample()
    {
        FanBoySubscriber fanBoy = new FanBoySubscriber();
        UnhappySubsciber unhappySubsciber = new UnhappySubsciber();
        CustomSubscriber customSubscriber = new CustomSubscriber("Jonathan", "Qu'est-ce qui est jaune et qui attend ?");

        Newsletter newsletter = new Newsletter();
        newsletter.addSubscriber(fanBoy);
        newsletter.addSubscriber(unhappySubsciber);
        newsletter.addSubscriber(customSubscriber);

        newsletter.sendEmail("Bienvenu dans ma newsletter inutile !");
    }

}

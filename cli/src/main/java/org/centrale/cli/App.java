package org.centrale.cli;

import org.centrale.domain.filesystem.MyDirectory;
import org.centrale.domain.filesystem.MyFile;
import org.centrale.domain.filesystem.MyFileExplorer;
import org.centrale.domain.newsletter.*;
import org.centrale.domain.shifumi.Hand;
import org.centrale.domain.shifumi.HandFactory;
import org.centrale.domain.shifumi.Pierre;
import org.centrale.domain.shifumi.Shifumi;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App.CompositePatternExample();
        // Pour tester le Shifumi décommentez la ligne suivante
        // App.PierreFeuilleCiseau();
    }

    public static void CompositePatternExample() {
        MyFileExplorer explorer = new MyFileExplorer();
        System.out.println("Bienvenue dans mon Explorateur de fichiers");
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        while (!stop) {
            System.out.println("Voici les commandes possibles pour vous balader dans ce programme : ");
            System.out.println("- path : afficher le chemin ou vous êtes");
            System.out.println("- size : taille du dossier actuel");
            System.out.println("- list : Liste le nombre de sous-dossiers/sous-fichiers s'il y en a");
            System.out.println("- add : ajouter un fichier ou un dossier lorsque c'est possible");
            System.out.println("- go : aller dans un sous dossier");
            System.out.println("- back : revenir en arrière");
            System.out.println("- quit : Fermer le programme");
            System.out.println("Quelle action voulez-vous entreprendre ?");
            String choix = sc.nextLine();
            switch (choix) {
                case "path":
                    System.out.println(explorer.getCurrentPath());
                    break;
                case "size":
                    System.out.println(explorer.getSizeFromCurrent());
                    break;
                case "list":
                    explorer.list();
                    break;
                case "add":
                    System.out.println("Fichier (1) ou Dossier (2) ?");
                    choix = sc.nextLine();
                    switch (choix) {
                        case "1":
                            System.out.println("Quel nom votre nouveau fichier aura-t-il ?");
                            String filename = sc.nextLine();
                            System.out.println("Quel est sa taille ?");
                            int fileSize = sc.nextInt();
                            explorer.add(new MyFile(filename, fileSize));
                            System.out.println("Fichier ajouté");
                            break;
                        case "2":
                            System.out.println("Quel nom votre nouveau dossier aura-t-il ?");
                            String name = sc.nextLine();
                            explorer.add(new MyDirectory(name));
                            System.out.println("Dossier ajouté");
                            break;
                        default:
                            System.out.println("Ajout abandonné");
                    }
                    break;
                case "go":
                    System.out.println("Où voulez-vous aller ?");
                    String name = sc.nextLine();
                    explorer.moveTo(name);
                    break;
                case "back":
                    explorer.moveBack();
                    break;
                case "quit": {
                    stop = true;
                }break;
                default: System.out.println("Cette commande est inconnue");
            }
        }
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

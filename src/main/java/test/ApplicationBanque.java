package test;

import metier.Compte;
import metier.IMetierBanque;
import metier.MetierBanqueImpl;

import java.util.Scanner;

public class ApplicationBanque {
    public static void main(String[] args) {
        new ApplicationBanque().start();
    }

    private void start() {
        System.out.println("Demarrage de l'application banque");
        Scanner scanner = new Scanner(System.in);
        System.out.println("donner le code du compte :");
        long code = scanner.nextLong();
        System.out.println("donner le solde du compte :");
        double solde = scanner.nextDouble();

        IMetierBanque metierBanque= new MetierBanqueImpl();

        //Compte compte1 = new Compte(code, solde);
        metierBanque.addCompte(new Compte(code, solde));
        while (true){
            try {
                System.out.println("Type d'operation (verser,retirer,quitter): ");
                // Better to use next() than nextLine() since nextLine() also takes in the new line character \n from previous scanner
                String operationType = scanner.next();
                if (operationType.equals("verser")) {
                    System.out.println("Montant a verser:");
                    metierBanque.verser(scanner.nextDouble(), code);
                } else if (operationType.equals("retirer")) {
                    System.out.println("Montant a retirer:");
                    metierBanque.retirer(scanner.nextDouble(), code);
                }
                else{
                    break;
                }
                System.out.println(metierBanque.consulterCompte(code).toString());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Fin de l'application banque");
    }
}

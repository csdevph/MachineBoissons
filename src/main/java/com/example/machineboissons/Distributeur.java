package com.example.machineboissons;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Distributeur {
    private int choix;

    public ArrayList<Boisson> getBoissons() {
        return boissons;
    }

    private final ArrayList<Boisson> boissons = new ArrayList<>();

    private int saisirNumero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Votre choix ?");
        int nb = sc.nextInt();
        return nb - 1;
    }

    void choisirBoisson() {
        Boisson b = boissons.get(saisirNumero());
        System.out.println("Votre choix : " + b.getNom());
        System.out.println("Prix : " + b.getPrix());
    }

    void afficherBoissons() {
        Boisson b;
        System.out.println("\nListe des boissons :");
        for (int i = 0; i < boissons.size(); i++) {
            b = boissons.get(i);
            System.out.println(i + 1 + " -> " + b.getNom() + ", " + b.getPrix() + " cents," + b.getTemp());
        }
    }

    private void ajouterBoissson(String ligne) {
        String[] data = ligne.split(";");
        String nom = data[0];
        int prix = Integer.parseInt(data[1]);
        int stock = Integer.parseInt(data[2]);
        String imageFile = data[3];
        String temp = data[4];
        boissons.add(new Boisson(nom, prix, stock, imageFile, temp
        ));
    }

    //todo voir Scanner p 197
    void chargerBoissons() throws IOException {
        String nomFichier;
        nomFichier = "src\\main\\java\\com\\example\\machineboissons\\data.txt";

        try (Scanner s = new Scanner(new BufferedReader(new FileReader(nomFichier)))) {
            while (s.hasNext()) {
                ajouterBoissson(s.next());
            }
            afficherBoissons();
        }
    }
}

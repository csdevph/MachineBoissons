package com.example.machineboissons;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Distributeur {
    public ArrayList<Boisson> getBoissons() {
        return boissons;
    }

    private final ArrayList<Boisson> boissons = new ArrayList<>();

    private void ajouterBoissson(String ligne) {
        String[] data = ligne.split(";");
        String nom = data[0];
        int prix = Integer.parseInt(data[1]);
        int stock = Integer.parseInt(data[2]);
        String imageFile = data[3];
        String temp = data[4];
        boolean alcool = Boolean.parseBoolean(data[5]);
        boissons.add(new Boisson(nom, prix, stock, imageFile, temp, alcool
        ));
    }

    void chargerBoissons() throws IOException {
        String nomFichier;
        nomFichier = "src\\main\\java\\com\\example\\machineboissons\\data.txt";

        try (Scanner s = new Scanner(new BufferedReader(new FileReader(nomFichier)))) {
            while (s.hasNext()) {
                ajouterBoissson(s.next());
            }
        }
    }
}

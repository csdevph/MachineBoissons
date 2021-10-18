package com.example.machineboissons;

public class Boisson implements Gerable {
    private String nom;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private int stock;
    private int prix;

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return this.getNom()+", "+getPrix()+" centimes";
    }

    Boisson(String nom, int prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public void increment() {
        stock++;
    }

    @Override
    public void decrement() {
        stock--;
    }
}



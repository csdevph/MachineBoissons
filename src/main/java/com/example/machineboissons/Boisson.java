package com.example.machineboissons;

import javafx.scene.image.Image;

public class Boisson implements Gerable {
    private String nom;
    private int prix;
    private Image image;
    private int stock;

    public String getTemp() {
        return temp;
    }

    private String temp;

    public int getStock() {
        return stock;
    }

    public Image getImage() {
        return image;
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return this.getNom() + ", " + getPrix() + " centimes";
    }

    Boisson(String nom, int prix, int stock, String imgFile,String temp) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.image = new Image(getClass().getResourceAsStream(imgFile));
        this.temp=temp;
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

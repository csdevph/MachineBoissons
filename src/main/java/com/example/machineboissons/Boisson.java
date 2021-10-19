package com.example.machineboissons;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Boisson implements Gerable {
    private String nom;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private int stock;

    public void setPrix(int prix) {
        this.prix = prix;
    }

    private int prix;
    private String imageName;
    private Image image;

    public Image getImage() {
        return image;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
//        return this.getNom() + ", " + getPrix() + " centimes";
        return this.getNom();
    }

    Boisson(String nom, int prix, int stock, String imgFile) {
        System.out.println(imgFile);
        String path = "C:\\Users\\phs\\IdeaProjects\\MachineBoissons\\src\\main\\resources\\com\\example\\machineboissons\\";
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
//        this.image = new Image(path + imgFile);
        this.image = new Image(getClass().getResourceAsStream(imgFile));
    }

    public String getImageName() {
        return imageName;
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



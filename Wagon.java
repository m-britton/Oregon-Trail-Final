package com.example.mp2oregontrailmvp;

public class Wagon {

    private double food;
    private double clothing;
    private double weapons;
    private double oxen;
    private double spareWagonWheel;
    private double spareWagonAxel;
    private double spareWagonTongues;
    private double medicalSupplyBox;
    private double sewingKit;
    private double fireStartingKit;
    private double kidsToys;
    private double familyKeepsakes;
    private double seedPackages;
    private double shovel;
    private double cookingItems;

    public Wagon(){}

    public Wagon(double food, double clothing, double weapons, double oxen, double spareWagonWheel, double spareWagonAxel, double spareWagonTongues, double medicalSupplyBox, double sewingKit, double fireStartingKit, double kidsToys, double familyKeepsakes, double seedPackages, double shovel, double cookingItems) {
        this.food = food;
        this.clothing = clothing;
        this.weapons = weapons;
        this.oxen = oxen;
        this.spareWagonWheel = spareWagonWheel;
        this.spareWagonAxel = spareWagonAxel;
        this.spareWagonTongues = spareWagonTongues;
        this.medicalSupplyBox = medicalSupplyBox;
        this.sewingKit = sewingKit;
        this.fireStartingKit = fireStartingKit;
        this.kidsToys = kidsToys;
        this.familyKeepsakes = familyKeepsakes;
        this.seedPackages = seedPackages;
        this.shovel = shovel;
        this.cookingItems =cookingItems;
    }


    //Setters
    public void setFood(double food) {
        this.food = food;
    }

    public void setClothing(double clothing) {
        this.clothing = clothing;
    }

    public void setWeapons(double weapons) {
        this.weapons = weapons;
    }

    public void setOxen(double oxen) {
        this.oxen = oxen;
    }

    public void setSpareWagonWheel(double spareWagonWheel) {
        this.spareWagonWheel = spareWagonWheel;
    }

    public void setSpareWagonAxel(double spareWagonAxel) {
        this.spareWagonAxel = spareWagonAxel;
    }

    public void setSpareWagonTongues(double spareWagonTongues) {
        this.spareWagonTongues = spareWagonTongues;
    }

    public void setMedicalSupplyBox(double medicalSupplyBox) {
        this.medicalSupplyBox = medicalSupplyBox;
    }

    public void setSewingKit(double sewingKit) {
        this.sewingKit = sewingKit;
    }

    public void setFireStartingKit(double fireStartingKit) {
        this.fireStartingKit = fireStartingKit;
    }

    public void setKidsToys(double kidsToys) {
        this.kidsToys = kidsToys;
    }

    public void setFamilyKeepsakes(double familyKeepsakes) {
        this.familyKeepsakes = familyKeepsakes;
    }

    public void setSeedPackages(double seedPackages) {
        this.seedPackages = seedPackages;
    }

    public void setShovel(double shovel) {
        this.shovel = shovel;
    }

    public void setCookingItems(double cookingItems) {
        this.cookingItems = cookingItems;
    }


    //Getters
    public double getFood() {
        return food;
    }

    public double getClothing() {
        return clothing;
    }

    public double getWeapons() {
        return weapons;
    }

    public double getOxen() {
        return oxen;
    }

    public double getSpareWagonWheel() {
        return spareWagonWheel;
    }

    public double getSpareWagonAxel() {
        return spareWagonAxel;
    }

    public double getSpareWagonTongues() {
        return spareWagonTongues;
    }

    public double getMedicalSupplyBox() {
        return medicalSupplyBox;
    }

    public double getSewingKit() {
        return sewingKit;
    }

    public double getFireStartingKit() {
        return fireStartingKit;
    }

    public double getKidsToys() {
        return kidsToys;
    }

    public double getFamilyKeepsakes() {
        return familyKeepsakes;
    }

    public double getSeedPackages() {
        return seedPackages;
    }

    public double getShovel() {
        return shovel;
    }

    public double getCookingItems() {
        return cookingItems;
    }

}

package com.blckly.kit.parts;

import java.util.LinkedList;

public class Kit {

  public static double DEFAULTPRICE = 10.00;

  private String name;
  private double basePrice = DEFAULTPRICE;
  private BodyKit bodyKit;
  private Engine engine;
  private LinkedList<Wheel> wheels;
  private PowerSource powerSource;
  private Color color;
  private Finish finish;

  private boolean unique = false;

  public Kit() {}

  public Kit(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public double getBasePrice() {
    // may not be the total price if component have surcharges.
    return basePrice;
  }

  public void setBasePrice(double price) {
    this.basePrice = price;
  }

  public BodyKit getBodyKit() {
    return bodyKit;
  }

  public void setBodyKit(BodyKit bodyKit) {
    this.bodyKit = bodyKit;
  }

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  public LinkedList<Wheel> getWheels() {
    return wheels;
  }

  public void setWheels(Wheel wheel) {
    // uni-cycle kits only :)
    this.wheels.add(wheel);
  }

  public PowerSource getPowerSource() {
    return powerSource;
  }

  public void setPowerSource(PowerSource powerSource) {
    this.powerSource = powerSource;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Finish getFinish() {
    return finish;
  }

  public void setFinish(Finish finish) {
    this.finish = finish;
  }

  public boolean getUnique() {
    return unique;
  }

  public void setUnique(boolean unique) {
    this.unique = unique;
  }
}

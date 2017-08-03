package com.blckly.kit.parts;

public class Kit {

  public static double DEFAULTPRICE = 10.00;

  private String name;
  private double basePrice;
  private KitBody kitBody;
  private Engine engine;
  private Wheel wheels;
  private PowerSource powerSource;
  private Color color;
  private Finish finish;

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
    // also - calculate price based on the component prices and not a set whole kit price
    return basePrice;
  }

  public void setBasePrice(double price) {
    this.basePrice = price;
  }

  public KitBody getKitBody() {
    return kitBody;
  }

  public void setKitBody(KitBody kitBody) {
    this.kitBody = kitBody;
  }

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  public Wheel getWheels() {
    return wheels;
  }

  public void setWheels(Wheel wheels) {
    // uni-cycle kits only :)
    this.wheels = wheels;
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
}

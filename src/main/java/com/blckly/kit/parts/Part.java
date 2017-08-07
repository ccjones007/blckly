package com.blckly.kit.parts;

public class Part {
  private String name;
  private double surcharge;
  // negative count would means we have back-ordered kits.
  private long count;


  public Part() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSurcharge() {
    return surcharge;
  }

  public void setSurcharge(double surcharge) {
    this.surcharge = surcharge;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public void incrementCount(long count) {
    this.count = this.count + count;
  }

  public long decrementCount() {
    this.count--;
    return this.count;
  }

  @Override
  public boolean equals(Object part) {
    return this.name.equalsIgnoreCase(((Part)part).getName());
  }
}

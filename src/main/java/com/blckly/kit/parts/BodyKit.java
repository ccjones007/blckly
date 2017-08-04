package com.blckly.kit.parts;

public class BodyKit extends Part {

  private int id;

  public BodyKit() {
    super();
  }

  public BodyKit(Integer id, String name) {
    super();
    this.id= id;
    setName(name);
  }

  public BodyKit(Integer id, String name, double surcharge) {
    this.id = id;
    setName(name);
    setSurcharge(surcharge);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}

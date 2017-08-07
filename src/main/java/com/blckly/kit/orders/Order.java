package com.blckly.kit.orders;

import java.util.LinkedList;

public class Order {

  private String customerName;
  private String address_one;
  private String address_two;
  private Kit kit;


  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setAddress_one(String address_one) {
    this.address_one = address_one;
  }

  public String getAddress_one() {
    return address_one;
  }

  public void setAddress_two(String address_two) {
    this.address_two = address_two;
  }

  public String getAddress_two() {
    return address_two;
  }

  public void setKit(Kit kit) {
    this.kit = kit;
  }

  public Kit getKit() {
    return kit;
  }


}

package com.blckly.kit.orders;

import java.util.LinkedList;

public class Order {

  private LinkedList<Kit> kits = new LinkedList<>();
  private String name;
  // used to test uniqueness of kit
  private String address_one;
  private String address_two;
}

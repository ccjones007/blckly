package com.blckly.kit.utils;

public class InventoryStatus {

  public static String SUCCESS = "success";
  public static String FAILURE = "failure";
  public static int ERROR_CODE_GEN_FAILURE = -1;
  public static int ITEM_ADDED = 1;


  private String status;
  private int id;
  private int count;

  public InventoryStatus(String status, int id) {
    this.status = status;
    this.id = id;
  }

  public InventoryStatus(String status, int id, int count) {
    this.status = status;
    this.id = id;
    this.count = count;
  }


  public String getStatus() {
    return status;
  }

  public int getId() {
    return id;
  }

  public int getCount() { return count; }
}

package com.blckly.kit.orders;

public class OrderStatus {

  public static int ORDER_SUCCESS = 1;
  public static int ORDER_FAILED = -1;
  public static int ORDER_BACKORDERED = 2;
  public static int ORDER_CANCELLED = 3;

  private int status;
  private String msg;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}

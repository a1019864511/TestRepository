package com.example.demo.Entity;


public class Order {

  private String orderId;
  private long userId;
  private java.sql.Timestamp orderCreateTime;
  private long movieId;
  private String userPrice;
  private int orderStatus;
  private String orderSite;
  private String movieName;
  private String orderImgsrc;

  public String getOrderImgsrc() {
    return orderImgsrc;
  }

  public void setOrderImgsrc(String orderImgsrc) {
    this.orderImgsrc = orderImgsrc;
  }

  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public String getOrderSite() {
    return orderSite;
  }

  public void setOrderSite(String orderSite) {
    this.orderSite = orderSite;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public int getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(int orderStatus) {
    this.orderStatus = orderStatus;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getOrderCreateTime() {
    return orderCreateTime;
  }

  public void setOrderCreateTime(java.sql.Timestamp orderCreateTime) {
    this.orderCreateTime = orderCreateTime;
  }


  public long getMovieId() {
    return movieId;
  }

  public void setMovieId(long movieId) {
    this.movieId = movieId;
  }


  public String getUserPrice() {
    return userPrice;
  }

  public void setUserPrice(String userPrice) {
    this.userPrice = userPrice;
  }

  @Override
  public String toString() {
    return "Order{" +
            "orderId=" + orderId +
            ", userId=" + userId +
            ", orderCreateTime=" + orderCreateTime +
            ", movieId=" + movieId +
            ", userPrice=" + userPrice +
            '}';
  }
}

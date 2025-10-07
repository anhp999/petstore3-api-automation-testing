package api.payload;

import java.util.Date;

import api.utilities.OrderStatus;

public class Order {
  private long id;
  private long petId;
  private int quantity;
  private Date shipDate;
  private OrderStatus status;
  private boolean complete = false;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getPetId() {
    return petId;
  }

  public void setPetId(long petId) {
    this.petId = petId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Date getShipDate() {
    return shipDate;
  }

  public void setShipDate(Date shipDate) {
    this.shipDate = shipDate;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public boolean isComplete() {
    return complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

}

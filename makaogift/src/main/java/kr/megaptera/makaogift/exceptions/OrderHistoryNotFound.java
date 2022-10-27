package kr.megaptera.makaogift.exceptions;

public class OrderHistoryNotFound extends RuntimeException {
  public OrderHistoryNotFound() {
    super("History not found...");
  }
}

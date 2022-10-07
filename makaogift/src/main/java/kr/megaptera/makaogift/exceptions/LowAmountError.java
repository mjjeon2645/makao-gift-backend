package kr.megaptera.makaogift.exceptions;

public class LowAmountError extends RuntimeException {
  public LowAmountError() {
    super("❌잔액이 부족하여 선물하기가 불가합니다❌");
  }
}

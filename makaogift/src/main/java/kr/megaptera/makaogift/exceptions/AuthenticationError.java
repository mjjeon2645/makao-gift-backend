package kr.megaptera.makaogift.exceptions;

public class AuthenticationError extends RuntimeException {
  public AuthenticationError() {
    super("Authentication Error");
  }
}

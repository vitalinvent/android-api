package ru.kassatka.comepay_sdk.responses;

/** The object passed when the command fails. */
public class ErrorMessage {

  // TODO: Add right fields.

  private Result result;

  /** Default constructor. */
  public ErrorMessage() {}

  /**
   * Constructor with command result.
   *
   * @param result - command result.
   */
  public ErrorMessage(Result result) {
    this.result = result;
  }

  /**
   * Set command result.
   *
   * @param result command result.
   */
  public void setResult(Result result) {
    this.result = result;
  }

  /**
   * Get command result
   *
   * @return - command result.
   */
  public Result getResult() {
    return result;
  }

  /** Types of the command error results. */
  public enum Result {
    PERMISSION_DENIED,
    UNRECOGNIZED_ERROR
  }
}

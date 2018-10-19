package ru.kassatka.comepay_sdk.responses;

/** The object passed when the command is executed successfully */
public class SuccessMessage {

  // TODO: Add right fields.

  private Result result;

  /** Default constructor. */
  SuccessMessage() {}

  /**
   * Constructor with command result.
   *
   * @param result - command result.
   */
  SuccessMessage(Result result) {
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
  /**
   * Set command result.
   *
   * @param result command result.
   */
  public void setResult(Result result) {
    this.result = result;
  }

  /** Types of the command successful results. */
  public enum Result {
    FULL_SUCCESS
  }
}

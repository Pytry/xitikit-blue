package org.xitikit.blue.nommoc.errors;

/**
 * Assertion util for verification of arguments passed to the api.
 * For internal use only.
 *
 * @author J. Keith Hoopes
 */
abstract class Verify{

  /**
   * If state is false, then an {@link IllegalArgumentException} with
   * the given message is thrown.
   *
   * @param state State to verify.
   * @param message Message describing the expected state.
   */
  static void state(final boolean state, final String message){

    if(!state){

      throw new IllegalArgumentException(message);
    }
  }

  /**
   * Verifies that the state of the object is not null,
   * or else an {@link IllegalArgumentException} with
   * the given message is thrown.
   *
   * @param object Object to verify state.
   * @param message Message describing the expected state.
   */
  static void notNull(final Object object, final String message){

    state(object != null, message);
  }
}

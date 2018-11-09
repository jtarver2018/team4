package a;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

/** Singleton collections.
 * @author Ori Roth
 * @since 2017-04-16 */
public interface singleton {
  /** Singleton list. */
  static <T> @NotNull List<T> list(final T ¢) {
    return as.list(¢);
  }

  /** Singleton array. */
  static <T> T[] array(final T ¢) {
    return as.array(¢);
  }
/*
  @SuppressWarnings("static-method") public static class TEST {
    
    @Test public void intListSingelton() {
      singleton mock = mock(singleton.class);
      when(mock.getAsBoolean()).thenReturn(true);
      azzert.that(ly(mock), is(true));
    }
  }
  */
}

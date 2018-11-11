package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class IsTest {
  @Test public void inEmpty() {
    azzert.nay(is.in(Boolean.TRUE));
    azzert.nay(is.in(Boolean.FALSE));
    azzert.nay(is.in(Integer.valueOf(2)));
    azzert.nay(is.in(Double.valueOf(3.4)));
    azzert.nay(is.in(Character.valueOf('c')));
  }

  @Test public void inNull() {
    azzert.nay(is.in(Integer.valueOf(2), (Double) null));
    azzert.nay(is.in(Double.valueOf(2.2), (Double) null));
    azzert.nay(is.in(String.valueOf("2"), (Double) null));
    azzert.nay(is.in(Character.valueOf('2'), (Double) null));
  }

  @Test public void inDouble() {
    azzert.aye(is.in(Double.valueOf(2.3), Double.valueOf(2.3), Double.valueOf(5.1), Double.valueOf(7.3)));
    azzert.aye(is.in(Double.valueOf(5.1), Double.valueOf(2.3), Double.valueOf(5.1), Double.valueOf(7.3)));
    azzert.aye(is.in(Double.valueOf(7.3), Double.valueOf(2.3), Double.valueOf(5.1), Double.valueOf(7.3)));
    azzert.nay(is.in(Double.valueOf(-66), Double.valueOf(2.3), Double.valueOf(5.1), Double.valueOf(7.3)));
    azzert.nay(is.in(Double.valueOf(2.6), Double.valueOf(2.3), Double.valueOf(5.1), Double.valueOf(7.3)));
    azzert.nay(is.in(Double.valueOf(6.6), Double.valueOf(2.3), Double.valueOf(5.1), Double.valueOf(7.3)));
    azzert.nay(is.in(Double.valueOf(15.6), Double.valueOf(2.3), Double.valueOf(5.1), Double.valueOf(7.3)));
  }

  @Test public void inInteger() {
    azzert.aye(is.in(Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.in(Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.in(Integer.valueOf(7), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.nay(is.in(Integer.valueOf(-3), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.nay(is.in(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.nay(is.in(Integer.valueOf(6), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.nay(is.in(Integer.valueOf(16), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
  }

  @Test public void inBoolean() {
    azzert.aye(is.in(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE));
    azzert.aye(is.in(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
    azzert.aye(is.in(Boolean.TRUE, Boolean.TRUE));
    azzert.nay(is.in(Boolean.FALSE, Boolean.TRUE));
    azzert.aye(is.in(Boolean.FALSE, Boolean.FALSE));
    azzert.nay(is.in(Boolean.TRUE, Boolean.FALSE));
  }

  @Test public void intIsIn() {
    azzert.aye(is.intIsIn(1, 1, 3, 5));
    azzert.aye(is.intIsIn(3, 1, 3, 5));
    azzert.aye(is.intIsIn(5, 1, 3, 5));
    azzert.nay(is.intIsIn(0, 1, 3, 5));
    azzert.nay(is.intIsIn(2, 1, 3, 5));
    azzert.nay(is.intIsIn(4, 1, 3, 5));
    azzert.nay(is.intIsIn(77, 1, 3, 5));
  }

  @Test public void notIn() {
    azzert.nay(is.not.in(Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.nay(is.not.in(Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.nay(is.not.in(Integer.valueOf(7), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.not.in(Integer.valueOf(-3), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.not.in(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.not.in(Integer.valueOf(6), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.not.in(Integer.valueOf(16), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
  }

  @Test public void out() {
    azzert.nay(is.out(Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.nay(is.out(Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.nay(is.out(Integer.valueOf(7), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.out(Integer.valueOf(-3), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.out(Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.out(Integer.valueOf(6), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
    azzert.aye(is.out(Integer.valueOf(16), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(7)));
  }

  @Test public void emptyString() {
    azzert.aye(is.empty(String.valueOf("")));
    azzert.nay(is.empty(String.valueOf("abc")));
  }

  @Test public void emptyArray() {
    azzert.aye(is.empty(new Integer[] {}));
    azzert.nay(is.empty(new Integer[] { Integer.valueOf(1) }));
  }

  @Test public void emptyList() {
    azzert.aye(is.empty(Arrays.asList()));
    azzert.nay(is.empty(Arrays.asList(Integer.valueOf(1))));
  }
}
package il.org.spartan.utils;

import java.math.*;
import java.util.*;

public class BigIntegerRange {
  BigInteger from;
  BigInteger to;
  BigInteger step;

  public BigIntegerRange() {
    this.from = null;
    this.to = null;
    this.step = BigInteger.ONE;
  }

  public BigIntegerRange from(final BigInteger value) {
    this.from = value;
    return this;
  }

  public BigInteger from() {
    return this.from;
  }

  public BigIntegerRange to(final BigInteger value) {
    this.to = value;
    return this;
  }

  public BigInteger to() {
    return this.to;
  }

  public Iterator<BigInteger> numbers() {
    return new Iterator<BigInteger>() {
      BigInteger current = from;

      @Override public boolean hasNext() {
        return to == null || current.add(step).compareTo(to) < 0;
      }

      @Override public BigInteger next() {
        final BigInteger $ = current;
        current = current.add(step);
        return $;
      }

      @Override public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  public BigIntegerRange interset(final BigIntegerRange other) {
    return this.to != null && other.from != null && this.to.compareTo(other.from) < 0
        || other.to != null && this.from != null && other.to.compareTo(this.from) < 0 ? null
            : new BigIntegerRange().from(this.from != null && this.from.compareTo(other.from) > 0 ? this.from : other.from)
                .to(other.to != null && to != null && this.to.compareTo(other.to) < 0 ? this.from : other.from);
  }

  public boolean includes(final BigInteger value) {
    return (from == null || from.compareTo(value) < 0) && (to == null || value.compareTo(to) < 0);
  }
}

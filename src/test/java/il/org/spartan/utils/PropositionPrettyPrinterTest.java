package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PropositionPrettyPrinterTest {
  @Test public void testNumber() {
    final PropositionPrettyPrinter.Number n = new PropositionPrettyPrinter.Number();
    azzert.that(n + "", is("1"));
    n.next();
    azzert.that(n + "", is("2"));
    n.next();
    azzert.that(n + "", is("3"));
    n.next();
    azzert.that(n + "", is("4"));
    azzert.isNull(n.less());
    azzert.notNull(n.more().less());
    azzert.notNull(n.more() + "");
  }

  @Test public void testNumberWithTab() {
    final PropositionPrettyPrinter.NumberWithTab n = new PropositionPrettyPrinter.NumberWithTab();
    n.more();
    azzert.notNull(n + "");
    n.less();
    azzert.notNull(n + "");
    n.next();
    azzert.notNull(n + "");
  }

  @Test public void testMain() {
    final PropositionPrettyPrinter p0 = new PropositionPrettyPrinter();
    final PropositionPrettyPrinter.NodePrettyPrinter n = p0.new NodePrettyPrinter();
    n.down();
    azzert.notNull(n + "");
    n.next();
    azzert.notNull(n + "");
    n.up();
    azzert.notNull(n + "");
  }
}

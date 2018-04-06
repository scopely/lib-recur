package org.dmfs.rfc5545.recur;

import org.dmfs.rfc5545.DateTime;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class RecurrenceIteratorBenchmark {

  DateTime startTime;
  DateTime endTime;
  RecurrenceRule rule;

  @Setup
  public void prepare() throws InvalidRecurrenceRuleException {
    startTime = DateTime.parse("19980119T070000Z");
    endTime = DateTime.parse("20280119T070000Z");
    rule = new RecurrenceRule("FREQ=DAILY;INTERVAL=1", RecurrenceRule.RfcMode.RFC5545_STRICT);
  }

  @Benchmark
  public void fastforward_30years_daily() {
    rule.iterator(startTime).fastForward(endTime);
  }
}

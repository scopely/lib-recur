package org.dmfs.rfc5545.recur;

import org.openjdk.jmh.annotations.Benchmark;

public class ParserBenchmark {
  @Benchmark
  public void parse() throws InvalidRecurrenceRuleException {
    RecurrenceRule rule = new RecurrenceRule("FREQ=DAILY;INTERVAL=1;UNTIL=20120331T035959Z", RecurrenceRule.RfcMode.RFC5545_STRICT);
  }
}

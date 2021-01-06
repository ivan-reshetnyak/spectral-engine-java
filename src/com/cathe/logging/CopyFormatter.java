package com.cathe.logging;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CopyFormatter extends Formatter {
  private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

  @Override
  public String format( LogRecord record ) {
    return String.format(format,
            new Date(record.getMillis()),
                     record.getLevel().getLocalizedName(),
                     record.getMessage());
  }
}

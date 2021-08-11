package converters;

import java.util.*;
import java.text.*;

public class CurrencyConverterBean {
    private static final double EXCHANGE_RATE = 0.79;
    private NumberFormat nf = NumberFormat.getInstance();
    private String amount;

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getAmount() {
	return amount;
    }
  
    public String getEuroval() {
        try {
             double Value = nf.parse(amount).doubleValue();
             Value *= EXCHANGE_RATE;
             nf.setMaximumFractionDigits(2);
             nf.setMinimumFractionDigits(2);
             return "&euro;" + nf.format(Value);
          }
          catch (ParseException e) {
             return ("Bad number format");
          }
     }
}
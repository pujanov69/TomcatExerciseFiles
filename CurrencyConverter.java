/* CurrencyConverter.java: A servlet to convert dollars to euros */
/* compile with -classpath <CATALINA_HOME>\common\lib\servlet-api.jar */
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CurrencyConverter extends HttpServlet {
    private static final double EXCHANGE_RATE = 0.79;
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
              throws ServletException, IOException {
           res.setContentType("text/html");
           PrintWriter out = res.getWriter();
           out.println("<html>");
           out.println("<head><title>Currency Conversion</title></head>");
           out.println("<body>");
           String amount = req.getParameter("amount");
           try {
               NumberFormat nf = NumberFormat.getInstance();
               double Value = nf.parse(amount).doubleValue();
               Value *= EXCHANGE_RATE;
               nf.setMaximumFractionDigits(2);
               nf.setMinimumFractionDigits(2);
               out.println("<big>" + "$" +
                    amount + " = &euro;" +
                    nf.format(Value) + "<p>");
               out.println("Exchange rate is .79 dollars to the Euro</big>");
                    
            }
            catch (ParseException e) {
                out.println("Bad number format");
            }
            out.println("</body></html>");
       }
}
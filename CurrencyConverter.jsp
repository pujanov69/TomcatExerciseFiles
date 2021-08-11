<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%! private static final double EXCHANGE_RATE = 0.79; %>

<%
    String amount = request.getParameter("amount");
           try {
               NumberFormat nf = NumberFormat.getInstance();
               double Value = nf.parse(amount).doubleValue();
               Value *= EXCHANGE_RATE;
               nf.setMaximumFractionDigits(2);
               nf.setMinimumFractionDigits(2);
            
%>

<html>
    <head><title>Currency Conversion JSP</title></head>
    <body>
        <big>
            $ <%= amount %> =
            &euro; <%= nf.format(Value) %>
        </big>
    </body>
</html>
<% 
 }
 catch (ParseException e) {
    out.println("Bad number format");
}
%>
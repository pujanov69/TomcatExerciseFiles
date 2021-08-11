<jsp:useBean id="converter" class="converters.CurrencyConverterBean" scope="page" >
<jsp:setProperty name="converter" property="amount" />
</jsp:useBean>

<html>
    <head><title>Currency Converter JSP 2</title></head>
    <body>
       <big>
           <jsp:getProperty name="converter" property="amount" /> = <jsp:getProperty name="converter" property="euroval" />
</big>
</body>
</html>

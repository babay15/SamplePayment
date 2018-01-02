<%-- 
    Document   : edit
    Created on : Jan 1, 2018, 8:28:32 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EDIT CREDIT!</h1>
        <form:form action="/ProjectFinance/index/edit/save" modelAttribute="creditBean" method="POST">
            <table>
                <tr>
                    <td>
                        <form:label path="creditBasePrice">
                            Base Price
                        </form:label>
                    </td>
                    <td>
                        <form:input path="creditBasePrice"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="creditInterestRate">
                            Interest Rate (%)
                        </form:label>
                    </td>
                    <td>
                        <form:input path="creditInterestRate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="creditDownPayment">
                            Down Payment
                        </form:label>
                    </td>
                    <td>
                        <form:input path="creditDownPayment"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="creditDuration">
                            Duration (MONTH)
                        </form:label>
                    </td>
                    <td>
                        <form:input path="creditDuration"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form:button>SAVE</form:button>
                    </td>
                </tr>
            </table>
            
        </form:form>
    </body>
</html>

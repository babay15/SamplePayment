<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
        <p><i>To display a different welcome page for this project, modify</i>
            <tt>index.jsp</tt> <i>, or create your own welcome page then change
                the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                welcome page and also update the welcome-file setting in</i>
            <tt>web.xml</tt>.</p>
        <h1>APPROVED CREDIT</h1><br>
        <c:if test="${empty admins}">DATA NOT AVAILABLE</c:if>
        <c:if test="${not empty admins}"> 
            <table border="2">
            <tr>
                <th>
                    Credit ID
                </th>                    
                <th>
                    Customer Name
                </th>
                <th>
                    Duration
                </th>
                <th>
                    Status
                </th>
                <th>
                    Manage
                </th>
            </tr>
        <c:forEach var="x" items="${admins}">
            <tr>
                <td>
                    ${x.creditId}
                </td>
                <td>
                    ${x.paymentId.customerId.customerName}
                </td>
                <td>
                    ${x.creditDuration} /month
                </td>
                <td>
                    ${x.creditStatus}
                </td>
                <td>
                    <a href="/ProjectFinance/index/delete/${x.creditId}"><button>DELETE</button></a> <a><button>EDIT</button></a>
                </td>
            </tr>
        </c:forEach>
        </table>
        </c:if>
            <br>    
        <h1>UNAPPROVED CREDIT</h1><br>
        
        <c:if test="${empty adminz}">DATA NOT AVAILABLE</c:if>
        <c:if test="${not empty adminz}">
        <table border="2">
            <tr>
                <th>
                    Credit ID
                </th>                    
                <th>
                    Customer Name
                </th>
                <th>
                    Duration
                </th>
                <th>
                    Status
                </th>
                <th>
                    Manage
                </th>
            </tr>
        <c:forEach var="x" items="${adminz}">
            <tr>
                <td>
                    ${x.creditId}
                </td>
                <td>
                    ${x.paymentId.customerId.customerName}
                </td>
                <td>
                    ${x.creditDuration} /month
                </td>
                <td>
                    ${x.creditStatus}
                </td>
                <td>
                    <a href="/ProjectFinance/index/approve/${x.creditId}"><button>APPROVE</button></a> <a href="/ProjectFinance/index/delete/${x.creditId}"><button>DELETE</button></a> <a><button>EDIT</button></a>
                </td>
            </tr>
        </c:forEach>
        </table>
        </c:if>
    </body>
</html>

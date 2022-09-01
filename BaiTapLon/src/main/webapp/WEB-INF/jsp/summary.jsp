<%-- 
    Document   : summary
    Created on : Aug 12, 2022, 10:48:13 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="text-center text-[56px] font-bold mt-[40px]">SUMMARY</h1>

<div class="mt-[100px]  w-[70%] mx-auto flex justify-center gap-[300px] rounded-[20px] shadow-2xl">
    <div class="pt-[50px] text-center">
        <h1 class="font-bold text-[20px]">Ten thanh vien </h1>
        <c:forEach items="${moneyUserPay}" var="m">
            <h1 class="py-[50px] text-[18px] font-bold text-green-500 ">
                ${m.username}
            </h1>
        </c:forEach>
    </div>

    <div class="pt-[50px] text-center">

        <h1 class="font-bold text-[20px]">Tien da tra </h1>
        <c:forEach items="${moneyUserPaid}" var="m">
            <h1 class="py-[50px] text-[18px] font-bold text-green-500 ">

                <fmt:formatNumber type = "number" value = "${m.money}" /> VND
            </h1>
        </c:forEach>
    </div>

    <div class="pt-[50px] text-center ">
        <h1 class="font-bold text-[20px] ">Tat toan </h1>
        <c:forEach items="${moneyUserPay}" var="m">

            <c:if test="${m.money < 0}"> 
                <h1 class="py-[50px] text-[18px] font-bold text-green-500 ">

                    <span class="text-pink-500">Duoc hoan:</span> <fmt:formatNumber type = "number" value = "${m.money*(-1)}" /> VND
                </h1>
            </c:if>
            <c:if test="${m.money > 0}"> 
                <h1 class="py-[50px] text-[18px] font-bold text-green-500 ">

                    <span class="text-pink-500">Phai tra:</span> <fmt:formatNumber type = "number" value = "${m.money}" /> VND
                </h1>
            </c:if>
        </c:forEach>
    </div>
</div>

<%-- 
    Document   : acceptIncome
    Created on : Aug 10, 2022, 5:50:26 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="text-center text-[48px] font-bold mb-[100px] pt-[100px]">ACCEPT INCOME FOR GROUP</h1>

<c:forEach items="${incomes}" var="i">
    <div class="flex  w-[1200px] h-[70px] mx-auto justify-center gap-[40px] mt-[70px]" id="incomeTemp${i.id}">
        <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mt-[100px] ml-[50px] " onclick="addIncomeGroup(${i.userId}, ${i.groupId}, ${i.money}, '${i.purpose}', '${i.time}', ${i.id})">


            <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                <path stroke-linecap="round" stroke-linejoin="round" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
            </svg>
        </button>

        <div class="w-[700px] h-[70px] shadow-2xl flex mt-[100px] rounded-[10px] bg-gradient-to-r from-pink-500 to-violet-500">

            <svg xmlns="http://www.w3.org/2000/svg" class="w-[60px] h-[60px] my-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                <path stroke-linecap="round" stroke-linejoin="round" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
            </svg>
            <div class="my-auto ml-[100px]">
                <h1 class="font-bold text-[25px]">${i.purpose}</h1>
                <h1 class="text-white">${i.time}</h1>
            </div>
            <h1 class="my-auto ml-auto mr-[20px] font-bold text-[20px]">+<fmt:formatNumber type = "number" value = "${i.money}" /> VND</h1>
        </div>


        <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mt-[100px] " onclick="deleteIncomeTemp(${i.id})">

            <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z" clip-rule="evenodd" />
            </svg>
        </button>

    </div>
</c:forEach>

<script>
    window.onload = function () {

    }
</script>


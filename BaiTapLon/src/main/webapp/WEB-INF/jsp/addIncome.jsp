<%-- 
    Document   : addIncome
    Created on : Aug 2, 2022, 12:31:44 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url value="/add-income" var="action" />

<div class=" ">
    <h1 class="text-center text-[48px] font-bold mb-[100px] pt-[100px]">ADD INCOME</h1>



    <form:form method="post" action="${action}" modelAttribute="inCome">

        <div class="flex flex-wrap justify-center gap-x-[45px] mb-[70px]">
            <label for="money" class="font-bold text-[20px] text-black0 mr-auto ml-[400px] ">Money: </label>                
            <form:input type="text" class="w-[400px] shadow-2xl rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="money" path="money" placeholder="enter money" />
            <form:errors path="money"  class="text-red-500 font-bold mx-[0px] ml-[100px]"  />
        </div>

        <div class="flex flex-wrap justify-center gap-x-[45px] mb-[70px]">
            <label for="time" class="font-bold text-[20px] text-black0 mr-auto ml-[400px] ">Time:  </label>                
            <form:input type="text" class="w-[400px] shadow-2xl rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="time" path="time" placeholder="enter time: yyyy-MM-dd" />
            <c:if test="${err!=null}"><h1 class="text-red-500 font-bold mx-[0px] ml-[100px]">${err}</h1></c:if>
        </div>

        <div class=" flex flex-wrap justify-center gap-x-[45px] mb-[70px]">
            <label for="purpose" class=" mr-auto ml-[400px] font-bold text-[20px] text-black">Purpose: </label>
            <form:input type="text" class="w-[400px] shadow-2xl rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="purpose" path="purpose" placeholder="enter purpose" />
            <form:errors path="purpose" class="text-red-500 font-bold ml-[100px]" />
        </div>

        <div class="flex justify-center">
            <button type="submit" class="w-[140px] h-[50px] bg-green-500 rounded-[25px] text-black font-bold hover:bg-pink-500 hover:duration-[1.5s] ">Submit</button>
        </div>
    </form:form>
</div>

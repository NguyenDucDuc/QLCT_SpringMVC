<%-- 
    Document   : login
    Created on : Aug 1, 2022, 6:55:35 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<c:url value="/login" var="action" />

<div class=" h-[1000px] ">
    <h1 class="text-center text-[48px] font-bold mb-[100px] pt-[100px]">DANG NHAP</h1>

    <c:if test="${param.error != null}">
        <div class="alert alert-danger alert-dismissible container">
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            <strong>Tai khoan hoac mat khau khong chinh xac!</strong>${params.error}
        </div>
    </c:if>
    
    <form method="post" action="${action}">
        <div class="flex justify-center gap-[45px] mb-[50px]">
            <label for="username" class="font-bold text-[20px] text-black0 ">Username: </label>
            <input type="text" class="w-[400px] rounded-[25px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="username" placeholder="Enter username" name="username">
        </div>

        <div class="flex justify-center gap-[45px] mb-[50px]">
            <label for="password" class="font-bold text-[20px] text-black">Password: </label>
            <input type="password" class="w-[400px] rounded-[25px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="password" placeholder="Enter password" name="password">
        </div>
        
        <div class="flex justify-center">
            <button type="submit" class="w-[140px] h-[50px] bg-green-500 rounded-[25px] text-black font-bold hover:bg-pink-500 hover:duration-[1.5s] ">Dang nhap</button>
        </div>
    </form>
</div>

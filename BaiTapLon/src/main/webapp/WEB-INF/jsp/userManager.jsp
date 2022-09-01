<%-- 
    Document   : userManager
    Created on : Aug 22, 2022, 11:12:44 AM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:forEach items="${users}" var="u">
    <div class="flex" id="user${u.id}">
        <div class="w-[800px] h-[70px] shadow-2xl flex mx-auto mb-[100px] rounded-[10px] bg-gradient-to-r from-pink-500 to-blue-400">


            <svg xmlns="http://www.w3.org/2000/svg" class="w-[60px] h-[60px] my-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                <path stroke-linecap="round" stroke-linejoin="round" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" />
            </svg>


            <div class="my-auto ml-[100px]">
                <h1 class="font-bold text-[17px]">${u.username}</h1>

            </div>

        </div>

        <c:if test="${u.active==1}">
            <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mb-[100px] mr-[200px] " onclick="lockUser(${u.id})" id="buttonuser${u.id}">


                <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z" clip-rule="evenodd" />
                </svg>
            </button>
        </c:if>

        <c:if test="${u.active==0}">
            <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mb-[100px] mr-[200px]" onclick="unlockUser(${u.id})" id="buttonuser${u.id}">


                <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M10 2a5 5 0 00-5 5v2a2 2 0 00-2 2v5a2 2 0 002 2h10a2 2 0 002-2v-5a2 2 0 00-2-2H7V7a3 3 0 015.905-.75 1 1 0 001.937-.5A5.002 5.002 0 0010 2z" />
                </svg>
            </button>
        </c:if>
    </div>
</c:forEach>

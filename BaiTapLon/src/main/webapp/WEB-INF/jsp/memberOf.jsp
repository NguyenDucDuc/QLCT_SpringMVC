<%-- 
    Document   : memberOf
    Created on : Aug 10, 2022, 10:07:50 AM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-[48px] font-bold mb-[100px] pt-[100px]">MEMBER OF</h1>


<div class="pb-[100px]">
    <c:forEach items="${groups}" var="g">
        <div class="flex  w-[1200px] h-[70px] mx-auto justify-center gap-[50px] mt-[50px]">

            <a href="<c:url value="/add-income-group"/>/?groupId=${g.groupId.id}">
                <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mt-[100px] ">

                    <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM7 9a1 1 0 000 2h6a1 1 0 100-2H7z" clip-rule="evenodd" />
                    </svg>

                </button>
            </a>

            <div class="w-[600px] h-[70px] shadow-2xl flex mt-[100px] rounded-[10px] bg-gradient-to-r from-pink-500 to-violet-500">

                <svg xmlns="http://www.w3.org/2000/svg" class="w-[60px] h-[60px] my-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
                </svg>
                <div class="my-auto ml-[100px]">
                    <h1 class="font-bold text-[25px]">${g.groupId.groupname}</h1>
                </div>
            </div>

            <a href="<c:url value="/add-income-group"/>/?groupId=${g.groupId.id}">
                <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mt-[100px] ">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm1-11a1 1 0 10-2 0v2H7a1 1 0 100 2h2v2a1 1 0 102 0v-2h2a1 1 0 100-2h-2V7z" clip-rule="evenodd" />
                    </svg>

                </button>
            </a>
        </div>
    </c:forEach>
</div>
<%-- 
    Document   : chatGroup
    Created on : Aug 30, 2022, 9:42:32 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-[48px] font-bold mb-[100px] pt-[100px]">CHAT GROUPS</h1>


<div class="pb-[100px]">
    <c:forEach items="${belong}" var="b">
        <div class="flex  w-[1400px] h-[70px] mx-auto justify-center gap-[40px] mt-[50px]">

            <a href="<c:url value="/chat"/>/?groupId=${b.groupId.id}">
                <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mt-[100px] ml-[50px] ">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M12 20.25c4.97 0 9-3.694 9-8.25s-4.03-8.25-9-8.25S3 7.444 3 12c0 2.104.859 4.023 2.273 5.48.432.447.74 1.04.586 1.641a4.483 4.483 0 01-.923 1.785A5.969 5.969 0 006 21c1.282 0 2.47-.402 3.445-1.087.81.22 1.668.337 2.555.337z" />
                    </svg>

                </button>
            </a>



            <div class="w-[700px] h-[70px] shadow-2xl flex mt-[100px] rounded-[10px] bg-gradient-to-r from-pink-500 to-violet-500">

                <svg xmlns="http://www.w3.org/2000/svg" class="w-[60px] h-[60px] my-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
                </svg>
                <div class="my-auto ml-[100px]">
                    <h1 class="font-bold text-[25px]">${b.groupId.groupname}</h1>
                </div>
            </div>


        </div>
    </c:forEach>

    <c:forEach items="${groups}" var="g">
        <div class="flex  w-[1400px] h-[70px] mx-auto justify-center gap-[40px] mt-[50px]">

            <a href="<c:url value="/chat"/>/?groupId=${g.id}">
                <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mt-[100px] ml-[50px] ">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M12 20.25c4.97 0 9-3.694 9-8.25s-4.03-8.25-9-8.25S3 7.444 3 12c0 2.104.859 4.023 2.273 5.48.432.447.74 1.04.586 1.641a4.483 4.483 0 01-.923 1.785A5.969 5.969 0 006 21c1.282 0 2.47-.402 3.445-1.087.81.22 1.668.337 2.555.337z" />
                    </svg>

                </button>
            </a>



            <div class="w-[700px] h-[70px] shadow-2xl flex mt-[100px] rounded-[10px] bg-gradient-to-r from-pink-500 to-violet-500">

                <svg xmlns="http://www.w3.org/2000/svg" class="w-[60px] h-[60px] my-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
                </svg>
                <div class="my-auto ml-[100px]">
                    <h1 class="font-bold text-[25px]">${g.groupname}</h1>
                </div>
            </div>


        </div>
    </c:forEach>
</div>

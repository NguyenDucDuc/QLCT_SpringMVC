<%-- 
    Document   : chat
    Created on : Aug 29, 2022, 12:44:34 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="bg-gradient-to-b from-green-500 to-cyan-500 w-[1000px] h-[800px] mx-auto opacity-80 flex flex-col rounded-[25px]">
    <!--        <textarea id="content"  class="w-[80%] h-[80%] border-[2px] border-white bg-cyan-500 bg-opacity-0 mx-auto mt-[10px] rounded-[15px]"></textarea>-->

    <div id="content" class="w-[100%] h-[100%]   mx-auto mt-[10px] rounded-[15px] overflow-x-auto">
        <c:forEach items="${listMessage}" var="message">
            <div class="flex mt-[30px] ml-[70px]">

                <c:if test="${message.userId.avatar!=null}">
                    <img src="${message.userId.avatar}" class="w-[50px] h-[50px] rounded-[50%] mr-0 mt-[3px]" />
                </c:if>
                <c:if test="${message.userId.avatar==null}">
                    <img src="https://res.cloudinary.com/djbju13al/image/upload/v1659513080/wpzmkfgvjf1hjrh4iy3c.jpg" class="w-[50px] h-[50px] rounded-[50%] mr-0 mt-[3px]" />
                </c:if>
                <div>
                    <h1 class="font-bold ml-[20px] " >${message.userId.username}</h1>
                    <h1 class="bg-pink-500 w-[auto] h-[40px] mr-auto ml-[20px] rounded-[15px]"><span class=" px-[15px] py-[15px] ">${message.content}</span></h1>
                </div>
            </div>
        </c:forEach>

    </div>
    <div class="flex mt-[20px] mb-[40px]  ">
        <input type="text" id="inputText" class="rounded-[15px] border-[2px] w-[60%] mx-auto border-white bg-cyan-500 bg-opacity-0" />
        <button class="rounded-[15px] border-[2px] w-[100px] bg-pink-500 mr-auto" onclick="sendData(${currentUser.id}, ${groupId})">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-[30px] h-[30px] mx-auto my-auto">
                <path stroke-linecap="round" stroke-linejoin="round" d="M6 12L3.269 3.126A59.768 59.768 0 0121.485 12 59.77 59.77 0 013.27 20.876L5.999 12zm0 0h7.5" />
            </svg>

        </button>
    </div>

</div>


<!--<input type="text" id="inputText">
<input type="button" value="Send Data" onClick="sendData(${currentUser.id}, ${groupId})" /><br /> 
<textarea id="content"  rows="10" cols="50"></textarea>-->
<h1 id="avatar" class="text-white">${currentUser.avatar}</h1>
<h1 id="username" clas="text-white">${currentUser.username}</h1>
<script>


</script>

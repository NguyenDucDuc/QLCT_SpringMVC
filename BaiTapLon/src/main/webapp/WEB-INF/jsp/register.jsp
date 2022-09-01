<%-- 
    Document   : register
    Created on : Aug 1, 2022, 6:55:42 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url value="/register" var="action" />

<div class=" h-[1000px] ">
    <h1 class="text-center text-[48px] font-bold mb-[100px] pt-[100px]">DANG KY</h1>


    <c:if test="${err != null}">
        <div class="alert alert-danger alert-dismissible">
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            <strong>Failed</strong>${err}
        </div>
    </c:if>

    <form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
        <div class="flex flex-wrap justify-center gap-x-[45px] mb-[50px]">
            <label for="username" class="font-bold text-[20px] text-black0 mr-auto ml-[400px] ">Username: </label>                
            <form:input type="text" class="w-[400px] rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="username" path="username" placeholder="enter username" />
             <form:errors path="username"  class="text-red-500 font-bold mx-[0px] ml-[100px]"  />
        </div>

        <div class="flex flex-wrap justify-center gap-x-[45px] mb-[50px]">
            <label for="password" class=" mr-auto ml-[400px] font-bold text-[20px] text-black">Password: </label>
            <form:input type="password" class="w-[400px] rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="password" path="password" placeholder="enter password" />
            <form:errors path="password"  class="text-red-500 font-bold mx-[0px] ml-[100px]"  />
        </div>

        <div class="flex flex-wrap justify-center gap-x-[45px] mb-[50px]">
            <label for="confirm" class=" mr-auto ml-[400px] font-bold text-[20px] text-black">Confirm: </label>
            <form:input type="password" class="w-[400px] rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="confirm" path="confirm" placeholder="confirm password" />
            <form:errors path="confirm"  class="text-red-500 font-bold mx-[0px] ml-[100px]"  />
        </div>

        <div class="flex flex-wrap justify-center gap-x-[45px] mb-[50px]">
            <label for="email" class=" mr-auto ml-[400px] font-bold text-[20px] text-black">Email: </label>
            <form:input type="text" class="w-[400px] rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="email" path="email" placeholder="enter email" />
            <form:errors path="email"  class="text-red-500 font-bold mx-[0px] ml-[100px]"  />
        </div>

        <div class="flex justify-center gap-[45px] mb-[50px]">
            <label for="avatar" class=" mr-auto ml-[400px] font-bold text-[20px] text-black">Avatar: </label>
            <form:input type="file" class="w-[400px] h-[43px] rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 file:bg-green-500 file:w-[90px] file:rounded-[25px] file:border-none  file:h-[35px] file:mt-[2px] " id="avatar" path="file" placeholder="choose file" />

        </div>

        <div class="flex justify-center gap-[45px] mb-[50px]">
            <label for="role" class=" mr-auto ml-[400px] font-bold text-[20px] text-black">Role: </label>
            <form:select path="role" class="w-[400px] rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 ">
                <option value="ROLE_USER">USER</option>
                <option value="ROLE_ENTERPRISE">ENTERPRISE</option>
            </form:select>
        </div>

        <div class="flex justify-center">
            <button type="submit" class="w-[140px] h-[50px] bg-green-500 rounded-[25px] text-black font-bold hover:bg-pink-500 hover:duration-[1s] ">Dang ky</button>
        </div>
    </form:form>
</div>


<%-- 
    Document   : addMember
    Created on : Aug 9, 2022, 8:00:55 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-[48px] font-bold mb-[100px] pt-[100px]">ADD MEMBER</h1>


<c:url value="/add-member" var="action" />

<c:if test="${err!=null}">
    <h1>${err}</h1>
</c:if>

<form:form modelAttribute="belongTo" class="w-[300px] h-[60px] mx-auto " action="${action}">
    <form:select class="w-[100%] border-[2px] border-green-500 rounded-[25px]" path="groupId">
        <option value="${group.id}">${group.groupname}</option>
    </form:select>
    <form:select path="userId" class="w-[100%] border-[2px] border-green-500 rounded-[25px]">
        <c:forEach items="${users}" var="u">
            <option value="${u.id}">${u.username}</option>
        </c:forEach>
    </form:select>
    <button type="submit" class="w-[150px] h-[50px] bg-gradient-to-r from-cyan-500 to-green-400 rounded-[25px] mt-[50px] font-bold">Add</button>
</form:form>




<c:forEach items="${users}" var="u">
    <h1>${u.username}</h1>
</c:forEach>

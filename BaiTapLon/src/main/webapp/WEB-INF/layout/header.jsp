<%-- 
    Document   : header
    Created on : Aug 1, 2022, 6:15:47 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm navbar-white bg-white">
    <div class="container-fluid">
        <a class="navbar-brand text-green-500 text-[34px] font-bold" href="<c:url value="/" /> ">MoneySpendingManager</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse mt-[20px] " id="mynavbar">

            <ul class="navbar-nav mx-auto flex gap-[40px]">
                <c:if  test="${pageContext.request.userPrincipal.name == null}">
<!--                    <li class="nav-item">
                        <a class="text-[18px] font-bold hover:duration-[1s]" href="javascript:void(0)">Login</a>
                    </li>-->

                    <li class="nav-item">
                        <a class="text-[18px] font-bold hover:duration-[1s]" href="<c:url value="/register" />">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="text-[18px] font-bold hover:duration-[1s]" href="<c:url value="/login" />">Login</a>
                    </li>
                </c:if>

                <c:if  test="${pageContext.request.userPrincipal.name != null && currentUser.active==1}">

                    <c:if test="${currentUser.avatar != null}">
                        <div class="bg-pink-500 w-[78px] h-[78px] rounded-[50%] ">
                            <img src="${currentUser.avatar}" class="w-[70px] h-[70px] rounded-[50%] mx-auto mt-[3px]" />
                        </div>
                    </c:if>

                    <c:if test="${currentUser.avatar == null}">
                        <div class="bg-pink-500 w-[78px] h-[78px] rounded-[50%] ">
                            <img src="https://res.cloudinary.com/djbju13al/image/upload/v1659513080/wpzmkfgvjf1hjrh4iy3c.jpg" class="w-[70px] h-[70px] rounded-[50%] mx-auto mt-[3px]" />
                        </div>
                    </c:if>

                    <li class="nav-item mt-[20px]">
                        <a class="text-[18px] font-bold hover:duration-[1s ] text-pink-500" href="javascript:void(0)">${pageContext.request.userPrincipal.name}</a>
                    </li>

                    <li class="nav-item mt-[20px]">
                        <a class="text-[18px] font-bold hover:duration-[1s]" href="<c:url value="/logout" />">Logout</a>
                    </li>
                    <li class="nav-item mt-[20px]">
                        <a class="text-[18px] font-bold hover:duration-[1s]" href="<c:url value="/warning" />">Warning</a>
                    </li>
                </c:if>

                <c:if  test="${pageContext.request.userPrincipal.name != null && currentUser.active==0}">

                    <c:if test="${currentUser.avatar != null}">
                        <div class="bg-pink-500 w-[78px] h-[78px] rounded-[50%] ">
                            <img src="${currentUser.avatar}" class="w-[70px] h-[70px] rounded-[50%] mx-auto mt-[3px]" />
                        </div>
                    </c:if>

                    <c:if test="${currentUser.avatar == null}">
                        <div class="bg-pink-500 w-[78px] h-[78px] rounded-[50%] ">
                            <img src="https://res.cloudinary.com/djbju13al/image/upload/v1659513080/wpzmkfgvjf1hjrh4iy3c.jpg" class="w-[70px] h-[70px] rounded-[50%] mx-auto mt-[3px]" />
                        </div>
                    </c:if>

                    <li class="nav-item mt-[20px]">
                        <a class="text-[18px] font-bold hover:duration-[1s ] text-pink-500" href="javascript:void(0)">User is block</a>
                    </li>

                    <li class="nav-item mt-[20px]">
                        <a class="text-[18px] font-bold hover:duration-[1s]" href="<c:url value="/logout" />">Logout</a>
                    </li>
                    
                </c:if>
            </ul>

            <form class="d-flex gap-[25px]">
                <input name="kw" class="form-control me-2 drop-shadow-2xl text-green-500  placeholder:text-green-500 border-[1.5px] border-green-500 rounded-[25px]" type="text" placeholder="enter keyword...">
                <button class="border-[1.5px] border-green-500 w-[160px] h-[50px] rounded-[25px] text-green-500 font-bold drop-shadow-2xl " type="submit">Search</button>
            </form>


        </div>
    </div>
</nav>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>


    </head>

    <body>
        <h1 class="text-center text-[56px] text-green-500 font-bold mt-[120px]">Simple way
            to manage personal finances</h1>

        <div class="flex justify-center  mt-[100px] grid auto-rows-auto columns-4">
            <div class="grid grid-cols-4 gap-[40px]">
                <a <c:if test="${currentUser.active==1}">href="<c:url value="/add-income" />"</c:if> <c:if test="${currentUser.active==0}">href="<c:url value="/user-block" />"</c:if> >  
                        <div class="shadow-2xl w-[300px] h-[200px] rounded-[15px]">
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" class="w-[40%] mx-auto mt-[10px]" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M9 8l3 5m0 0l3-5m-3 5v4m-3-5h6m-6 3h6m6-3a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg>
                            </div>
                            <div>
                                <h1 class="text-center mt-[20px] font-bold text-green-500 text-[25px]" >Add Income</h1>
                            </div>
                        </div>
                    </a>

                    <!--            card-->

                        <a <c:if test="${currentUser.active==1}">href="<c:url value="/add-spending" />"</c:if> <c:if test="${currentUser.active==0}">href="<c:url value="/user-block" />"</c:if>>
                        <div class="shadow-2xl w-[300px] h-[200px] rounded-[15px]">
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" class="w-[40%] mx-auto mt-[10px]" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M15 9a2 2 0 10-4 0v5a2 2 0 01-2 2h6m-6-4h4m8 0a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg>
                            </div>
                            <div>
                                <h1 class="text-center mt-[20px] font-bold text-green-500 text-[25px]" >Add Spending</h1>
                            </div>
                        </div>
                    </a>

                    <!--            card-->

                        <a  <c:if test="${currentUser.active==1}">href="<c:url value="/view-income" />"</c:if> <c:if test="${currentUser.active==0}">href="<c:url value="/user-block" />"</c:if>>
                        <div class="shadow-2xl w-[300px] h-[200px] rounded-[15px]">
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" class="w-[40%] mx-auto mt-[10px]" viewBox="0 0 20 20" fill="currentColor">
                                    <path d="M10 12a2 2 0 100-4 2 2 0 000 4z" />
                                    <path fill-rule="evenodd" d="M.458 10C1.732 5.943 5.522 3 10 3s8.268 2.943 9.542 7c-1.274 4.057-5.064 7-9.542 7S1.732 14.057.458 10zM14 10a4 4 0 11-8 0 4 4 0 018 0z" clip-rule="evenodd" />
                                </svg>
                            </div>
                            <div>
                                <h1 class="text-center mt-[20px] font-bold text-green-500 text-[25px]" >View Income</h1>
                            </div>
                        </div>
                    </a>

                    <!--            card-->


                        <a  <c:if test="${currentUser.active==1}">href="<c:url value="/view-spending" />"</c:if> <c:if test="${currentUser.active==0}">href="<c:url value="/user-block" />"</c:if>>
                        <div class="shadow-2xl w-[300px] h-[200px] rounded-[15px]">
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" class="w-[40%] mx-auto mt-[10px]" viewBox="0 0 20 20" fill="currentColor">
                                    <path d="M10 12a2 2 0 100-4 2 2 0 000 4z" />
                                    <path fill-rule="evenodd" d="M.458 10C1.732 5.943 5.522 3 10 3s8.268 2.943 9.542 7c-1.274 4.057-5.064 7-9.542 7S1.732 14.057.458 10zM14 10a4 4 0 11-8 0 4 4 0 018 0z" clip-rule="evenodd" />
                                </svg>
                            </div>


                            <div>
                                <h1 class="text-center mt-[20px] font-bold text-green-500 text-[25px]" >View Spending</h1>
                            </div>
                        </div>
                    </a>

                        <a  <c:if test="${currentUser.active==1}">href="<c:url value="/create-group" />"</c:if> <c:if test="${currentUser.active==0}">href="<c:url value="/user-block" />"</c:if>>
                        <div class="shadow-2xl w-[300px] h-[200px] rounded-[15px]">
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" class="w-[40%] mx-auto mt-[10px]" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
                                </svg>
                            </div>


                            <div>
                                <h1 class="text-center mt-[20px] font-bold text-green-500 text-[25px]" >Create Group</h1>
                            </div>
                        </div>
                    </a>

                    <!--                    MY GROUP-->
                        <a <c:if test="${currentUser.active==1}">href="<c:url value="/my-groups" />"</c:if> <c:if test="${currentUser.active==0}">href="<c:url value="/user-block" />"</c:if>>
                        <div class="shadow-2xl w-[300px] h-[200px] rounded-[15px]">
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" class="w-[40%] mx-auto mt-[10px]" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M18 9v3m0 0v3m0-3h3m-3 0h-3m-2-5a4 4 0 11-8 0 4 4 0 018 0zM3 20a6 6 0 0112 0v1H3v-1z" />
                                </svg>
                            </div>


                            <div>
                                <h1 class="text-center mt-[20px] font-bold text-green-500 text-[25px]" >My Groups</h1>
                            </div>
                        </div>
                    </a>


                    <!--                    MEMBER OF-->
                        <a <c:if test="${currentUser.active==1}">href="<c:url value="/member-of" />"</c:if> <c:if test="${currentUser.active==0}">href="<c:url value="/user-block" />"</c:if>>
                        <div class="shadow-2xl w-[300px] h-[200px] rounded-[15px]">
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" class="w-[40%] mx-auto mt-[10px]" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M8 14v3m4-3v3m4-3v3M3 21h18M3 10h18M3 7l9-4 9 4M4 10h16v11H4V10z" />
                                </svg>
                            </div>


                            <div>
                                <h1 class="text-center mt-[20px] font-bold text-green-500 text-[25px]" >Member Of</h1>
                            </div>
                        </div>
                    </a>


                    <!--                    Message OF-->
                        <a <c:if test="${currentUser.active==1}">href="<c:url value="/chat-group" />"</c:if> <c:if test="${currentUser.active==0}">href="<c:url value="/user-block" />"</c:if>>
                    <div class="shadow-2xl w-[300px] h-[200px] rounded-[15px]">
                        <div>
                            
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-[40%] mx-auto mt-[10px]">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M7.5 8.25h9m-9 3H12m-9.75 1.51c0 1.6 1.123 2.994 2.707 3.227 1.129.166 2.27.293 3.423.379.35.026.67.21.865.501L12 21l2.755-4.133a1.14 1.14 0 01.865-.501 48.172 48.172 0 003.423-.379c1.584-.233 2.707-1.626 2.707-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0012 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018z" />
                            </svg>

                        </div>


                        <div>
                            <h1 class="text-center mt-[20px] font-bold text-green-500 text-[25px]" >Chat group</h1>
                        </div>
                    </div>
                </a>

            </div>
        </div>

    </body>
</html>



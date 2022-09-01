<%-- 
    Document   : viewSpending
    Created on : Aug 4, 2022, 12:48:02 PM
    Author     : DucND
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<h1 class="text-center text-[56px] font-bold mt-[40px]">MY SPENDING  </h1>

<div class="container">
    <!--    search stats-->
    <div class="mt-[50px] w-[1100px] mx-auto flex">
        <form class="flex gap-[20px]">
            <div class="">
                <label>From date: </label>
                <input type="text" placeholder="yyyy-MM-dd" class="w-[240px] border-green-500 border-[2px] rounded-[25px]" name="fromDate" />
            </div>
            <div class="">
                <label>From date: </label>
                <input type="text" placeholder="yyyy-MM-dd" class="w-[240px] border-green-500 border-[2px] rounded-[25px]" name="toDate" />
            </div>

            <div class="">
                <button type="submit" class="w-[140px] h-[46px] bg-pink-500 font-bold rounded-[25px] ml-[20px]">Search</button>
            </div>
        </form>

    </div>

    <!--    chart js-->

    <div class="w-[900px] h-[400px] mx-auto flex mt-[80px] justify-center">
        <div>
            <canvas id="myChart" class="w-[400px]"></canvas>
        </div>

        <div class="ml-auto mt-[80px]">
            <table class="border-collapse border-green-500 border-[2px]  w-[400px] h-[200px] ">
                <thead>
                    <tr class="border-black border-[2px] text-center">
                        <th class="border-green-500 border-[2px]">Time</th>
                        <th class="border-green-500 border-[2px]">Spending Money</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${statsSpending}" var="s">
                        <tr class="border-green-500 border-[2px] text-pink-500 font-bold text-center">
                            <td class="border-green-500 border-[2px]">${s[0]}</td>
                            <td class="border-green-500 border-[2px]"><fmt:formatNumber type = "number" value = "${s[1]}" /> VND</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


    <!--    Search -->
    <div class="mt-[50px] w-[800px] mx-auto flex">
        <form class="flex">
            <div class="">
                <input type="text" placeholder="Enter keyword" class="w-[240px] border-green-500 border-[2px] rounded-[25px]" name="spendingName" />
            </div>

            <div class="">
                <button type="submit" class="w-[140px] h-[46px] bg-pink-500 font-bold rounded-[25px] ml-[20px]">Search</button>
            </div>
        </form>

    </div>
    <!--    pagination-->

    <div class="flex">
        <ul class="pagination ml-[24%] mt-[40px]">

            <c:forEach begin="1" end="${Math.ceil(countSpending/pageSize)}" var="i">
                <li class="page-item"><a class="page-link" href="<c:url value="/view-income"/>/?page=${i}&pageSize=${pageSize}">${i}</a></li>
                </c:forEach>

        </ul>

        <h1 class="mt-[50px] font-bold font-[20px] ml-[23%]">So san pham: </h1>
        <form class="flex">
            <select class="ml-auto mr-[10%] h-[40px] mt-[40px] w-[190px] border-green-500 border-[2px] rounded-[25px]" name="pageSize">
                <option value=2>2</option>
                <option value=4>4</option>
                <option value=6>6</option>
            </select>

            <button type="submit" class="mt-[40px] font-bold font-[20px] w-[80px] h-[40px] bg-pink-500 rounded-[25px] mr-[20px]">OK</button>
        </form>
    </div>



    <c:if test="${spendings!=null}">
        <c:forEach items="${spendings}" var="spending">
            <div class="flex" id="spending${spending.id}">


                <div class="w-[800px] h-[70px] shadow-2xl flex mx-auto mt-[100px] rounded-[10px] bg-gradient-to-r from-pink-500 to-blue-400">
                    <svg xmlns="http://www.w3.org/2000/svg" class="w-[60px] h-[60px] my-auto" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M4 4a2 2 0 00-2 2v4a2 2 0 002 2V6h10a2 2 0 00-2-2H4zm2 6a2 2 0 012-2h8a2 2 0 012 2v4a2 2 0 01-2 2H8a2 2 0 01-2-2v-4zm6 4a2 2 0 100-4 2 2 0 000 4z" clip-rule="evenodd" />
                    </svg>
                    <div class="my-auto ml-[100px]">
                        <h1 class="font-bold text-[17px]">${spending.purpose}</h1>
                        <h1 class="text-white">${spending.time}</h1>
                    </div>
                    <h1 class="my-auto ml-auto mr-[20px] font-bold text-[20px]">+<fmt:formatNumber type = "number" value = "${spending.money}" /> VND</h1>
                </div>

                <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mt-[100px] mr-[200px] " onclick="deleteSpending(${spending.id})">


                    <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z" clip-rule="evenodd" />
                    </svg>
                </button>

            </div>

        </c:forEach>
    </c:if>



    <!--    <div class="w-[800px] h-[70px] shadow-2xl flex mx-auto mt-[100px] rounded-[10px] bg-gradient-to-r from-pink-500 to-blue-400">
            <svg xmlns="http://www.w3.org/2000/svg" class="w-[60px] h-[60px] my-auto" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M4 4a2 2 0 00-2 2v4a2 2 0 002 2V6h10a2 2 0 00-2-2H4zm2 6a2 2 0 012-2h8a2 2 0 012 2v4a2 2 0 01-2 2H8a2 2 0 01-2-2v-4zm6 4a2 2 0 100-4 2 2 0 000 4z" clip-rule="evenodd" />
            </svg>
            <div class="my-auto ml-[100px]">
                <h1>My tile</h1>
                <h1>DMY</h1>
            </div>
            <h1 class="my-auto ml-auto mr-[20px]">Money</h1>
        </div>-->
</div>

<script src="<c:url value="/js/ChartJS.js" />"></script>
<script>

                let spendingLabels = [];
                let spendingData = [];

    <c:forEach items="${statsSpending}" var="s">
                spendingLabels.push('${s[0]}')
                spendingData.push(${s[1]})
    </c:forEach>

                window.onload = function () {
                    incomeChart("myChart", spendingLabels, spendingData)
                }
</script>

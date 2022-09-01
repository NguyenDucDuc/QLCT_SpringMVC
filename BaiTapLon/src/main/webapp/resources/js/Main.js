/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function loadIncomeTemps() {
    fetch(`/BaiTapLon/api/incomeTemp/2349`).then(function (res) {
        return res.json();
    }).then(function (data) {
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            
                <div class="flex  w-[1200px] h-[70px] mx-auto justify-center gap-[40px] mt-[70px]">
       
            <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mt-[100px] ml-[50px] ">


                <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                    <path stroke-linecap="round" stroke-linejoin="round" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
                </svg>
            </button>

        <div class="w-[700px] h-[70px] shadow-2xl flex mt-[100px] rounded-[10px] bg-gradient-to-r from-pink-500 to-violet-500">

            <svg xmlns="http://www.w3.org/2000/svg" class="w-[60px] h-[60px] my-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                <path stroke-linecap="round" stroke-linejoin="round" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
            </svg>
            <div class="my-auto ml-[100px]">
                <h1 class="font-bold text-[25px]">${data.purpose}</h1>
                <h1 class="text-white">${data.time}</h1>
            </div>
            <h1 class="my-auto ml-auto mr-[20px] font-bold text-[20px]">+<fmt:formatNumber type = "number" value = "${data.money}" /> VND</h1>
        </div>

            <button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mt-[100px] ">
                
                <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z" clip-rule="evenodd" />
                </svg>
            </button>
    </div>
            
            `
        }

    })
}

function deleteIncomeTemp(id) {
    fetch(`/BaiTapLon/api/incomeTemp/${id}`, {
        method: "delete"
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let row = document.getElementById(`incomeTemp${id}`)
        row.style.display = "none"
    })
}

function addIncomeGroup(userId, groupId, money, purpose, time, id) {



    fetch(`/BaiTapLon/api/incomeGroup/`, {
        method: "post",
        body: JSON.stringify({
            "userId": userId,
            "groupId": groupId,
            "purpose": purpose,
            "time": time,
            "money": money
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let row = document.getElementById(`incomeTemp${id}`)
        row.style.display = "none"
    })

    fetch(`/BaiTapLon/api/incomeTemp/${id}`, {
        method: "delete"
    })
}


function deleteIncome(id) {
    fetch(`/BaiTapLon/api/deleteIncome/${id}`, {
        method: "delete"
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let row = document.getElementById(`income${id}`)
        row.style.display = "none"
    })
}

function deleteSpending(id) {
    fetch(`/BaiTapLon/api/deleteSpending/${id}`, {
        method: "delete"
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let row = document.getElementById(`spending${id}`)
        row.style.display = "none"
    })
}


function lockUser(id) {
    fetch(`/BaiTapLon/api/updateUser/${id}`, {
        method: "put"
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let button = document.getElementById(`buttonuser${id}`)
        button.innerHTML = `<button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mb-[100px] mr-[200px]" onclick="unlockUser(${id})" id="buttonuser${id}">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M10 2a5 5 0 00-5 5v2a2 2 0 00-2 2v5a2 2 0 002 2h10a2 2 0 002-2v-5a2 2 0 00-2-2H7V7a3 3 0 015.905-.75 1 1 0 001.937-.5A5.002 5.002 0 0010 2z" />
                </svg>
            </button>`
    })
}


function unlockUser(id) {
    fetch(`/BaiTapLon/api/unlockUser/${id}`, {
        method: "put"
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let button = document.getElementById(`buttonuser${id}`)
        button.innerHTML = `<button class="bg-gradient-to-r from-cyan-500 to-blue-500 w-[150px] rounded-[10px] h-[70px] shadow-2xl mb-[100px] mr-[200px] " onclick="lockUser(${id})" id="buttonuser${id}">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-[50px] w-[50px] mx-auto" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z" clip-rule="evenodd" />
                </svg>
            </button>`
    })
}

function addMessage(userId, groupId) {
    let content = document.getElementById("inputText").value
    fetch(`/BaiTapLon/api/addMessage/`, {
        method: "post",
        body: JSON.stringify({
            "user_id": userId,
            "group_id": groupId,
            "content": content,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {

    })

}







//CHAT REAL TIME
//var username = prompt("Ho ten: ")
var websocket = new WebSocket("ws://localhost:5000")
websocket.onopen = function (message) {
    processOpen(message)
}
websocket.onmessage = function (message) {
    processMessage(message)
}
websocket.onclose = function (message) {
    processClose(message)
}
websocket.onerror = function (message) {
    processError(message)
}


function processOpen(message) {
    let divMessage = document.getElementById("content")
//    divMessage.innerHTML += `<h1>server connected</h1>`
//        content.value += "server connected\n"
//        content.value += username + " da tham gia !\n"
}
function sendData(userId, groupId) {

//    var mes = username + ": " + inputText.value
    let content = document.getElementById("inputText").value
    let username = document.getElementById("username").innerText
    let avatar = document.getElementById("avatar").innerText
    
    if (typeof websocket != "undefined" && websocket.readyState == WebSocket.OPEN) {
        websocket.send(content+"!"+username+"!"+avatar)
        inputText.value = ""
    }



    fetch(`/BaiTapLon/api/addMessage/`, {
        method: "post",
        body: JSON.stringify({
            "user_id": userId,
            "group_id": groupId,
            "content": content,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {

    })

}
function processMessage(message) {
    let divMessage = document.getElementById("content")
    console.log(message.data)
    const mes = message.data.split("!")[0]
    const username = message.data.split("!")[1]
    const avatar = message.data.split("!")[2]
//    let avatar = document.getElementById("currentUser").innerText
//    console.log(currentUser)


//        divMessage.innerHTML += message.data
    divMessage.innerHTML += `<div class="flex mt-[30px] ml-[70px]">
            
            ${avatar ? `<img src="${avatar}" class="w-[50px] h-[50px] rounded-[50%] mr-0 mt-[3px]" />` : `<img src="https://res.cloudinary.com/djbju13al/image/upload/v1659513080/wpzmkfgvjf1hjrh4iy3c.jpg" class="w-[50px] h-[50px] rounded-[50%] mr-0 mt-[3px]" />` }
            <div>
                <h1 class="font-bold ml-[20px] " >${username}</h1>
                <h1 class="bg-pink-500 w-[auto] h-[40px] mr-auto ml-[20px] rounded-[15px]"><span class=" px-[15px] py-[15px] ">${mes}</span></h1>
            </div>
        </div>`
}
function processClose(message) {
    content.value += username + " da roi phong !\n"
}
function processError() {
    content.value += "Da xay ra loi\n"
}
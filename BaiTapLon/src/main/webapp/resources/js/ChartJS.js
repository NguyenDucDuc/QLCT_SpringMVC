/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function generateColor(){
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r},${g},${b})`
}


function incomeChart(id, incomeLabels=[], incomeData=[] ) {
    
    let colors = []
    for (let i = 0; i< incomeData.length; i++)
        colors.push(generateColor())
    
    const data = {
        labels: incomeLabels,
        datasets: [{
                label: 'My First Dataset',
                data: incomeData,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'doughnut',
        data: data,
    };
    
    let c = document.getElementById(id).getContext("2d")
    new Chart(c, config)

}


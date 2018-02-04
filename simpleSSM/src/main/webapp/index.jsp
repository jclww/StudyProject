
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chart</title>
    <style>
        #canvas{
            width: 200px;
            height: 200px;
        }
        .box{
            width: 800px;
            height: 800px;
        }
    </style>
</head>
<body>
<div class="box">
    <canvas id="canvas" style="display: block;"></canvas>
    <button id="randomizeData">asada</button>
</div>


</body>
<%--<spring.script src="/js/chart.js"></spring.script>--%>
<spring.script src="/js/Chart.bundle.min.js"></spring.script>
        <spring.script src="/js/utils.js"></spring.script>
<%--<spring.script src="https://cdn.bootcss.com/Chart.js/2.5.0/Chart.bundle.min.js"></spring.script>--%>
<spring.script>
    var lineChartData = {
        labels: ["2017-07-31 17:50:30", "2017-07-31 17:50:30", "2017-07-31 17:50:30", "2017-07-31 17:50:30", "2017-07-31 17:50:30", "2017-07-31 17:50:30", "2017-07-31 17:50:30"],
        datasets: [{
            label: "My First dataset",
            borderColor: 'rgb(255, 99, 132)',
            backgroundColor: 'rgb(255, 99, 132)',
            fill: false,
            data: [
                1,2,3,4,5,6,7
            ],
            yAxisID: "y-axis-1",
        }, {
            label: "My Second dataset",
            borderColor: 'rgb(54, 162, 235)',
            backgroundColor: 'rgb(54, 162, 235)',
            fill: false,
            data: [
                40,-20,30,50,50,160,30
            ],
            yAxisID: "y-axis-2"
        }]
    };

    window.onload = function() {
        var ctx = document.getElementById("canvas").getContext("2d");
        window.myLine = Chart.Line(ctx, {
            data: lineChartData,
            options: {
                responsive: true,
                hoverMode: 'index',
                stacked: false,
                title:{
                    display: true,
                    text:'Chart.js Line Chart - Multi Axis'
                },
                scales: {
                    yAxes: [{
                        type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                        display: true,
                        position: "left",
                        id: "y-axis-1",
                    }, {
                        type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                        display: true,
                        position: "right",
                        id: "y-axis-2",

                        // grid line settings
                        gridLines: {
                            drawOnChartArea: false, // only want the grid lines for one axis to show up
                        },
                    }],
                }
            }
        });
    };

    document.getElementById('randomizeData').addEventListener('click', function() {
        lineChartData.datasets.forEach(function(dataset) {
            dataset.data = dataset.data.map(function() {
                return randomScalingFactor();
            });
        });

        window.myLine.update();
    });
</spring.script>
</html>

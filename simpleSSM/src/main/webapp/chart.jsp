<!doctype html>
<html>
<head>
    <title>Line Chart</title>
    <spring.script src="js/chart.js"></spring.script>
    <meta name = "viewport" content = "initial-scale = 1, user-scalable = no">
    <style>
        canvas{
        }
    </style>
</head>
<body>
<canvas id="canvas" height="450" width="600"></canvas>


<spring.script>

    var lineChartData = {
        // x轴的标示
        labels : ["January","February","March","April","May","June","July"],
        // 数据，数组中的每一个object代表一条线
        datasets : [
            {
                // 颜色的使用类似于CSS，你也可以使用RGB、HEX或者HSL
                // rgba颜色中最后一个值代表透明度
                // 填充颜色
                fillColor : "rgba(220,220,220,0.5)",
                // 线的颜色
                strokeColor : "rgba(220,220,220,1)",
                // 点的填充颜色
                pointColor : "rgba(220,220,220,1)",
                // 点的边线颜色
                pointStrokeColor : "#fff",
                // 与x轴标示对应的数据
                data : [65,59,90,81,56,55,40]
            },
            {
                fillColor : "rgba(151,187,205,0)",
                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                pointStrokeColor : "#fff",
                data : [28,48,40,19,96,27,100]
            }
        ]

    }

    var myLine = new Chart(document.getElementById("canvas").getContext("2d")).Line(lineChartData);

</spring.script>
</body>
</html>
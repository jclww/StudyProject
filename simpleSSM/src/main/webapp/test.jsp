<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" >
    <spring.script src="js/jquery.min.js"></spring.script>
    <spring.script src="js/bootstrap.min.js"></spring.script>
    <spring.script src="js/bootstrap-datetimepicker.min.js"></spring.script>
    <spring.script src="js/locales/bootstrap-datetimepicker.fr.js"></spring.script>
    <style>
        #top-40{
            height: 40px;
        }
    </style>
</head>
<body>
<div class="container">
    <div id="top-40">

    </div>
    <div class="row" >
        <div class="col-sm-2">
            <div class="btn-group btn-group-lg col-sm-12">
                <a id="modal-196262" class="btn btn-default"  href="#modal-container-196262" role="button" class="btn" data-toggle="modal">添加商品</a>
            </div>
            <div class="btn-group btn-group-lg col-sm-12">
                <button type="button" class="btn btn-default" onclick="refresh()">查询所有</button>
            </div>
        </div>
        <div class="col-sm-3">
            <p class="text-center">商品名称查找</p>

            <form action="selectByName">
                <div class="col-sm-12">
                    <div class="input-group">
                        <input type="text" name="name" class="form-control">
                        <span class="input-group-btn">
                        <input class="btn btn-default" type="submit" onclick="selectByName(this)" value="查询"></input>
                    </span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-sm-3">
            <p class="text-center">商品编号查找</p>

            <form action="selectBySn">
                <div class="col-sm-12">
                    <div class="input-group">
                        <input type="text" name="sn" class="form-control">
                        <span class="input-group-btn">
                        <input id="sa" class="btn btn-default" type="submit" value="查询"></input>
                    </span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-sm-4">
            <p class="text-center">商品发布时间查找</p>

            <form action="selectByTime">
                <div class="col-md-10">
                    <div class="form-group ">
                        <label for="dtp_input1" class="col-md-2 control-label">起始</label>
                        <div class="input-group date form_datetime col-md-10" data-date="2017-07-10T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                            <input name="begin" id="dtp_input1" class="form-control" size="16" value="" readonly="" type="text">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dtp_input2" class="col-md-2 control-label">终止</label>
                        <div class="input-group date form_datetime col-md-10" data-date="2017-07-10T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input2">
                            <input name="end" id="dtp_input2" class="form-control" size="16" value="" readonly="" type="text">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <input type="submit" style="height:50px; margin-top:14px;" value="查询"/>
                </div>
            </form>
        </div>
    </div>
    <table class="table table-bordered">
        <div  class="col-sm-12">
        <caption>商品信息列表</caption>
        <thead>
        <tr>
            <th>名称</th>
            <th>编号</th>
            <th>类型</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="goodsList">
        <tr class="goods">
            <td>Tanmay</td>
            <td class="goodId">Bangalore</td>
            <td>560001</td>
            <td>2017-07-10 13:04:23</td>
            <td><a onclick="mod(this)">修改</a>&nbsp;&nbsp;<a onclick="del(this)">删除</a></td>
        </tr>

        </tbody>

        </div>

    </table>
    <div id="foot" class="col-sm-12">
        <ul class="pagination">
            <li><a href="#">&laquo;</a></li>
            <li class="active"><a addr="selectAllGoods" onclick="refreshAllGoods(this)">1</a></li>
            <li><a addr="selectAllGoods" onclick="refreshAllGoods(this)">2</a></li>
            <li><a addr="selectAllGoods" onclick="refreshAllGoods(this)">3</a></li>
            <li><a addr="selectAllGoods" onclick="refreshAllGoods(this)">4</a></li>
            <li><a addr="selectAllGoods" onclick="refreshAllGoods(this)">5</a></li>
            <li><a addr="selectAllGoods" onclick="refreshAllGoods(this)">6</a></li>
            <li><a addr="selectAllGoods" onclick="refreshAllGoods(this)">7</a></li>
            <li><a href="#">&raquo;</a></li>
        </ul>

    </div>
</div>
<spring.script type="text/javascript">
    function mod(va) {
        var goodsid = $(va).parent().prev().prev().prev().html();
        location.href = "modify?goodsId="+goodsid;
    }
    function del(va) {
        if (confirm("你确定删除吗？")) {
            var goodssn = $(va).parent().prev().prev().prev().html();
            var sn = {goodsSn:goodssn};
            request(sn,"POST","deleteBySn",deleteReturn);
        }
        else {
        }
    }
    function deleteReturn(data) {
        alert(data)
    }
</spring.script>
<spring.script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</spring.script>
<spring.script type="text/javascript">
    Date.prototype.format = function(format) {
        var date = {
            "M+": this.getMonth() + 1,
            "d+": this.getDate(),
            "h+": this.getHours(),
            "m+": this.getMinutes(),
            "s+": this.getSeconds(),
            "q+": Math.floor((this.getMonth() + 3) / 3),
            "S+": this.getMilliseconds()
        };
        if (/(y+)/i.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
        }
        for (var k in date) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1
                    ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
            }
        }
        return format;
    }
    function selectByName(thiz) {

    }
    function refresh() {
        var str = {
            page: 0}
        request(str,"GET","selectAllGoods",refreshResultList)
    }
    function refreshAllGoods(m) {
        $(".active").removeClass("active")
        $(m).parent().addClass("active")


        var page = $(m).html();
        var action = $(m).attr("addr");
        var obj = new Object();
        obj.page = page;
        var str = {
            page: page}
        request(str,"GET",action,refreshResultList)

    }
    function createGoods(name,sn,type,time) {
        var goods = "<tr class='goods'>"+
            "<td>" +name+
            "</td>"+
            "<td class='goodsn'>" +sn+
            "</td>"+
            "<td>" +type+
            "</td>"+
            "<td>" +time+
            "</td>"+
        "<td><a onclick='mod(this)'>修改</a>&nbsp;&nbsp;" +
            "<a onclick='del(this)'>删除</a></td></tr>"
        return goods;
    }
    function refreshResultList (data) {
        var goodsList = eval("(" + data + ")");
        var list = $(".container").find("#goodsList");
        list.html("");
        if (data.length > 0) {
            $(goodsList).each(function(index, goods) {
                var timestamp = goods.create_date;
                var newDate = new Date();
                newDate.setTime(timestamp);
                var time = newDate.format('yyyy-MM-dd h:m:s');
                var goodsDiv = createGoods(goods.name, goods.sn, goods.product_type,time)
                list.append(goodsDiv);
            });
        } else {
            list.html("<h3>暂无商品！</h3>");
        }
    }
    function request(object,method,methodURL,successFunction){
        $.ajax({
            type: method,
//            dataType: 'json',
//            contentType: 'application/json;charset=utf-8',
            url: methodURL,
            data: object,
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status+"\r\n"+XMLHttpRequest.readyState+"\r\n"+textStatus);
            },
            success: successFunction
        });
//        $.ajax({
//            type: method,
//            datatype:"json",
//            contentType: "application/json;charset=utf-8",
//            url:methodURL,
//            data:object,
//            error: function(XMLHttpRequest, textStatus, errorThrown) {
//                debugger;
//                alert(XMLHttpRequest.status+"\r\n"+XMLHttpRequest.readyState+"\r\n"+textStatus);
//            },
//            success: successFunction
//        });
    }
</spring.script>
<div class="datetimepicker datetimepicker-dropdown-bottom-right dropdown-menu" style="left: 640.5px; z-index: 1010; display: none; top: 85px;"><div class="datetimepicker-minutes" style="display: none;"><table class=" table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">16 September 1979</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><fieldset class="minute"><legend>AM</legend><span class="minute">5:00</span><span class="minute">5:05</span><span class="minute">5:10</span><span class="minute">5:15</span><span class="minute">5:20</span><span class="minute active">5:25</span><span class="minute">5:30</span><span class="minute">5:35</span><span class="minute">5:40</span><span class="minute">5:45</span><span class="minute">5:50</span><span class="minute">5:55</span></fieldset></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-hours" style="display: none;"><table class=" table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">16 September 1979</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><fieldset class="hour"><legend>AM</legend><span class="hour hour_am">12</span><span class="hour hour_am">1</span><span class="hour hour_am">2</span><span class="hour hour_am">3</span><span class="hour hour_am">4</span><span class="hour active hour_am">5</span><span class="hour hour_am">6</span><span class="hour hour_am">7</span><span class="hour hour_am">8</span><span class="hour hour_am">9</span><span class="hour hour_am">10</span><span class="hour hour_am">11</span></fieldset><fieldset class="hour"><legend>PM</legend><span class="hour hour_pm">12</span><span class="hour hour_pm">1</span><span class="hour hour_pm">2</span><span class="hour hour_pm">3</span><span class="hour hour_pm">4</span><span class="hour hour_pm">5</span><span class="hour hour_pm">6</span><span class="hour hour_pm">7</span><span class="hour hour_pm">8</span><span class="hour hour_pm">9</span><span class="hour hour_pm">10</span><span class="hour hour_pm">11</span></fieldset></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-days" style="display: block;"><table class=" table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">September 1979</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr><tr><th class="dow">Mo</th><th class="dow">Tu</th><th class="dow">We</th><th class="dow">Th</th><th class="dow">Fr</th><th class="dow">Sa</th><th class="dow">Su</th></tr></thead><tbody><tr><td class="day old">27</td><td class="day old">28</td><td class="day old">29</td><td class="day old">30</td><td class="day old">31</td><td class="day">1</td><td class="day">2</td></tr><tr><td class="day">3</td><td class="day">4</td><td class="day">5</td><td class="day">6</td><td class="day">7</td><td class="day">8</td><td class="day">9</td></tr><tr><td class="day">10</td><td class="day">11</td><td class="day">12</td><td class="day">13</td><td class="day">14</td><td class="day">15</td><td class="day active">16</td></tr><tr><td class="day">17</td><td class="day">18</td><td class="day">19</td><td class="day">20</td><td class="day">21</td><td class="day">22</td><td class="day">23</td></tr><tr><td class="day">24</td><td class="day">25</td><td class="day">26</td><td class="day">27</td><td class="day">28</td><td class="day">29</td><td class="day">30</td></tr><tr><td class="day new">1</td><td class="day new">2</td><td class="day new">3</td><td class="day new">4</td><td class="day new">5</td><td class="day new">6</td><td class="day new">7</td></tr></tbody><tfoot><tr><th colspan="7" class="today">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-months" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">1979</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="month">Jan</span><span class="month">Feb</span><span class="month">Mar</span><span class="month">Apr</span><span class="month">May</span><span class="month">Jun</span><span class="month">Jul</span><span class="month">Aug</span><span class="month active">Sep</span><span class="month">Oct</span><span class="month">Nov</span><span class="month">Dec</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-years" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">1970-1979</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="year ">1969</span><span class="year">1970</span><span class="year">1971</span><span class="year">1972</span><span class="year">1973</span><span class="year">1974</span><span class="year">1975</span><span class="year">1976</span><span class="year">1977</span><span class="year">1978</span><span class="year active">1979</span><span class="year ">1980</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Today</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div></div>
<div class="datetimepicker datetimepicker-dropdown-bottom-right dropdown-menu" style="left: 640.5px; z-index: 1020; display: none; top: 134px;"><div class="datetimepicker-minutes" style="display: none;"><table class=" table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">10 Juillet 2017</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="minute active">14:00</span><span class="minute">14:05</span><span class="minute">14:10</span><span class="minute">14:15</span><span class="minute">14:20</span><span class="minute">14:25</span><span class="minute">14:30</span><span class="minute">14:35</span><span class="minute">14:40</span><span class="minute">14:45</span><span class="minute">14:50</span><span class="minute">14:55</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-hours" style="display: none;"><table class=" table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">10 Juillet 2017</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="hour">0:00</span><span class="hour">1:00</span><span class="hour">2:00</span><span class="hour">3:00</span><span class="hour">4:00</span><span class="hour">5:00</span><span class="hour">6:00</span><span class="hour">7:00</span><span class="hour">8:00</span><span class="hour">9:00</span><span class="hour">10:00</span><span class="hour">11:00</span><span class="hour">12:00</span><span class="hour">13:00</span><span class="hour active">14:00</span><span class="hour">15:00</span><span class="hour">16:00</span><span class="hour">17:00</span><span class="hour">18:00</span><span class="hour">19:00</span><span class="hour">20:00</span><span class="hour">21:00</span><span class="hour">22:00</span><span class="hour">23:00</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-days" style="display: block;"><table class=" table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">Juillet 2017</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr><tr><th class="dow">L</th><th class="dow">Ma</th><th class="dow">Me</th><th class="dow">J</th><th class="dow">V</th><th class="dow">S</th><th class="dow">D</th></tr></thead><tbody><tr><td class="day old">26</td><td class="day old">27</td><td class="day old">28</td><td class="day old">29</td><td class="day old">30</td><td class="day">1</td><td class="day">2</td></tr><tr><td class="day">3</td><td class="day">4</td><td class="day">5</td><td class="day">6</td><td class="day">7</td><td class="day">8</td><td class="day">9</td></tr><tr><td class="day today active">10</td><td class="day">11</td><td class="day">12</td><td class="day">13</td><td class="day">14</td><td class="day">15</td><td class="day">16</td></tr><tr><td class="day">17</td><td class="day">18</td><td class="day">19</td><td class="day">20</td><td class="day">21</td><td class="day">22</td><td class="day">23</td></tr><tr><td class="day">24</td><td class="day">25</td><td class="day">26</td><td class="day">27</td><td class="day">28</td><td class="day">29</td><td class="day">30</td></tr><tr><td class="day">31</td><td class="day new">1</td><td class="day new">2</td><td class="day new">3</td><td class="day new">4</td><td class="day new">5</td><td class="day new">6</td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-months" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">2017</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="month">Jan</span><span class="month">Fev</span><span class="month">Mar</span><span class="month">Avr</span><span class="month">Mai</span><span class="month">Jui</span><span class="month active">Jul</span><span class="month">Aou</span><span class="month">Sep</span><span class="month">Oct</span><span class="month">Nov</span><span class="month">Dec</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-years" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">2010-2019</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="year ">2009</span><span class="year">2010</span><span class="year">2011</span><span class="year">2012</span><span class="year">2013</span><span class="year">2014</span><span class="year">2015</span><span class="year">2016</span><span class="year active">2017</span><span class="year">2018</span><span class="year">2019</span><span class="year ">2020</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div></div>
<div class="datetimepicker datetimepicker-dropdown-bottom-right dropdown-menu" style="left: 649px; z-index: 1030;"><div class="datetimepicker-minutes" style="display: none;"><table class=" table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">10 Juillet 2017</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="minute active">14:00</span><span class="minute">14:05</span><span class="minute">14:10</span><span class="minute">14:15</span><span class="minute">14:20</span><span class="minute">14:25</span><span class="minute">14:30</span><span class="minute">14:35</span><span class="minute">14:40</span><span class="minute">14:45</span><span class="minute">14:50</span><span class="minute">14:55</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-hours" style="display: block;"><table class=" table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">10 Juillet 2017</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="hour">0:00</span><span class="hour">1:00</span><span class="hour">2:00</span><span class="hour">3:00</span><span class="hour">4:00</span><span class="hour">5:00</span><span class="hour">6:00</span><span class="hour">7:00</span><span class="hour">8:00</span><span class="hour">9:00</span><span class="hour">10:00</span><span class="hour">11:00</span><span class="hour">12:00</span><span class="hour">13:00</span><span class="hour active">14:00</span><span class="hour">15:00</span><span class="hour">16:00</span><span class="hour">17:00</span><span class="hour">18:00</span><span class="hour">19:00</span><span class="hour">20:00</span><span class="hour">21:00</span><span class="hour">22:00</span><span class="hour">23:00</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-days" style="display: none;"><table class=" table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">Juillet 2017</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr><tr><th class="dow">L</th><th class="dow">Ma</th><th class="dow">Me</th><th class="dow">J</th><th class="dow">V</th><th class="dow">S</th><th class="dow">D</th></tr></thead><tbody><tr><td class="day old">26</td><td class="day old">27</td><td class="day old">28</td><td class="day old">29</td><td class="day old">30</td><td class="day">1</td><td class="day">2</td></tr><tr><td class="day">3</td><td class="day">4</td><td class="day">5</td><td class="day">6</td><td class="day">7</td><td class="day">8</td><td class="day">9</td></tr><tr><td class="day today active">10</td><td class="day">11</td><td class="day">12</td><td class="day">13</td><td class="day">14</td><td class="day">15</td><td class="day">16</td></tr><tr><td class="day">17</td><td class="day">18</td><td class="day">19</td><td class="day">20</td><td class="day">21</td><td class="day">22</td><td class="day">23</td></tr><tr><td class="day">24</td><td class="day">25</td><td class="day">26</td><td class="day">27</td><td class="day">28</td><td class="day">29</td><td class="day">30</td></tr><tr><td class="day">31</td><td class="day new">1</td><td class="day new">2</td><td class="day new">3</td><td class="day new">4</td><td class="day new">5</td><td class="day new">6</td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-months" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">2017</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="month">Jan</span><span class="month">Fev</span><span class="month">Mar</span><span class="month">Avr</span><span class="month">Mai</span><span class="month">Jui</span><span class="month active">Jul</span><span class="month">Aou</span><span class="month">Sep</span><span class="month">Oct</span><span class="month">Nov</span><span class="month">Dec</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div><div class="datetimepicker-years" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-left"></span> </th><th colspan="5" class="switch">2010-2019</th><th class="next" style="visibility: visible;"><span class="glyphicon glyphicon-arrow-right"></span> </th></tr></thead><tbody><tr><td colspan="7"><span class="year ">2009</span><span class="year">2010</span><span class="year">2011</span><span class="year">2012</span><span class="year">2013</span><span class="year">2014</span><span class="year">2015</span><span class="year">2016</span><span class="year active">2017</span><span class="year">2018</span><span class="year">2019</span><span class="year ">2020</span></td></tr></tbody><tfoot><tr><th colspan="7" class="today">Aujourd'hui</th></tr><tr><th colspan="7" class="clear" style="display: none;">Clear</th></tr></tfoot></table></div></div>
<div class="modal fade" id="modal-container-196262" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    添加商品
                </h4>
            </div>
            <div class="modal-body">

                <div >
                    <form class="bs-example bs-example-form" role="form" action="addGoods">
                        <div class="input-group">
                            <span class="input-group-addon">商&nbsp;&nbsp;品&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;称</span>
                            <input name="name" type="text" class="form-control">
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">创&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;建&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人</span>
                            <input name="create" type="text" class="form-control">
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">商品商城标语</span>
                            <input name="slogan" type="text" class="form-control">
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">商品商城编号</span>
                            <input name="shopId" type="text" class="form-control">
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">商品对应商户ID</span>
                            <input name="spuId" type="text" class="form-control">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">商&nbsp;&nbsp;品&nbsp;&nbsp;&nbsp;状&nbsp;&nbsp;态</span>
                            <select name="state">
                                <option value ="0">初始状态</option>
                                <option value ="1">已上架</option>
                                <option value ="2">已下架</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">商品是否置顶</span>
                            <select name="top">
                                <option value ="false">当前不置顶</option>
                                <option value ="true">当前置顶</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">商品是否有效</span>
                            <select name="valid">
                                <option value ="true">有效</option>
                                <option value ="false">无效</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">商&nbsp;&nbsp;品&nbsp;&nbsp;&nbsp;类&nbsp;&nbsp;型</span>
                            <select name="type">
                                <option value ="1">文本</option>
                                <option value ="2">流</option>
                                <option value ="3">图文</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon">商品审核状态</span>
                            <select name="reviewState">
                                <option value ="1">待处理</option>
                                <option value ="2">完成审核</option>
                            </select>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <input type="submit" class="btn btn-primary" value="添加"></input>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>

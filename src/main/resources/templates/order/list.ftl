<html>
<#include "../common/header.ftl">
<body>
<#--弹窗-->
<h1>
    有订单.....hh
</h1>
<h2>
    返回的内容:${crrateResult?default("null")}
</h2>
<div class="modal fade" id="mymodal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提醒
                </h4>
            </div>
            <div class="modal-body">
                你有新的订单
            </div>
            <div class="modal-footer">
                <button type="button" onclick="javascript:document.getElementById('notice').pause()" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
            </div>
        </div>
    </div>
</div>

<#--播放音乐-->
<audio id="notice" loop="loop">
    <source src="/sell/mp3/song.mp3" type="audio/mpeg" />
</audio>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket('ws://127.0.0.1:8080/sell/webSocket');
    }else {
        alert('该浏览器不支持websocket');
    }
    websocket.onopen = function (event) {
        console.log('建立连接')
    }
    websocket.onclose = function (event) {
        console.log('连接关闭')
    }
    websocket.onmessage = function (event) {
        console.log('收到消息:' + event.data);
        // 弹窗提醒, 播放音乐
        $('#mymodal').modal('show');
        document.getElementById('notice').play();

    }
    websocket.onerror = function (event) {
        alert('websocket通信发生错误!')
    }
    window.onbeforeunload = function (event) {
        websocket.close();
    }
</script>
</body>
</html>


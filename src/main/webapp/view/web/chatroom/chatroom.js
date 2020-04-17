document.getElementById("messages").scrollTop = document
		.getElementById("messages").scrollHeight;
var messagerecord = {
		
};
var websocket = null;
login();
$(".bottom-bar, .window-bar").hide();
function login(){
	//判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://192.168.1.8:9003/chat/group");
    }
    else {
        alert('当前浏览器 Not support websocket')
    }
    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        var data = JSON.parse(event.data);
        var type = data["type"];
        if(type == "notice"){
        	if($(".thread[ip=" + data.ip.replace(/\./g, '') + "]").length > 0){
        		return;
        	}
        	var html = '<div class="thread" ip="' + data.ip.replace(/\./g, '') + '">';
            html += '<div class="details">';
            html += '<div class="user-head online">';
            html += '<div class="talk-userimg">' + data.uname.substring(0, 1) + '</div>';
            html += '</div>';
            html += '<div class="user-name">' + data.uname + '</div>';
            html += '<div class="last-message">无消息</div>';
            html += '</div>';
            var d = new Date()
            html += '<div class="last new"></div>';
            html += '</div>';
            $(".conversations").append(html);
        }else if(type == "init"){
        	var users = data.users;
        	for (var i = 0; i < users.length; i++) {
        		var userItem = users[i];
        		var html = '<div class="thread" ip="' + userItem.ip.replace(/\./g, '') + '">';
                html += '<div class="details">';
                html += '<div class="user-head online">';
                html += '<div class="talk-userimg">' + userItem.name.substring(0, 1) + '</div>';
                html += '</div>';
                html += '<div class="user-name">' + userItem.name + '</div>';
                html += '<div class="last-message">无消息</div>';
                html += '</div>';
                var d = new Date()
                html += '<div class="last new"></div>';
                html += '</div>';
                $(".conversations").append(html);
			}
        }else{
        	var dataFrom = data.fromip.replace(/\./g, '');
        	if($(".thread[ip=" + dataFrom + "].active").length > 0){
        		var html = '<div class="message">';
                html += '<div class="user-head">';
                html += '<div class="talk-userimg">' + data.fromname.substring(0, 1) + '</div>';
                html += '</div>';
                html += '<div class="content">' + data.message + '</div>';
                html += '</div>';
                $(".messages").append(html);
        	}else{
        		$(".thread[ip=" + dataFrom + "] .last-message").text(data.message);
        	}
        	var record = messagerecord[dataFrom];
        	if(record){
        		record.push({"msg":data.message, "from":"other"});
        	}else{
        		record = [{"msg":data.message, "from":"other"}];
        		messagerecord[dataFrom] = record;
        	}
        }
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }
}
//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
	console.log(innerHTML)
}

//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}

//发送消息
function send() {
	var html = '<div class="message fromme">';
    html += ' <div class="user-head">';
    html += '<div class="talk-userimg mine">我</div>';
    html += '</div>';
    html += '<div class="content">' + $(".msg-input").val() + '</div>';
    html += '</div>';
    $(".messages").append(html);
    websocket.send($(".msg-input").val());
    var dataFrom = $(".thread.active").attr('ip');
    var record = messagerecord[dataFrom];
	if(record){
		record.push({"msg":$(".msg-input").val(), "from":"me"});
	}else{
		record = [{"msg":$(".msg-input").val(), "from":"me"}];
		messagerecord[dataFrom] = record;
	}
    $(".msg-input").val("");
}

$('.conversations').on('click', '.thread', function(){
	var userName = $(this).find('.user-name').text();
	$(this).addClass('active');
	$('.curname').text(userName);
	$(".top-bar .talk-userimg").text(userName.substring(0, 1));
	var ip = $(this).attr('ip');
	$(".bottom-bar, .window-bar").show();
	var record = messagerecord[ip];
	if(record){
		$("#messages").html('<div class="date-split">以前或更早以前</div>');
		for (var i = 0; i < record.length; i++) {
			var item = record[i];
			var from = item.from;
			if(from == "other"){
				var html = '<div class="message">';
                html += '<div class="user-head">';
                html += '<div class="talk-userimg">' + userName.substring(0, 1) + '</div>';
                html += '</div>';
                html += '<div class="content">' + item.msg + '</div>';
                html += '</div>';
                $(".messages").append(html);
			}else{
				var html = '<div class="message fromme">';
                html += '<div class="user-head">';
                html += '<div class="talk-userimg mine">我</div>';
                html += '</div>';
                html += '<div class="content">' + item.msg + '</div>';
                html += '</div>';
                $(".messages").append(html);
			}
		}
	}
	$(this).find('.last.new').remove();
});
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<script>
function ajaxChatRoomList(){
	$.ajax({
		url:"chatRoomList/"+$("#loggedId").val(),
	type:"get",
	dataType:"json",
	async:false,
	success:function(data){
		var HTMLOut="";
		for(var idx in data){
			HTMLOut+='<tr>';
			HTMLOut+='<td onclick="openChatRoom('+data[idx].masterName+')">'+data[idx].masterName+'</td></tr>';
		}
		$("ChatRoom").append(HTMLOut)
	}
	)};
	
		let websocket;
     
         //입장 버튼을 눌렀을 때 호출되는 함수
         function connect() {
             // 웹소켓 주소
             var wsUri = "ws://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/websocket/echo.do";
             // 소켓 객체 생성
             websocket = new WebSocket(wsUri);
             //웹 소켓에 이벤트가 발생했을 때 호출될 함수 등록
             websocket.onopen = onOpen;
             websocket.onmessage = onMessage;
             console.log(websocket.send);
         }
         
         //웹 소켓에 연결되었을 때 호출될 함수
         function onOpen() {
             // ENTER-CHAT 이라는 메세지를 보내어, Java Map에 session 추가
             const data = {
                    "roomId" : roomId,
                    "name" : "${loginUser}",
                 "message" : "ENTER-CHAT"
            };
            let jsonData = JSON.stringify(data);
             websocket.send(jsonData);
             console.log(websocket);
         }
         function openChatRoom(x){
        	 $("#ChatBox").css("display","");
        	 $.
         }
</script>
	<table id="ChatRoom">
	</table>
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
		crossorigin="anonymous">
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function checkId(){
	    	let id= $("#id").val()//id값이 "id"인 입력란의 값 저장
	    	$ajax({
	    		url : "member/idCheck", type:"post",
	    		dataType:{id:id},
	    		success: function(cnt){
	    			console.log(id);
	    			  if(cnt == 0){ //cnt가 1이 아니면(=0인 경우) -사용 가능한 아이디
	    				  $('.id_ok').css("display","inline-block");
	    			  	  $('.id_already').css("display","none");
	    			}else{ //cnt가 1인 경우 - 이미 존재하는 아이디
	    				$('.id_already').css("display","inline-block");
	    				$('.id_ok').css("display","none");
	    				alert("아이디를 다시 입력해주세요");
	    				$('#id').val('');
	    			}
	    		},
	    		error:function(){
	    			alert("에러");
	    		}
	    	});
	    };
    	
    
    </script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.id_ok{
color:#008000;
display: none;
}

.id_already{
color:#6A82FB; 
display: none;
}
</style>
</head>
<body>
<div>
	<p>회원가입 폼</p>
	<form id="fo" action="register" method="post">
	<table>
	<tr>
	<th><label for="id">아이디</label></th>
	<th><input type="text" name="id" id="id" oninput="checkId()">
	<span class ="id_ok">사용가능한 아이디입니다</span>
	<span class="id_already">누군가 이 아이디를 사용하고 있어요</span></th>
	<!-- id ajax 중복체크 -->
	</tr>
	<tr>
	<th>비밀번호 </th><th><input type="text" name="pw"></th>
	</tr>
	<tr>
	<th>주소 </th><th><input type="text" name="addr"></th>
	</tr>
	<tr>
	<th>이름 </th><th><input type="text" name="name"></th>
	</tr>
	<tr>
	<th>이메일 </th><th><input type="text" name="email"></th>
	</tr>
	<tr>
	<th><label><input type="radio" name="gender" value="1">남자</label></th>
	<th><label><input type="radio" name="gender" value="2">여자</label></th>
	</tr>
	<tr>
	<th>핸드폰번호 </th><th><input type="text" name="phNum"></th>
	</tr>
	<tr>
	<th>선호 카테고리 </th>
	<th><select name="per_cate">
		<option>신발</option>
		<option>옷</option>
		<option>전자제품</option>
		<option>가구</option>
		<option></option>
		
	</select></th>
	</tr>
	<tr><th span="2">
		<input type="submit" value="전송"></th></tr>
	</table>
	</form>
</div>

</body>
</html>
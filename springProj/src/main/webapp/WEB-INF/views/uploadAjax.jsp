<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<title>아작스를 통한 이미지 업로드</title>
<script type="text/javascript">
	$(function() {
		const sel_file = []
		
		$('#input_img').on("change", handleImgFileSelect)
		
		function handleImgFileSelect(e) {
			$(".img_wrap").html("")
			const files = e.target.files
			const fileArr = Array.prototype.slice.call(files)
			
			fileArr.forEach(function(f) {
				if(!f.type.match("image.*")) {
					alert('only img')
					return
				}
				
				sel_file.push(f)
				
				const reader = new FileReader()
				
				reader.onload = function(e) {
					const img_html = '<img src="' + e.target.result + '">'
					$(".img_wrap").append(img_html)
				}
				
				reader.readAsDataURL(f)
			})
		}
		
		$('#uploadBtn').on("click", function(e) {
			//jQuery를 이용하여 파일 업로드를 하기위해
			//formData  객체(가상의 form 태그) 이용.
			// 해당 객체에 필요한 파라미터를 담아서 전송함
			var formData = new FormData();
			// input 요소의 name 속성의 값이 uploadFile인 것을 찾아서
			// 자바스크립트의  inputFile 객체에 할당
			var inputFile = $("input[name='uploadFile']");
			// 첫번째 파일 객체 안에 업로드 할 이미지들이 있는데
			// 그 이미지 객체들을 files 객체에 할당
			var files = inputFile[0].files;

			for (var i = 0; i < files.length; i++) {
				formData.append("uploadFile", files[i])
			}

			console.log("files : " + files);

			$.ajax({
				url : "/uploadAjax",
				data : formData,
				type : "post",
				dataType : "json",
				success : function(res) {
					console.log("hello")
					console.log(res)
				},
				processData : false,
				contentType : false
			})
		});
	});
</script>

<style type="text/css">
	.img_wrap {
		width: 300px;
		margin-top: 50px;
		display: flex;
	}
	
	.img_wrap img {
		max-width: 100%;
	}
</style>
</head>
<body>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">아작스를 통한 이미지 업로드</h1>
		</div>
	</div>

	<div class="container">
		<div class="form-group row">
			<label class="col-sm-2">이미지</label>
			<div class="col-sm-3">
				<input type="file" id="input_img" name="uploadFile" multiple />
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" id="uploadBtn" class="btn btn-primary"
					value="업로드" name="uploadFile" />
			</div>
		</div>
	</div>
	<div>
		<div class="img_wrap">
			
		</div>
	</div>


</body>
</html>
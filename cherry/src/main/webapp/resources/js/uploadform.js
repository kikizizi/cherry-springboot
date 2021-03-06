		function inputChange() {
			var fileInput = document.getElementById("addImage");
			var file_name = fileInput.files[0].name // 파일명
			new_p = document.createElement('p');
			new_p.innerText = file_name + ' ';
			new_p.setAttribute('class', 'img' + img_num);
			new_b = document.createElement('button');
			new_b.setAttribute('class', 'img' + img_num);
			new_b.setAttribute("onclick", "delClass('img" + img_num + "')");
			new_b.setAttribute('type', 'button');
			new_b.innerText = 'x';
			new_p.appendChild(new_b);
			$('#imgDiv').append(new_p);
			$('#addImage').attr('class', 'imageInputs img' + img_num);
			$('#addImage').removeAttr('id');
			var new_input = document.createElement('input');
			new_input.setAttribute('type', 'file');
			new_input.setAttribute('id', 'addImage');
			new_input.setAttribute('class', 'imageInputs');
			new_input.setAttribute('onchange', 'inputChange()')
			new_input.setAttribute('accept',
					'.jpg, .jpeg, .png, .JPG, .JPEG, .gif');
			$('#imgDiv').append(new_input);
			img_num += 1
		}
		var delClass = function(c) {
			$('.' + c).remove();
		}
		let img_num = 0;
		$("#addBtn").click(function(e) {
			e.preventDefault();
			if ($('.imageInputs').length < 6) {
				$("#addImage").trigger("click");
			}
		})
		$('#explanation').keyup(function() {
			$('#charNum').text($('#explanation').val().length + '자/2000자');
		})
				
		$("#submitBtn").click(function(e){
			e.preventDefault();
			if($("#title").val()==""){
				swal({
					  title: "제목을 입력해주세요",
					  icon: "warning",
					  button: "ok",
					});
			}else if ($("#price").val()==""){
				swal({
					  title: "가격을 입력해주세요",
					  icon: "warning",
					  button: "ok",
					});
			}else if($("#category2").val()=="선택"){
				swal({
					  title: "카테고리를 선택해주세요",
					  icon: "warning",
					  button: "ok",
					});
			}else if($("#explanation").val().length<10){
				swal({
					  title: "설명을 입력해주세요",
					  text:"최소 10자 이상",
					  icon: "warning",
					  button: "ok",
					});
			}else{
				let imgs = $('.imageInputs');
				for (let i = 0; i < imgs.length; i++) {
					imgs[i].setAttribute('name', 'img' + i);
				}
				$('#addImage').remove();
				$('#addForm').submit();
			}
		})
		
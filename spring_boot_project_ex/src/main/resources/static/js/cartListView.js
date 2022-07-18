/**
 * cartListView.js
 */
 
  $(document).ready(function(){
  	// [전체 선택] 체크박스 체크했을 때
  	$('#allCheck').on('click', function(){
  		// [전체 선택] 체크박스 상태 확인
  		var chk = $('#allCheck').prop("checked");
  		
  		if(chk) {  // true : 체크되었다면
  			$('.chkDelete').prop("checked", true);
  		} else {
  			$('.chkDelete').prop("checked", false);
  		}  		
  	});
  	
  	// 개별 체크박스 (.chkDelete) 하나라도 해제할 경우 [전체선택] 체크박스 해제
  	// 모두 체크되었을 때 [전체선택] 체크
  	/*
  	$('.chkDelete').on("click", function(){
  		var count = 0;
  		$('.chkDelete').each(function(){
  			if($(this).is(':checked'))
  				count++;
  		});  	
  		
  		if(count == $('.chkDelete').length)  // 체크된 수가 전체 개수라면 
  			$('#allCheck').prop("checked", true);
  		else
  			$('#allCheck').prop("checked", false);  	
  	});
  	*/
  	
  	$(".chkDelete").click(function(){
		var total = $(".chkDelete").length;   // 전체 체크박수 개수
		var checked = $(".chkDelete:checked").length; // 체크된 체크박스 개수

		if(total != checked)   // 두 수가 같다면 (모두 선택된 상태가 아니라면)
			$("#allCheck").prop("checked", false);  // 해제
		else // 모두 선택했으면 
			$("#allCheck").prop("checked", true);  // 체크
	});
  });
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
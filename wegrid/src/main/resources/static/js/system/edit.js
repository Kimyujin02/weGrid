$('#pwd-reset').click(function() {
    if (confirm('정말 비밀번호를 초기화 하시겠습니까?')) {
   
        $.ajax({
            url: '/system/resetPassword',  // 요청을 보낼 URL
            type: 'POST',  // HTTP 메소드 (POST)
           //contentType: 'application/json',  // 전송할 데이터 형식
            data: ({ no }),  
            success: function(response) {
                if (response.success) {
                    alert('비밀번호가 초기화되었습니다.');
                } else {
                    alert('비밀번호 초기화에 실패했습니다.');
                }
            },
            error: function() {
                alert('에러가 발생했습니다.');
            }
        });
    }
});
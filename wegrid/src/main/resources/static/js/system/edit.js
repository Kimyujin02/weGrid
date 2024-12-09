$('#pwd-reset').click(function () {
    if (confirm('정말 비밀번호를 초기화 하시겠습니까?')) {
        const no =   $(this).val();// 사원의 번호 설정

        $.ajax({
            url: '/system/resetPassword',
            type: 'POST',
            contentType: 'application/json', // JSON 형식으로 전송
            data: JSON.stringify({ no: no }), // JSON 데이터로 변환
            success: function (response) {
                if (response.success) {
                    alert('비밀번호가 초기화되었습니다. 새 비밀번호는: ' + response.newPassword);
                } else {
                    alert('비밀번호 초기화에 실패했습니다: ' + response.message);
                }
            },
            error: function () {
                alert('에러가 발생했습니다.');
            }
        });
    }
});



   // 선택된 옵션의 텍스트를 input 필드에 업데이트하는 함수
   function updateDepartmentName() {
    const select = document.getElementById('deptName'); // select 요소
    const input = document.getElementById('department-name'); // input 요소

    // 선택된 옵션의 텍스트 가져오기
    const selectedText = select.options[select.selectedIndex].text;

    // input 필드에 선택된 텍스트 설정
    input.value = selectedText;
}

    //계정 비활성화 처리함
$('#delete-btn').click(function() {
    const no = $(this).data('no'); 
    const name = $(this).data('name'); 
    
        if (confirm(`정말 해당 사원 ${name}의 데이터를 삭제하시겠습니까?`)) {
            $.ajax({
                url: '/system/account/delete', // 서버의 삭제 처리 API URL
                type: 'POST',
                contentType: 'application/json', // JSON 형식으로 데이터 전송
                data: JSON.stringify({ no: no }), // 삭제할 사원의 번호를 JSON으로 전송
                success: function (response) {
                    if (response.success) {
                        alert('사원이 삭제되었습니다.');
                        location.reload(); // 페이지 새로고침
                    } else {
                        alert('삭제에 실패했습니다: ' + response.message);
                    }
                },
                error: function () {
                    alert('요청 처리 중 오류가 발생했습니다.');
                }
            });
        }
    });
    
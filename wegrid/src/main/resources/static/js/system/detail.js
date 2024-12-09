$('#delete-btn').click(function() {
    const no = $(this).data('no'); // '123'
    const name = $(this).data('name'); // 'John Doe'
    
        if (confirm(`정말 해당 사원${name}의 데이터를 삭제하시겠습니까?`)) {
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
    
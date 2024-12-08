function handleCheckbox(x){
    //모든 체크박스 가져오기
    const checkBoxArr = document.querySelectorAll(".checkbox-td > input[type=checkbox]");

    //모든 체크박스 체크하기
    for(let i = 0; i < checkBoxArr.length; ++i){
        checkBoxArr[i].checked = x.checked;
    }
}

function deleteNotice() {
    // 1. 체크된 게시글 번호들 가져오기
    const accountArr = []; // 선택된 값들을 저장할 배열
    const checkBoxArr = document.querySelectorAll(".checkbox-td > input[type=checkbox]:checked");

    // 체크된 체크박스에서 value 값을 가져오기
    checkBoxArr.forEach((checkbox) => {
        accountArr.push(checkbox.value); // 체크박스의 value 값 추가
    });

    // 선택된 값이 없을 경우 알림
    if (accountArr.length === 0) {
        alert("삭제할 항목을 선택하세요.");
        return;
    }

    // 2. 서버에 요청 보내기
    $.ajax({
        url: "/system/delete",
        method: "DELETE",
        data: JSON.stringify({ accountArr }), // JSON 데이터로 전송
        contentType: "application/json", // 요청 데이터 형식 설정
        success: function (response) {
            console.log("응답: ", response);
            if (response === "good") {
                alert("삭제 성공!");
            } else {
                alert("삭제 실패...");
            }
            location.reload();
        },
        error: function () {
            console.log("통신 실패...");
            alert("삭제 중 오류가 발생했습니다.");
        },
    });
}




document.addEventListener('DOMContentLoaded', function () {
    const rows = document.querySelectorAll('.list-middle');

    rows.forEach(row => {
        row.addEventListener('click', function (event) {
            // 클릭한 대상이 버튼이거나 특정 클래스인 경우 실행 중단
            if (event.target.tagName === 'BUTTON' || event.target.closest('.exclude-click')) {
                return; // 클릭 이벤트 전파 중단
            }

            const no = this.dataset.no; // 각 행의 data-no 속성에서 no 값 가져오기
            window.location.href = `/system/detail?no=${no}`; // 상세조회 페이지로 이동
        });
    });
});



// 버튼 js
document.getElementById("create-btn").addEventListener("click", function (event) {
    const form = document.querySelector("form");
    if (form.checkValidity()) {
        alert("신규 계정이 생성되었습니다!");
        form.submit();
    } else {
        alert("필수 입력 항목을 확인하세요!");
    }
});


    // 선택된 옵션을 input 필드에 업데이트하는 함수
    // 선택된 옵션의 텍스트를 input 필드에 업데이트하는 함수
    function updateDepartmentName() {
        const select = document.getElementById('deptName'); // select 요소
        const input = document.getElementById('department-name'); // input 요소

        // 선택된 옵션의 텍스트 가져오기
        const selectedText = select.options[select.selectedIndex].text;

        // input 필드에 선택된 텍스트 설정
        input.value = selectedText;
    }
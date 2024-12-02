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
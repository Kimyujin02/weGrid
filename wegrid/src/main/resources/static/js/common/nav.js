

function toggleList() {
    const submit = document.querySelector('#submitListt');
    const receive = document.querySelector('#receiveListt');
    
    // .visible 클래스 토글
    if (submit.classList.contains('visible')) {
        submit.classList.remove('visible'); // 숨기기
    } else {
        submit.classList.add('visible'); // 보이기
    }
    if (receive.classList.contains('visible')) {
        receive.classList.remove('visible'); // 숨기기
    } else {
        receive.classList.add('visible'); // 보이기
    }
}

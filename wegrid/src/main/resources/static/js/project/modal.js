// 버튼 클릭 시 모달 열기
document.getElementById('schedule-btn').addEventListener('click', function() {
    var myModal = new bootstrap.Modal(document.getElementById('writeModal'));
    myModal.show();
});

// 모달 닫기
function closeModal() {
    var myModal = new bootstrap.Modal(document.getElementById('writeModal'));
    myModal.hide();
}

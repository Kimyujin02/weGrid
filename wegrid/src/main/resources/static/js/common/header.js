// 모달 열기
function openModal() {
    document.getElementById("userModal").style.display = "block";
}

// 모달 닫기
function closeModal() {
    document.getElementById("userModal").style.display = "none";
}

// 모달 외부 클릭 시 닫기
window.onclick = function(event) {
    const modal = document.getElementById("userModal");
    if (event.target === modal) {
        modal.style.display = "none";
    }
};
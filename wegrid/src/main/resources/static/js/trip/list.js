// 모달 열기
function openTripModal() {
    document.getElementById("tripModal").style.display = "block";
}

// 모달 닫기
function closeTripModal() {
    document.getElementById("tripModal").style.display = "none";
}

// 모달 외부 클릭 시 닫기
window.onclick = function(event) {
    const modal = document.getElementById("tripModal");
    if (event.target === modal) {
        modal.style.display = "none";
    }
};
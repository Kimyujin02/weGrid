document.querySelectorAll('.project-dates').forEach(item => {
    const startDate = item.dataset.start.substring(0, 10);
    const endDate = item.dataset.end.substring(0, 10);
    item.textContent = `${startDate} ~ ${endDate}`;
});



// 카드 컨테이너 가져오기
const cardContainer = document.querySelector(".card-container");

// 카드 클릭 이벤트 처리
cardContainer.addEventListener("click", function (evt) {
    // 클릭한 요소에서 가장 가까운 카드 찾기
    const card = evt.target.closest("#card");
    if (!card) return; // 카드가 아닌 다른 요소를 클릭한 경우 무시

    // 카드에서 프로젝트 이름 가져오기
    const projectTitle = card.querySelector(".project-title").innerText.trim();
    console.log(projectTitle);


    // 상세 조회 페이지로 이동
    location.href = `/project/people?projectName=${encodeURIComponent(projectTitle)}`;
});

// 모달 열기
function addOpenModal() {
    const modal = document.getElementById('searchModal');
    modal.style.display = 'flex'; 
}

// 모달 닫기
function addCloseModal() {
    const modal = document.getElementById('searchModal');
    modal.style.display = 'none';
}

// 사원 선택 시 동작
function selectEmployee(name) {
    alert(`${name}님이 선택되었습니다.`);  // 알림 표시

    // 사원 정보를 추가하는 부분
    const personnelList = document.getElementById('personnelList');

    // 새로운 사원 정보를 나타내는 div 생성
    const personDiv = document.createElement('div');
    personDiv.className = 'person-line';

    // 사원 정보와 삭제 버튼
    personDiv.innerHTML = `
        <span>${name}</span>
        <button class="remove-btn" onclick="removeEmployee(this)">삭제</button>
    `;

    // 리스트에 추가
    personnelList.appendChild(personDiv);

    // 모달 닫기
    addCloseModal();
}

// 사원 검색 함수
function searchEmployee(query) {
    const resultsContainer = document.getElementById('employeeResults');
    resultsContainer.innerHTML = " "; // 기존 검색 결과 초기화

     // AJAX 요청
     $.ajax({
        url: '/employee/search',
        method: 'GET',
        data: { query },
        success: function (data) {
            // 검색 결과 렌더링
            data.forEach((employee) => {
                const li = $('<li></li>').text(employee.name);
                li.on('click', function () {
                    selectEmployee(employee.name); // 사원 선택 시 이벤트
                });
                resultsContainer.appendChild(li);
            });
        },
        error: function (error) {
            console.error('Error-employees:', error);
            alert('사원 검색에 실패했습니다.');
        }
    });

}

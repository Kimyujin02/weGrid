function selectClient(name) {
    document.getElementById('clientName').value = name; // 선택된 이름 입력란에 설정
    document.getElementById('suggestions').style.display = 'none'; // 리스트 숨기기
}


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

// 사원 검색 함수 (샘플 데이터 활용)
function searchEmployee(query) {
    const resultsContainer = document.getElementById('employeeResults');
    resultsContainer.innerHTML = ''; // 기존 검색 결과 초기화

    // 간단한 검색 데이터 시뮬레이션
    const sampleData = [
        '김철수',
        '김태훈',
        '정재성',
        '김승택',
        '김유진',
        '왕두수',
        '홍길동'
    ];

    // 입력값과 일치하는 데이터 필터링
    const filteredData = sampleData.filter((name) =>
        name.includes(query.trim())
    );

    // 필터링된 결과를 리스트에 추가
    filteredData.forEach((name) => {
        const li = document.createElement('li');
        li.textContent = name;
        li.onclick = () => selectEmployee(name); // 사원 선택 시 이벤트
        resultsContainer.appendChild(li);
    });
}

// 사원 선택 시 동작
function selectEmployee(name) {
    alert(`${name}님이 선택되었습니다.`);
    addCloseModal();
}


// 선택된 사원 정보를 추가하는 함수
function selectEmployee(name) {
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

// 사원 삭제 함수
function removeEmployee(button) {
    const personDiv = button.parentElement; // 버튼의 부모 요소 (사원 정보)
    personDiv.remove(); // 해당 요소 삭제
}


// 버튼 js
document.getElementById("create-btn").addEventListener("click", function (event) {
    const form = document.querySelector("form");
    if (form.checkValidity()) {
        alert("프로젝트가 생성되었습니다!");
        form.submit();
    } else {
        alert("필수 입력 항목을 확인하세요!");
    }
});

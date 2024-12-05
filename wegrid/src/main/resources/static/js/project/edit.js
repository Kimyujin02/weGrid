// 사원 선택 시 동작
function selectPm(employee) {
    alert(`${employee.name}님이 선택되었습니다.`); // 알림 표시
    
    // 입력 필드에 선택된 이름 설정
    const inputTag = document.getElementById('empName');
    const hiddenTag = document.getElementById('empNo');
    hiddenTag.value = employee.no;
    inputTag.value = employee.name;

    // 검색 결과를 숨기기
    const resultsContainer = document.getElementById('searchResults');
    resultsContainer.innerHTML = ""; // 검색 결과 초기화
}

function searchPm(name) {
    const resultsContainer = document.getElementById('searchResults');
    resultsContainer.innerHTML = ""; // 기존 검색 결과 초기화

    if (!name.trim()) {
        return; // 입력값이 없으면 종료
    }

    // AJAX 요청
    $.ajax({
        url: '/project/employee/search',
        method: 'GET',
        data: { name },
        success: function (data) {
            console.log(data);

            // 검색 결과 렌더링
            data.forEach((employee) => {
                const liTag = document.createElement("li");
                liTag.innerText = employee.name;
                liTag.className = "search-item"; // 스타일 추가 가능
                liTag.onclick = function(){selectPm(employee);}
                resultsContainer.appendChild(liTag);
            });
        },
        error: function (error) {
            console.error('Error-employees:', error);
            alert('사원 검색에 실패했습니다.');
        }
    });
}


////////////////////////////////////////////////////////////////////////////////////

// 고객사 검색시 동작
function selectClient(client) {
    alert(`${client.name}님이 선택되었습니다.`); // 알림 표시

    // 입력 필드에 선택된 이름 설정
    const inputTag = document.getElementById('clientName');
    const hiddenTag = document.getElementById('clientNo');
    hiddenTag.value = client.no;
    inputTag.value = client.name;

    // 검색 결과를 숨기기
    const resultsContainer = document.getElementById('searchClient');
    resultsContainer.innerHTML = ""; // 검색 결과 초기화
}


function searchClient(clientName) {
    const resultsContainer = document.getElementById('searchClient');
    
    resultsContainer.innerHTML = ""; // 기존 검색 결과 초기화

    if (!clientName.trim()) {
        return; // 입력값이 없으면 종료
    }

    // AJAX 요청
    $.ajax({
        url: '/project/client/search',
        method: 'GET',
        data: { clientName },
        success: function (data) {

            // 검색 결과 렌더링
            data.forEach((client) => {
                console.log("client", client);
                console.log("client", client.name);
                const liTag = document.createElement("li");
                liTag.innerText = client.name;
                liTag.className = "search-items"; 
                liTag.onclick = function(){selectClient(client);}
                // liTag.setAttribute("onclick", `selectClient("${client.name}");`); // 클릭 이벤트 연결
                resultsContainer.appendChild(liTag);
            });
        },
        error: function (error) {
            console.error('Error-clients:', error);
            alert('고객사 검색에 실패했습니다.');
        }
    });
}

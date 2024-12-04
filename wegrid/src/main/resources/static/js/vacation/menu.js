// 모달 열기
function openVacationModal() {
    document.getElementById("vacationModal").style.display = "block";
}

// 모달 닫기
function closeVacationModal() {
    document.getElementById("vacationModal").style.display = "none";
}

function checkDate(){
    const startDate = document.querySelector('input[type="date"]').value;
}

function linkUser() {
    // user-history 클래스를 가진 모든 요소를 선택
    const targets = document.querySelectorAll(".user-history *");

    // 각각의 요소에 클릭 이벤트 추가
    targets.forEach(target => {
        target.addEventListener("click", (event) => {
            // 클릭된 요소에서 부모인 user-history 요소까지 추적
            const parentRow = event.target.closest(".user-history");

            // 필요하다면 parentRow의 특정 데이터 속성이나 텍스트 값을 가져올 수 있음
            const deptName = parentRow.querySelector("td:nth-child(1)").textContent.trim();
            const name = parentRow.querySelector("td:nth-child(2)").textContent.trim();

            // URL로 보내기 위한 데이터 준비 (예: 쿼리 파라미터)
            const url = `/someEndpoint?deptName=${encodeURIComponent(deptName)}&name=${encodeURIComponent(name)}`;

            // URL로 이동
            window.location.href = url;
        });
    });
}



//function insertNewVacation(){
//    document.getElementById("vacationModal").style.display = "none";
//
//    const startDate = document.getElementById("startDate").value;
//    const endDate = document.getElementById("endDate").value;
//
//    const selectedRadio = document.querySelector(".checkbox-group input[type=radio]:checked");
//    const vacTypeNo = selectedRadio ? selectedRadio.value : null;
//
//    const content = document.getElementById("content").value;
//
//    $.ajax({
//        url: '/vacation/menu',
//        type: 'POST',  // HTTP 요청 방식 (POST 또는 GET)
//        data: {
//            startDate,
//            endDate,
//            vacTypeNo,
//            content
//        },
//        success: function(response) {
//            console.log('휴가 등록 성공:', response);
//        },
//        error: function(xhr, status, error) {
//            console.error('휴가 등록 실패:', error);
//        }
//    });

    // const vacTypeNo = document.querySelectorAll('.checkbox-group input[type="checkbox"]:checked');
    // const startDate = document.querySelector(".startDate").value;
//}





//document.addEventListener('DOMContentLoaded', function () {
//    // 버튼 클릭 이벤트 리스너
//    document.getElementById('submitButton').addEventListener('click', function () {
//        // 선택된 체크박스 가져오기
//        const selectedCheckboxes = Array.from(
//            document.querySelectorAll('.checkbox-group input[type="checkbox"]:checked')
//        );
//
//        // 선택된 값 추출
//        const selectedValues = selectedCheckboxes.map(checkbox => checkbox.value);
//
//        // 선택된 값 출력 (콘솔 확인용)
//        console.log('선택된 항목:', selectedValues);
//
//        // 선택된 데이터를 처리 (예: 서버로 전송)
//        if (selectedValues.length > 0) {
//            processData(selectedValues);
//        } else {
//            alert('선택된 항목이 없습니다.');
//        }
//    });
//});
//
//function processData(selectedValues) {
//    // 데이터를 처리하는 함수 (예: AJAX로 서버에 전송)
//    fetch('/vacation/process', {
//        method: 'POST',
//        headers: {
//            'Content-Type': 'application/json',
//        },
//        body: JSON.stringify({ selectedVacationTypes: selectedValues }),
//    })
//        .then(response => response.json())
//        .then(data => {
//            console.log('서버 응답:', data);
//            alert('처리가 완료되었습니다.');
//        })
//        .catch(error => {
//            console.error('에러 발생:', error);
//            alert('처리 중 문제가 발생했습니다.');
//        });
//}
//
//
//
//
//
//
//
//const fileTag = document.querySelector("input[name=f]");
//fileTag.addEventListener("change", preview);
//
//function preview(evt){
//    const previewArea = document.querySelector(".preview-area");
//    previewArea.innerHTML = "";
//    for(let i = 0; i < evt.target.files.length; ++i){
//        const f = evt.target.files[i];
//        const fr = new FileReader();    //파일 읽어들이기위한 객체
//        fr.onload = function(evt){ //파라미터에 변수넣으면 이벤트를 가져옴 근데 변수명은 내 맘대로
//            const dataUrl = evt.target.result;
//            const imgTag = document.createElement("img");
//            imgTag.setAttribute("src", dataUrl);
//            imgTag.setAttribute("width", "100");
//            imgTag.setAttribute("height", "100");
//            previewArea.appendChild(imgTag);
//        }
//        fr.readAsDataURL(f);
//    }
//}




// 모달 외부 클릭 시 닫기
//window.onclick = function(event) {
//    const modal = document.getElementById("vacationModal");
//    if (event.target === modal) {
//        modal.style.display = "none";
//    }
//};


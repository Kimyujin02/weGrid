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



function loadBoardList(searchType, searchTitleValue, searchContentValue){
    const tbodyTag = document.querySelector("table tbody");

        const url = new URL(location);
    let pno = url.searchParams.get("pno");
    if(pno == null){
        pno = 1;
    }

    $.ajax({
        url : `/board/data?pno=${pno}` ,
        data : {
            searchType,
            searchTitleValue,
            searchContentValue,
        }, //키-밸류라 객체
        // method :, 어차피 기본값이 GET
        success: function (m) {
            const vacationList = m.a;
            const pvo = m.b;
            paintPageArea(pvo);

            tbodyTag.innerText = ""; // 기존 내용 초기화

            for (const vo of vacationList) {
                const trTag = document.createElement("tr");

                // 부서 이름
                const tdTag01 = document.createElement("td");
                const aTag01 = document.createElement("a");
                aTag01.setAttribute("href", `/vacation/detail?vno=${vo.no}`);
                aTag01.innerText = vo.deptName;
                tdTag01.appendChild(aTag01);
                trTag.appendChild(tdTag01);

                // 이름
                const tdTag02 = document.createElement("td");
                tdTag02.innerText = vo.name;
                trTag.appendChild(tdTag02);

                // 시작 날짜
                const tdTag03 = document.createElement("td");
                tdTag03.innerText = vo.startDate;
                trTag.appendChild(tdTag03);

                // 종료 날짜
                const tdTag04 = document.createElement("td");
                tdTag04.innerText = vo.endDate;
                trTag.appendChild(tdTag04);

                // 내용
                const tdTag05 = document.createElement("td");
                tdTag05.innerText = vo.content;
                trTag.appendChild(tdTag05);

                // 휴가 유형
                const tdTag06 = document.createElement("td");
                tdTag06.innerText = vo.vacTypeName;
                trTag.appendChild(tdTag06);

                // 사용 횟수
                const tdTag07 = document.createElement("td");
                tdTag07.innerText = vo.useCnt;
                trTag.appendChild(tdTag07);

                // 수정 버튼
                const tdTag08 = document.createElement("td");
                const editButton = document.createElement("button");
                editButton.classList.add("edit");
                editButton.innerText = "수정";
                editButton.onclick = function () {
                    openVacationModal();
                };
                tdTag08.appendChild(editButton);
                trTag.appendChild(tdTag08);

                // 삭제 버튼
                const tdTag09 = document.createElement("td");
                const deleteButton = document.createElement("button");
                deleteButton.classList.add("delete");
                deleteButton.innerText = "삭제";
                deleteButton.onclick = function () {
                    // 삭제 로직 작성
                    console.log(`Delete vacation with id: ${vo.no}`);
                };
                tdTag09.appendChild(deleteButton);
                trTag.appendChild(tdTag09);

                // 행 추가
                tbodyTag.appendChild(trTag);
            }
        } ,
        fail : function(){
            alert("게시글 목록조회 실패 (관리자에게 문의하세요)");
        } ,
    })

}

loadBoardList();




function submitSearchForm(){
    const searchType = document.querySelector("select[name=searchType]").value; //제목인지 내용인지

    const titleOrContentValue = document.querySelector("input[name=searchValue]").value;

    let searchTitleValue = "";
    let searchContentValue = "";
    if(searchType == "title"){
        searchTitleValue = titleOrContentValue;
    }else{
        searchContentValue = titleOrContentValue;
    }

    loadBoardList(searchType, searchTitleValue, searchContentValue);

    //기본이벤트 막기
    return false;
}


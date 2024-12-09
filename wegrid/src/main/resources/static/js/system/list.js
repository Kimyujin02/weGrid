document.addEventListener('DOMContentLoaded', function () {
    const rows = document.querySelectorAll('.list-middle');

    rows.forEach(row => {
        row.addEventListener('click', function (event) {
            // 클릭한 대상이 버튼, 체크박스, 또는 exclude-click 클래스일 경우 실행 중단
            if (
                event.target.tagName === 'BUTTON' ||
                event.target.type === 'checkbox' ||
                event.target.closest('.exclude-click')
            ) {
                return; // 클릭 이벤트 전파 중단
            }

            const no = this.dataset.no; // 각 행의 data-no 속성에서 no 값 가져오기
            window.location.href = `/system/detail?no=${no}`; // 상세조회 페이지로 이동
        });
    });
});

function handleCheckbox(x) {
    // 모든 체크박스 가져오기
    const checkBoxArr = document.querySelectorAll(".checkbox-td > input[type=checkbox]");

    // 모든 체크박스 체크하기
    checkBoxArr.forEach(checkbox => {
        checkbox.checked = x.checked;
    });
}

function deleteAccount(){
    //1. 체크된 게시글 번호들 가져오기
    const accountArr = []; // 체크된 게시글 번호를 저장할 배열
    const checkBoxArr = document.querySelectorAll(".checkbox-td > input[type=checkbox]");
    for(const checkBox of checkBoxArr){
        if(checkBox.checked == false){continue;} // 체크되지 않은 경우 건너뛰기
        const accountNo = checkBox.parentNode.parentNode.children[0].value;
        console.log("checkBox" , checkBox);
        accountArr.push(accountNo); // 번호를 배열에 추가해줌
    }

    console.log("accountArr" , accountArr);
    

    //2. 서버한테 요청 보내기
    $.ajax( {
        url : "/system/delete" ,
        method : "delete" ,
        // contentType: "application/json", // JSON 형식으로 데이터 전송
        data: {
            accountArr : JSON.stringify(accountArr)
        }, // 데이터를 객체로 감싸서 JSON 문자열로 변환
        success : function(x){
            console.log("통신 성공 !!!");
            if(x == "good"){
                alert("삭제 성공 !");
            }else{
                alert("삭제 실패 ...");
            }
            location.reload();
        } ,
        error : function(){
            console.log("통신 실패 ...");
        } ,
    } );
}




document.addEventListener('DOMContentLoaded', function () {
    const rows = document.querySelectorAll('.list-middle');

    rows.forEach(row => {
        row.addEventListener('click', function (event) {
            // 클릭한 대상이 버튼이거나 특정 클래스인 경우 실행 중단
            if (event.target.tagName === 'BUTTON' || event.target.closest('.exclude-click')) {
                return; // 클릭 이벤트 전파 중단
            }

            const no = this.dataset.no; // 각 행의 data-no 속성에서 no 값 가져오기
            window.location.href = `/system/detail?no=${no}`; // 상세조회 페이지로 이동
        });
    });
});




// 필터링
// 부서 변경 시 직급 필터링
function updateJobOptions() {
    const selectedDept = document.getElementById("deptName").value;
    const jobSelect = document.getElementById("job");
    const allJobOptions = [...jobSelect.options];

    allJobOptions.forEach(option => {
        option.style.display = "block";
        if (selectedDept && option.dataset.deptNo && option.dataset.deptNo !== selectedDept) {
            option.style.display = "none";
        }
    });
  
    applyFilters(); // 부서 변경 시 필터링 적용
}

// 필터링 적용
function applyFilters() {
    const deptNo = document.getElementById("deptName").value;
    const jobNo = document.getElementById("job").value;
    const url = `/system/account/list?deptNo=${deptNo}&jobNo=${jobNo}`;
    window.location.href = url; // 필터링된 값으로 페이지 이동
}






// 일정 추가 모달 창 실행
function openWriteModal(date) {

    // 창 실행 전 내용 초기화
    document.querySelector("#calendar-title").value = "";
    document.querySelector("#calendar-content").value = "";
    document.querySelector("#calendar-start-date").value = "";
    document.querySelector("#calendar-end-date").value = "";
    document.querySelector("#calendar-type").value = "";

    // 전달받은 날짜 정보 YYYY-MM-DD 형식으로 변환

    const yyyy = date.getFullYear().toString();
    let mm = date.getMonth() + 1;
    mm = mm < 10 ? '0' + mm.toString() : mm.toString();
    let dd = date.getDate();
    dd = dd < 10 ? '0' + dd.toString() : dd.toString();

    // 입력창 기본 날짜 설정
    const todayDate = yyyy + "-" + mm + "-" + dd + "T00:00"; // 클릭할 날짜 값을 input 태그 형식에 맞게 00시로 변환
    const startDateTag = document.querySelector("#calendar-start-date");
    startDateTag.value=todayDate;
    const endDateTag = document.querySelector("#calendar-end-date");
    endDateTag.value=todayDate;

    // 모달창에 항목 정보 추가
    loadTypeInfo();

    // 모달 창 띄우기
    $("#writeModal").modal("show");

}

// 캘린더 항목 정보 작성 모달창에 추가
function loadTypeInfo(){

    const selectTag = document.querySelector("#calendar-type");
    const colorTag = document.querySelector("#writeModal input[name=color]");

    for (let i = 1; i < typeInfo.length; i++) {
        const optionTag = document.createElement("option");
        optionTag.value = typeInfo[i].no;
        optionTag.innerText = typeInfo[i].name;
        if(i==1){
            optionTag.setAttribute("selected","selected");
            colorTag.value=typeInfo[1].color;
        }
        selectTag.appendChild(optionTag);
    }
    
    selectTag.addEventListener("change", function(evt){
        colorTag.value=typeInfo[evt.target.value].color;
    })

}

// 일정종류 정보 작성 모달창에 추가
function loadKindInfo(){

    const selectTag = document.querySelector(".kind-area");
    const colorTag = document.querySelector("#writeModal input[name=color]");

    for (let i = 1; i < typeInfo.length; i++) {
        const optionTag = document.createElement("option");
        optionTag.value = typeInfo[i].no;
        optionTag.innerText = typeInfo[i].name;
        if(i==1){
            optionTag.setAttribute("selected","selected");
            colorTag.value=typeInfo[1].color;
        }
        selectTag.appendChild(optionTag);
    }
    
    selectTag.addEventListener("change", function(evt){
        colorTag.value=typeInfo[evt.target.value].color;
    })
}


// 캘린더 항목 선택란 초기화
const writeModal = document.querySelector("#writeModal");
writeModal.addEventListener("hide.bs.modal", function(){
    const selectTag = document.querySelector("#calendar-type");
    if(selectTag.firstElementChild != null){
        selectTag.innerHTML = null;
    }
    // if(document.querySelector("#calendar-kindName-view") != null){
    //     document.querySelector("#calendar-kindName-view").remove();
    // }
});

// 서버에 일정정보 추가
function insertToDB(){

    // 입력할 데이터 수집
    const formData = $("#writeForm").serialize();

    // 저장할 월 정보 수집
    const date = document.querySelector("#calendar-start-date").value;
    const calcDate = calculateDate(new Date(date.replace("T"," ")));
    
    // 저장할 캘린더 항목 정보 수집
    const typeNo = document.querySelector("#calendar-type").value;

    // 서버에 데이터 전달
    $.ajax({
        url: "/calendar/write",
        method: "POST",
        data: formData,
        success: function(result){
            if(result == 1){
                alert("신규 일정 등록 완료!!");
                console.log("로컬 비우기",typeNo,calcDate);  
                deleteLocalStorage(typeNo,calcDate);
                console.log("이벤트 비우기",typeNo,calcDate);  
                removeEventSource(typeNo,calcDate);
                addEventToCalendar(calcDate,typeNo,typeNo);
                $('#writeModal').modal('hide');
            }
            else{
                alert("신규 일정 등록 실패");
            }
        },
        error: function(){
            alert("서버에 신규 일정 저장 실패");
        }
        
    })

    return false; 

}




   // 추가 버튼 클릭 시
    // $("#addCalendar").on("click", function () {  // modal의 추가 버튼 클릭 시
    //     // var content = $("#calendar_content").val();
    //     // var start_date = $("#calendar_start_date").val();
    //     // var end_date = $("#calendar_end_date").val();

    //     // //내용 입력 여부 확인
    //     // if (content == null || content == "") {
    //     //     alert("내용을 입력하세요.");
    //     // } else if (start_date == "" || end_date == "") {
    //     //     alert("날짜를 입력하세요.");
    //     // } else if (new Date(end_date) - new Date(start_date) < 0) { // date 타입으로 변경 후 확인
    //     //     alert("종료일이 시작일보다 먼저입니다.");
    //     // } else { // 정상적인 입력 시
    //     //     var obj = {
    //     //         "title": content,
    //     //         "start": start_date,
    //     //         "end": end_date
    //     //     }//전송할 객체 생성

    //     //     console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
    //     // }

        
    // });
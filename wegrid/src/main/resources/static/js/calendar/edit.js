
// 일정 수정 모달 실행
function openEditModal(vo){

    loadTypeInfoEdit(vo);
    document.querySelector("input[name=no]").value=vo.no;
    document.querySelector("#calendar-title-edit").value=vo.title;
    addWriterInfoEdit(vo);
    document.querySelector("#calendar-start-date-edit").value=(vo.startDate).replace(" ","T");
    document.querySelector("#calendar-end-date-edit").value=(vo.endDate).replace(" ","T");
    loadKindInfoEdit(vo);
    document.querySelector("#calendar-content-edit").value=vo.content;

    // 상세조회 모달 창 닫기
    $("#detailModal").modal("hide");
    // 수정 모달 창 띄우기
    $("#editModal").modal("show");

}

// 캘린더 항목 정보 수정 모달창에 추가
function loadTypeInfoEdit(vo){

    const selectTag = document.querySelector("#calendar-type-edit");
    const colorTag = document.querySelector("#editModal input[name=color]");

    for (let i = 1; i < 3; i++) {
        const optionTag = document.createElement("option");
        optionTag.value = typeInfo[i].no;
        optionTag.innerText = typeInfo[i].name;
        if(vo.typeNo == typeInfo[i].no){
            optionTag.setAttribute("selected",true);
            colorTag.value=vo.color;
        }
        selectTag.appendChild(optionTag);
    }
    
    selectTag.addEventListener("change", function(evt){
        colorTag.value=typeInfo[evt.target.value].color;
    })

}

// 작성자 정보 수정 모달창에 추가
function addWriterInfoEdit(vo){
    const areaTag = document.querySelector("#editModal .writer-area");
    if(vo.typeNo == 1){
        const classNameList = areaTag.className;
        if(!classNameList.includes("hidden-area")){
            areaTag.classList.add("hidden-area");
        }
    }
    else{
        document.querySelector("#calendar-writerName-edit").value=vo.writerName;
        document.querySelector("#editModal .writer-area").classList.remove("hidden-area");
    }
}

// 일정종류 정보 수정 모달창에 추가
function loadKindInfoEdit(vo){

    const selectTag = document.querySelector("#editModal .kind-area");

    for (let i = 0; i < kindInfo.length; i++) {
        const boxTag = document.createElement("div");
        boxTag.className = "kindBox";

        const labelTag = document.createElement("label");
        labelTag.htmlFor = "kind"+(i+1);
        labelTag.className = "col-form-label";
        labelTag.innerText = kindInfo[i].name;

        const radioTag = document.createElement("input");
        radioTag.type = "radio";
        radioTag.id = "kind"+(i+1);
        radioTag.name = "kindNo";
        radioTag.value = kindInfo[i].no;
        if(vo.kindNo != null && vo.kindNo == kindInfo[i].no){
            radioTag.setAttribute("checked",true);
        }

        boxTag.appendChild(labelTag);
        boxTag.appendChild(radioTag);
        selectTag.appendChild(boxTag);
    }
    
}

// 일정 종류 다시 숨기기
const editModal = document.querySelector("#editModal");
editModal.addEventListener("hide.bs.modal", function(){
    document.querySelector("#calendar-type-edit").innerHTML = null;
    document.querySelector("#editModal .kind-area").innerHTML = null;
});

// 서버에 수정한 일정정보 전달
function editAtDB(){

    // 입력할 데이터 수집
    const formData = $("#editForm").serialize();
    console.log("formData",formData);
    // 저장할 월 정보 수집
    const date = document.querySelector("#calendar-start-date-edit").value;
    const calcDate = calculateDate(new Date(date.replace("T"," ")));
    const startDate = new Date(date.replace("T"," "));
    const endDate = new Date((document.querySelector("#calendar-end-date-edit").value).replace("T"," "));
    
    if(endDate-startDate < 0){
        alert("종료일이 시작일보다 빠릅니다. 날짜를 다시 확인해주세요.");
        return false;
    }

    // 저장할 캘린더 항목 정보 수집
    const typeNo = document.querySelector("#calendar-type-edit").value;

    // 서버에 데이터 전달
    $.ajax({
        url: "/calendar/edit",
        method: "POST",
        data: formData,
        success: function(result){
            if(result == "success"){
                alert("일정 수정 완료!!");
                console.log("로컬 비우기",typeNo,calcDate);  
                deleteLocalStorage(typeNo,calcDate);
                console.log("이벤트 비우기",typeNo,calcDate);  
                removeEventSource(typeNo,calcDate);
                addEventToCalendar(calcDate,typeNo,typeNo);
                $('#editModal').modal('hide');
            }
            else{
                alert("일정 수정 실패");
            }
        },
        error: function(){
            alert("서버에 수정한 일정정보 전달 실패");
        }
        
    })

    return false; 

}
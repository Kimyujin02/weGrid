
// 일정 수정 모달 실행
function openEditModal(vo){

    document.querySelector("input[name=no]").value=vo.no;
    document.querySelector("#calendar-title-edit").value=vo.title;
    if(vo.typeNo != 1){
        addWriterInfoEdit(vo);
    }
    document.querySelector("#calendar-start-date-edit").value=(vo.startDate).replace(" ","T");
    document.querySelector("#calendar-end-date-edit").value=(vo.endDate).replace(" ","T");

    document.querySelector("#calendar-content-edit").value=vo.content;

    // 모달 창 띄우기
    $("#editModal").modal("show");
    // 
    $("#detailModal").modal("hide");

}

// 캘린더 항목 정보 모달창에 추가
function loadTypeInfoEdit(){

    const nowTypeNo = document.querySelector("#calendar-typName-view").getAttribute("no");
    const selectTag = document.querySelector("#calendar-type-edit");

    if( selectTag.firstElementChild == null){
                
        for (let i = 1; i < typeInfo.length; i++) {
            const optionTag = document.createElement("option");
            optionTag.value = typeInfo[i].no;
            optionTag.innerText = typeInfo[i].name;
            // if(i==0){
            //     optionTag.setAttribute("selected","selected");
            // }
            selectTag.appendChild(optionTag);
        }

    }else{
        selectTag.firstElementChild.setAttribute("selected","selected");
    }
    
    let colorTag = document.querySelector("input[name=color]");
    colorTag.value=typeInfo[1].color;

    selectTag.addEventListener("change", function(evt){
        colorTag.value=typeInfo[evt.target.value].color;
    })

}

// 작성자 정보 수정 모달창에 추가
function addWriterInfoEdit(vo){
    if(document.querySelector("#editModal .writer-area div") != null){
        return;
    }
    const areaTag = document.querySelector("#editModal .writer-area");
    
    const writerTag = document.createElement("div");
    writerTag.setAttribute("id","calendar-writerName-edit");
    writerTag.setAttribute("class","calendar-detail-view-box");
    writerTag.innerText=vo.writerName;
    areaTag.appendChild(writerTag);

    const brTag = document.createElement("br");
    areaTag.appendChild(brTag);
    
    areaTag.classList.remove("hidden-area");
}


// 서버에 수정한 일정정보 전달
function editAtDB(){

    // 입력할 데이터 수집
    const formData = $("#editForm").serialize();

    // 저장할 월 정보 수집
    const date = document.querySelector("#calendar-start-date-edit").value;
    const calcDate = calculateDate(new Date(date.replace("T"," ")));
    
    // 저장할 캘린더 항목 정보 수집
    const typeNo = document.querySelector("#calendar-type-edit").value;

    // 서버에 데이터 전달
    $.ajax({
        url: "/calendar/edit",
        method: "POST",
        data: formData,
        success: function(result){
            if(result == 1){
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
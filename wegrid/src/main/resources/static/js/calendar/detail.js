
// 상세정보 모달 실행
function showEventDetail(evt) {
    
    $.ajax({
        url: "/calendar/detail",
        data :{
            no : evt.event.id
        },
        success:function(vo){

            console.log("통신 성공");
            console.log("vo",vo);
            document.querySelector("input[name=scheduleNo]").value=vo.no;
            document.querySelector("#calendar-typName-view").innerText=vo.typeName;
            document.querySelector("#calendar-typName-view").setAttribute("no",vo.typeNo);
            document.querySelector("#calendar-color-view").style.backgroundColor=vo.color;
            document.querySelector("#calendar-title-view").innerText=vo.title;
            if(vo.typeNo != 1){
                addWriterInfo(vo);
            }
            document.querySelector("#calendar-start-Date-view").innerText=vo.startDate;
            document.querySelector("#calendar-end-Date-view").innerText=vo.endDate;
            if(vo.kindNo != null){

                if(document.querySelector("#kindName-view") == null){
                    const areaTag = document.querySelector("#kindName-view-area");
                    
                    const kindTag = document.createElement("div");
                    kindTag.setAttribute("id","calendar-kindName-view");
                    kindTag.setAttribute("class","calendar-detail-view-box");
                    kindTag.innerText=vo.kindName;
    
                    areaTag.appendChild(kindTag);
                }
            }
            document.querySelector("#calendar-content-view").innerHTML=vo.content;
            document.querySelector("input[name=isEditable]").value=vo.isEditable;

            // 수정 시 해당 정보를 가져가도록 버튼에 onclick 함수 적용
            document.querySelector("#toEditBtn").onclick = function(){openEditModal(vo)}

            // 모달 창 띄우기
            $("#detailModal").modal("show");
        },
        error:function(){
            console.log("통신 실패");

        }

    })

}

// 일정 종류 모달창에 추가
function addWriterInfo(vo){
    if(document.querySelector("#kindName-view-area div") != null){
        return;
    }

    const areaTag = document.querySelector("#kindName-view-area");
                    
    const kindTag = document.createElement("div");
    kindTag.setAttribute("id","calendar-kindName-view");
    kindTag.setAttribute("class","calendar-detail-view-box");
    kindTag.innerText=vo.kindName;
    
    areaTag.appendChild(kindTag);
}


// 작성자 정보 상세조회 모달창에 추가
function addWriterInfo(vo){
    if(document.querySelector("#detailModal .writer-area div") != null){
        return;
    }
    const areaTag = document.querySelector("#detailModal .writer-area");
    
    const writerTag = document.createElement("div");
    writerTag.setAttribute("id","calendar-writerName-view");
    writerTag.setAttribute("class","calendar-detail-view-box");
    writerTag.innerText=vo.writerName;
    areaTag.appendChild(writerTag);

    const brTag = document.createElement("br");
    areaTag.appendChild(brTag);
    
    areaTag.classList.remove("hidden-area");
}

// 작성자 정보, 일정 종류 다시 숨기기
const detailModal = document.querySelector("#detailModal");
detailModal.addEventListener("hide.bs.modal", function(){
    if(document.querySelector("#calendar-writerName-view") != null){
        document.querySelector("#detailModal .writer-area").classList.add("hidden-area");
        document.querySelector("#calendar-writerName-view").remove();
    }
    if(document.querySelector("#calendar-kindName-view") != null){
        document.querySelector("#calendar-kindName-view").remove();
    }
});

// 일정 삭제
function deleteSchedule(){

    // 필요한 일정정보 수집
    const no = document.querySelector("input[name=scheduleNo]").value;
    const typeNo = document.querySelector("#calendar-typName-view").getAttribute("no");
    const calcDate = calculateDate(new Date(document.querySelector("#calendar-start-Date-view").innerText));

    $.ajax({
        url: "/calendar/delete",
        data:{
            no
        },
        success:function(result){        
            if(result == 1){
                alert("일정 삭제 완료!!");
                console.log("로컬 비우기",typeNo,calcDate);  
                deleteLocalStorage(typeNo,calcDate);
                console.log("이벤트 비우기",typeNo,calcDate);  
                removeEventSource(typeNo,calcDate);
                addEventToCalendar(calcDate,typeNo,typeNo);
                $('#detailModal').modal('hide');
            }
            else{
                alert("신규 일정 등록 실패");
            }
        },
        error:function(){
            alert("서버와 통신 실패");
        }

    })

}

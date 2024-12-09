
// 상세정보 모달 실행
function showEventDetail(evt) {

    $.ajax({
        url: "/calendar/detail",
        data :{
            no : evt.event.id
        },
        success:function(map){
            console.log("통신 성공");        
            const vo = map.vo;
            const loginInfo = map.loginInfo;

            document.querySelector("input[name=scheduleNo]").value=vo.no;
            if(vo.typeName == null){
                document.querySelector("#calendar-typName-view").innerText=typeInfo[vo.typeNo].name;
            }else{
                document.querySelector("#calendar-typName-view").innerText=vo.typeName;
            }
            document.querySelector("#calendar-typName-view").setAttribute("no",vo.typeNo);
            if(vo.color == null) {
                document.querySelector("#calendar-color-view").style.backgroundColor=typeInfo[vo.typeNo].color;
            }else{
                document.querySelector("#calendar-color-view").style.backgroundColor=vo.color;
            }
            document.querySelector("#calendar-title-view").innerText=vo.title;
            addWriterInfo(vo);
            document.querySelector("#calendar-start-Date-view").innerText=vo.startDate;
            document.querySelector("#calendar-end-Date-view").innerText=vo.endDate;
            if(vo.kindNo != null) {
                addKindInfo(vo);
            }
            // document.querySelector("#calendar-content-view").innerHTML=vo.content;
            addContent(vo);
            activateModalFooter(vo,loginInfo);
             
            // 모달 창 띄우기
            $("#detailModal").modal("show");
        },
        error:function(){
            console.log("통신 실패");

        }

    })

}

// 일정 종류 상세조회 모달창에 추가
function addKindInfo(vo){
    const areaTag = document.querySelector("#kindName-view-area");

    const kindTag = document.createElement("div");
    kindTag.setAttribute("id","calendar-kindName-view");
    kindTag.setAttribute("class","calendar-detail-view-box");
    kindTag.innerText=vo.kindName;
    
    areaTag.appendChild(kindTag);
}

// 작성자 정보 상세조회 모달창에 추가
function addWriterInfo(vo){

    const areaTag = document.querySelector("#detailModal .writer-area");
    if(vo.typeNo == 1){
        const classNameList = areaTag.className;
        if(!classNameList.includes("hidden-area")){
            areaTag.classList.add("hidden-area");
        }
    }
    else{
        document.querySelector("#calendar-writerName-view").innerText=vo.writerName;
        document.querySelector("#detailModal .writer-area").classList.remove("hidden-area");
    }

}

// 수정, 삭제 버튼 추가
function activateModalFooter(vo,loginInfo){
    
    if(vo.isEditable == 'Y' && loginInfo.no == vo.writerNo){
        const footerTag = document.querySelector("#detailModal .modal-footer");
        
        const btn1Tag = document.createElement("button");
        btn1Tag.type = "button";
        btn1Tag.className = "btn btn-primary";
        btn1Tag.innerText = "수정";
        
        const btn2Tag = document.createElement("button");
        btn2Tag.type = "button";
        btn2Tag.className = "btn btn-secondary";
        btn2Tag.innerText = "삭제";
        
        footerTag.appendChild(document.createElement("hr"));
        footerTag.appendChild(btn1Tag);
        footerTag.appendChild(btn2Tag);

        footerTag.classList.remove(".hidden-area");

        btn1Tag.onclick = function(){openEditModal(vo)};
        btn2Tag.onclick = function(){deleteSchedule()};
    }
    
}

// 일정 종류 다시 숨기기
const detailModal = document.querySelector("#detailModal");
detailModal.addEventListener("hide.bs.modal", function(){
    if(document.querySelector("#calendar-kindName-view") != null){
        document.querySelector("#calendar-kindName-view").remove();
    }

    const footerTag = document.querySelector("#detailModal .modal-footer");

    footerTag.innerHTML = null;
    footerTag.classList.add(".hidden-area");
});

// 일정 삭제
function deleteSchedule(){

    // 필요한 일정정보 수집
    const no = document.querySelector("input[name=scheduleNo]").value;
    const typeNo = document.querySelector("#calendar-typName-view").getAttribute("no");
    const calcDate = calculateDate(new Date(document.querySelector("#calendar-start-Date-view").innerText));

    if(!confirm("정말 삭제하시겠습니까?")){
        return;
    }

    $.ajax({
        url: "/calendar/delete",
        data:{
            no
        },
        success:function(result){        
            if(result == "success"){
                alert("일정 삭제 완료!!");
                console.log("로컬 비우기",typeNo,calcDate);  
                deleteLocalStorage(typeNo,calcDate);
                console.log("이벤트 비우기",typeNo,calcDate);  
                removeEventSource(typeNo,calcDate);
                addEventToCalendar(calcDate,typeNo,typeNo);
                $('#detailModal').modal('hide');
            }
            else{
                alert("일정 삭제 실패");
            }
        },
        error:function(){
            alert("서버와 통신 실패");
        }

    })

}

// 일정 내용 추가
function addContent(vo) {

    const contentTag = document.querySelector("#calendar-content-view");
    contentTag.innerHTML = null;

    if(vo.typeNo == 3){     
        const aTag = document.createElement("a");
        aTag.href="/project/people?projectNo="+vo.no+"&pno=1";
        aTag.textContent = "프로젝트 바로가기 >>";
        
        const brTag = document.createElement("br");

        const textNode = document.createTextNode(vo.content);

        contentTag.appendChild(aTag);
        contentTag.appendChild(brTag);
        contentTag.appendChild(textNode);
    }   
    else{
        contentTag.innerHTML = vo.content;
    }

}
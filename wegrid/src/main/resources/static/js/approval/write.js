let approvalStep = "";

// 결재자 설정 버튼 클릭
function handleApproval(step) {
    approvalStep = step;
    openEmpSearchModal();
    return false;
}

//모달 열기
function openEmpSearchModal(){
    document.querySelector("#empSearchModal").style.display = "block";
    document.querySelector("#searchTag").value = "";
}



// 모달 닫기
function closeEmpSearchModal(name , no , dept) {
    if(no != null && no != ""){
        setApprovalNo(no);
        setApprovalName(name);
        setApprovalDept(dept);
    }
    document.querySelector("#empSearchModal").style.display = "none";
}

//결재자 네임값 설정
function setApprovalName(name){
    const middleBtn = document.querySelector("#approvalMiddleBtn");
    const lastBtn = document.querySelector("#approvalLastBtn");

    if(approvalStep === "middle"){
        middleBtn.innerText = name;
        middleBtn.removeAttribute("class" , "approvalBtn");
        middleBtn.setAttribute("class" , "approvalaaa");
    }else if(approvalStep === "last"){
        lastBtn.innerText = name;
        lastBtn.removeAttribute("class" , "approvalBtn");
        lastBtn.setAttribute("class" , "approvalaaa");
    }
}

//결재자 네임값 설정
function setApprovalDept(dept){
    const middleDept = document.querySelector("#middleDept");
    const lastDept = document.querySelector("#lastDept");

    if(approvalStep === "middle"){
        middleDept.innerText = dept;
   
    }else if(approvalStep === "last"){
        lastDept.innerText = dept;
       
    }
}

//히든 태그에 결재자 정보 설정 //중간 또는 최종
function setApprovalNo(no){
    if(approvalStep === "middle"){
        document.querySelector("#approvalMiddle").value = no;
    }else if(approvalStep === "last"){
        document.querySelector("#approvalLast").value = no;
    }
}



//모달창에서 tr 클릭했을 때 동작하는 핸들러 설정
const tbodyTag = document.querySelector("#empSearchModalTable tbody");
tbodyTag.addEventListener("click" , function(evt){
    if(evt.target.tagName != "TD"){return;}
    const trTag = evt.target;
    const no = trTag.parentNode.children[0].innerText;
    const name = trTag.parentNode.children[3].innerText;
    const dept = trTag.parentNode.children[1].innerText;
    closeEmpSearchModal(name , no , dept);
});

// 드래그를 위한 변수 선언
let isDragging = false;
let startX, startY;
let modalX = 0, modalY = 0;

// 모달 요소 가져오기
const modal = document.querySelector(".empSearchModal-content");
const header = document.querySelector(".empSearchModal-header"); // 헤더로 드래그 가능하도록 설정

// 마우스 다운 이벤트
header.addEventListener("mousedown", (e) => {
    isDragging = true;
    startX = e.clientX - modalX;
    startY = e.clientY - modalY;
    modal.style.transition = "none"; // 이동 시 애니메이션 제거
});

// 마우스 이동 이벤트
document.addEventListener("mousemove", (e) => {
    if (isDragging) {
        modalX = e.clientX - startX;
        modalY = e.clientY - startY;

        // 모달 위치 업데이트
        modal.style.transform = `translate(${modalX}px, ${modalY}px)`;
    }
});

// 마우스 업 이벤트
document.addEventListener("mouseup", () => {
    isDragging = false;
});

function openEmpSearch(pno, searchType, searchValue) {
    const tbodyTag = document.querySelector("#empSearchModalTable tbody");
    const selectTag = document.querySelector("#dept-filter");

    if (pno == null) {
        pno = 1;
    }

    const prevSelectedValue = selectTag.value; // 기존 선택 값 저장

    $.ajax({
        url: `/approval/emp/list/data?pno=${pno}`,
        data: {
            searchType,
            searchValue,
        },
        success: function (m) {
            const memberVoList = m.a;
            const pvo = m.b;
            const deptVoList = m.c;
            paintPageArea(pvo);

            tbodyTag.innerHTML = "";
            selectTag.innerHTML = "";

            const selectAll = document.createElement("option");
            selectAll.setAttribute("value", "");
            selectAll.innerHTML = "전체";
            selectTag.appendChild(selectAll);

            for (const vo of deptVoList) {
                const optionTag = document.createElement("option");
                optionTag.setAttribute("value", vo.code);
                optionTag.innerText = vo.name;

                // 기존 선택값과 일치하면 선택 상태 유지
                if (vo.code === prevSelectedValue) {
                    optionTag.selected = true;
                }

                selectTag.appendChild(optionTag);
            }

            for (const vo of memberVoList) {
                const trTag = document.createElement("tr");
                trTag.setAttribute("class", "list-middle");
                const tdTag01 = document.createElement("td");
                tdTag01.innerText = vo.no;
                trTag.appendChild(tdTag01);

                const tdTag02 = document.createElement("td");
                tdTag02.innerText = vo.deptName;
                trTag.appendChild(tdTag02);

                const tdTag03 = document.createElement("td");
                tdTag03.innerText = vo.jobName;
                trTag.appendChild(tdTag03);

                const tdTag04 = document.createElement("td");
                tdTag04.innerText = vo.name;
                trTag.appendChild(tdTag04);

                tbodyTag.appendChild(trTag);
            }
        },
        error: function () {
            alert("출장 조회 실패");
        },
    });
}

 openEmpSearch();
function submitSearchForm(pno){
    
    const searchType = document.querySelector("#dept-filter").value;
    const searchValue = document.querySelector("#searchTag").value;

    openEmpSearch(pno , searchType , searchValue);

    return false; // 기본 이벤트 막을 수 있음
};

function paintPageArea(pvo){
    const pageArea = document.querySelector(".page");
    pageArea.innerHTML = "";
    //이전버튼
    if(pvo.startPage != 1){
        const aTag = document.createElement("a");
        const iTag = document.createElement("i");
        const spanTag = document.createElement("span");
        iTag.setAttribute("class" , "fas fa-caret-left fa-lg");
        iTag.setAttribute("id" , "leftPageBtn")
        aTag.setAttribute("onclick" , `submitSearchForm(${pvo.startPage-1})`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }
    
    for( let i = pvo.startPage ; i <= pvo.endPage ; i++ ){
        const aTag = document.createElement("a");
        const spanTag = document.createElement("span");
        aTag.setAttribute("onclick" ,`submitSearchForm(${i})`);
        aTag.innerText = i;
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }
    
    //다음버튼
    if(pvo.endPage != pvo.maxPage){
        const aTag = document.createElement("a");
        const iTag = document.createElement("i");
        const spanTag = document.createElement("span");
        iTag.setAttribute("class" , "fas fa-caret-right fa-lg");
        iTag.setAttribute("id" , "rightPageBtn");
        aTag.setAttribute("onclick" , `submitSearchForm(${pvo.endPage+1})`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }

}

function cancle(){
    // if (!window.confirm('결재등록을 취소하시겠습니까?')) {
    //     event.preventDefault(); // 기본 동작 중단
    // }
    if(window.confirm('결재등록을 취소하시겠습니까?')){
        location.href="/approval/submitList"
    }else{
        return false;
    }
   
    
}

function confirmSubmission() {
    if (!window.confirm('결재를 등록하시겠습니까?')) {
      return false;
    }
    return
}


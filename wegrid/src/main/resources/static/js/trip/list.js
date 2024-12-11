// 모달 열기
function openTripModal() {
    document.getElementById("tripModal").style.display = "block";
    fqes();
}

// 모달 닫기
function closeTripModal() {
    document.getElementById("tripModal").style.display = "none";
}

// 모달 외부 클릭 시 닫기
// window.onclick = function(event) {
//     const modal = document.getElementById("tripModal");
//     if (event.target === modal) {
//         modal.style.display = "none";
//     }
// };
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}
// 드래그를 위한 변수 선언
let isDragging = false;
let startX, startY;
let modalX = 0, modalY = 0;

// 모달 요소 가져오기
const modal = document.querySelector(".tripModal-content");
const header = document.querySelector(".tripModal-header"); // 헤더로 드래그 가능하도록 설정

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
        aTag.setAttribute("href" , `/trip/list?pno=${pvo.startPage-1}`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }
    
    for( let i = pvo.startPage ; i <= pvo.endPage ; i++ ){
        const aTag = document.createElement("a");
        const spanTag = document.createElement("span");
        aTag.setAttribute("href" , `/trip/list?pno=${i}`);
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
        aTag.setAttribute("href" , `/trip/list?pno=${pvo.endPage+1}`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }

}





function loadTripList(searchType , searchValue){
    const tbodyTag = document.querySelector("#table>tbody");

    const url = new URL(location);
    let pno = url.searchParams.get("pno");
    if(pno == null){
        pno = 1;
    }
    $.ajax({
        
        url : `/trip/list/data?pno=${pno}` ,
        data : {
            searchType ,
            searchValue ,
        },
       
        success : function(m){
            const tripVoList = m.a;
            const pvo = m.b;
            paintPageArea(pvo);

            tbodyTag.innerHTML="";
            
            for(let vo of tripVoList){
                const trTag = document.createElement("tr");
                trTag.setAttribute("class" , "list-middle")
                const tdTag01 = document.createElement("td");
                tdTag01.innerText = vo.no;
                trTag.appendChild(tdTag01)
    
                const tdTag02 = document.createElement("td");
                tdTag02.innerText = vo.title;
                trTag.appendChild(tdTag02)
    
                const tdTag03 = document.createElement("td");
                tdTag03.innerText = vo.startDate;
                trTag.appendChild(tdTag03)
    
                const tdTag04 = document.createElement("td");
                tdTag04.innerText = vo.endDate;
                trTag.appendChild(tdTag04)
    
                const tdTag05 = document.createElement("td");
                tdTag05.innerText = vo.writerName;
                trTag.appendChild(tdTag05)
                
                const tdTag06 = document.createElement("td");
                tdTag06.innerText = vo.typeName;
                trTag.appendChild(tdTag06)
                
                
                tbodyTag.appendChild(trTag);

            }
            
            
        },
        error : 
        function(){
            alert("출장 조회 실패")
        },

    });


}

loadTripList();

function endTripList(searchType , searchValue){
    const tbodyTag = document.querySelector("#table>tbody");

    const url = new URL(location);
    let pno = url.searchParams.get("pno");
    if(pno == null){
        pno = 1;
    }
    $.ajax({
        
        url : `/trip/endList/data?pno=${pno}` ,
        data : {
            searchType ,
            searchValue ,
        },
       
        success : function(m){
            const tripVoList = m.a;
            const pvo = m.b;
            paintPageArea(pvo);

            tbodyTag.innerHTML="";
            
            for(let vo of tripVoList){
                const trTag = document.createElement("tr");
                trTag.setAttribute("class" , "list-middle")
                const tdTag01 = document.createElement("td");
                tdTag01.innerText = vo.no;
                trTag.appendChild(tdTag01)
    
                const tdTag02 = document.createElement("td");
                tdTag02.innerText = vo.title;
                trTag.appendChild(tdTag02)
    
                const tdTag03 = document.createElement("td");
                tdTag03.innerText = vo.startDate;
                trTag.appendChild(tdTag03)
    
                const tdTag04 = document.createElement("td");
                tdTag04.innerText = vo.endDate;
                trTag.appendChild(tdTag04)
    
                const tdTag05 = document.createElement("td");
                tdTag05.innerText = vo.writerName;
                trTag.appendChild(tdTag05)
                
                const tdTag06 = document.createElement("td");
                tdTag06.innerText = vo.typeName;
                trTag.appendChild(tdTag06)
                
                
                tbodyTag.appendChild(trTag);

            }
            
            
        },
        error : 
        function(){
            alert("출장 조회 실패")
        },

    });

}

const tbodyTag = document.querySelector("#table>tbody");

// tbodyTag.addEventListener("click" , function(evt){
//     if(evt.target.tagName != "TD"){return;}
//     const no = evt.target.parentNode.children[0].innerText;
//     console.log( evt.target.parentNode.parentNode);
//     location.href=`/trip/detail?tno=${no}`;
// });

tbodyTag.addEventListener("click", function(evt) {
    if (evt.target.tagName != "TD") { return; }
    
    // 현재 클릭된 tr 태그
    const currentTr = evt.target.parentNode;
    const currentNo = currentTr.children[0].innerText;
    let nextNo = "";
    let previousNo = "";
    console.log("현재 tr의 첫 번째 td 값:", currentNo);

    // 이전 tr 태그
    const previousTr = currentTr.previousElementSibling;
    if (previousTr) {
        previousNo = previousTr.children[0].innerText;
        console.log("이전 tr의 첫 번째 td 값:", previousNo);
    } else {
        
        console.log("이전 tr이 존재하지 않습니다.");
    }

    // 다음 tr 태그
    const nextTr = currentTr.nextElementSibling;
    if (nextTr) {
        nextNo = nextTr.children[0].innerText;
        console.log("다음 tr의 첫 번째 td 값:", nextNo);
    } else {
        
        console.log("다음 tr이 존재하지 않습니다.");
    }

    // 현재 tr의 값으로 이동
    location.href = `/trip/detail?tno=${currentNo}&preNo=${previousNo}&nextNo=${nextNo}`;
});




function submitSearchForm(){
    
    const searchType = document.querySelector("#trip-filter").value;
    const searchValue = document.querySelector("#searchTag").value;

    loadTripList(searchType , searchValue);

    return false; // 기본 이벤트 막을 수 있음
};

document.addEventListener("DOMContentLoaded", function(){
    const today = new Date().toISOString().split("T")[0]; // 현재 날짜
    const startDateInput = document.querySelector("input[name=startDate]");
    const endDateInput = document.querySelector("input[name=endDate]");  

    
    startDateInput.min = today;

    
    startDateInput.addEventListener("change", function(){
        endDateInput.min = startDateInput.value; // 종료 날짜 최소값 = 시작 날짜
    });
});


//     window.confirm("출장등록 하시겠습니까?");
// });
const radioValue = document.querySelectorAll("input[type=radio]");

function fqes(){
    for(const vo of radioValue){
        if(vo.value == "1"){
            vo.checked=true;
            console.log(vo);
        }
    }
}

const buttons = document.querySelectorAll('.fil-btn-z');

buttons.forEach(button => {
    button.addEventListener('click', () => {
        buttons.forEach(btn => btn.classList.remove('active'));

        button.classList.add('active');
    });
});

function sub(){
    if(!window.confirm('출장등록을 하시겠습니까?')){
        return false;
    }
    return;
}

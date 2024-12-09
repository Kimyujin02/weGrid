
// 항목 별 탭 클릭 시 캘린더 일정 hide/show
const filterBox = document.querySelector(".calendar-filter-area");
filterBox.addEventListener("click", function(evt){
    const typeNo = evt.target.getAttribute("no");
    // 캘린더 타입 div 외 선택 시 return
    if(evt.target.tagName !="DIV" || !(evt.target.className).includes("filter-box")){
        return
    }

    // 선택된 캘린더 타입에 '선택됨' 클래스 부여 및 선택했어던 다른 캘린더 타입 '선택됨' 제거
    if(evt.target.className.includes("selected-calendar")){
        evt.target.classList.remove("selected-calendar");
        removeEventSource(typeNo);
    }
    else{
        evt.target.classList.add("selected-calendar");
        addEventToCalendar(0,typeNo,typeNo);

    }

});

// 날짜 이동 시 이동 한 날짜 계산
function calculateDate(date,type){

    let calcDate = new Date(date.getFullYear(),date.getMonth());

    if(type == "+m"){
        calcDate.setMonth(calcDate.getMonth()+1);
    }
    else if(type=="-m"){
        calcDate.setMonth(calcDate.getMonth()-1);
    }
    else if(type=="+y"){
        calcDate.setFullYear(calcDate.getFullYear()+1);    
    }
    else if(type=="-y"){
        calcDate.setFullYear(calcDate.getFullYear()-1);    
    }

    let yy = calcDate.getFullYear();
    let mm = calcDate.getMonth();
    
    if(mm != 12){
        mm += 1;
        if(mm < 10){
            mm = "0"+mm;
        }
    }
    calcDate= yy+"-"+mm;

    // return calcDate;
    return yy;

}

// local저장소 데이터 삭제
function deleteLocalStorage(typeNo,date){
    console.log("삭제 시작");
    if(date != null){
        const itemName = date+"-"+typeInfo[typeNo].type;
        localStorage.removeItem(itemName);
    }
    else{
        for(let i=localStorage.length-1; i>=0; i--){
          const itemName = localStorage.key(i);
          if(itemName.includes(typeInfo[typeNo].type) && itemName != "calendar-type-info" && itemName != "calendar-kind-info"){
            localStorage.removeItem(itemName);
          }
        }
    }
    console.log("삭제 완료");
}

// 서버에서 캘린더 항목 별 정보 가져오기
function getCalendarInfo(){
    console.log("캘린더 항목, 일정종류 정보 불러오기 시작");
    if(typeInfo == null){
        // 서버에서 정보 불러오기
        $.ajax({
            url: "/calendar/calendarInfo",
            async : false,
            success : function(infoDataMap){
                // 데이터 꺼내기
                const getTypeInfo = infoDataMap.typeInfo;
                const getKindInfo = infoDataMap.kindInfo;
                // 인덱스 맞추기 위해 항목 정보 리스트에 빈 값 추가
                const emptyData = {};
                getTypeInfo.unshift(emptyData);
                // local 저장소에 저장
                localStorage.setItem("calendar-type-info" , JSON.stringify(getTypeInfo));           
                localStorage.setItem("calendar-kind-info" , JSON.stringify(getKindInfo));           
            },
            error : function(){
                alert("캘린더 항목, 일정종류 정보 조회 실패");
            } 
        })
        // 전역변수에 불러온 정보 저장
        typeInfo = JSON.parse(localStorage.getItem("calendar-type-info"));
        kindInfo = JSON.parse(localStorage.getItem("calendar-kind-info"));
        
    }
    console.log("캘린더 항목, 일정종류 정보 불러오기 완료");
}

// 캘린터 페이지 로드 시 캘린더 화면 실행
document.addEventListener('DOMContentLoaded', function(){
    console.log("캘린더 생성 시작");  
    // 캘린더 생성
    loadCalendar();
    console.log("캘린더 생성 완료"); 
})
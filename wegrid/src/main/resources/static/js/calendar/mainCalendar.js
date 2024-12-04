
// 항목 별 탭 클릭 시 캘린더 일정 hide/show
const filterBox = document.querySelector(".calendar-filter-area");
filterBox.addEventListener("click", function(evt){

    // 캘린더 타입 div 외 선택 시 return
    if(evt.target.tagName !="DIV" || !(evt.target.className).includes('filter-box')){
        return
    }

    // 선택된 캘린더 타입에 '선택됨' 클래스 부여 및 선택했어던 다른 캘린더 타입 '선택됨' 제거

    if(evt.target.className.includes("selected-calendar")){
        evt.target.classList.remove('selected-calendar');
        // hideEvtSource(evt);
        removeEventSource(evt.target.no);
    }
    // }
    else{
        evt.target.classList.add('selected-calendar');
        showEvtSource(evt);
        // console.log(document.querySelectorAll("."+evt.target.id+"_schedule"));
        // document.querySelectorAll("."+evt.target.id+"_schedule").classList.remove('hidden-schedule');
        // document.querySelectorAll("."+evt.target.id+"_schedule").style.display = "block";
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

    return calcDate;

}

// local저장소 데이터 삭제
function deleteLocalStorage(typeNo,date){
    console.log("삭제 시작");
    if(date != null){
        const itemName = date+"_"+typeInfo[typeNo].type;
        localStorage.removeItem(itemName);
    }
    else{
        for(let i=localStorage.length-1; i>=0; i--){
          const itemName = localStorage.key(i);
          if(itemName.includes(typeInfo[typeNo].type) && itemName != "calendar-type-info"){
            localStorage.removeItem(itemName);
          }
        }
    }
    console.log("삭제 완료");
}

function showEvtSource(evt){
    const targetArr = document.querySelectorAll("."+evt.target.id+"_schedule");
    for(let i = 0; i < targetArr.length; i++){
        targetArr[i].classList.remove('hidden-schedule');
    }

    // const calcDate = calculateDate(mainCalendar.getDate());
    // const targetId = evt.target.id;
    // const itemName = calcDate+"_"+targetId;
    // const source = JSON.parse(localStorage.getItem(itemName));
    // mainCalendar.addEventSource( source );
}

function hideEvtSource(evt){
    
    console.log("no 값 : ",evt.target.id);
    
    const targetArr = document.querySelectorAll("."+evt.target.id+"_schedule");
    for(let i = 0; i < targetArr.length; i++){
        targetArr[i].classList.add('hidden-schedule');
    }

    // const calcDate = calculateDate(mainCalendar.getDate());
    // const targetId = evt.target.id;
    // const itemName = calcDate+"_"+targetId;
    // const evtSources = mainCalendar.getEventSourceById(itemName);
    // evtSources.remove();

}

// 서버에서 캘린더 항목 별 정보 가져오기
function getTypeInfo(){
    console.log("캘린더 항목 별 정보 불러오기 시작");
    if(typeInfo == null){
        // 서버에서 캘린더 타입 정보 불러오기
        $.ajax({
            url: "/calendar/getTypeInfo",
            async : false,
            success : function(getTypeData){
                const emptyData = {};
                getTypeData.unshift(emptyData);
                localStorage.setItem("calendar-type-info" , JSON.stringify(getTypeData));           
            },
            error : function(){
                alert("캘린더 항목 별 정보 조회 실패");
            } 
        })
        // 전역변수에 불러온 정보 저장
        typeInfo = JSON.parse(localStorage.getItem("calendar-type-info"));
        
    }
    console.log("캘린더 항목 별 정보 불러오기 완료");
}

// 캘린터 페이지 로드 시 캘린더 화면 실행
document.addEventListener('DOMContentLoaded', function(){
    console.log("캘린더 생성 시작");  
    // 캘린더 생성
    loadCalendar();
    console.log("캘린더 생성 완료"); 
})

// 캘린터 페이지 로드 시 개인 캘린더 화면 실행
document.addEventListener('DOMContentLoaded', function(){
    
    const today = new Date();
    loadCalendar(today,1);

})

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
    }
    else{
        evt.target.classList.add('selected-calendar');
    }

    const no = evt.target.value;


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
    else {
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
    const x = yy+"-"+mm;

    return calcDate;

}

// function loadEvents(date,no){

//     $.ajax({
//         url: "/calendar/load",

        
//     })

// }
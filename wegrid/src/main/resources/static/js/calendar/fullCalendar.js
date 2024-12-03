
function loadEvents(calcDate,typeNo){
  
  // 캘린더 항목 별 정보 수집
  const typeInfo = JSON.parse(localStorage.getItem("calendar-type-info"));
  
  // 인덱스 변수 설정
  const stNum = 0, endNum = 3;
  if(typeNo != 0){
    stNum = typeNo;
    endNum = typeNo+1;
  }

  for(let i = stNum; i  < endNum; i++){
    // local 저장소에 저장할 일정정보 이름 생성
    const itemName = calcDate+"_"+typeInfo[i].type;
    // local 저장소에서 해당 일정정보 이미 존재하는지 확인
    const localData =  JSON.parse(localStorage.getItem(itemName));
  
    if(localData == null){  
      // 해당 일정정보 local 저장소에 없으면 서버에서 데이터 호출
      $.ajax({
        url: "/calendar/load",
        async : false,
        data: {
            date:calcDate,
            type:typeInfo[i].type
        },
        success : function(getData){
            localStorage.setItem(itemName, JSON.stringify(getData));
            mainCalendar.addEventSource(JSON.parse(localStorage.getItem(itemName)));
        },
        error : function(){
            alert("캘린더 조회 실패");
            return "fail";
        }        
      })
    }
    else if(mainCalendar.getEventSourceById(itemName) == null) {
      // local 저장소에 일정정보 존재하지만 EventSouces에 없는 경우 추가
      mainCalendar.addEventSource( JSON.parse(localStorage.getItem(itemName)));
    }
    else {
      // 해당 일정정보 이미 존재
      // return "done";
    }
  }
}

// fullCalendar 로 달력 생성
let mainCalendar = "";
function loadCalendar() {
  console.log("로드 시작");

  const typeInfo = JSON.parse(localStorage.getItem("calendar-type-info"));
  if(typeInfo == null){
    getTypeInfo();
  }

  const calendarEl = document.querySelector("#calendar");

  mainCalendar = new FullCalendar.Calendar(calendarEl, {
    // themeSystem: 'bootstrap5',
    customButtons: {
      writeBtn: {
        text: '일정 추가',
        click: function () {
          const date = new Date();
          openWriteModal(date);
        }
      },
      customPrevY: { // 이전 연도로 이동
        icon: 'fc-icon-chevrons-left',
        click: function (evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"-y");
          loadEvents(calcDate,0);
          mainCalendar.prevYear();
        }
      },
      customPrev: { // 이전 달로 이동
        icon: 'fc-icon-chevron-left',
        click: function (evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"-m");
          loadEvents(calcDate,0);
          mainCalendar.prev();
        }
      },
      customNext: { // 다음 월로 이동
        icon: 'fc-icon-chevron-right',
        click: function(evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"+m");
          loadEvents(calcDate,0);
          mainCalendar.next();
        }
      },
      customNextY: { // 다음 연도로 이동
        icon: 'fc-icon-chevrons-right',
        click: function(evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"+y");
          loadEvents(calcDate,0);
          mainCalendar.nextYear();
        }
      }
    },
    headerToolbar: {
      left: 'writeBtn',
      center: 'customPrevY customPrev title customNext customNextY',
      right: 'today'
    },
    initialView: 'dayGridMonth',
    // editable: true,
    editable: false,
    // eventLimit: true,
    dayMaxEvents: true,
    timeZone: 'local',
    locale: 'ko',
    expandRows: true,
    dateClick: function (evt) {
      openWriteModal(evt.date);
    },
    eventClick: function (evt) {
      showEventDetail(evt);
    },
    eventSources:[
     
    ]

  })
  
  // 캘린더 생성
  mainCalendar.render();

  console.log("로드 성공");
}
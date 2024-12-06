
// 전역 변수 선언
let mainCalendar = "";
let typeInfo = JSON.parse(localStorage.getItem("calendar-type-info"));
let kindInfo = JSON.parse(localStorage.getItem("calendar-kind-info"));

// 서버에서 일정정보 불러오기
function loadEvents(date,type,typeNo,itemName){  
  console.log("서버에서 데이터 호출 시작" , itemName);
  let loadDataJSON = "";

  $.ajax({
    url: "/calendar/load",
    async : false,
    data: {
      date,
      type,
      typeNo
    },
    success : function(loadData){
      loadDataJSON = JSON.stringify(loadData);
      localStorage.setItem(itemName, loadDataJSON);
    },
    error : function(){
      alert("캘린더 조회 실패");
      return "fail";
    }        
  })
  console.log("서버에서 데이터 호출 완료" , itemName);
  return loadDataJSON;

}

// 캘린더에 일정정보 추가하기
function addEventToCalendar(calcDate,typeNo1,typeNo2){
  console.log("일정정보 추가 시작",calcDate);
  // 인덱스 변수 설정
  const stNum = typeNo1, endNum = typeNo2;
  
  for(let i = stNum; i  <= endNum; i++){
    
    // local 저장소에 저장할 일정정보 이름 생성
    const typeName = typeInfo[i].type;
    const itemName = calcDate+"-"+typeName;
    
    if(calcDate==0){
      for(let i = 0; i < localStorage.length; i++){
        const storageName = localStorage.key(i);
        if(storageName.includes(typeName)){
          mainCalendar.addEventSource(JSON.parse(localStorage.getItem(storageName)));
        }
      }
    }
    else if(mainCalendar.getEventSourceById(itemName) == null){
      
      // local 저장소에서 해당 일정정보 이미 존재하는지 확인
      let localData = localStorage.getItem(itemName);

      // 일정정보 없으면 일정정보 불러오기 함수 호출
      if(localData == null) {
        localData = loadEvents(calcDate,typeName,typeInfo[i].no,itemName);
      }
      
      const typeClassName = document.querySelector("#"+typeName).className;
      if(typeClassName.includes("selected-calendar")){
        // 캘린더에 일정정보 추가
        mainCalendar.addEventSource(JSON.parse(localData));
      }
      
    }
    
  }
  console.log("추가 후 eventsources",mainCalendar.getEventSources());
  
  console.log("일정정보 추가 완료",calcDate);
}

// 캘린더에서 일정정보 삭제하기
function removeEventSource(typeNo,date){

  const typeName = typeInfo[typeNo].type;

  if(date != null){
    const eventId = date+"-"+typeName;
    (mainCalendar.getEventSourceById(eventId)).remove();
  }
  else{
    const evtList = mainCalendar.getEventSources();    
    for(let i=evtList.length-1; i>=0; i--){
      const eventId = evtList[i].id;
      if(eventId.includes(typeName)){
        (mainCalendar.getEventSourceById(eventId)).remove();
      }
    }
  }

}

// fullCalendar로 달력 생성
function loadCalendar() {
  console.log("로드 시작");
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
          addEventToCalendar(calcDate,1,3);
          mainCalendar.prevYear();
        }
      },
      customPrev: { // 이전 달로 이동
        icon: 'fc-icon-chevron-left',
        click: function (evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"-m");
          addEventToCalendar(calcDate,1,3);
          mainCalendar.prev();
        }
      },
      customNext: { // 다음 월로 이동
        icon: 'fc-icon-chevron-right',
        click: function(evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"+m");
          addEventToCalendar(calcDate,1,3);
          mainCalendar.next();
        }
      },
      customNextY: { // 다음 연도로 이동
        icon: 'fc-icon-chevrons-right',
        click: function(evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"+y");
          addEventToCalendar(calcDate,1,3);
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
  
  // 캘린더 항목, 일정종류 정보 전역변수 저장
  getCalendarInfo();

  // 개인일정 제외한 local 저장소 초기화
  deleteLocalStorage(1);
  deleteLocalStorage(2);
  deleteLocalStorage(3);

  // 첫 화면 일정 정보 추가
  const today = calculateDate(new Date());
  addEventToCalendar(today,1,3);
  
  // 캘린더 생성
  mainCalendar.render(); 
  console.log("로드 성공");
}
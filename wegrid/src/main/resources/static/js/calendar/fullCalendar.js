
function loadEvents(calcDate){
  console.log("이벤트 로드 시작");
  
  const typeInfo = JSON.parse(localStorage.getItem("calendar-type-info"));

  for(let i = 0; i<3; i++){
    const itemName = calcDate+"_"+typeInfo[i].no;

    if(localStorage.getItem(itemName) != null){
      if(mainCalendar.getEventSourceById(itemName) == null){
        mainCalendar.addEventSource( JSON.parse(localStorage.getItem(itemName)));
      }
      
      if(i != 2){
        continue;
      }
      else {
        return "done";
      }

    }

    $.ajax({
        url: "/calendar/load",
        async : false,
        data: {
            date:calcDate,
            typeNo:typeInfo[i].no
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

}

// fullCalendar 로 달력 생성
let mainCalendar = "";
function loadCalendar(nowDate) {
  
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
          write(date);
        }
      },
      customPrevY: { // 이전 연도로 이동
        icon: 'fc-icon-chevrons-left',
        click: function (evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"-y");
          loadEvents(calcDate);
          mainCalendar.prevYear();
        }
      },
      customPrev: { // 이전 달로 이동
        icon: 'fc-icon-chevron-left',
        click: function (evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"-m");
          loadEvents(calcDate);
          mainCalendar.prev();
        }
      },
      customNext: { // 다음 월로 이동
        icon: 'fc-icon-chevron-right',
        click: function(evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"+m");
          loadEvents(calcDate);
          mainCalendar.next();
        }
      },
      customNextY: { // 다음 연도로 이동
        icon: 'fc-icon-chevrons-right',
        click: function(evt) {
          const calcDate = calculateDate(mainCalendar.getDate(),"+y");
          loadEvents(calcDate);
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
      write(evt.date);
    },
    eventClick: function (evt) {
      console.log(evt);
      // detail();
    },
    eventSources:[
     
    ]

  })
  
  // 캘린더 생성
  mainCalendar.render();

  console.log("로드 성공");

}
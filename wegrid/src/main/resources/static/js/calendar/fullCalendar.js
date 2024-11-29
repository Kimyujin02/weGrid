// fullCalendar 로 달력 생성
function loadCalendar(date, no) {

  const calendarEl = document.querySelector("#calendar");

  const mainCalendar = new FullCalendar.Calendar(calendarEl, {
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
          console.log(evt);
          calculateDate(mainCalendar.getDate(),"-y");
          mainCalendar.prevYear();
        }
      },
      customPrev: { // 이전 달로 이동
        icon: 'fc-icon-chevron-left',
        click: function (evt) {
          console.log(evt);
          calculateDate(mainCalendar.getDate(),"-m");
          mainCalendar.prev();
        }
      },
      customNext: { // 다음 월로 이동
        icon: 'fc-icon-chevron-right',
        click: function(evt) {
          console.log(evt);
          calculateDate(mainCalendar.getDate(),"+m");
          mainCalendar.next();
        }
      },
      customNextY: { // 다음 연도로 이동
        icon: 'fc-icon-chevrons-right',
        click: function(evt) {
          console.log(evt);
          calculateDate(mainCalendar.getDate(),"+y");
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
    eventLimit: true,
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
    eventSource:[
      {
        events: [
         
        ],
        color: "#ABE1FF",
        text: "#FFFFFF"
      },
      {
        events: [
          {
            title: 'Business Lunch',
            start: '2024-11-03T13:00:00',
            constraint: 'businessHours'
          },
          {
            title: 'Meeting',
            start: '2024-11-13T11:00:00',
            constraint: 'availableForMeeting', // defined below
          },
          {
            title: 'Conference',
            start: '2024-11-18',
            end: '2024-11-20'
          },
          {
            title: 'Party',
            start: '2024-11-29T20:00:00'
          },
    
          // areas where "Meeting" must be dropped
          {
            groupId: 'availableForMeeting',
            start: '2024-10-11T10:00:00',
            end: '2024-10-11T16:00:00',
            rendering: 'background'
          },
          {
            groupId: 'availableForMeeting',
            start: '2024-10-13T10:00:00',
            end: '2024-10-13T16:00:00',
            rendering: 'background'
          },
    
          // red areas where no events can be dropped
          {
            start: '2024-11-24',
            end: '2024-11-28',
            overlap: false,
            rendering: 'background',
            color: '#ff9f89'
          },
          {
            start: '2024-12-06',
            end: '2024-12-08',
            overlap: false,
            rendering: 'background',
            color: '#ff9f89'
          }
        ]
      }
    
    ]
   
  })

  // 캘린더 생성
  mainCalendar.render()

}
document.addEventListener('DOMContentLoaded', function() {
    
    const calendarEl = document.querySelector("#calendar");

    const calendar = new FullCalendar.Calendar(calendarEl, {
        themeSystem: 'bootstrap5',
        headerToolbar: {
            left: '',
            center: 'prevYear prev title next nextYear',
            right:'today'
        },
        initialView: 'dayGridMonth',
        editable: true,
        eventLimit: true,
        dayMaxEvents: true,
        timeZone: 'local',
        locale: 'ko',
        expandRows: true,
    })

    calendar.render()

  })
// 일정 추가
function openWriteModal(date) {

    // 창 실행 전 내용 초기화
    document.querySelector("#calendar_title").value = "";
    document.querySelector("#calendar_content").value = "";
    document.querySelector("#calendar_start_date").value = "";
    document.querySelector("#calendar_end_date").value = "";
    document.querySelector("#calendar_type").value = "";

    // 전달받은 날짜 정보 YYYY-MM-DD 형식으로 변환
    const yyyy = date.getFullYear().toString();
    let mm = date.getMonth() + 1;
    mm = mm < 10 ? '0' + mm.toString() : mm.toString();
    let dd = date.getDate();
    dd = dd < 10 ? '0' + dd.toString() : dd.toString();

    // 입력창 기본 날짜 설정
    // const todayDate = info.dateStr+"T00:00"; // 클릭할 날짜 값을 input 태그 형식에 맞게 00시로 변환
    const todayDate = yyyy + "-" + mm + "-" + dd + "T00:00"; // 클릭할 날짜 값을 input 태그 형식에 맞게 00시로 변환
    const startDateTag = document.querySelector("#calendar_start_date");
    startDateTag.value=todayDate;
    const endDateTag = document.querySelector("#calendar_end_date");
    endDateTag.value=todayDate;

    // 모달창에 항목 정보 추가
    loadTypeInfo();

    // 모달 창 띄우기
    $("#writeModal").modal("show");

    // 추가 버튼 클릭 시
    // $("#addCalendar").on("click", function () {  // modal의 추가 버튼 클릭 시
    //     // var content = $("#calendar_content").val();
    //     // var start_date = $("#calendar_start_date").val();
    //     // var end_date = $("#calendar_end_date").val();

    //     // //내용 입력 여부 확인
    //     // if (content == null || content == "") {
    //     //     alert("내용을 입력하세요.");
    //     // } else if (start_date == "" || end_date == "") {
    //     //     alert("날짜를 입력하세요.");
    //     // } else if (new Date(end_date) - new Date(start_date) < 0) { // date 타입으로 변경 후 확인
    //     //     alert("종료일이 시작일보다 먼저입니다.");
    //     // } else { // 정상적인 입력 시
    //     //     var obj = {
    //     //         "title": content,
    //     //         "start": start_date,
    //     //         "end": end_date
    //     //     }//전송할 객체 생성

    //     //     console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
    //     // }

        
    // });

}

// 캘린더 항목 정보 모달창에 추가
function loadTypeInfo(){

    const typeInfo = JSON.parse(localStorage.getItem("calendar-type-info"));

    const selectTag = document.querySelector("#calendar_type");
    const areaTag = document.querySelector(".type-area");

    if( selectTag.firstElementChild == null){
                
        for (let i = 0; i < typeInfo.length; i++) {
            const optionTag = document.createElement("option");
            optionTag.value = typeInfo[i].no;
            optionTag.innerText = typeInfo[i].name;
            if(i==0){
                optionTag.setAttribute("selected","selected");
            }
            selectTag.appendChild(optionTag);
        }

    }else{
        selectTag.firstElementChild.setAttribute("selected","selected");
    }
    
    let colorTag = document.querySelector("input[name=color]");
    if(colorTag == null){
        colorTag = document.createElement("input");
        colorTag.setAttribute("type","color");
        colorTag.setAttribute("name","color");
        colorTag.setAttribute("readonly",true);
        areaTag.appendChild(colorTag);
    }

    colorTag.value=typeInfo[0].color;

    selectTag.addEventListener("change", function(evt){

        colorTag.value=typeInfo[evt.target.value-1].color;
    })

}


function insertToDB(){

    // 입력할 데이터 수집
    const aa = document.querySelector("form");
    var formData = new FormData(aa);
    const a = $("#calendar_title").val();
    console.log(a);
    
    console.log(aa);
    console.log(formData);

    // formData = $("form").serialize();
    return false;

    // 서버에 데이터 전달
    $.ajax({
        url: "/calendar/write",
        method: "POST",
        data: formData,
        success: function(result){
            console.log(result);
            
            // loadEvents(date,typeNo);
        },
        error: function(){
            
        }
        
    })


    return false; 

}
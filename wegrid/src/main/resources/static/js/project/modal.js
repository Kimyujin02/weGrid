

 // 모달 창 띄우기
 $("#writeModal").modal("show");

 // 추가 버튼 클릭 시
 $("#addCalendar").on("click",function(){  // modal의 추가 버튼 클릭 시
     var content = $("#calendar_content").val();
     var start_date = $("#calendar_start_date").val();
     var end_date = $("#calendar_end_date").val();
     
     //내용 입력 여부 확인
     if(content == null || content == ""){
         alert("내용을 입력하세요.");
     }else if(start_date == "" || end_date ==""){
         alert("날짜를 입력하세요.");
     }else if(new Date(end_date)- new Date(start_date) < 0){ // date 타입으로 변경 후 확인
         alert("종료일이 시작일보다 먼저입니다.");
     }else{ // 정상적인 입력 시
         var obj = {
             "title" : content,
             "start" : start_date,
             "end" : end_date
         }//전송할 객체 생성

         console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
     }
 });
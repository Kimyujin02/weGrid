// 일정 추가
function showEventDetail(evt) {
    
    $.ajax({
        url: "/calendar/detail",
        data :{
            no : evt.event.id
        },
        success:function(vo){
            console.log(vo);
            console.log(vo.color);
            console.log(document.querySelector("#color-view"));
            console.log(document.querySelector("#color-view").style.backgrounColor);
            const aa = document.querySelector("#color-view");
            console.log(aa.style.backgrounColor);
            
            
            
            console.log("통신 성공");
            document.querySelector("#typName-view").innerText=vo.typeName;
            document.querySelector("#color-view").style.backgroundColor=vo.color;
            document.querySelector("#title-view").innerText=vo.title;
            document.querySelector("#startDate-view").innerText=vo.startDate;
            document.querySelector("#endDate-view").innerText=vo.endDate;
            if(vo.kindNo != null){

                if(document.querySelector("#kindName-view") == null){
                    const areaTag = document.querySelector("#kindName-view-area");
                    
                    const kindTag = document.createElement("div");
                    kindTag.setAttribute("id","kindName-view");
                    kindTag.setAttribute("class","calendar-detail-view-box");
                    kindTag.innerText=vo.kindName;
    
                    areaTag.appendChild(kindTag);
                }
            }
            document.querySelector("#content-view").innerHTML=vo.content;
            
            // 모달 창 띄우기
            $("#detailModal").modal("show");
        },
        error:function(){
            console.log("통신 실패");

        }


    })



}
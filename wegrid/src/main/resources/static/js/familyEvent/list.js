
function openFamilyEventNotion(){
    window.open('https://www.notion.so/154d5a279fee80c88482d6f734abfa6a?v=ca476901e4e744428dc0d858217d12ca', '_blank');
}



function paintPageArea(pvo){
    const pageArea = document.querySelector(".page");
    pageArea.innerHTML = "";
    //이전버튼
    if(pvo.startPage != 1){
        const aTag = document.createElement("a");
        const iTag = document.createElement("i");
        const spanTag = document.createElement("span");
        iTag.setAttribute("class" , "fas fa-caret-left fa-lg");
        iTag.setAttribute("id" , "leftPageBtn")
        aTag.setAttribute("href" , `/trip/list?pno=${pvo.startPage-1}`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }
    
    for( let i = pvo.startPage ; i <= pvo.endPage ; i++ ){
        const aTag = document.createElement("a");
        const spanTag = document.createElement("span");
        aTag.setAttribute("href" , `/trip/list?pno=${i}`);
        aTag.innerText = i;
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }
    
    //다음버튼
    if(pvo.endPage != pvo.maxPage){
        const aTag = document.createElement("a");
        const iTag = document.createElement("i");
        const spanTag = document.createElement("span");
        iTag.setAttribute("class" , "fas fa-caret-right fa-lg");
        iTag.setAttribute("id" , "rightPageBtn");
        aTag.setAttribute("href" , `/trip/list?pno=${pvo.endPage+1}`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }

}



function loadTripList(searchType , searchValue){
    const tbodyTag = document.querySelector("#table>tbody");

    const url = new URL(location);
    let pno = url.searchParams.get("pno");
    if(pno == null){
        pno = 1;
    }
    $.ajax({
        
        // url : `/trip/list/data?pno=${pno}` ,
        url : `/familyEvent/list` ,
        method : "post" ,
        // data : {
        //     searchType ,
        //     searchValue ,
        // },
       
        success : function(m){
            // const tripVoList = m.a;
            // const pvo = m.b;
            // paintPageArea(pvo);
            
            const data = JSON.parse(m);
           
            // 필요한 정보만 추출
            
            const extractedData = data.results.map(result => {
            const title = result.properties.title.title[0].text.content;
            const writer = result.properties.writer.rich_text[0]?.text.content || '';
            const content = result.properties.content.rich_text[0]?.text.content || '';
            const location = result.properties.location.rich_text[0]?.text.content || '';
            const url = result.url;

            return { title, writer, content, location, url };
            });
            
            // 3. 결과 출력
            console.log(extractedData);

            // tbodyTag.innerHTML="";
            
            // for(let vo of tripVoList){
            //     const trTag = document.createElement("tr");
            //     trTag.setAttribute("class" , "list-middle")
            //     const tdTag01 = document.createElement("td");
            //     tdTag01.innerText = vo.no;
            //     trTag.appendChild(tdTag01)
    
            //     const tdTag02 = document.createElement("td");
            //     tdTag02.innerText = vo.title;
            //     trTag.appendChild(tdTag02)
    
            //     const tdTag03 = document.createElement("td");
            //     tdTag03.innerText = vo.startDate;
            //     trTag.appendChild(tdTag03)
    
            //     const tdTag04 = document.createElement("td");
            //     tdTag04.innerText = vo.endDate;
            //     trTag.appendChild(tdTag04)
    
            //     const tdTag05 = document.createElement("td");
            //     tdTag05.innerText = vo.writerName;
            //     trTag.appendChild(tdTag05)
                
            //     const tdTag06 = document.createElement("td");
            //     tdTag06.innerText = vo.typeName;
            //     trTag.appendChild(tdTag06)
                
                
            //     tbodyTag.appendChild(trTag);

            // }
            
            
        },
        error : 
        function(){
            alert("출장 조회 실패")
        },

    });


}

loadTripList();

const tbodyTag = document.querySelector("#table>tbody");

tbodyTag.addEventListener("click" , function(evt){
    if(evt.target.tagName != "TD"){return;}
    const no = evt.target.parentNode.children[0].innerText;
    location.href=`/trip/detail?tno=${no}`;
});



function submitSearchForm(){
    
    const searchType = document.querySelector("#trip-filter").value;
    const searchValue = document.querySelector("#searchTag").value;

    loadTripList(searchType , searchValue);

    return false; // 기본 이벤트 막을 수 있음
};

document.addEventListener("DOMContentLoaded", function(){
    const today = new Date().toISOString().split("T")[0]; // 현재 날짜
    const startDateInput = document.querySelector("input[name=startDate]");
    const endDateInput = document.querySelector("input[name=endDate]");

    
    startDateInput.min = today;

    
    startDateInput.addEventListener("change", function(){
        endDateInput.min = startDateInput.value; // 종료 날짜 최소값 = 시작 날짜
    });
});


//     window.confirm("출장등록 하시겠습니까?");
// });
const radioValue = document.querySelectorAll("input[type=radio]");

function fqes(){
    for(const vo of radioValue){
        if(vo.value == "1"){
            vo.checked=true;
            console.log(vo);
        }
    }
}



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
        aTag.setAttribute("href" , `/approval/submitList?pno=${pvo.startPage-1}`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }
    
    for( let i = pvo.startPage ; i <= pvo.endPage ; i++ ){
        const aTag = document.createElement("a");
        const spanTag = document.createElement("span");
        aTag.setAttribute("href" , `/approval/submitList?pno=${i}`);
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
        aTag.setAttribute("href" , `/approval/submitList?pno=${pvo.endPage+1}`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }

}



function submitApprovalList(statusFilter){
    const tbodyTag = document.querySelector("#table>tbody");

    const url = new URL(location);
    let pno = url.searchParams.get("pno");
    if(pno == null){
        pno = 1;
    }
    $.ajax({
        
        url : `/approval/submitList/data?pno=${pno}` ,
        data : {
            statusFilter,
        },
       
        success : function(m){
            const submitApprovalVoList = m.a;
            const pvo = m.b;
            paintPageArea(pvo);

            tbodyTag.innerHTML="";
            
            for(let vo of submitApprovalVoList){
                const trTag = document.createElement("tr");
                trTag.setAttribute("class" , "list-middle")
                const tdTag01 = document.createElement("td");
                tdTag01.innerText = vo.no;
                trTag.appendChild(tdTag01)
    
                const tdTag02 = document.createElement("td");
                tdTag02.innerText = vo.enrollDate;
                trTag.appendChild(tdTag02)
    
                const tdTag03 = document.createElement("td");
                tdTag03.innerText = vo.title;
                trTag.appendChild(tdTag03)
    
                const tdTag04 = document.createElement("td");
                tdTag04.innerText = vo.llineName;
                trTag.appendChild(tdTag04)
    
                const tdTag05 = document.createElement("td");
                tdTag05.innerText = vo.statusName;
                trTag.appendChild(tdTag05)
                
                tbodyTag.appendChild(trTag);

            }
            
            
        },
        error : 
        function(){
            alert("결재 상신목록 조회 실패")
        },

    });


}



submitApprovalList();

const tbodyTag = document.querySelector("#table>tbody");

tbodyTag.addEventListener("click" , function(evt){
    if(evt.target.tagName != "TD"){return;}
    const no = evt.target.parentNode.children[0].innerText;
    location.href=`/approval/detail?ano=${no}`;
});



function submitSearchForm(){
    
    const statusFilter = document.querySelector("#approval-status").value;

    submitApprovalList(statusFilter);

    return false; // 기본 이벤트 막을 수 있음
};

const tbodyTag = document.querySelector(".table>tbody");

tbodyTag.addEventListener("click" , function(evt){
    if(evt.target.tagName !== "TD"){return;}
    const no = evt.target.parentNode.children[0].innerText;
    location.href=`/board/detail?bno=${no}`;
});



//----------------------------

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
        aTag.setAttribute("href" , `/board/list?pno=${pvo.startPage-1}`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }

    for( let i = pvo.startPage ; i <= pvo.endPage ; i++ ){
        const aTag = document.createElement("a");
        const spanTag = document.createElement("span");
        aTag.setAttribute("href" , `/board/list?pno=${i}`);
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
        aTag.setAttribute("href" , `/board/list?pno=${pvo.endPage+1}`);
        aTag.appendChild(iTag);
        spanTag.appendChild(aTag);
        pageArea.appendChild(spanTag);
    }

}




function loadBoardList(searchType, searchTitleValue, searchContentValue){
    const tbodyTag = document.querySelector(".bottom-bottom table>tbody");

        const url = new URL(location);
    let pno = url.searchParams.get("pno");
    if(pno == null){
        pno = 1;
    }

    $.ajax({
        url : `/board/list/data?pno=${pno}` ,
        data : {
            searchType,
            searchTitleValue,
            searchContentValue,
        }, //키-밸류라 객체
        // method :, 어차피 기본값이 GET
        success : function(m){
            const boardVoList = m.a;
            const pvo = m.b;
            paintPageArea(pvo);

            tbodyTag.innerText = "";
            console.log(boardVoList);

            for(const vo of boardVoList){
                const trTag = document.createElement("tr");

                const aTag01 = document.createElement('a');
                const tdTag01 = document.createElement('td');

                tdTag01.appendChild(aTag01);
                aTag01.setAttribute("href", `/board/detail?bno=${vo.no}`);
                aTag01.innerText = vo.no;
                trTag.appendChild(tdTag01);

                const tdTag02 = document.createElement('td');
                tdTag02.innerText = vo.title;
                trTag.appendChild(tdTag02);

                const tdTag03 = document.createElement('td');
                tdTag03.innerText = vo.name;
                trTag.appendChild(tdTag03);

                const tdTag04 = document.createElement('td');
                tdTag04.innerText = vo.enrollDate;
                trTag.appendChild(tdTag04);

                const tdTag05 = document.createElement('td');
                tdTag05.innerText = vo.viewCnt;
                trTag.appendChild(tdTag05);

                tbodyTag.appendChild(trTag);
                }
        } ,
        fail : function(){
            alert("게시글 목록조회 실패 (관리자에게 문의하세요)");
        } ,
    })

}

loadBoardList();




function submitSearchForm(){
    const searchType = document.querySelector("select[name=searchType]").value; //제목인지 내용인지

    const titleOrContentValue = document.querySelector("input[name=searchValue]").value;

    let searchTitleValue = "";
    let searchContentValue = "";
    if(searchType == "title"){
        searchTitleValue = titleOrContentValue;
    }else{
        searchContentValue = titleOrContentValue;
    }

    loadBoardList(searchType, searchTitleValue, searchContentValue);

    //기본이벤트 막기
    return false;
}



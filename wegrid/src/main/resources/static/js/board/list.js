const tbodyTag = document.querySelector(".table>tbody");

tbodyTag.addEventListener("click" , function(evt){
    if(evt.target.tagName != "TD"){return;}
    const no = evt.target.parentNode.children[0].innerText;
    location.href=`/board/detail?bno=${no}`;
});

//----------------------------

function paintPageArea(pvo){
    const pageArea = document.querySelector(".page");
    pageArea.innerHTML = "";

    //이전 버튼
    if(pvo.startPage != 1){
        const aTag = document.createElement("a");
        aTag.setAttribute("href", `/board/list?pno=${pvo.startPage-1}`);
        aTag.innerText = "이전";
        pageArea.appendChild(aTag);
    }

    //페이지 버튼
    for(let i=pvo.startPage; i<=pvo.endPage; i++){
        const aTag = document.createElement("a");
        aTag.setAttribute("href", `/board/list?pno=${i}`);
        aTag.innerText = i;
        pageArea.appendChild(aTag);
    }

    //다음 버튼
    if(pvo.endPage != pvo.maxPage){
        const aTag = document.createElement("a");
        aTag.setAttribute("href", `/board/list?pno=${pvo.endPage+1}`);
        aTag.innerText = "다음";
        pageArea.appendChild(aTag);
    }

}


//검색기능
//function loadBoardList(searchType, searchValue){
//    const tbodyTag = document.querySelector("main table>tbody");
//
//    const url = new URL(location);
//    let pno = url.searchParams.get("pno");
//    if(pno == null){
//        pno = 1;
//    }
//
//    $.ajax({
//        url : `/board/list/data?pno=${pno}` ,
//        data : {
//            searchType, // = searchType : searchType
//            searchValue, // = searchValue : searchValue
//        }, //키-밸류라 객체
//        // method :, 어차피 기본값이 GET
//        success : function(m){
//            const boardVoList = m.a;
//            const pvo = m.b;
//            paintPageArea(pvo);
//
//            tbodyTag.innerText = "";
//            console.log(boardVoList);
//
//            for(const vo of boardVoList){
//                const trTag = document.createElement("tr");
//
//                const aTag01 = document.createElement('a');
//                const tdTag01 = document.createElement('td');
//                tdTag01.appendChild(aTag01);
//                aTag01.setAttribute("href", `/board/detail?bno=${vo.no}`);
//                aTag01.innerText = vo.title;
//                trTag.appendChild(tdTag01);
//
//                const tdTag02 = document.createElement('td');
//                tdTag02.innerText = vo.categoryNo;
//                trTag.appendChild(tdTag02);
//
//                const tdTag03 = document.createElement('td');
//                tdTag03.innerText = vo.hit;
//                trTag.appendChild(tdTag03);
//
//                const tdTag04 = document.createElement('td');
//                tdTag04.innerText = vo.writerNo;
//                trTag.appendChild(tdTag04);
//
//                const tdTag05 = document.createElement('td');
//                tdTag05.innerText = vo.createDate;
//                trTag.appendChild(tdTag05);
//
//                tbodyTag.appendChild(trTag);
//                }
//        } ,
//        fail : function(){
//            alert("게시글 목록조회 실패 (관리자에게 문의하세요)");
//        } ,
//    })
//
//}
//
//loadBoardList();



//검색 카테고리 설정
//function handleSearchType(x){
//    //요소 가져오기 - 제목검색
//    //요소 가져오기 - 카테고리검색
//    const titleTag = document.querySelector("input[name=searchValue]");
//    const categoryTag = document.querySelector("select[name=searchValue]");
//
//    //searchType값에 따라서, 둘 중 하나를 disabled상태로 만들기
//    if(x.value == "title"){
//        //제목일떄
//        categoryTag.setAttribute("disabled", true);
//        titleTag.removeAttribute("disabled");
//    }else{
//        //카테일때
//        titleTag.setAttribute("disabled", true);
//        categoryTag.removeAttribute("disabled");
//    }
//
//
//}
//
//function submitSearchForm(){
//    const searchType = document.querySelector("select[name=searchType]").value;
//
//    const titleTagValue = document.querySelector("input[name=searchValue]").value;
//    const categoryTagValue = document.querySelector("select[name=searchValue]").value;
//
//    let searchValue = "";
//    if(searchType == "title"){
//        searchValue = titleTagValue;
//    }else{
//        searchValue = categoryTagValue;
//    }
//
//    loadBoardList(searchType, searchValue);
//
//    //기본이벤트 막기
//    return false;
//}
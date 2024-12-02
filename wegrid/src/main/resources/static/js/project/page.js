function paintPageArea(pvo){
    const pageArea = document.querySelector(".page-area");
    pageArea.innerHTML = "";
    
    // 이전버튼
    if(pvo.startPage != 1){
        const aTag = document.createElement("a");
        aTag.setAttribute("href", `/project/people?pno=${pvo.startPage-1}`); // aTag에 href 채울 값 넣어주기
        const icon = document.createElement("i");
        icon.innerHTML = '<i class="fas fa-caret-left fa-lg"></i>'
        icon.style.color = "#174880"; // 아이콘 색상 설정
        pageArea.append(aTag);
    }
    

    // 페이지 버튼
    for(let i=pvo.startPage; i<= pvo.endPage; ++i){
        const aTag = document.createElement("a");
        aTag.setAttribute("href", `/project/people?pno=${i}`); // aTag에 href 채울 값 넣어주기
        aTag.innerText = i;
        pageArea.append(aTag);
    }

    // 다음 버튼
    if(pvo.endPage != pvo.maxPage){
        const aTag = document.createElement("a");
        aTag.setAttribute("href", `/project/people?pno=${pvo.endPage + 1}`); // aTag에 href 채울 값 넣어주기
        const icon = document.createElement("i");
        icon.innerHTML = '<i class="fas fa-caret-left fa-lg"></i>'
        icon.style.color = "#174880"; // 아이콘 색상 설정
        pageArea.append(aTag);
    }
   
}
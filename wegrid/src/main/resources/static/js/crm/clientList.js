function paintPageArea(pvo, clientVoList, searchType, searchValue) {
  const pagingArea = document.querySelector(".paging-area");
  pagingArea.innerHTML = ""; // 기존 내용을 초기화

  // 이전 버튼
  if (pvo.startPage > 1) {
      const prevTag = document.createElement("a");
      prevTag.setAttribute("href", `/crm/list?pno=${pvo.startPage - 1}&`);
      prevTag.className = "previous";
      prevTag.innerHTML = '<i class="fas fa-caret-left fa-lg" style="color: #174880;"></i>';
      pagingArea.appendChild(prevTag);
  }

  // 페이지 번호 버튼
  for (let i = pvo.startPage; i <= pvo.endPage; i++) {
      const pageTag = document.createElement("a");
      pageTag.setAttribute("href", `/crm/list?pno=${i}`);
      pageTag.className = i === pvo.currentPage ? "current" : "pageNum";
      pageTag.innerText = i;
      pagingArea.appendChild(pageTag);
  }

  // 다음 버튼
  if (pvo.endPage < pvo.maxPage) {
      const nextTag = document.createElement("a");
      nextTag.setAttribute("href", `/crm/list?pno=${pvo.endPage + 1}`);
      nextTag.className = "next";
      nextTag.innerHTML = '<i class="fas fa-caret-right fa-lg" style="color: #174880;"></i>';
      pagingArea.appendChild(nextTag);
  }
}



function applyFilters(){
  const tbodyTag = document.querySelector("main table>tbody");
  const maxRows = 15; // 테이블의 고정 행 수

  const url = new URL(location);
  let pno = url.searchParams.get("pno");
  if(pno == null){
      pno = 1;
  }

  let statusNo = document.querySelector('select[aria-label="Default select example"]:nth-of-type(1)').value;
  let rankCode = document.querySelector('select[aria-label="Default select example"]:nth-of-type(2)').value;
  let searchType = document.querySelector('select[name="searchType"]').value;
  let searchValue = document.querySelector('input[name="searchValue"]').value;

  console.log(searchType);
  console.log(searchValue);
  console.log('Selected Status:', statusNo);
  console.log('Selected Rank:', rankCode);

  $.ajax({
      url : `/crm/list/filtered` ,
      type: "GET",
      data : {
          pno,
          searchType,
          searchValue,
          statusNo,
          rankCode
      } ,
      success : function(m){
          const clientVoList = m.a;
          const pvo = m.b;

          paintPageArea(pvo);

          tbodyTag.innerHTML = "";

          for(const vo of clientVoList){
              const trTag = document.createElement("tr");
              trTag.className = "list-middle";

              const tdTag01 = document.createElement('td');
              tdTag01.innerText = vo.no;
              trTag.appendChild(tdTag01);

              const tdTag02 = document.createElement('td');
              tdTag02.className = "linked-name";
              tdTag02.innerHTML = `<a href='/crm/detail?cno=${vo.no}&pno=1'>${vo.name}</a>`;
              trTag.appendChild(tdTag02);
              
              const tdTag03 = document.createElement('td');
              tdTag03.innerText = vo.rankName;
              trTag.appendChild(tdTag03);
              
              const tdTag04 = document.createElement('td');
              tdTag04.innerText = vo.startDate;
              trTag.appendChild(tdTag04);

              tbodyTag.appendChild(trTag);
          }

          // 데이터가 부족한 경우 빈 행 추가
          const rowsToAdd = maxRows - clientVoList.length;
          if (rowsToAdd > 0) {
              for (let i = 0; i < rowsToAdd; i++) {
                  const emptyTr = document.createElement("tr");
                  emptyTr.className = "list-middle";

                  for (let j = 0; j < 4; j++) {
                      const emptyTd = document.createElement("td");
                      emptyTd.innerText = "";
                      emptyTr.appendChild(emptyTd);
                  }

                  tbodyTag.appendChild(emptyTr);
              }
          }

      } ,
      fail : function(){
          alert("목록조회 실패 (관리자에게 문의하세요)");
      } ,
  });

}

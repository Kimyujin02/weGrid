document.addEventListener("DOMContentLoaded", function () {
    // 모든 드롭다운 토글 버튼에 이벤트 리스너 추가
    const dropdownToggles = document.querySelectorAll('.dropdown-toggle');
    
    dropdownToggles.forEach((toggleButton) => {
      toggleButton.addEventListener('click', function (e) {
        e.stopPropagation(); // 이벤트 전파 중단 (다른 클릭 이벤트 방지)
        const dropdown = this.parentElement; // 클릭한 버튼의 부모 드롭다운 찾기
        
        // 현재 드롭다운 활성화/비활성화
        dropdown.classList.toggle('active');
      });
    });
  
    // 드롭다운 외부 클릭 시 닫기
    document.addEventListener('click', function () {
      document.querySelectorAll('.dropdown.active').forEach((dropdown) => {
        dropdown.classList.remove('active');
      });
    });
  
    // 드롭다운 메뉴 안의 모든 옵션에 대해서도 클릭 시 이벤트 전파 중단
    const dropdownItems = document.querySelectorAll('.dropdown-menu label');
    dropdownItems.forEach((item) => {
      item.addEventListener('click', function (e) {
        e.stopPropagation(); // 클릭 이벤트가 드롭다운 닫기로 전파되지 않도록 방지
      });
    });
  });



function paintPageArea(pvo, searchValue = "", cno = "") {
  const pagingArea = document.querySelector(".paging-area");
  pagingArea.innerHTML = ""; // 기존 내용을 초기화

  // 이전 버튼
  if (pvo.startPage > 1) {
      const prevTag = document.createElement("a");
      prevTag.setAttribute("href", `/crm/history?cno=${cno}&pno=${pvo.startPage - 1}&searchValue=${searchValue}`);
      prevTag.className = "previous";
      prevTag.innerHTML = '<i class="fas fa-caret-left fa-lg" style="color: #174880;"></i>';
      pagingArea.appendChild(prevTag);
  }

  // 페이지 번호 버튼
  for (let i = pvo.startPage; i <= pvo.endPage; i++) {
      const pageTag = document.createElement("a");
      pageTag.setAttribute("href", `/crm/history?cno=${cno}&pno=${i}&searchValue=${searchValue}`);
      pageTag.className = i === pvo.currentPage ? "current" : "pageNum";
      pageTag.innerText = i;
      pagingArea.appendChild(pageTag);
  }

  // 다음 버튼
  if (pvo.endPage < pvo.maxPage) {
      const nextTag = document.createElement("a");
      nextTag.setAttribute("href", `/crm/history?cno=${cno}&pno=${pvo.endPage + 1}&searchValue=${searchValue}`);
      nextTag.className = "next";
      nextTag.innerHTML = '<i class="fas fa-caret-right fa-lg" style="color: #174880;"></i>';
      pagingArea.appendChild(nextTag);
  }
}



document.querySelector(".search-box").addEventListener("submit", function(event) {
  event.preventDefault(); // 폼 제출로 인한 페이지 리프레시 방지
  
  loadHistoryList(); // 검색 후 프로젝트 리스트 로드
});

function loadHistoryList(){
  const tbodyTag = document.querySelector("main table>tbody");
  const maxRows = 10; // 테이블의 고정 행 수

  const url = new URL(location);
  let pno = url.searchParams.get("pno");
  if(pno == null){
      pno = 1;
  }

  let cno = url.searchParams.get("cno");
  const searchValue = document.querySelector('input[name=searchValue]').value;
  console.log(searchValue);
  console.log(cno);
  console.log(pno);

  $.ajax({
      url : `/crm/history/data` ,
      data : {
          searchValue,
          cno,
          pno,
      } ,
      success : function(m){
          const historyVoList = m.a;
          const pvo = m.b;

          paintPageArea(pvo, searchValue, cno);

          console.log(historyVoList, pvo);

          tbodyTag.innerHTML = "";

          for(const vo of historyVoList){
              const trTag = document.createElement("tr");
              trTag.className = "list-middle";

              const tdTag01 = document.createElement('td');
              tdTag01.innerText = vo.no;
              trTag.appendChild(tdTag01);

              const tdTag02 = document.createElement('td');
              tdTag02.innerText = vo.writerName;
              trTag.appendChild(tdTag02);
              
              const tdTag03 = document.createElement('td');
              tdTag03.className = "linked-name";
              tdTag03.innerHTML = `<a href='/crm/history/detail?cno=${cno}&hno=${vo.no}'>${vo.inquiry}</a>`;
              trTag.appendChild(tdTag03);

              const tdTag04 = document.createElement('td');
              tdTag04.innerText = vo.enrollDate.split(" ")[0];
              trTag.appendChild(tdTag04);

              const tdTag05 = document.createElement('td');
              const editButton = document.createElement('button');
              editButton.type = "button";
              editButton.className = "btn btn-primary";
              editButton.textContent = "수정";

              // 버튼 클릭 시 로그인 정보와 작성자 번호 비교
              editButton.addEventListener('click', function() {
                  if (loginMemberNo !== vo.writerNo) {
                      alert("권한이 없습니다.");
                  } else {
                      location.href = `/crm/history/edit?cno=${cno}&hno=${vo.no}`;
                  }
              });

              tdTag05.appendChild(editButton);
              trTag.appendChild(tdTag05);
              tbodyTag.appendChild(trTag);
          }

          // 데이터가 부족한 경우 빈 행 추가
          const rowsToAdd = maxRows - historyVoList.length;
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
  
loadHistoryList();
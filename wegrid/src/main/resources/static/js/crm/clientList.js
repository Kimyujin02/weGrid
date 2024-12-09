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




function applyFilters(){
  const tbodyTag = document.querySelector("main table>tbody");

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

  // "전체" 값이 선택되면 필터링에서 제외
  // if (statusNo === "") {
  //     statusNo = null;
  // }
  // if (rankCode === "") {
  //     rankCode = null;
  // }

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

      } ,
      fail : function(){
          alert("목록조회 실패 (관리자에게 문의하세요)");
      } ,
  });

}

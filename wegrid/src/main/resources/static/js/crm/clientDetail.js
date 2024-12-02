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



  function loadPrjList(cno, searchValue) {
    const tbodyTag = document.querySelector("main table > tbody");
    const maxRows = 10; // 테이블의 고정 행 수

$.ajax({
      url : `/crm/detail/data` ,
      data : {
          cno ,
          searchValue ,
      } ,
      // method : ~~~ ,
      success : function(m){
          const prjVoListData = m;
          console.log(prjVoListData);
          if (!Array.isArray(prjVoListData)) {
            console.error("Received data is not an array.");
            return;
        }
          // const pvo = m.b;
          // paintPageArea(pvo);

          console.log(prjVoListData);

          tbodyTag.innerHTML = "";

          for(const vo of prjVoListData){
              const trTag = document.createElement("tr");
              trTag.className = "list-middle";

              const tdTag01 = document.createElement('td');
              tdTag01.innerText = vo.projectNo;
              trTag.appendChild(tdTag01);

              const tdTag02 = document.createElement('td');
              tdTag02.className = "linked-name";
              trTag.appendChild(tdTag02);
              tdTag02.innerHTML = `<a href='/project/detail?cno=${vo.projectNo}'>${vo.projectName}</a>`;

              const tdTag03 = document.createElement('td');
              tdTag03.innerText = vo.projectStatusName;
              trTag.appendChild(tdTag03);

              const tdTag04 = document.createElement('td');
              tdTag04.innerText = vo.startDate.split(" ")[0] + " - " + vo.endDate.split(" ")[0];
              trTag.appendChild(tdTag04);

              tbodyTag.appendChild(trTag);
          }

          // 데이터가 부족한 경우 빈 행 추가
          const rowsToAdd = maxRows - prjVoListData.length;
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
          alert("목록조회 실패");
      } ,
  });

}

loadPrjList();


function submitSearchForm() {

    const cno = document.querySelector("input[name=cno]").value;
    const searchValue = document.querySelector("input[name=searchValue]").value;

    loadPrjList(cno, searchValue);

    return false;
}
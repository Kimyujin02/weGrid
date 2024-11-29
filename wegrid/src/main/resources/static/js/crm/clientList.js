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










  function loadClientList(searchType, searchValue){
    const tbodyTag = document.querySelector("main table>tbody");
    //tbodyTag 내용 채우기 ~~~

    // const url = new URL(location);
    // let pno = url.searchParams.get("pno");
    // if(pno == null){
    //     pno = 1;
    // }
    $.ajax({
        url : `/crm/list/data` ,
        data : {
            searchType ,
            searchValue ,
        } ,
        // method : ~~~ , 어차피 기본값이 get
        success : function(m){
            const clientVoList = m;
            // const pvo = m.b;
            // paintPageArea(pvo);

            console.log(clientVoList);

            tbodyTag.innerHTML = "";

            for(const vo of clientVoList){
                const trTag = document.createElement("tr");

                const tdTag01 = document.createElement('td');
                tdTag01.innerText = vo.no;
                trTag.appendChild(tdTag01);

                tdTag01.innerHTML = `<a href='/board/detail?bno=${vo.no}'>${vo.title}</a>`;

                const tdTag02 = document.createElement('td');
                tdTag02.innerText = vo.name;
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
            alert("목록조회 실패");
        } ,
    });

}

loadClientList();
  
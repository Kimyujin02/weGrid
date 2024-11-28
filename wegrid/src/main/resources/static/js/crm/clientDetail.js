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
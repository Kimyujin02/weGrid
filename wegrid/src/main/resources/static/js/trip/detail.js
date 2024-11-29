// 모달 열기
function openTripModal() {
    document.getElementById("tripModal").style.display = "block";
}

// 모달 닫기
function closeTripModal() {
    document.getElementById("tripModal").style.display = "none";
}


function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
          
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

  
            if(data.userSelectedType === 'R'){
             
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}
// 드래그를 위한 변수 선언
let isDragging = false;
let startX, startY;
let modalX = 0, modalY = 0;

// 모달 요소 가져오기
const modal = document.querySelector(".tripModal-content");
const header = document.querySelector(".tripModal-header"); // 헤더로 드래그 가능하도록 설정

// 마우스 다운 이벤트
header.addEventListener("mousedown", (e) => {
    isDragging = true;
    startX = e.clientX - modalX;
    startY = e.clientY - modalY;
    modal.style.transition = "none"; // 이동 시 애니메이션 제거
});

// 마우스 이동 이벤트
document.addEventListener("mousemove", (e) => {
    if (isDragging) {
        modalX = e.clientX - startX;
        modalY = e.clientY - startY;

        // 모달 위치 업데이트
        modal.style.transform = `translate(${modalX}px, ${modalY}px)`;
    }
});

// 마우스 업 이벤트
document.addEventListener("mouseup", () => {
    isDragging = false;
});

function combineAdress(){
    const address3 = document.querySelector("#sample6_postcode").value;
    const address1 = document.querySelector("#sample6_address").value;
    const address2 = document.querySelector("#sample6_detailAddress").value;
    const address = address1 +" , "+ address2 +" , "+ address3;
    const desTag = document.querySelector("#address");

    desTag.setAttribute("value" , address);
}

document.addEventListener("DOMContentLoaded", function(){
    const today = new Date().toISOString().split("T")[0]; // 현재 날짜
    const startDateInput = document.querySelector("input[name=startDate]");
    const endDateInput = document.querySelector("input[name=endDate]");

    
    startDateInput.min = today;

    
    startDateInput.addEventListener("change", function(){
        endDateInput.min = startDateInput.value; // 종료 날짜 최소값 = 시작 날짜
    });
});
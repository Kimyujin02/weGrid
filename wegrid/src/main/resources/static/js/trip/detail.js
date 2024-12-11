// 모달 열기
function openTripModal() {
    document.getElementById("tripModal").style.display = "block";
    fqes();
}

// 모달 닫기
function closeTripModal() {
    document.getElementById("tripModal").style.display = "none";
    location.reload(true);
}


function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
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


document.addEventListener("DOMContentLoaded", function(){
    const today = new Date().toISOString().split("T")[0]; // 현재 날짜
    const startDateInput = document.querySelector("input[name=startDate]");
    const endDateInput = document.querySelector("input[name=endDate]");

    
    startDateInput.min = today;

    
    startDateInput.addEventListener("change", function(){
        endDateInput.min = startDateInput.value; // 종료 날짜 최소값 = 시작 날짜
    });
});

const tripType = document.querySelector("input[name=aaaaaaaaaaaa]").value

const radioValue = document.querySelectorAll("input[type=radio]");

function fqes(){
    for(const vo of radioValue){
        if(vo.value == tripType){
            vo.checked=true;
            console.log(vo);
        }
    }
}

function deletee(){
    if(!window.confirm('삭제 하시겠습니까?')){
        return false;
    }
    return;
}
function updatee(){
    if(!window.confirm('수정하시겠습니까?')){
        return false;
    }
    return;
}
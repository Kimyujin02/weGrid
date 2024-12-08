

// 항목 추가 모달 실행
function openAddModal(type){

    // 모달 창 초기화
    const modalTag = document.querySelector("#preferenceModal  > div");
    modalTag.innerHTML = null;

    // 항목 추가 템플릿 복사
    const template = document.getElementById("#addModalContent");
    const clone = template.content.cloneNode(true);
    modalTag.appendChild(clone);

    // 추가하는 항목 정보 모달창에 저장
    modalTag.querySelector(".addItemForm input[name=type]").value=type;
    console.log( modalTag.querySelector(".addItemForm input[name=type]").value);
    
    console.log(modalTag);

    

    // 모달 창 실행
    $("#preferenceModal").modal("show");

}

// 항목 추가 처리
function addItem(){
    console.log("항목 추가 시작");
    
    $.ajax({
        url: "/systemPreference/add",
        method: "POST",
        data: {
            type: type,
            name: itemName,
        },
        success: function(resultMap){
            if(resultMap.result == 1){
                alert("항목 추가 완료!!");
                
                addNewItem(resultMap.vo,type);
                
                $('#preferenceModal').modal('hide');
            }
            else{
                alert("항목 추가 실패");
            }
        },
        error: function(){
            alert("서버와 통신 실패");
        }
        
    })
    
    console.log("항목 추가 완료");
    alert("추가 함수 종료");
    return false; 

}

// 추가한 항목 화면에 추가
function addNewItem(vo,type){
    const bodyTag = document.querySelector("#"+type);

    const template = document.getElementById("#emptyLine");
    const clone = template.content.cloneNode(true);

    
    console.log("0",clone.querySelector(".itemName"));
    console.log("1",clone.querySelector(".editItem"));
    console.log("2",clone.querySelector(".deleteItem"));

    clone.querySelector("#itemNo").value=vo.no;
    clone.querySelector(".itemName").innerText = vo.name;
    
    bodyTag.appendChild(clone);
}


// 항목 수정 모달 실행
function openEditModal(x){

    // 모달 창 초기화
    const modalTag = document.querySelector("#preferenceModal > div");
    modalTag.innerHTML = null;

    // 항목 수정 템플릿 복사
    const template = document.getElementById("#editModalContent");
    const clone = template.content.cloneNode(true);
    modalTag.appendChild(clone);
    
    // 수정할 항목 정보 모달창에 저장
    const bodyTag = x.parentElement.parentElement.parentElement;
    modalTag.querySelector("#beforeName").innerText = bodyTag.querySelector(".itemName").innerText;
    modalTag.querySelector(".editItemForm input[name=no]").value = bodyTag.querySelector("#itemNo").value;
    modalTag.querySelector(".editItemForm input[name=type]").value=bodyTag.id;

    // 모달 창 실행
    $("#preferenceModal").modal("show");

}

// 항목 삭제
function deleteItem(no){
    console.log("no",no);
}



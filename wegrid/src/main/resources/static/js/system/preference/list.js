

// 항목 추가 모달 실행
function openAddModal(type){

    // 모달 창 초기화
    const modalTag = document.querySelector("#preferenceModal  > div");
    modalTag.innerHTML = null;

    // 항목 추가 템플릿 복사
    const template = document.getElementById("addModalContent");
    const clone = template.content.cloneNode(true);
    console.log("clone",clone);
    
    modalTag.appendChild(clone);
    
    if(type == "department" || type == "jobInfo"){
        const divTag = modalTag.querySelector(".mb-3");

        const template2 = document.getElementById("subInput");
        const clone2 = template2.content.cloneNode(true);

        divTag.appendChild(clone2);   

        if(type == "department"){
            divTag.querySelector("#subLabel").innerText = "부서 코드";
        }
        else{
            divTag.querySelector("#subLabel").innerText = "기본 연차 수량";
        }
    }

    // 추가하는 항목 정보 모달창에 저장
    modalTag.querySelector(".addItemForm input[name=type]").value=type;

    // 모달 창 실행
    $("#preferenceModal").modal("show");

}

// 항목 추가 처리
function addItem(){
    console.log("항목 추가 시작");

    const type = document.querySelector(".addItemForm input[name=type]").value;
    const name = document.querySelector(".addItemForm input[name=itemName]").value;

    if(name == null || name=="" || name==" "){
        alert("추가할 항목명을 입력해주세요.");
        return false;
    }

    let sub = null;
    if(type == "department" || type == "jobInfo"){
        sub = document.querySelector(".addItemForm #subValue").value;
        if(sub == null || sub =="" || sub ==" "){
            alert("추가 정보를 입력해주세요.");
            return false;
        }   
    }
    
    $.ajax({
        url: "/systemPreference/add",
        method: "POST",
        data: {
            type,
            name,
            sub
        },
        success: function(resultMap){
            if(resultMap.result == 1){
                alert("항목 추가 완료!!");
                
                addNewItem(resultMap.vo,type);
                
                if(type == "jobInfo"){
                    addNewItem(resultMap.vo,"vacCnt");
                }
                
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
    return false; 

}

// 추가한 항목 화면에 추가
function addNewItem(vo,type){
  
    const bodyTag = document.querySelector("#"+type);
    
    let template;
    if(type == "vacCnt"){
        template = document.getElementById("emptyLine2");
    }
    else{
        template = document.getElementById("emptyLine");
    } 
    const clone = template.content.cloneNode(true);

    if(type=="department"){
        clone.querySelector("#itemNo").value=vo.code;
    }else{
        clone.querySelector("#itemNo").value=vo.no;
    }
    
    if(type == "vacCnt") {
        clone.querySelector(".itemValue").innerText=vo.vacCnt;
    }
    clone.querySelector(".itemName").innerText = vo.name;
    
    bodyTag.appendChild(clone);
    
}



// 항목 수정 모달 실행
function openEditModal(x){

    // 모달 창 초기화
    const modalTag = document.querySelector("#preferenceModal > div");
    modalTag.innerHTML = null;

    // 항목 수정 템플릿 복사
    const template = document.getElementById("editModalContent");
    const clone = template.content.cloneNode(true);
    modalTag.appendChild(clone);
    
    // 수정할 항목 정보 모달창에 저장
    const type = x.parentElement.parentElement.parentElement.id;
    if(type == "vacCnt"){
        modalTag.querySelector("#beforeValueLable").innerText = "기존 수량";
        modalTag.querySelector("#afterValueLabel").innerText = "변경 수량";
        modalTag.querySelector(".editItemForm input[name=no]").value = x.parentElement.nextElementSibling.value;
    }
    else{
        modalTag.querySelector(".editItemForm input[name=no]").value = x.parentElement.nextElementSibling.nextElementSibling.value;
    }
    modalTag.querySelector("#beforeName").innerText = x.parentElement.previousElementSibling.innerText;
    modalTag.querySelector(".editItemForm input[name=type]").value=type;

    // 모달 창 실행
    $("#preferenceModal").modal("show");

}

// 항목 수정 처리
function editItem(){
    console.log("항목 수정 시작");

    const type = document.querySelector(".editItemForm input[name=type]").value;
    const no = document.querySelector(".editItemForm input[name=no]").value;
    const name = document.querySelector(".editItemForm input[name=itemName]").value;
    if(name == null || name=="" || name==" "){
        alert("수정할 항목명을 입력해주세요.");
        return false;
    }
    $.ajax({
        url: "/systemPreference/edit",
        method: "POST",
        data: {
            type,
            no,
            name
        },
        success: function(result){
            if(result == 1){
                alert("항목 수정 완료!!");
                 
                changeEditItem(no,name,type);
                
                $('#preferenceModal').modal('hide');
            }
            else{
                alert("항목 수정 실패");
            }
        },
        error: function(){
            alert("서버와 통신 실패");
        }
    })
    
    console.log("항목 수정 완료");
    return false; 

}

// 수정한 항목 화면에 반영
function changeEditItem(no,name,type){
    const noList = document.querySelectorAll("#"+type+" #itemNo");
    
    for(let i=0; i<noList.length; i++){
        if(noList[i].value == no){
            if(type == "vacCnt"){
                noList[i].previousElementSibling.previousElementSibling.innerText = name;
            }
            else{
                noList[i].previousElementSibling.previousElementSibling.previousElementSibling.innerText = name;
            }
            break;
        }
    }

}


// 항목 삭제 처리
function deleteItem(x){
    console.log("항목 삭제 시작");

    const no =  x.parentElement.nextElementSibling.value;
    const type = x.parentElement.parentElement.parentElement.id;

    if(!confirm("정말 삭제하시겠습니까?")){
        return;
    }

    $.ajax({
        url: "/systemPreference/delete",
        method: "GET",
        data: {
            type,
            no
        },
        success: function(result){
            if(result == 1){
                alert("항목 삭제 완료!!");
                
                deleteExistItem(no,type);
                if(type == "jobInfo"){
                    deleteExistItem(no,"vacCnt");
                }
                $('#preferenceModal').modal('hide');
            }
            else{
                alert("항목 삭제 실패");
            }
        },
        error: function(){
            alert("서버와 통신 실패");
        }
    })
    console.log("항목 삭제 완료");
}

// 화며에서 삭제한 항목 제거
function deleteExistItem(no,type){
    const noList = document.querySelectorAll("#"+type+" #itemNo");
    
    for(let i=0; i<noList.length; i++){
        if(noList[i].value == no){
            noList[i].parentElement.remove();
            break;
        }
    }

}
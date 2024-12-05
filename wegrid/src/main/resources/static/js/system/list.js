function handleCheckbox(x){
    //모든 체크박스 가져오기
    const checkBoxArr = document.querySelectorAll(".checkbox-td > input[type=checkbox]");

    //모든 체크박스 체크하기
    for(let i = 0; i < checkBoxArr.length; ++i){
        checkBoxArr[i].checked = x.checked;
    }
}


function deleteList(){
  //1. 체크된 게시글 번호들 가져오기
  const noticeNoArr = [];
  const checkBoxArr = document.querySelectorAll(".checkbox-td > input[type=checkbox]");
  for(const checkBox of checkBoxArr){
      if(checkBox.checked == false){continue;}    
      const noticeNo = checkBox.parentNode.parentNode.children[0].innerText;
      noticeNoArr.push(noticeNo);
  }

  //2. 서버한테 요청 보내기
  $.ajax( {
      url : "/system/delete" ,
      method : "delete" ,
      data : {
          noticeNoArr : JSON.stringify(noticeNoArr)
      } ,
      success : function(x){
          console.log("통신 성공 !!!");
          if(x == "good"){
              alert("삭제 성공 !");
          }else{
              alert("삭제 실패 ...");
          }
          location.reload();
      } ,
      error : function(){
          console.log("통신 실패 ...");
      } ,
  } );

}
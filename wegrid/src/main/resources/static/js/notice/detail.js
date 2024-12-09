//댓글 작성하기 버튼 클릭시
function writeReply(boardNo){
    //댓글 내용 가져오기
    const replyContent = document.querySelector("#reply-write-area input[name=content]").value;
    
     //비동기 통신하기
     $.ajax({
        url : "/notice/reply/write",
        method : "post",
        data : {
            "content" : replyContent,
            noticeNo,
        },
        success : function(x){
            console.log("통신성공")
            if(x == 1){
                alert("댓글 작성 완료")
                loadReply();
            }else{
                alert("댓글 작성 실패")
            }
        },
        error : function(){
            console.log("통신실패");
        },
     });
}

//댓 불러와
function loadReply(){
    //현재 공지사항 번호 얻기
    const noticeNo = document.querySelector("#reply-list-area").getAttribute("noticeNo");

    //비동기 통신 (ajax)를 이용해 데이터 받기
    $.ajax({
        url : "/notice/reply/list",
        method : "get",
        data : {
            noticeNo
        },
        success : function(x){
            console.log("통신 성공 !");
            console.log("댓글 리스트 : " , x);
            PaintReplyList(x);
        },
        error : function(){
            console.log("통신 실패 !");
        },
     });
}

//댓 리스트 그리기
function PaintReplyList(voList){
    const replyListArea = document.querySelector("#reply-list-area");
    replyListArea.innerHTML = "";
    const replycontext = document.querySelector("#replycontext");
    replycontext.innerHTML = "";

    for(const vo of voList){
        const div01 = document.createElement("div");
        div01.innerText = vo.content;
    
        const div02 = document.createElement("div");
        div02.innerText = vo.nick;
        
        const div03 = document.createElement("div");
        div03.innerText = vo.createDate;
    
        replyListArea.appendChild(div01);
        replyListArea.appendChild(div02);
        replyListArea.appendChild(div03);
    }
}

loadReply();
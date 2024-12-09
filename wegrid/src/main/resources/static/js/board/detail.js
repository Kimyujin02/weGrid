function writeReply(boardNo){
    //댓글 내용 가져오기
    const replyContent = document.querySelector("#reply-write-area input[name=content]").value;

     //비동기 통신하기
     $.ajax({
        url : "/board/reply/write",
        method : "post",
        data : {
            "content" : replyContent,
            boardNo,
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
    const noticeNo = document.querySelector("#reply-list-area").getAttribute("boardNo");

    //비동기 통신 (ajax)를 이용해 데이터 받기
    $.ajax({
        url : "/board/reply/list",
        method : "get",
        data : {
            boardNo
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
    const replyListArea = document.getElementById("reply-list-area");
    replyListArea.innerHTML = "";  // 기존 댓글 목록 초기화

    replyList.forEach(reply => {
        const div = document.createElement("div");
        div.classList.add("reply-user");

        div.innerHTML = `
            <div class="reply-icon"></div> <!-- 프로필 아이콘 -->
            <div class="reply-info">
                <div>${reply.writerName}</div> <!-- 작성자 이름 -->
                <div>${reply.deptName}</div> <!-- 부서명 -->
            </div>
            <div class="reply-text">${reply.content}</div> <!-- 댓글 내용 -->

            <div class="reply-subinfo">
                <div class="reply-date">${reply.date}</div> <!-- 댓글 작성일 -->
                <div class="reply-adjust">
                    <div class="reply-edit">수정하기</div>
                    <div class="reply-delete">삭제하기</div>
                </div>
            </div>
        `;

        replyListArea.appendChild(div);  // 새로운 댓글을 목록에 추가
    }
}

loadReply();




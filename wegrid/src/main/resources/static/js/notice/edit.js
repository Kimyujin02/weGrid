function delAttach(attchNo, fileName, imgTag){

    const result = confirm("해당 사진을 삭제할꺼야? (복구 안됨)");
    if(result == false){return;}

    $.ajax({
        url : "/notice/attachment/del",
        method : "post",
        data : {
            ano : attchNo,        //클라에서 ano만 받아오고있는데 changeName 받아오고, 원본경로 받아오면됨
            fileName : fileName,
        },
        success : function(data){
            console.log(data);
            if(data == "1"){
                alert("첨부파일 삭제 성공");
                imgTag.remove();
            }else{
                alert("첨부파일 삭제 실패");
            }
        },
        fail : function(){
            alert("통신 실패");
        },
    });
}
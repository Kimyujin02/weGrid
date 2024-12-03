document.querySelectorAll('.project-dates').forEach(item => {
    const startDate = item.dataset.start.substring(0, 10);
    const endDate = item.dataset.end.substring(0, 10);
    item.textContent = `${startDate} ~ ${endDate}`;
});


const tbodyTag = document.querySelector("main .project-table tbody");

//클릭이라는 이벤트가 발생했을 때 함수가 실행됨
tbodyTag.addEventListener("click", function(evt){ 

    //만약 td를 누른게 아니라면 잘못 누르는 경우 return
    if(evt.target.tagName != "TD"){ return;}

    //클릭한 td태그에 접근하고 tr태그(부모)에서 그 자식들인 td태그에 접근해서 게시글 번호 뽑아내기
    const projectName = evt.target.parentNode.children[0].innerText; 

    // 뽑아낸 번호로 요청 보내기(상세조회)
    location.href=`/project/people?projectName=${projectName}`;

});
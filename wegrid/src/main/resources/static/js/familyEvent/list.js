
function openFamilyEventNotion(){
    window.open('https://www.notion.so/154d5a279fee80c88482d6f734abfa6a?v=ca476901e4e744428dc0d858217d12ca', '_blank');
}

function loadFamilyEventList(){
    const tbodyTag = document.querySelector("#table>tbody");

    // const url = new URL(location);
    // let pno = url.searchParams.get("pno");
    // if(pno == null){
    //     pno = 1;
    // }
    $.ajax({
        
        // url : `/trip/list/data?pno=${pno}` ,
        url : `/familyEvent/list` ,
        method : "post" ,
        // data : {
        //     searchType ,
        //     searchValue ,
        // },
       
        success : function(m){
            // const tripVoList = m.a;
            // const pvo = m.b;
            // paintPageArea(pvo);
            
        // JSON 문자열을 객체로 변환
        const data = JSON.parse(m);

        // 필요한 정보만 추출
        const extractedData = [];

        // `results` 배열 순회
        for (let i = 0; i < data.results.length; i++) {
            const result = data.results[i];

            const type = result.properties.type.title[0].text.content;
            const writer = result.properties.writer.rich_text[0]?.text.content || '';
            const content = result.properties.content.rich_text[0]?.text.content || '';
            const location = result.properties.location.rich_text[0]?.text.content || '';
            const dept = result.properties.dept.rich_text[0]?.text.content || '';
            const date = result.properties.date.rich_text[0]?.text.content || '';
           

            // 추출한 데이터를 배열에 추가
            extractedData.push({ type, writer, content, location , dept , date });
        }

        // 결과 출력
        console.log(extractedData);

        // localStorage.setItem("extractedDataList" , JSON.stringify(extractedData));
        
        // const pvo = {};
        // pvo.currnetPage = 1;
        // pvo.currnetPage = 1;
        // pvo.currnetPage = 1;
        // pvo.currnetPage = 1;
        // pvo.boardLimit = 10;
        // pvo.offset = 0;

        // const extractedDataList = JSON.parse(localStorage.getItem("extractedDataList"));
        // const boardVoList = [];
        // for(let i = offset ; i < offset+boardLimit; ++i){
        //     const vo = extractedDataList[i];
        //     boardVoList.push(vo);
        // }


            tbodyTag.innerHTML="";
            
            for(let vo of extractedData){
                const trTag = document.createElement("tr");
                trTag.setAttribute("class" , "list-middle")
                const tdTag01 = document.createElement("td");
                tdTag01.innerText = vo.type;
                trTag.appendChild(tdTag01)
    
                const tdTag02 = document.createElement("td");
                tdTag02.innerText = vo.content;
                trTag.appendChild(tdTag02)
    
                const tdTag03 = document.createElement("td");
                tdTag03.innerText = vo.location;
                trTag.appendChild(tdTag03)
                
                const tdTag04 = document.createElement("td");
                tdTag04.innerText = vo.dept;
                trTag.appendChild(tdTag04)
                
                const tdTag05 = document.createElement("td");
                tdTag05.innerText = vo.writer;
                trTag.appendChild(tdTag05)
                
                const tdTag06 = document.createElement("td");
                tdTag06.innerText = vo.date;
                trTag.appendChild(tdTag06)
    
                
                tbodyTag.appendChild(trTag);

            }
            
            
        },
        error : 
        function(){
            alert("출장 조회 실패")
        },

    });


}

loadFamilyEventList()

// const tbodyTag = document.querySelector("#table>tbody");

// tbodyTag.addEventListener("click" , function(evt){
//     if(evt.target.tagName != "TD"){return;}
//     const no = evt.target.parentNode.children[0].innerText;
//     location.href=`/trip/detail?tno=${no}`;
// });











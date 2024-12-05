
const fileTag = document.querySelector("input[name=input]");
fileTag.addEventListener("change", preview);

function preview(evt){
    const previewArea = document.querySelector(".info-text");
    previewArea.innerHTML = "";
    for(let i = 0; i < evt.target.files.length; ++i){
        const input = evt.target.files[i];
        const fr = new FileReader();    //파일 읽어들이기위한 객체
        fr.onload = function(evt){ //파라미터에 변수넣으면 이벤트를 가져옴 근데 변수명은 내 맘대로
            const dataUrl = evt.target.result;
            const imgTag = document.createElement("img");
            imgTag.setAttribute("src", dataUrl);
            imgTag.setAttribute("width", "100");
            imgTag.setAttribute("height", "100");
            previewArea.appendChild(imgTag);
        }
        fr.readAsDataURL(f);
    }
}


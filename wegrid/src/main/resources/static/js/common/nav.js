

window.onload = function(){
    const asideTag = document.querySelector(".approvalMenuList");
    asideTag.addEventListener("click" , function(evt){
        // evt.target.setAttribute("class" , "active");
        // evt.target.classList.remove("abc");
        // evt.target.classList.add("active");
        evt.target.classList.toggle("active");            //add , remove 합쳐놓은것
        
        
         
    })
}

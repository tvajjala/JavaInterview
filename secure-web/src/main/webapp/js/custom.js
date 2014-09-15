function startexams(){
     url="writesampleexam.do";
    param="move=start";
    retrieveVTRAJAXURL(url,dispquestion,param);
  
}


function nextquestion(){
     url="writesampleexam.do";
    param="move=next";
    retrieveVTRAJAXURL(url,dispquestion,param);
  
}


function prevquestion(){
     url="writesampleexam.do";
    param="move=prev";
    retrieveVTRAJAXURL(url,dispquestion,param);
  
}

function dispquestion(output){
    var qands=output.split("##");
    var qdesc=document.getElementById("questiondesc");
    qdesc.innerHTML =qands[0];
    var adesc=document.getElementById("answerdesc");
    adesc.innerHTML =qands[1];
    
    
}
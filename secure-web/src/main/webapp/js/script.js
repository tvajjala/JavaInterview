// Used to remove white space 

function displayanstype(){
    var qid=document.getElementById("2k8qtid").value;
  var tepetfid=  document.getElementById("tepetfid");
  var tepetextid=  document.getElementById("tepetextid");
  var tepemultiid=  document.getElementById("tepemultiid");
  tepetfid.style.display="none";
  tepetextid.style.display="none";
  tepemultiid.style.display="none";
    if(qid=="1"){
  tepetfid.style.display="block";  
    }else if(qid=="2"){
  tepetextid.style.display="block";  
    }else if(qid=="3"){
  tepemultiid.style.display="block";  
    }
    
    
    

}
function checkAllBoxes(){
    
    for (var i=0;i<document.vtr.elements.length;i++)
        {
            var e=document.vtr.elements[i];
            
            if ((e.name!="allbox") && (e.type=="checkbox")&&(!e.disabled))
                {
                    
                    e.checked=document.vtr.allbox.checked;
                }
            }
        }
        
        
        
        
        function gotomanagelearners(){
            alert("Goto Manage Learner Page To Do This Operation");
            var flag=confirm("Want to go Manage Learners Page");
            if(flag){
                window.location="managestudents.do";
            }else{
            return flag;
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    function deletelearnerfromcourse(userid){
        
        var flag=confirm("Want To Delete User From This Course");
        if(flag){
            url="deletelearnerfromcourseajax.do";
            param="deletecourseuid="+userid;
            retrieveVTRAJAXURL(url,samepage,param);
            
        }else{
        return false;
    }
}

function deleteproctorfromcourse(userid){
    
    var flag=confirm("Want To Delete User From This Course");
    if(flag){
        url="deleteproctorfromcourseajax.do";
        param="deletecourseuid="+userid;
        retrieveVTRAJAXURL(url,addcourseproctor,param);
        
    }else{
    return false;
}
}






function showassignedlearners(){
    
    var tid=tree.getSelectedItemId();
    var cname=tree.getSelectedItemText();
    
    if(tid==""){
        alert("select Course first");
        return false;
    }else{
    window.location="showassignedlearnersofcourse.do?learnercourseid="+tid+"&cname="+cname;
}
}

function assigncoursetoproctor(userid,username){
    var url="addcoursetoproctor.do";    
    var param="proctorid="+userid+"&proname="+username;
    retrieveVTRAJAXURL(url,addcourseproctor,param);
}

function addcourseproctor(output){
    var pcid=document.getElementById("proctorcourseassignmsg");
    pcid.style.color="red";
    pcid.style.fontWeight="bold";
    
    pcid.innerHTML=output;
    
}








function deleteitem(){
    var node=tree.getSelectedItemId();
    if(node==""){
        alert("Select Course First");
        return ;
    }
    
    var flag= confirm("Want to Delete Course "+ tree.getSelectedItemText());
    if(flag){
        var url="deletecourseelement.do";    
        var param="deleteid="+tree.getSelectedItemId();
        retrieveVTRAJAXURL(url,samepage,param);
    }
}

function insertitem(){
    var child =document.getElementById('ed1').value;
    if(Trim(child)==""){
        document.getElementById('ed1').value="";
        alert("EnterCourse  Name First");
        return ;
    }else{
    
    var flag= confirm (" Are You Want Add "+ child+" To Course   " + tree.getSelectedItemText());
    if(!flag){
        return false;
    }
}

var inserelementurl="insertcourseelement.do";
var param="parent="+tree.getSelectedItemId()+"&child="+child;
retrieveVTRAJAXURL(inserelementurl,samepage,param);
}


function assigntoproctor(){
    var courseid=tree.getSelectedItemId();
    if(courseid==""){
        alert("Select Course First ");
        return false;
    }else{
    
    var coursename=tree.getSelectedItemText();
    var flag= confirm("Want to Assign Proctors to Course  "+ coursename);
    if(flag){
        url="assigncoursetoproctorajax.do";
        var param="courseid="+courseid;
        retrieveVTRAJAXURL(url,assignPrctors,param);
    }else{
    return false;
}
}
}


function generateqpapermodel(){
    var courseid=tree.getSelectedItemId();
    if(courseid==""){
        alert("Select Course First ");
        return false;
    }else{
    
    var coursename=tree.getSelectedItemText();
    var flag= confirm("Want to Generate Question Paper Model to Course  "+ coursename);
    if(flag){
        url="generateqpapermodelajax.do";
        alert(coursename);
        var param="courseid="+courseid+"&coursename="+coursename;
        retrieveVTRAJAXURL(url,generateQuestionPaperModel,param);
    }else{
    return false;
}
}
}


function generateQuestionPaperModel(output){

window.location="qpapermodelgeneration.do";
}

function assignPrctors(output){
    
    window.location="gotoaddcoursetoproctorspage.do";
    
    
}

function assignqptolearners(){
  var d= document.getElementsByName("qpaperid");
  var flags=false;
  var seval;
  for(var i=0;i<d.length;i++){
      if(d[i].checked){
      seval=d[i].value;
      flags=true;
      break;
      }
  }
   if(!flags){
      alert("Select Question Paper");
      return;
    }else{
   url="getlearnerlistofpapercourse.do";
   var param="qpaperid="+seval;
   retrieveVTRAJAXURL(url,showcourselearners,param);
}
   

}

function getallquestionpapers(){

var courseid=tree.getSelectedItemId();
var coursename=tree.getSelectedItemText();
alert(coursename);
window.location="viewallquestionpapers.do?courseid="+courseid;

}


function showcourselearners(output) {
    
    window.location="showcourselearners.do";
    
    
    
}

function assigntolearner(){
    
    var courseid=tree.getSelectedItemId();
    if(courseid==""){
        alert("Select Course First ");
        return false;
    }else{
    
    var coursename=tree.getSelectedItemText();
    var flag=confirm("Want to Assign Learners to Course  "+ coursename);
    if(flag){
        url="assigncoursetolearnersajax.do";
        var param="courseid="+courseid;
        retrieveVTRAJAXURL(url,assignLearners,param);
    }else{
    return false;
}
} 


}

function assignLearners(output) {
    
    window.location="gotouploadlearners.do";
    
    //   window.location="gotoaddcoursetolearnerspage.do";
    
}


function removeProctorsDialog() 
{
    var parent = document.getElementById("proctorwindow");
    document.body.removeChild(parent);
    return false;
}

function removeLearnersDialog(){
    var parent = document.getElementById("learnerswindow");
    document.body.removeChild(parent);
    return false;
}




function OnFocus(elementId, defaultText)
{ 
    if (document.getElementById(elementId).value == defaultText)
        {
            document.getElementById(elementId).className = "textfield";
            document.getElementById(elementId).value = "";
        }
    }
    
    function OnBlur(elementId, defaultText)
    {
        var serchfieldvtr=document.getElementById(elementId);
        
        var textValue = serchfieldvtr.value;
        
        if (textValue == defaultText || textValue.length == 0)
            {
                document.getElementById(elementId).className = "watermark";
                document.getElementById(elementId).value = defaultText;
            }
            else
                document.getElementById(elementId).className = "normal";
        }
        
        
        
        function getyahooid(){
            
            var url="https://edit.yahoo.com/registration?IntlSwapBtn=1&preferredcontent=in&u=5481knt45mt2t&dracs=&t=znfbWBRm6Y0ZWpAL8zDFSOH0lAp60eQwhKi8J1jqQHUGqHEBwcP.GEx06KuHYbtpcE.Bm5j7HgkpU0TLPJ0Xodkg7fUiuoHv4a4Odqbf7PlYwpZH5itgtiws7qN.m_DzDyPgRYrbnhn8Srvu.Nt1dnDBwpBuDq39X87sWcU6M0aMtBy3cxlPcU0ne.XICSziVOsYp3r3YjI12yQoO6._OeOXOSP8wzvEr0dcxCZyidGozwx2gDslTQ--~B&done=http://mail.yahoo.com&last=&partner=yahoo_default&intl=us&src=ym&.scrumb=&jsenabled=0";
            mywindow = window.open(url,"Globarena","location=0,resizable=1,toolbar=0,menubar=1,status=0,scrollbars=1,width=800,height=600,top=1200,left=1500");
            var width=screen.width;
            var height=screen.height;
            var x=(width-800)/2;
            var y=(height-600)/2;
            mywindow.moveTo(x,y);
        }
        
        
        function exceluploadhelp(cpath){
            
            url=cpath+"/help/uploadexcel.jsp";
            mywindow = window.open(url,"Globarena","location=0,resizable=1,toolbar=0,menubar=1,status=0,scrollbars=1,width=800,height=600,top=1200,left=1500");
            var width=screen.width;
            var height=screen.height;
            var x=(width-800)/2;
            var y=(height-600)/2;
            mywindow.moveTo(x,y);
        }
        
        
        function Trim(str){
            while(str.charAt(0) == (" ") ){
                str = str.substring(1);
            }
            while(str.charAt(str.length-1) == " " ){
                str = str.substring(0,str.length-1);
            }
            return str;
        }
        
        //Hide status bar msg script- By VTR
        // call this function using onmouseover of hyperlink
        var statusmsg=""
        function hidestatus(){
            window.status=statusmsg;
            return true
        }
        //Hide status bar msg script- By VTR
        
        
        
        
        function checkmanagerdetails(){
            var errormsg=document.getElementById("errormsg");
            var uid=document.getElementById("uid").value;
            var fname=document.getElementById("fname").value;
            
            
            var dob=document.getElementById("dob").value;
            
            var email=document.getElementById("email").value;
            var phone=document.getElementById("phone").value;
            
            if(Trim(uid)==''){
                errormsg.innerHTML="Please Enter UserID";
                uid="";
                return false;
            }else if(Trim(uid).length<5){
            errormsg.innerHTML="UserID Must Have At Least 5 Characters";
            return false;
        } else if(Trim(fname)==''){
        errormsg.innerHTML="Please Enter FirstName";
        return false;
    } else if(Trim(dob)==''){
    errormsg.innerHTML="Please Select DataOfBirth";
    return false;
}else if(Trim(phone)==''){
errormsg.innerHTML="Please Enter Phone Number";
return false;
}else if((Trim(phone).length<5)){

errormsg.innerHTML="Invalid Phone Number";
return false;
}else if(Trim(email)==''){
errormsg.innerHTML="Please Enter E-Mail ID ";
return false;
}else if(email!=''){
var filter=/^.+@.+\..{2,3}$/
if (filter.test(email)){
    
    return true;
}else{
errormsg.innerHTML=" InValid E-Mail Address";
return false;
}
}else{
var fvtr=confirm("Please Check User Status Before Submitting  ");
return fvtr;
}
}

function changetheme(tid){
    var finalurl="changetheme.do";
    var param="themeid="+tid;
    retrieveVTRAJAXURL(finalurl,samepage,param);
}

function scrresoltion(){
    var finalurl="changeScreenSize.do";
    var param="";
    retrieveVTRAJAXURL(finalurl,samepage,param);
    
}


function samepage(){
    window.location=window.location.href;
}

function home(cpath){
    window.location=cpath;
}

function getManagerAjaxDetails(mid){
    var finalurl="getmanagerdatabyid.do";
    var param="mid="+mid;
    retrieveVTRAJAXURL(finalurl,displayManagers,param);
}


function getApproverAjaxDetails(mid){
    var finalurl="getapproverdatabyid.do";
    var param="mid="+mid;
    retrieveVTRAJAXURL(finalurl,displayApprovers,param);
}

function getProctorAjaxDetails(mid){
    var finalurl="getproctordatabyid.do";
    var param="mid="+mid;
    retrieveVTRAJAXURL(finalurl,displayProctors,param);
}

function getStudentAjaxDetails(mid){
    var finalurl="getstudentdatabyid.do";
    var param="mid="+mid;
    retrieveVTRAJAXURL(finalurl,displayStudents,param);
}




function displayManagers(output){
    
    var splitdata=output.split(",");
    document.getElementById("uid").value=splitdata[0];
    document.getElementById("fname").value=splitdata[1];
    document.getElementById("lname").value=splitdata[2];
    document.getElementById("dob").value =splitdata[3];
    document.getElementById("email").value =splitdata[4];
    document.getElementById("designation").value =splitdata[5];
    document.getElementById("phone").value =splitdata[6];
    
    
}


function displayApprovers(output){
    
    var splitdata=output.split(",");
    document.getElementById("uid").value=splitdata[0];
    document.getElementById("fname").value=splitdata[1];
    document.getElementById("lname").value=splitdata[2];
    document.getElementById("dob").value =splitdata[3];
    document.getElementById("email").value =splitdata[4];
    document.getElementById("designation").value =splitdata[5];
    document.getElementById("phone").value =splitdata[6];
    
    
}



function displayProctors(output){
    var splitdata=output.split(",");
    document.getElementById("uid").value=splitdata[0];
    document.getElementById("fname").value=splitdata[1];
    document.getElementById("lname").value=splitdata[2];
    document.getElementById("dob").value =splitdata[3];
    document.getElementById("email").value =splitdata[4];
    document.getElementById("designation").value =splitdata[5];
    document.getElementById("phone").value =splitdata[6];
    document.getElementById("rolev").innerHTML=splitdata[7].split("_")[1];
    
}


function displayStudents(output){
    
    var splitdata=output.split(",");
    document.getElementById("uid").value=splitdata[0];
    document.getElementById("fname").value=splitdata[1];
    document.getElementById("lname").value=splitdata[2];
    document.getElementById("dob").value =splitdata[3];
    document.getElementById("email").value =splitdata[4];
    document.getElementById("designation").value =splitdata[5];
    document.getElementById("phone").value =splitdata[6];
    
    
}


function deleteManager(mid){
    
    var flag=confirm("Are You Sure want to Delete User ");
    if(flag){
        var flag2=confirm("Click OK to Delete User Permanantly from Database ");
        if(flag2){
            
            var mdurl="deletemanagerbyid.do";
            var param="mid="+mid;
            retrieveVTRAJAXURL(mdurl,userMessage,param);
            alert("Record Deleted"); 
            window.location="createmanagers.do";
        }else{
        alert("Record Delete Cancelled");
    }
    
    
}else{
alert("Record Deletion Cancelled");
}

}

function deleteApprover(mid){
    
    var flag=confirm("Are You Sure want to Delete User");
    if(flag){
        var flag2=confirm("Click OK to Delete User Permanantly from Database ");
        if(flag2){
            
            var mdurl="deleteapproverbyid.do";
            var param="mid="+mid;
            retrieveVTRAJAXURL(mdurl,userMessage,param);
            alert("Record Deleted"); 
            window.location="createapprovers.do";
        }else{
        alert("Record Delete Cancelled");
    }
    
    
}else{
alert("Record Deletion Cancelled");
}

}




function deleteProctor(mid){
    
    var flag=confirm("Are You Sure want to Delete User ");
    if(flag){
        var flag2=confirm("Click OK to Delete User Permanantly from Database ");
        if(flag2){
            
            var mdurl="deleteproctorbyid.do";
            var param="mid="+mid;
            retrieveVTRAJAXURL(mdurl,userMessage,param);
            alert("Record Deleted"); 
            window.location="createproctors.do";
        }else{
        alert("Record Delete Cancelled");
    }
    
    
}else{
alert("Record Deletion Cancelled");
}

}

function deleteStudent(mid){
    
    var flag=confirm("Are You Sure want to Delete User ");
    if(flag){
        var flag2=confirm("Click OK to Delete User Permanantly from Database ");
        if(flag2){
            
            var mdurl="deletestudentbyid.do";
            var param="mid="+mid;
            retrieveVTRAJAXURL(mdurl,userMessage,param);
            alert("Record Deleted"); 
            window.location="managestudents.do";
        }else{
        alert("Record Delete Cancelled");
    }
    
    
}else{
alert("Record Deletion Cancelled");
}

}






function userMessage(output){
    var errormsg=document.getElementById("errormsg");
    errormsg.innerHTML=output;
    
}


function resetManagerPass(mid){
    var flag=confirm("Are You Sure Want to Reset Password  ");
    if(flag){
        var mdurl="resetmanagerpassword.do";
        var param="mid="+mid;
        retrieveVTRAJAXURL(mdurl,userMessage,param);
    }     
    else{
        alert("Password Resetting Cancelled ");
    }
    
}



function updateUserInfomation(uid){
    
    var flag=confirm("Are You Sure Want to Update Information  ");
    
    if(flag){
        var mdurl="updateUserInfo.htm";
        var param="uid="+uid;
        retrieveVTRAJAXURL(mdurl,userMessage,param);
    }     
    else{
        alert("Password Resetting Cancelled ");
    }
    
}




function resetApproverPass(mid){
    
    var flag=confirm("Are You Sure Want to Reset Password  ");
    
    if(flag){
        var mdurl="resetapproverpassword.do";
        var param="mid="+mid;
        retrieveVTRAJAXURL(mdurl,userMessage,param);
    }     
    else{
        alert("Password Resetting Cancelled ");
    }
    
}



function resetProctorPass(mid){
    
    var flag=confirm("Are You Sure Want to Reset Password  ");
    
    if(flag){
        var mdurl="resetproctorpassword.do";
        var param="mid="+mid;
        retrieveVTRAJAXURL(mdurl,userMessage,param);
    }     
    else{
        alert("Password Resetting Cancelled ");
    }
    
}


function resetStudentPass(mid){
    var flag=confirm("Are You Sure Want to Reset Password  ");
    if(flag){
        var mdurl="resetstudentpassword.do";
        var param="mid="+mid;
        retrieveVTRAJAXURL(mdurl,userMessage,param);
    }     
    else{
        alert("Password Resetting Cancelled ");
    }
    
}





function showdesc(linkid){
    var linkdesc=  document.getElementById("linkdesc"); 
    var msg="No Message Added";
    
    if(linkid=="admin1"){
        msg="View And Edit Personal Information of Administrator.There can be only Administrator for this product";
    } else if(linkid=="admin2"){
    msg="Create ,View And Edit Managers.There can be more than two managers can created by the admin, enabling /disabling also done by the admin only    ";
} else if(linkid=="admin3"){
msg="Create ,View And Edit  Approvers.There can be more than two  Approvers can created by the admin/managers, enabling /disabling also done by the admin,managers only ";
} else if(linkid=="admin4"){
msg="Create ,View And Edit  Proctors.There can be more than two  Proctors can created by the admin/managers, enabling /disabling also done by the admin,managers only ";
} else if(linkid=="admin5"){
msg="Create And View Students";
} else if(linkid=="admin6"){
msg="Go to mail box for sending /receiving messages and queries";
} else if(linkid=="admin7"){
msg="Manage Search Engine Content Like Add /Delete Pages to Search Engine";
}
linkdesc.innerHTML=msg;
}



function showproctordesc(linkid){
    var linkdesc=  document.getElementById("linkdesc"); 
    var msg="No Message Added";
    if(linkid=="proctor1"){
        msg="View Personal Information";
    }else if(linkid=="proctor2"){
    msg="Creating Questions of Different Types  ";
}else if(linkid=="proctor3"){
msg="Sending/ Receiving  Mails";
}

linkdesc.innerHTML=msg;

}

function showmanagerdesc(linkid){
    var linkdesc=  document.getElementById("linkdesc"); 
    var msg="No Message Added";
    
    if(linkid=="manager1"){
        msg="View And Edit Personal Information of Manager.";
    } else if(linkid=="manager2"){
    msg="Create ,View And Edit Learners. enabling /disabling also done by the admin ,manager only    ";
} else if(linkid=="manager3"){
msg="Create ,View And Edit  Courses.Assign Courses To PROCTORS And STUDENTS ";
} else if(linkid=="manager4"){
msg="Manager Examination Learners Reports In Different Formats";
} else if(linkid=="manager5"){
msg="Go to mail box for sending /receiving messages and queries.  ";
}
linkdesc.innerHTML=msg;
}



function hidedesc(){
    var linkdesc=  document.getElementById("linkdesc"); 
    linkdesc.innerHTML="";
    
}



function changeLanguage(cpath){
    var language= document.getElementById("language");
    finalurl=cpath+"/changelanguage";
    var param="language="+language.value;
    retrieveVTRAJAXURL(finalurl,samepage,param);
    
    
}


function showdiv(curobj,show,div,cmtid){
    
    var obj =  document.getElementById(div);
    obj.style.display=((show =="block")? "block" : "none");
    
    if(obj.style.display =="block"){
        
        var xpos=getposOffset(curobj, "left",-30,"minus")+((typeof opt_position!="undefined" && opt_position.indexOf("right")!=-1)? -(subobj.offsetWidth-curobj.offsetWidth) : 0);
        var ypos=getposOffset(curobj, "top",15,"add")+((typeof opt_position!="undefined" && opt_position.indexOf("bottom")!=-1)? curobj.offsetHeight : 0);
        obj.style.left=xpos+"px";
        obj.style.top=ypos+"px";
        
    }
    return true;
}




function getposOffset(overlay, offsettype,adjustoffset,sign){
    
    var totaloffset=(offsettype=="left")? overlay.offsetLeft : overlay.offsetTop;
    
    var parentEl=overlay.offsetParent;
    
    while (parentEl!=null){
        
        totaloffset=(offsettype=="left")? totaloffset+parentEl.offsetLeft : totaloffset+parentEl.offsetTop;
        parentEl=parentEl.offsetParent;
        
    }
    
    if(sign=="minus"){
        
        totaloffset = totaloffset - adjustoffset;
        
    }else{
    
    totaloffset = totaloffset + adjustoffset;
    
}

return totaloffset;

}


/////////////////////change password//////////////////////////
function changepass(uid,cpath){
    var newpw= document.getElementById("newpw").value;
    if(Trim(newpw)==""){
        document.getElementById("msg").innerHTML="Enter New Password";
        document.getElementById("newpw").value="";
        return false;
    }
    var cpw= document.getElementById("cpw").value;
    
    if(Trim(cpw)==""){
        document.getElementById("msg").innerHTML="Confirm Your Password";
        document.getElementById("cpw").value="";
        return false;
    }
    if(newpw!=cpw){
        document.getElementById("msg").innerHTML="Password Not Matching";
        document.getElementById("cpw").value="";
        document.getElementById("newpw").value="";
        return false;
    }
    var finalurl=cpath+"/changepassword.do";
    var param="uid="+uid+"&newpw="+newpw+"&cpw="+cpw;
    retrieveVTRAJAXURL(finalurl,displayPasswordMsg,param);
    return false;
}

function displayPasswordMsg(output){
    document.getElementById("msg").innerHTML=output;
    document.getElementById("cpw").value="";
    document.getElementById("newpw").value="";
    
}
/////////////////////change password//////////////////////////

/////////////////////Book Mark Image //////////////////////////
function bookmarksite() 
{ 
    if (document.all) 
        window.external.AddFavorite(self.location,document.title); 
    else if (window.sidebar) 
        window.sidebar.addPanel(document.title,self.location, ""); 
} 

function ClientValidate(source, arguments)
{
    // even number?
    if (arguments.Value.length > 1000)
        arguments.IsValid = false;
    else
        arguments.IsValid = true;
}

/////////////////////Book Mark Image //////////////////////////







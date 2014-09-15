


function retrieveVTRAJAXURL(url,callbackfunction,params) {
    
    
    var req = createXHR();
    
    req.onreadystatechange = function(){
        this.r = req;
        this.callback = callbackfunction;
        processStateChange(this.r, this.callback);
    }
    try {
        req.open("post", url, true); //was get
        req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        req.setRequestHeader("Content-length", params.length);
        req.setRequestHeader("Connection", "close");
        
    } catch (e) {
    //alert("Problem Communicating with Server\n"+e);
    
    alert("There Was A Problem Communicating With Server. SERVER ERROR CODE "+e);
    
    if(typeof(ajax_cleanup_on_failure) != 'undefined')
        {
            ajax_cleanup_on_failure();
        }
    }
    req.send(params);// QUERY STRING PASSING
}

function processStateChange(req, callback) {
    
    if (req.readyState == 4) 
        { 
            
            if(req.status == 200) 
                {
                    
                    if(typeof(callback) == 'function')
                        {
                            callback(req.responseText);
                        }
                    } else {
                    alert("There Was A Problem Communicating With Server. Please Try Again Req Status "+req.status);
                    
                    if(typeof(ajax_cleanup_on_failure) != 'undefined'){
                        ajax_cleanup_on_failure();
                    }
                }
                
            }else{
            
            
        }
    }
    
    ////////////////////////////////////////   XMLHTTPRequest OBJECT ////////////////////////////////
    function createXHR() 
    {
        var xmlhttp;
        
        /*@cc_on
        
        @if (@_jscript_version >= 5)
        
        try {
        
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
        
        } catch (e) {
        
        try {
        
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        
        } catch (E) {
        
        xmlhttp = false;
        
        }
        
        }
        
        @else
        
        xmlhttp = false;
        
        @end @*/
        
        if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
            
            try {
                
                xmlhttp = new XMLHttpRequest();
                
                
            } catch (e) {
            
            xmlhttp = false;
            
        }
        
    }
    
    return xmlhttp;
}
////////////////////////////////////////   AJAX OBJECT ////////////////////////////////


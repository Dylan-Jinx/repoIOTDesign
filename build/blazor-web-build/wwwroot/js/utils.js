

function getFullPath(obj) {
    if (obj) {
        //ie
        if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
            obj.select();
            return document.selection.createRange().text;
        }
        //firefox
        else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
            if (obj.files) {
                return obj.files.item(0).getAsDataURL();
            }
            return obj.value;
        }
        return obj.value;
    }
}

function goBack() {
    window.history.go(-1); 
}

function addFoodNutrition() {

    $.ajax({
        type:'Post',
    })
}

function addflexible() {
     $("script[src='js/flexible.js']").add();
}

function removeflexible() {
    if ($("script").length > 0) {
        $("script[src='js/flexible.js']").remove();

    }
}

function loadLib() {
    let script = document.createElement("script");
    script.async = false;
    script.src = "/js/flexible.js";
    document.body.appendChild(script);
}

function reloadPage() {
    window.location.reload();
}

function flexible() {
    
    var docEl = this.document.documentElement;
    var dpr = this.window.devicePixelRatio || 1;

    // adjust body font size
    function setBodyFontSize() {
        if (document.body) {
            document.body.style.fontSize = 12 * dpr + "px";
        } else {
            document.addEventListener("DOMContentLoaded", setBodyFontSize);
        }
    }
    setBodyFontSize();

    // set 1rem = viewWidth / 10
    function setRemUnit() {
        var rem = docEl.clientWidth / 24;
        docEl.style.fontSize = rem + "px";
    }

    setRemUnit();

    // reset rem unit on page resize
    window.addEventListener("resize", setRemUnit);
    window.addEventListener("pageshow", function (e) {
        if (e.persisted) {
            setRemUnit();
        }
    });

    // detect 0.5px supports
    if (dpr >= 2) {
        var fakeBody = document.createElement("body");
        var testElement = document.createElement("div");
        testElement.style.border = ".5px solid transparent";
        fakeBody.appendChild(testElement);
        docEl.appendChild(fakeBody);
        if (testElement.offsetHeight === 1) {
            docEl.classList.add("hairlines");
        }
        docEl.removeChild(fakeBody);
    }
}

function getTime() {
    var t = null;
    t = setTimeout(time, 1000);//開始运行
    function time() {
        clearTimeout(t);//清除定时器
        dt = new Date();
        var h = dt.getHours();//获取时
        var m = dt.getMinutes();//获取分
        var s = dt.getSeconds();//获取秒
        if (m < 10) {
            if (s < 10) {
                document.getElementById("showTime").innerHTML = "当前时间：" + h + "：0" + m + "：0" + s;
            }
            else {
                document.getElementById("showTime").innerHTML = "当前时间：" + h + "：0" + m + "：" + s;
            }
        }
        else {
            if (s < 10) {
                document.getElementById("showTime").innerHTML = "当前时间：" + h + "：" + m + "：0" + s;
            }
            else {
                document.getElementById("showTime").innerHTML = "当前时间：" + h + "：" + m + "：" + s;
            }
        }
        t = setTimeout(time, 1000); //设定定时器，循环运行     
    }
}


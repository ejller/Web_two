var zero = 175;
var rConstLenght = 150;
var x;
var y;
var r;

//Значение относительно Canvas
// var xCanvas;
// var yCanvas;
//Проверка введенных значений
var validY = false;
var validX = false;

var iconName="fast";
var count  = 0;
var mq1 = ['лед', 'льдина', 'айсберг'];
var mq2 = ['дыра', 'дырка', 'ящерица', 'волосы'];
var mq3 = ['свет'];
var mq4 = ['личность' ,"человек", 'характер'];
var mq5 = ['разум', 'мозг', 'сердце', 'душа', 'отражение', 'сознание'];
var mq6 = ['взгляд', 'эмоции'];
var mq7 = ['соль' ];
var mq8 = ['тишина', 'молчание'];
var nowErr = 0;
var nowRand=0;

//Интерактивный обьект
function draw() {

    if (get_count()>=3)
        openModal();

    var canvas = document.getElementById('canvas');
    if (canvas.getContext) {

        canvas.addEventListener('click', canvasClicked, false);

        function canvasClicked(e) {

            xCanvas = e.pageX - e.target.offsetLeft;
            yCanvas = e.pageY - e.target.offsetTop;
            x = xCanvas;
            y = yCanvas;


            if (x >= zero) {
                x = x - zero
            } else {
                x = -(zero - x);
            }

            if (y <= zero) {
                y = zero - y;
            } else {
                y = -(y - zero);
            }

            //Проверка задан ли радиус
            r = document.querySelector('input[name="r_field"]:checked').value;
            if (r !== null)
                rChoose();

        }

    }
}

function pointDraw(r, xCanvas, yCanvas) {
    var canvas = document.getElementById('canvas');
    if (canvas.getContext) {
        var ctx = canvas.getContext('2d');
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.beginPath();

        if (r!==0){
            ctx.fillStyle = "#470005";}
        else {
            ctx.fillStyle = "rgba(91,234,65,0.68)";
        }
        ctx.moveTo(125, 35);
        ctx.arc(xCanvas, yCanvas, 6, 0, 2 * Math.PI);
        ctx.fill();
    }
}

//Предвалидация радиуса и отправка формы
function rChoose() {

    var rValid = ['1', '2', '3', '4', '5'];
    if (contains(rValid, r)) {

        x = Math.round(x / rConstLenght * r);
        y = y / rConstLenght * r;


        if (contains([-5, -4, -3, -2, -1, 0, 1, 2, 3], x) && (-3 < y) && (y < 5)) {

            var fieldX = document.getElementById('X_field');
            var fieldY = document.getElementById('Y_field');
            if (fieldX.value !== "") {
                document.getElementById("x" + fieldX.value).classList.remove('sel');
            }
            fieldX.value = x;
            fieldY.value = y;

            document.getElementById("x" + x).classList.add('sel');

            document.forms["form"].submit();
            validY =true;
            validX = true;
            if (get_count()<3){
                document.forms["form"].submit();
                count_up();
            } else {
                openModal();
            }
        }
    }

    checkAnimation()
}

//Нажатие кнопки x
function xChoose(x) {

    var field = document.getElementById('X_field');

    if (field.value === x) {
        field.value = "";
        document.getElementById("x" + x).classList.remove('sel');
        validX=false;
    } else {
        if (field.value !== "") {
            document.getElementById("x" + field.value).classList.remove('sel');
        }
        field.value = x;
        document.getElementById("x" + x).classList.add('sel');
        validX=true;
    }

    checkAnimation()
}

function yChoose() {

    var field = document.getElementById('Y_field');
    var txt = field.value.match(/^[0-2]{1}[\,|\.]{1}\d{1,}$|^-[0-4]{1}[\,\.]\d{1,}$|^[0-2]$|^-[0-4]$/m);

    if (txt !== null && ("-0" !== txt)) {
        validY=true;
        if (field.classList.contains("invalid"))
            field.classList.remove("invalid");
    } else {
        validY=false;
        field.classList.add("invalid");
    }

    checkAnimation()
}

//Проверка содержания числа в массиве
function contains(a, obj) {

    for (var i = 0; i < a.length; i++) {
        if (a[i] === obj)
            return true;
    }
    return false;
}


function checkAnimation() {
    var message = document.getElementById("about_block");
    var button = document.getElementById('button_submit');
    if (validX&&validY){
        button.classList.add("button_animated");
        message.style.visibility="hidden";
    } else {
        message.style.visibility="visible";
        button.classList.remove("button_animated");
    }
}


function submit_btn() {
    if (validY&&validX ) {
        if (get_count()<3){
            document.forms["form"].submit();

            count_up();
        } else {
            openModal();
        }
    }


}

function changeIcon(icon) {

        document.getElementById(iconName+"_text").classList.remove('chooseButton');
        document.getElementById(iconName+"_title").classList.remove('chooseButton');
        document.getElementById(iconName+"_icon").classList.remove('chooseButton');
        document.getElementById(icon+"_icon").classList.add('chooseButton');
        document.getElementById(icon+"_title").classList.add('chooseButton');
        document.getElementById(icon+"_text").classList.add('chooseButton');
        iconName = icon;
}


function checkAnswer() {
    var q = getCookie('q');
    var field_answer = document.getElementById('answer');
    var answer = field_answer.value;
    answer = answer.toLowerCase().replace(" ", "");
    var result=false;
    switch (q) {
        case '1':result = contains(mq1, answer);
        break;
        case '2':result = contains(mq2, answer);
        break;
        case '3':result = contains(mq3, answer);
        break;
        case '4':result = contains(mq4, answer);
        break;
        case '5':result = contains(mq5, answer);
            break;
        case '6':result = contains(mq6, answer);
            break;
        case '7':result = contains(mq7, answer);
            break;
        case '8':result = contains(mq8, answer);
            break;
    }
    if(result) {
        closeModal();
        count_reset();

    } else {
        showErr();
    }
}

function showErr() {
    var showE = getRandomInt(1,3);
    if (nowErr!==0){
        document.getElementById("error"+nowErr).style.display = "none";
    }
    nowErr=showE;
    document.getElementById("error"+showE).style.display = "block";

}

function openModal() {

    var q = getRandomInt(1,8);
    setCookie('q',q);
    document.getElementById("q"+q).style.display = "block";
    var modal = document.getElementById("myModal");
    modal.style.display = "block";
}

function closeModal() {
    if (nowErr!==0)
        document.getElementById("error"+nowErr).style.display = "none";
    document.getElementById("answer").value="";
    document.getElementById("q"+ getCookie('q')).style.display = "none";
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
}




function drawR(res, xN, yN ,rN) {
    var xCanvas = 0;
    var yCanvas = 0;
    if (res!=='-1'){
        if (xN<0){
            xCanvas = 175 - Math.abs(xN)/rN*150;
        } else {

            xCanvas = 175 + xN/rN*150;
        }
        if (yN<0){
            yCanvas = 175 + Math.abs(yN)/rN*150;
        } else {
            yCanvas = 175 - yN/rN*150;
        }

        pointDraw(res, xCanvas,yCanvas);
    }
}


function getRandomInt(min, max) {

    return Math.floor(Math.random() * ((max+1) - min)) + min;
}

function count_up() {

    setCookie('count', get_count()+1)
}
function count_reset() {

    setCookie('count', 0)
}

function get_count() {

    var ret = parseInt(getCookie('count'));

    if (!isNaN(ret)) {
        return ret;
    }
    return 0;
}


function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}

function setCookie(name, value, options) {

    options = {
        path: '/'
    };

    if (options.expires && options.expires.toUTCString) {
        options.expires = options.expires.toUTCString();
    }

    var updatedCookie = encodeURIComponent(name) + "=" + encodeURIComponent(value);

    for (var optionKey in options) {
        updatedCookie += "; " + optionKey;
        var optionValue = options[optionKey];
        if (optionValue !== true) {
            updatedCookie += "=" + optionValue;
        }
    }

    document.cookie = updatedCookie;
}




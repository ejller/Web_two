<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<head>
    <meta charset="URF-8">
    <title>
        Lab Two
    </title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/main_style.css"/>
    <link href="https://fonts.googleapis.com/css?family=Hepta+Slab|M+PLUS+Rounded+1c|Oswald|Roboto+Mono&display=swap" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/main.js"></script>

    <style>
        .header {
            background-image: url("${pageContext.request.contextPath}/image/head.png");
        }

        .footer {
            background-image: url("${pageContext.request.contextPath}/image/footer.png");
        }

        .head_foot_img {
            background-image: url("${pageContext.request.contextPath}/image/hft.png");
        }

        <%--.slider_text_block {--%>
        <%--    background-image: url("${pageContext.request.contextPath}/image/icon/info_back.png");--%>
        <%--}--%>

        .graph canvas {
            background-image: url("${pageContext.request.contextPath}/image/batman.png");
        }

        .graph {
            background-image: url("${pageContext.request.contextPath}/image/circle.png");
        }

        .preview_img{
            background-image: url("${pageContext.request.contextPath}/image/hft_bottom.png");;
        }

    </style>
</head>

<body onload="draw()">
<div class="main">
    <div class="preview_img">
        <div class="head_foot_img">

            <div class="head_block">
                <div class="header">
                    <div class="empty"></div>
                    <div class="group_variant"> P3202 V-Batman</div>
                    <div class="name"> Nekrasova A.</div>
                </div>
             </div>

            <div class="title_one">
                <div><img src="${pageContext.request.contextPath}/image/title_zero.png" width="25%"></div>
            </div>


            <div class="text text-one">
                <span>THE NEW STORY OF GOTEM</span>
                <div class="line">
                    <img src="${pageContext.request.contextPath}/image/line.png"
                         width=93%">
                </div>

                <br>
                <br>
                <span> Вашему вниманию представляется новый сервис Готема, позволяющий дистационно связваться с бэтменом. В данный
        момент сервис находится в режиме тестирования.
        </span>


                <div id="wrapper">
                    <a href="#title_two" class="my-super-cool-btn">
                        <div class="dots-container">
                            <div class="dot"></div>
                            <div class="dot"></div>
                            <div class="dot"></div>
                            <div class="dot"></div>
                        </div>
                        <span>START</span>
                    </a>
                </div>

            </div>


            <div class="alfred_img">
                <img src="${pageContext.request.contextPath}/image/alfred.png" width="90%">
            </div>

            <div class="title_up_slider">Advantages</div>
            <div class="slider_wrapp">
                <div class="slider">

                    <div class="icons">

                        <div class="icon fast chooseButton" id="fast_icon" onclick="changeIcon('fast')">
                            <img src="${pageContext.request.contextPath}/image/icon/fast.png" width="100%">
                        </div>

                        <div class="icon point">
                            <img src="${pageContext.request.contextPath}/image/icon/point.png" width="70%">
                        </div>

                        <div class="icon free" id="free_icon" onclick="changeIcon('free')">
                            <img src="${pageContext.request.contextPath}/image/icon/free.png" width="60%">
                        </div>

                        <div class="icon point">
                            <img src="${pageContext.request.contextPath}/image/icon/point.png" width="70%">
                        </div>

                        <div class="icon safety" id="safety_icon" onclick="changeIcon('safety')">
                            <img src="${pageContext.request.contextPath}/image/icon/safety.png" width="45%">
                        </div>

                    </div>

                    <div class="slider_text_block">

                        <div class="title_slider chooseButton" id="fast_title"><span>FAST</span></div>
                        <div class="title_slider" id="free_title"><span>FREE</span></div>
                        <div class="title_slider" id="safety_title"><span>SAFETY</span></div>
                        <div class="line_slider"><img src="${pageContext.request.contextPath}/image/line.png"
                                                      width=100%">
                        </div>
                        <div class="slider_text chooseButton" id="fast_text">Скорость работы сайта сравнима только с быстротой
                            бэтмобиля.
                        </div>
                        <div class="slider_text" id="free_text">Сервис является абсолютно бесплатным. </div>
                        <div class="slider_text" id="safety_text">Мы дорожим вашей конфиденциальностью.</div>

                    </div>

                </div>
            </div>


            <div class="title_two" id = "title_two">
                <div><img src="${pageContext.request.contextPath}/image/title_two.png" width="25%"></div>
            </div>

            <div class="task_block">

                <div class="task graph">
                    <canvas width="350px" height="350px" id="canvas" onclick=""></canvas>
                </div>

                <div class="task form">

                    <form method="get" action="mainServlet" target="result" id="form">

                        <div class="ftx">
                            <span class="title_form">Form</span>
                            <div class="line">
                                <img src="${pageContext.request.contextPath}/image/line.png"
                                     width=24%">
                            </div>
                            <br>
                            <span> Установите в соответствующих полях ваши координаты, отправьте заявку и ожидайте ответа. Если вы используете интерактивный обьект,
                                то обратите внимание, что выбранные координаты по Х будут округлены.</span>
                        </div>

                        <div class="R_coordinate">
                            <span style="margin-right: 5px"> R:</span>
                            <input id="r1" type="radio" checked value="1" name="r_field">
                            <label for="r1">1</label>
                            <input id="r2" type="radio" value="2" name="r_field">
                            <label for="r2">2</label>
                            <input id="r3" type="radio" value="3" name="r_field">
                            <label for="r3">3</label>
                            <input id="r4" type="radio" value="4" name="r_field">
                            <label for="r4">4</label>
                            <input id="r5" type="radio" value="5" name="r_field">
                            <label for="r5">5</label>
                            <span id="slider"></span>
                        </div>

                        <div class="Y_coordinate">
                            <span style="margin-right: 5px">Y: </span>
                            <input type="text" name="y_field" id="Y_field" oninput="yChoose()" placeholder="(-5..3)"
                                   autocomplete="off">
                        </div>

                        <div class="X_coordinate">
                            <span style="margin-right: 5px"> X: </span>
                            <button type="button" class="X_button" id="x-5" onclick="xChoose('-5')">-5</button>
                            <button type="button" class="X_button" id="x-4" onclick="xChoose('-4')">-4</button>
                            <button type="button" class="X_button" id="x-3" onclick="xChoose('-3')">-3</button>
                            <button type="button" class="X_button" id="x-2" onclick="xChoose('-2')">-2</button>
                            <button type="button" class="X_button" id="x-1" onclick="xChoose('-1')">-1</button>
                            <button type="button" class="X_button" id="x0" onclick="xChoose('0')">0</button>
                            <button type="button" class="X_button" id="x1" onclick="xChoose('1')">1</button>
                            <button type="button" class="X_button" id="x2" onclick="xChoose('2')">2</button>
                            <button type="button" class="X_button" id="x3" onclick="xChoose('3')">3</button>
                            <input type="hidden" name="x_field" id="X_field">

                        </div>
                        <p class="about_block" id="about_block">Введите корректные значения</p>

                        <div class="button" id="button_submit" onclick="submit_btn()">
                            <div id="circle"></div>
                            CHECK
                        </div>

                    </form>

                </div>
            </div>

            <div class="table_block">
                <iframe src="${pageContext.request.contextPath}/result.jsp" frameborder="0" seamless
                        name="result" id="iframe"></iframe>
            </div>

            <div class="footer">
                <div class="faq"> @2019 Сделано при поддержке комиссии ПИКТа по отчислениям</div>
            </div>
        </div>
    </div>
</div>

<div id="myModal" class="modal">
    <!-- Modal content -->
    <div class="modal-content">
        <div class="mistwruo"><img src="${pageContext.request.contextPath}/image/mistery.png" width="60%"></div>
        <p class="info_modal">Не так быстро. Для продолжения напряги мозги и попробуй отгадать мою загадку.</p>
        <div class="line" style="text-align: center; height: 1px">
            <img src="${pageContext.request.contextPath}/image/line.png"
                 width=80%">
        </div>
        <div class="img_modal"></div>
        <p class="question" id="q1">Что может разрушить корабль, но боится солнца? Что это?</p>
        <p class="question" id="q2">Чем больше вы режете меня, тем больше я расту. Что я?</p>
        <p class="question" id="q3">Могу заполнить зал или единственное сердце, однажды забрав, мной нельзя поделиться.
            Что я?</p>
        <p class="question" id="q4">Я могу быть в толпе, но всегда отличаюсь. Что я?</p>
        <p class="question" id="q5">Я чувствую тебя, и мысли твои слышу, с тобой с первого дня и здесь пока ты дышишь.
            Что я?</p>
        <p class="question" id="q6">Легче пера, но долго не удержать. Что я?</p>
        <p class="question" id="q7">Дочь морская, но в воде умираю. Что я?</p>
        <p class="question" id="q8">Я крепка, как скала, но рушусь от слова. Что я?</p>
        <div class="modal_input"> <input type="text" id="answer"></div>
        <div style="height: 50px; width:100%; text-align: center">
            <p class="error" id="error1">Подумай еще</p>
        <p class="error" id="error2">Неверно</p>
        <p class="error" id="error3">Так думаешь только ты</p>
        </div>
        <div style="width: 100%; text-align: center;">
            <div id="wrapper1" style="padding-top: 10px;">
                <a class="my-super-cool-btn" onclick="checkAnswer()">
                    <div class="dots-container">
                        <div class="dot"></div>
                        <div class="dot"></div>
                        <div class="dot"></div>
                        <div class="dot"></div>
                    </div>
                    <span>CHECK</span>
                </a>
            </div>
        </div>
    </div>

</div>

</body>
</html>
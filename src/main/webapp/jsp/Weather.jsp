<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 16.11.2020
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@page import="weather.ModelWeather" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Weather</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/StyleWeather.css"/>

</head>
<body>
<div class="page">

    <div class="header">
        <h1 class="head-title">Мой сайт</h1>
        <h2 class="head-subtitle">добро пожаловать</h2>
    </div>

    <div class="nav">
        <a class="nav-link" href="#"> Главная</a>
        <a class="nav-link" href="#"> Главная</a>
        <a class="nav-link" href="#"> Главная</a>
        <a class="nav-link" href="#"> Главная</a>

    </div>

    <img src="../pages/intro.jpg" alt="">

    <div class="content">
        <h3 class="content-title">Об авторе</h3>

        <div class="content-text">
            <p>"Как мгла исчезает с восходом Солнца, так и невежество рассеивается светом знания".
                Знание достигается непрерывными исследованиями.
                Человек должен постоянно занимать себя исследованием природы Брахмана:
                реальностями "Я", изменениями, происходящими с индивидуумом из-за рождения, смерти и тому подобное.
                Как шелуху снимают с риса, так же вы должны очистить ум от невежества, прилипшего к нему, постоянно используя для этого исследования духа, "Я".
                Только когда человек обретет полное знание, он сможет получить освобождение или, иначе говоря, Мокшу.
                После того, как человек достигнет осознания Духа, Атмы, о чем говорилось выше, он должен придерживаться пути Брахмана и действовать в соответствии с новой мудростью.
            </p>
            <a class="read-more" href="#">Читать
                полностью</a>
        </div>

        <h3 class="article-title">Новости</h3>
        <div class="article">
            <h4 class="article-head"> Заголовок новости </h4>
            <div class="article-date">27.10.2020</div>
            <div class="article-text">
                <p>"Как мгла исчезает с восходом Солнца, так и невежество рассеивается светом знания".
                    Знание достигается непрерывными исследованиями.
                    Человек должен постоянно занимать себя исследованием природы Брахмана:
                    реальностями "Я", изменениями, происходящими с индивидуумом из-за рождения, смерти и тому подобное.
                    Как шелуху снимают с риса, так же вы должны очистить ум от невежества, прилипшего к нему, постоянно используя для этого исследования духа, "Я".
                    Только когда человек обретет полное знание, он сможет получить освобождение или, иначе говоря, Мокшу.
                    После того, как человек достигнет осознания Духа, Атмы, о чем говорилось выше, он должен придерживаться пути Брахмана и действовать в соответствии с новой мудростью.
                </p>
            </div>

            <a class="read-more" href="#">Читать
                полностью</a>
        </div>

        <div class="article">
            <h4 class="article-head"> Заголовок новости </h4>
            <div class="article-date">27.10.2020</div>
            <div class="article-text">
                <p>"Как мгла исчезает с восходом Солнца, так и невежество рассеивается светом знания".
                    Знание достигается непрерывными исследованиями.
                    Человек должен постоянно занимать себя исследованием природы Брахмана:
                    реальностями "Я", изменениями, происходящими с индивидуумом из-за рождения, смерти и тому подобное.
                    Как шелуху снимают с риса, так же вы должны очистить ум от невежества, прилипшего к нему, постоянно используя для этого исследования духа, "Я".
                    Только когда человек обретет полное знание, он сможет получить освобождение или, иначе говоря, Мокшу.
                    После того, как человек достигнет осознания Духа, Атмы, о чем говорилось выше, он должен придерживаться пути Брахмана и действовать в соответствии с новой мудростью.
                </p>
            </div>

            <a class="read-more" href="#">Читать
                полностью</a>



            <div>
                <form class="form_all" action="" method="post">
                    <div class="form_g">
                        <div class="form_groop">
                            <label for="city"> Введите Город:</label>
                            <input class="form_input" name="City" id="city" type="text" placeholder="Введите город">
                            <input class="form_submitd" type="submit" >
                        </div>
                    </div>
                </form>
            </div>

        </div>

    </div>


    <%out.print(request.getAttribute("C"));%>








    <div class="footer">Сделанно мной</div>


</div>

</body>
</html>
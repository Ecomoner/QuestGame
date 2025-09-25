<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Начало космического приключения</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>Космическое приключение</h1>
    <h2>Пролог</h2>
    <div class="story">
        <p>Ты стоишь в космическом порту и готов поднятся на борт своего корабля. Разве не об этом ты мечтал?
            Стать капитаном галактического судна с экипажем, которы будет совершать подвиги под твоим командованием.</p>
        <p>Так что в перед!</p>
    </div>
    <h2>Знакомство с экипажем</h2>
    <div class="story">
        <p>Когда ты поднялся на борт корабля, тебя поприветсвовала девушка с черной папкой в руках:</p>
        <p>- Здравствуйте, командир! Я Тисса - ваша помощница. Видите? Там в углу пьет кофе наш штурман
            - сержант Переганый Шлейф, под штурвалом спит наш бортмеханик - Черный Богдан, а фотографирует его
            Сергей Стальная Пятка - наш навигатор.</p>
        <p>А как обращатся к вам?</p>
    </div>
    <c:if test="${not empty error}">
        <div class="error-message">
            <p>${error}</p>
        </div>
    </c:if>

    <form method="post" class="player-form">
        <label for="playerName">Введите ваше имя: </label>
        <input type="text" id="playerName" name="playerName" required
               placeholder="Имя игрока" class="form-input">

        <button type="submit" class="start-button">Начать игру</button>
    </form>

</div>
</body>
</html>
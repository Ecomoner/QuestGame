<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 22.09.2025
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Космическое приключение</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Космическое приключение</h1>

        <div class="player-info">
            <p>Имя игрока: <span class="highlight">${sessionScope.player.name}</span></p>
            <p>Количество игр: <span class="highlight">${sessionScope.player.countGame}</span></p>
        </div>

        <div class="game-message">
            <p>${sessionScope.gameState.message}</p>
        </div>

        <c:if test="${not empty error}">
            <div class="error-message">
                <p>${error}</p>
            </div>
        </c:if>
        <c:if test="${not sessionScope.gameState.gameOver}">
            <form method="post" class="choice-form">
                <c:choose>
                    <%-- Шаг 1: Принять вызов --%>
                    <c:when test="${sessionScope.gameState.currentStep eq 'acceptanceOfACall'}">
                        <button type="submit" name="choice" value="1" class="choice-button">
                            1. Принять вызов
                        </button>
                        <button type="submit" name="choice" value="2" class="choice-button">
                            2. Отклонить вызов
                        </button>
                    </c:when>
                    <%-- Шаг 2: Подняться на мостик --%>
                    <c:when test="${sessionScope.gameState.currentStep eq 'goToBridge'}">
                        <button type="submit" name="choice" value="1" class="choice-button">
                            1.Подняться на мостик
                        </button>
                        <button type="submit" name="choice" value="2" class="choice-button">
                            2.Отказаться подниматься на мостик
                        </button>
                    </c:when>
                    <%-- Шаг 3: Расказать о себе правду --%>
                    <c:when test="${sessionScope.gameState.currentStep eq 'aboutYourself'}">
                        <button type="submit" name="choice" value="1" class="choice-button">
                            1.Расказать правду о себе
                        </button>
                        <button type="submit" name="choice" value="2" class="choice-button">
                            2.Солгать о себе
                        </button>
                    </c:when>
                </c:choose>
            </form>
        </c:if>
    </div>
</body>
</html>

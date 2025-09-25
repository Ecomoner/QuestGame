<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 22.09.2025
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Результат игры</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1 class="result-title">
        <c:choose>
            <c:when test="${sessionScope.gameState.winGame}">
                <span class="victory">ПОБЕДА!</span>
            </c:when>
            <c:otherwise>
                <span class="defeat">ПОРАЖЕНИЕ</span>
            </c:otherwise>
        </c:choose>
    </h1>

    <div class="result-message">
        <p>${sessionScope.gameState.message}</p>
    </div>

    <form method="post" class="restart-form">
        <button type="submit" name="choice" value="restart" class="restart-button">
            Играть снова
        </button>
    </form>
</div>
</body>
</html>

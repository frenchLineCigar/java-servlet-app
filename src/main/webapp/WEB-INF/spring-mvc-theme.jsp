<%--
< Spring MVC 테마 스위처 예제 >
이 페이지에는 다른 테마간에 간단히 전환 할 수있는 두 개의 링크가 있다.
테마는 <spring:theme /> 요소를 사용하여 포함된다. 이 요소는 현재 테마를 표시한다.
--%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <link rel="stylesheet" href="<spring:theme code='stylesheet'/>" type="text/css" />
    <title>Spring MVC ThemeResolver Example</title>
</head>
<body>

<h3>Spring MVC ThemeResolver Example</h3>
theme: <a href="?theme=bright">bright</a> | <a href="?theme=dark">dark</a>

</body>
</html>
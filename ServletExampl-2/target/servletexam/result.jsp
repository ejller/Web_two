
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    {
        function callBatya() {
            var res = <jsp:getProperty name="jb" property="lastres"/>;
            var x =0;
            var y=0;
            var r =0;
            if (res !== -1){
                 x = <jsp:getProperty name="jb" property="lastx"/>;
                 y = <jsp:getProperty name="jb" property="lasty"/>;
                 r = <jsp:getProperty name="jb" property="lastr"/>;
                parent.drawR(res, x, y, r);
            }
        }

        document.addEventListener("DOMContentLoaded", callBatya)
    }
</script>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/table.css"/>
</head>
<body>
<jsp:useBean id="jb" class="com.devcolibri.servlet.JavaBean" scope="session"/>
    <table>
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Начало работы</th>
            <th>Время работы</th>
            <th>Реузльтат</th>
        </tr>
        <%! int i = 0;%>
        <%
            for (i = 0; i<jb.getValue();i++) {
        %>
        <tr>
            <th>
                <% jb.getVal("x",i); %>
            <th>
                <% jb.getVal("y",i); %>
            </th>
            <th>
                <% jb.getVal("r",i); %>
            </th>
            <th>
                <% jb.getVal("s",i); %>
            </th>
            <th>
                <% jb.getVal("t",i); %>
            </th>
            <th>
                <% jb.interp(jb.getVal("flag",i)); %>
            </th>
            </th>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>

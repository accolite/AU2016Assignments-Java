<%@ page import="com.mitul.chat.model.ChatManager" %>
<%@ page import="com.mitul.chat.model.Message" %>
<%@ page import="com.mitul.chat.model.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<br>
<br>
<fieldset style="background-color: antiquewhite">
    <legend>Register yourself</legend>
    <div>
        <form action="/register" method="post">
            <div>Register user</div>
            <div>
                <input type="text" name="username" placeholder="username">
                <input type="text" name="password" placeholder="password">
                <input type="submit" value="register">
            </div>
        </form>
    </div>
</fieldset>

<br>
<br>
<fieldset style="background-color: greenyellow">
    <legend>User Login</legend>
    <div>
        <form action="/login" method="post">
            <div>Login user</div>
            <div>
                <input type="text" name="username" placeholder="username">
                <input type="text" name="password" placeholder="password">
                <input type="submit" value="login">
            </div>
        </form>
    </div>

    <th>
        <fieldset align="left">
            <legend>Registered users</legend>
            <div>
                <div>
                    <% for (User user : ChatManager.getRegisteredUsers()) { %>
                    <div>
                        <%= user.getUsername()%>
                    </div>
                    <% } %>
                </div>
            </div>

        </fieldset>
    </th>

</fieldset>

<br>
<br>
<fieldset style="background-color: aqua">
    <legend>Chat Room</legend>
    <div>
        <form action="/logout" method="post">
            <div>
                <input type="submit" value="logout">
            </div>
        </form>
    </div>

    <table>
        <th>
    <textarea placeholder="Your chat appears here" style="width: 500px; height: 150px;" >
        <% for (Message message : ChatManager.getChatRooms().get(0).getMessages()) { %>
            From :<%= message.getUser().getUsername()%>
            Message: <%= message.getMessage()%>
            Date :<%= message.getCreated()%>
        <% } %>
    </textarea>
        </th>

        <th>
            <div>
                Logged in user : <div>${sessionScope.get("user")==null?"":sessionScope.get("user").username}</div>
            </div>
        </th>

    </table>

    <div>
        <form action="/send" method="post">
            <div>Send message</div>
            <div>
                <input type="text" name="message" placeholder="Your Message">
                <input type="submit" value="send">
            </div>
        </form>
    </div>

</fieldset>

<br>
<br>
<fieldset style="background-color: tomato">
    <legend>Admin Control for Banned Words</legend>
    <div>
        Banned words list
        <form action="/banned" method="post">
            <div>
                <input type="text" name="message" placeholder="Bann a word">
                <input type="submit" value="submit">
            </div>
        </form>
    </div>

    <br>
    <br>
    <div>
        List of banned words<br>
        <%for (String word : ChatManager.getBannedWords()) { %>
                <%=word%>
        <br>
        <%
            }
        %>

    </div>

</fieldset>

</body>
</html>

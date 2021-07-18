<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<c:import url="templates/headTag.jsp" />

<body>

    <div class="wrapper">
        <c:import url="templates/headerTag.jsp" />

        <c:import url="templates/sidebar.jsp" />
        
        <h2>Request Data</h2>

        <ul>
            <li><strong>Remote Computer: </strong>${requestBean.remoteComputer}</li>
            <li><strong>Remote Address: </strong>${requestBean.remoteAddress}</li>
            <li><strong>Request Method: </strong>${requestBean.requestHttpMethod}</li>
            <li><strong>Request URI: </strong>${requestBean.requestURI}</li>
            <li><strong>Request URL: </strong>${requestBean.requestURL}</li>
            <li><strong>Request Protocol: </strong>${requestBean.requestProtocol}</li>
            <li><strong>Server Name: </strong>${requestBean.serverName}</li>
            <li><strong>Server Port Number: </strong>${requestBean.serverPortNumber}</li>
            <li><strong>Server Locale: </strong>${requestBean.serverLocale}</li>
            <li><strong>Query String: </strong>${requestBean.queryString}</li>
            <li><strong>Query Parameter Value: </strong>${requestBean.queryParameterValue}</li>
            <li><strong>User Agent: </strong>${requestBean.userAgent}</li>
        </ul>

        <c:import url="templates/footer.jsp" />
    </div>

</body>
</html>
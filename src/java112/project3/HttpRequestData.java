package java112.project3;

import java.util.*;

public class HttpRequestData {


    /**
     * The computer making the request.
     */
    private String remoteComputer; 
    
    /**
     * The IP address of the computer making the request.
     */
    private String remoteAddress; 

    /**
     * The HTTP Method of the request (ex: GET)
     */
    private String requestHttpMethod; 

    /**
     * The URI of the request.
     */
    private String requestURI; 

    /**
     * The URL of the request 
     */
    private String requestURL; 

    /**
     * The protocol of the request.
     */
    private String requestProtocol; 

    /**
     * The server name that the request goes to.
     */
    private String serverName; 

    /**
     * The port number that receives the request.
     */
    private String serverPortNumber; 

    /**
     * The locale in which the server is based.
     */
    private Locale serverLocale; 

    /**
     * The query (if any) in the URL.
     */
    private String queryString; 

    /**
     * The value of the query parameter named "queryParameter"
     */
    private String queryParameterValue; 

    /**
     * The User Agent information, basically browser information.
     */
    private String userAgent; 


    /**
     * Getter method for the remoteComputer instance variable 
     * 
     * @return remoteComputer instance variable
     */
    public String getRemoteComputer() {
        return this.remoteComputer;
    }

    /**
     * Setter method for the instance variable remoteComputer
     * 
     * @param remoteComputer the value to assign to remoteComputer
     */
    public void setRemoteComputer(String remoteComputer) {
        this.remoteComputer = remoteComputer;
    }

    /**
     * Getter method for the instance variable remoteAddress
     * 
     * @return remoteAddress instance variable
     */
    public String getRemoteAddress() {
        return this.remoteAddress;
    }

    /**
     * Setter method for the instance variable remoteAddress
     * 
     * @param remoteAddress the value to assign to remoteAddress
     */
    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    /**
     * Getter method for the instance variable requestHttpMethod
     * 
     * @return requestHttpMethod instance variable
     */
    public String getRequestHttpMethod() {
        return this.requestHttpMethod;
    }

    /**
     * Setter method for the instance variable requestHttpMethod
     * 
     * @param requestHttpMethod the value to assign to requestHttpMethod
     */
    public void setRequestHttpMethod(String requestHttpMethod) {
        this.requestHttpMethod = requestHttpMethod;
    }

    /**
     * Getter method for the instance variable requestURI
     * 
     * @return requestURI instance variable
     */
    public String getRequestURI() {
        return this.requestURI;
    }

    /**
     * Setter method for the instance variable requestURI
     * 
     * @param requestURI the value to assign to requestURI
     */
    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    /**
     * Getter method for the instance variable requestURL
     * 
     * @return requestURL instance variable
     */
    public String getRequestURL() {
        return this.requestURL;
    }

    /**
     * Setter method for the instance variable requestURL
     * 
     * @param requestURL the value to assign to requestURL
     */
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    /**
     * Getter method for the instance variable requestProtocol
     * 
     * @return requestProtocol instance variable
     */
    public String getRequestProtocol() {
        return this.requestProtocol;
    }

    /**
     * Setter method for the instance variable requestProtocol
     * 
     * @param requestProtocol the value to assign to requestProtocol
     */
    public void setRequestProtocol(String requestProtocol) {
        this.requestProtocol = requestProtocol;
    }

    /**
     * Getter method for the instance variable serverName
     * 
     * @return serverName instance variable
     */
    public String getServerName() {
        return this.serverName;
    }

    /**
     * Setter method for the instance variable serverName
     * 
     * @param serverName the value to assign to serverName
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * Getter method for the instance variable serverPortNumber
     * 
     * @return serverPortNumber instance variable
     */
    public String getServerPortNumber() {
        return this.serverPortNumber;
    }

    /**
     * Setter method for the instance variable serverPortNumber
     * 
     * @param serverPortNumber the value to assign to serverPortNumber
     */
    public void setServerPortNumber(String serverPortNumber) {
        this.serverPortNumber = serverPortNumber;
    }

    /**
     * Getter method for the instance variable serverLocale
     * 
     * @return serverLocale instance variable
     */
    public Locale getServerLocale() {
        return this.serverLocale;
    }

    /**
     * Setter method for the instance variable serverLocale
     * 
     * @param serverLocale the value to assign to serverLocale
     */
    public void setServerLocale(Locale serverLocale) {
        this.serverLocale = serverLocale;
    }

    /**
     * Getter method for the instance variable  queryString
     * 
     * @return queryString instance variable
     */
    public String getQueryString() {
        return this.queryString;
    }

    /**
     * Setter method for the queryString instance variable.
     * 
     * @param queryString the value to be assigned to queryString
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    /**
     * Getter method for the queryString instance variable.
     * 
     * @return queryParameterValue the instance variable
     */
    public String getQueryParameterValue() {
        return this.queryParameterValue;
    }

    /**
     * Setter method for the queryParameterValue instance variable.
     * 
     * @param queryParameterValue the value to be assigned to queryParameterValue
     */
    public void setQueryParameterValue(String queryParameterValue) {
        this.queryParameterValue = queryParameterValue;
    }

    /**
     * Getter method for the userAgent instance variable.
     * 
     * @return userAgent instance variable
     */
    public String getUserAgent() {
        return this.userAgent;
    }

    /**
     * Setter method for the userAgent instance variable.
     * 
     * @param userAgent the value to be assigned to userAgent
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    
}
package com.pettermahlen.liten;

import com.sun.net.httpserver.HttpServer;

/**
 * Created by IntelliJ IDEA.
 * User: Petter
 * Date: 2011-12-18
 * Time: 13:15
 * To change this template use File | Settings | File Templates.
 */
public class Response {
    private final int responseStatusCode;
    private final String responseBody;


    public Response(String responseBody, int responseStatusCode) {
        this.responseBody = responseBody;
        this.responseStatusCode = responseStatusCode;
    }
}

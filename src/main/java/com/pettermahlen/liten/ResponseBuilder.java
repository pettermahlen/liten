package com.pettermahlen.liten;

import com.google.common.base.Predicate;
import com.sun.net.httpserver.HttpExchange;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Petter
 * Date: 2011-12-18
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
public class ResponseBuilder {
    private final Response response;
    private Predicate<HttpExchange> predicate;

    public ResponseBuilder(Response response) {
        this.response = response;
    }

    public static ResponseBuilder ok(String responseBody) {
        return new ResponseBuilder(new Response(responseBody, 200));
    }

    public static ResponseBuilder notFound() {
        return new ResponseBuilder(new Response("", 404));
    }

    public ResponseBuilder to(Predicate<HttpExchange> predicate) {
        this.predicate = predicate;
        return this;
    }
}

package com.pettermahlen.liten;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Petter
 * Date: 2011-12-18
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
public class ContextBuilder {
    private final LitenServer.Builder builder;
    private final String contextPath;

    private boolean trackingRequests = false;
    private Collection<ResponseBuilder> responseBuilders;
    
    public ContextBuilder(LitenServer.Builder builder, String contextPath) {
        this.builder = builder;
        this.contextPath = contextPath;
    }

    public ContextBuilder trackingRequests() {
        trackingRequests = true;
        return this;
    }

    public ContextBuilder responding(ResponseBuilder... responseBuilders) {
        for (ResponseBuilder responseBuilder : responseBuilders) {
            this.responseBuilders.add(responseBuilder);
        }
        return this;
    }

    public LitenServer build() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}

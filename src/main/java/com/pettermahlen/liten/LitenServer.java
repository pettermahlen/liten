package com.pettermahlen.liten;

/**
 * Created by IntelliJ IDEA.
 * User: Petter
 * Date: 2011-12-18
 * Time: 12:52
 * To change this template use File | Settings | File Templates.
 */
public class LitenServer {


    public static Builder listeningOn(int port) {
        return new Builder(port);
    }


    public static class Builder {
        private final int port;
        private String contextPath;

        public Builder(int port) {
            this.port = port;
        }

        public ContextBuilder withContext(String contextPath) {
            return new ContextBuilder(this, contextPath);
        }
    }
}

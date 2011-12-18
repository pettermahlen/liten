package com.pettermahlen.liten;

import com.google.common.base.Predicate;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import com.sun.net.httpserver.HttpExchange;

import javax.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: Petter
 * Date: 2011-12-18
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
public class RequestPredicates {
    // TODO: shouldn't be plain HttpExchange, needs something that can guarantee that the request body can be read multiple times
    public static Predicate<HttpExchange> method(final String methodName) {
        return new Predicate<HttpExchange>() {
            public boolean apply(@Nullable HttpExchange input) {
                return input != null && input.getRequestMethod().equals(methodName);
            }
        };
    }
    
    public static Predicate<HttpExchange> body(final String regularExpression) {
        return new Predicate<HttpExchange>() {
            public boolean apply(@Nullable HttpExchange input) {
                if (input == null) {
                    return false;
                }

                try {
                    byte[] bodyBytes = ByteStreams.toByteArray(input.getRequestBody());

                    return  Pattern.matches(regularExpression, new String(bodyBytes));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        };
    }
}

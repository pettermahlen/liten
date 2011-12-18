package com.pettermahlen.liten;

import org.junit.Test;

import static com.google.common.base.Predicates.and;
import static com.pettermahlen.liten.RequestPredicates.body;
import static com.pettermahlen.liten.RequestPredicates.method;
import static com.pettermahlen.liten.ResponseBuilder.notFound;
import static com.pettermahlen.liten.ResponseBuilder.ok;

/**
 * Created by IntelliJ IDEA.
 * User: Petter
 * Date: 2011-12-18
 * Time: 12:52
 * To change this template use File | Settings | File Templates.
 */
public class LitenServerTest {

    @Test
    public void shouldBeConfigurableViaFluidAPI() throws Exception {
        
        LitenServer litenServer = LitenServer.listeningOn(8080)
                .withContext("oidLookup") // TODO should return something else?
                .trackingRequests()
                .responding(
                        ok("OK").to(and(method("GET"), body("some reg ex"))),
                        ok("Added").to(method("POST")),
                        notFound().to(method("GET"))
                ).build();
    }
}

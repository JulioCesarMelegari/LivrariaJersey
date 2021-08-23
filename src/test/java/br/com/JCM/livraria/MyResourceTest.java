package br.com.JCM.livraria;


import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest extends JerseyTest {



    @Test
    public void testGetIt() {
        final String responseMsg = target().path("myresource").request().get(String.class);

        assertEquals("Hello, Heroku!", responseMsg);
    }
}

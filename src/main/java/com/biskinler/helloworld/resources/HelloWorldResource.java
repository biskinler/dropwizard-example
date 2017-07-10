package com.biskinler.helloworld.resources;

import com.biskinler.helloworld.models.Hello;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Hello sayHello(@QueryParam("name") Optional<String> name) {
        return new Hello(counter.incrementAndGet(),
                String.format(template, name.or(defaultName)));
    }

    @GET
    @Timed
    @Path("/10times")
    public List sayHello10Time(@QueryParam("name") Optional<String> name) {
        Hello hello = new Hello(counter.incrementAndGet(), String.format(template, name.or(defaultName)));
        List li = new ArrayList<Hello>();
        for (int i = 0; i < 10; i++) {
            li.add(hello);
        }
        return li;
    }
}

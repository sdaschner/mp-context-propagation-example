package com.sebastian_daschner.mp_context_propagation_example;

import org.eclipse.microprofile.context.ThreadContext;

import javax.enterprise.inject.Produces;

public class ThreadContextProducer {

    @Produces
    ThreadContext threadContext() {

        System.out.println("creating thread context");

        return ThreadContext.builder()
                .propagated(ThreadContext.ALL_REMAINING)
                .build();
    }

}

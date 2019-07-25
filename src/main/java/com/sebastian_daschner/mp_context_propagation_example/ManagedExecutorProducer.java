package com.sebastian_daschner.mp_context_propagation_example;

import org.eclipse.microprofile.context.ManagedExecutor;
import org.eclipse.microprofile.context.ThreadContext;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

public class ManagedExecutorProducer {

    @Produces
    ManagedExecutor managedExecutor() {
        System.out.println("creating managed executor");

        return ManagedExecutor.builder()
                .propagated(ThreadContext.CDI, ThreadContext.APPLICATION)
                .maxAsync(4)
                .maxQueued(4)
                .build();
    }

    public void disposeManagedExecutor(@Disposes ManagedExecutor managedExecutor) {
        System.out.println("disposing managed executor");
        managedExecutor.shutdownNow();
    }

}

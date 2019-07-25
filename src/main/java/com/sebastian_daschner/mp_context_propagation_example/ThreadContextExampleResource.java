package com.sebastian_daschner.mp_context_propagation_example;

import org.eclipse.microprofile.context.ThreadContext;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("contexts")
public class ThreadContextExampleResource {

    @Inject
    ExampleStore exampleStore;

    @Inject
    ThreadContext threadContext;

    @Resource
    ManagedExecutorService mes;

    @Inject
    Notifier notifier;

    @PUT
    public void setExample(String example) {
        exampleStore.setExample(example);
        mes.execute(threadContext.contextualRunnable(notifier::notifyAbout));
    }

}

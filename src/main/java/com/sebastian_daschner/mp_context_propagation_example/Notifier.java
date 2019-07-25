package com.sebastian_daschner.mp_context_propagation_example;

import javax.inject.Inject;

public class Notifier {

    @Inject
    ExampleStore exampleStore;

    public void notifyAbout() {
        System.out.println("trying to notify...");
        try {
            System.out.println("notified about new: " + exampleStore.getExample());
        } catch (Exception e) {
            System.err.println("got an error");
            e.printStackTrace();
        }
    }

}

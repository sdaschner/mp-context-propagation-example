package com.sebastian_daschner.mp_context_propagation_example;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ExampleStore {

    private String example;

    public String getExample() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return example;
    }

    public void setExample(String example) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.example = example;
    }

}

package com.unidev.template.ui.view;

import com.unidev.platform.utils.RandomUtils;
import com.unidev.template.TestService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Form extends VerticalLayout implements View {

    @Autowired
    private RandomUtils randomUtils;

    @Autowired
    private TestService testService;


    public Form() {
    }

    @PostConstruct
    public void init() {
        Button button = new Button("Test button " + testService.method());
        Label label = new Label("Hello! I'm the root UI! " + randomUtils.randomValue("A", "B", "C"));

        addComponent(button);
        addComponent(label);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}

package com.unidev.app.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.stereotype.Component;

/**
 * AboutView application view
 */
@Component
public class AboutView extends VerticalLayout implements View {

    public AboutView() {
        Label label = new Label("Application developed by UniversalDevelopment");
        addComponent(label);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}

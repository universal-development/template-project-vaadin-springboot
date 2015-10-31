package com.unidev.template.ui;


import com.unidev.app.view.AboutView;
import com.unidev.template.ui.view.FormView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme(Reindeer.THEME_NAME)
public class ApplicationUI extends UI {

    @Autowired
    private AboutView aboutView;

    @Autowired
    private FormView formView;


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);


        final CssLayout navigationBar = new CssLayout();
        navigationBar.addComponent(createNavigationButton("Main", ""));
        navigationBar.addComponent(createNavigationButton("About", AboutView.VIEW_NAME));
        root.addComponent(navigationBar);

        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", formView);

        navigator.addView(AboutView.VIEW_NAME, aboutView);

    }


    protected Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }
}
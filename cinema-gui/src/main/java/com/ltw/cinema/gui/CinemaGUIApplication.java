package com.ltw.cinema.gui;

import com.ltw.cinema.gui.desktop.gui.MainGUI;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients(basePackages = "com.ltw.cinema.api.feign")
@SpringBootApplication
public class CinemaGUIApplication {
    private static ConfigurableApplicationContext context;
    private static MainGUI mainGUI;

    public static void main(String[] args) {
        context = new SpringApplicationBuilder(CinemaGUIApplication.class)
                .headless(false).run(args);
        mainGUI = new MainGUI();
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

    public static MainGUI getMainGUI() {
        return mainGUI;
    }
}

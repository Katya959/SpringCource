package ru.safutina.springcourse.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

// Вместо web.xml файла
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // Добавляем фильтр для PATCH и DELETE запросов

    // Этот метод запускается при старте Spring приложения
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        // Здесь выполняем приватный метод
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        /* Мы добавляем к нашему приложению один фильтр. Сами его не реализуем, он уже есть в Spring, просто его добавляем.
        Фильтр смотрит на значение скрытого поля _method, смотрит, какой там HTTP-метод находится.
        PATCH и DELETE запросы будут идти как POST запросы, он будет перенаправлять входящие HTTP запросы на нужные методы контроллера.
        "/*" - фильтр будет работать для всех адресов в нашем приложении. Фильтр срабатывает при любом запросе.
         */
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }
}

package ru.safutina.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Исполняет роль web.xml (полностью ему эквивалентна). Конфигурационный Java файл.
public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    // Пока не используем
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Таккже как и в web.xml файле подставляли путь до applicationContextMVC.xml
    // Теперь этот класс знает, где находится Spring конфигурация (находится в Java классе SpringConfig)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /*
    Эквивалентно:
    <servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
    </servlet-mapping>
    Эквивалентно этому. Все http-запросы от пользователя посылаем на DispatcherServlet.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

package mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppIn extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс конфигурации
    //этот метод должен содержать конфигурации которые инициализируют Beans
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{HibernateConfig.class};
    }

    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    //Данный метод указывает url, на котором будет базироваться приложение
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

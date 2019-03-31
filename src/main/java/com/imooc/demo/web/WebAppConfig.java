package com.imooc.demo.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
//        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**").excludePathPatterns("index");

        //就是这个
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**").excludePathPatterns("/index","/login");
    }

    private class InterceptorConfig implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            String url = httpServletRequest.getRequestURI();
            //拦截！判断是否是LOGIN 其他的登录后才能访问
            if (url.toLowerCase().indexOf("login") >= 0) {
                return true;
            }
             //通过seesion来判断你是否登陆成功
            HttpSession session = httpServletRequest.getSession();
            if (session.getAttribute("user") != null) {
                return true;
            }
            httpServletResponse.sendRedirect("/login");
            return false;
        }

        @Override
        public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        }
    }
}

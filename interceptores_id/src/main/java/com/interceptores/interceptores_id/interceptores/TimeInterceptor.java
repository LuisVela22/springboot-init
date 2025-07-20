package com.interceptores.interceptores_id.interceptores;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeInterceptor implements HandlerInterceptor {

    private static final String START_TIME = "inicio";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long TiempoInicio = System.currentTimeMillis();
        request.setAttribute(START_TIME, TiempoInicio);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //calcula el tiempo transcurrido
        long TiempoInicio = (long) request.getAttribute(START_TIME);
        long TiempoFin = System.currentTimeMillis() - TiempoInicio;
        System.out.println("Tiempo de ejecucion: "+ TiempoFin + "milisegundos para URL" + request.getRequestURI());

    }

}

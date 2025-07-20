package com.springapp.conotrlhorario.interceptor.control_horario.interceptores;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Calendario_Interceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private int open;

    @Value("${config.calendar.close}")
    private int close;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        
        if(hora >= open && hora< close) {
            StringBuilder mensaje = new StringBuilder("Binevenido");
            mensaje.append("Atendemos desde las: ");
            mensaje.append(open);
            mensaje.append("AM");
            mensaje.append("hasta las: ");
            mensaje.append(close);
            mensaje.append("PM");
            mensaje.append("Gracias por su visita");
            request.setAttribute("Mensaje", mensaje.toString());

            return true;
        }
        return false;

    }

    

}

package com.qiuxj.springcloud.config;

import com.qiuxj.springcloud.Boss701DTO;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_qiuxj",r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }

    public static void main(String[] args) {
        Boss701DTO boss701DTO = new Boss701DTO();
        String classname = boss701DTO.getClass().getSimpleName();
        System.out.println(classname.substring(0,1).toLowerCase()+classname.substring(1).replaceAll("DTO",""));
    }

}

package com.loki.rfidtrack.apitrack.common.interceptor;


import com.loki.rfidtrack.apitrack.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Loki.C
 * @Date: 2019/2/27
 * @description: Jwt拦截器配置
 * @modified by:
 * @version: Component 加入到容器中
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过拦截路径，确定是否需要认证");

        //无论如何都放行，具体能不能操作还是在具体的操作中去判断
        //拦截器只负责把请求头中包含token的令牌进行一个解析验证
        try {
            // 如果不是映射到方法直接通过
            if (!(handler instanceof HandlerMethod)) {
                return true;
            }
            String uri = request.getRequestURI();
            System.out.println("filter url:" + uri);
            String authorization = request.getHeader("Authorization");
            if (StringUtils.isNotBlank(authorization)&&authorization.contains("Beaere ")) {
                String[] param = authorization.split(" ");
                if ("Beaere".equals(param[0])) {
                    String token = param[1];
                    //解析token
                    Claims claims = jwtUtil.parseJWT(token);
                    String userName = (String) claims.getId();
                    String password = (String) claims.getSubject();
                    //管理员
                    return (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password) && "APIUSER".equals(userName) && "APIPASSWORD".equals(password));
                }
            } else{
                throw new RuntimeException("权限不足");
            }
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("令牌不正确");
        }
        return true;
    }
}

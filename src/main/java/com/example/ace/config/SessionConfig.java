package com.example.ace.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * <p>Title:SessionConfig.java</p >
 * <p>Description:session</p >
 *
 * @author Sephinor
 * @version 1.0
 * @time 2019/11/25 20:20
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*60*24*7)
public class SessionConfig {
}

package gcruz.photocollection.mspcuser.config;

import gcruz.photocollection.mspcuser.utils.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtBeansConfig {
    @Bean
    public JwtTokenUtil jwtTokenUtilInstance(){
        return new JwtTokenUtil();
    }
}

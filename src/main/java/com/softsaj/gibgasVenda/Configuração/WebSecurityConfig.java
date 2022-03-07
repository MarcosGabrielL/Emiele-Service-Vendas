/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.gibgasVenda.Configuração;

/**
 *
 * @author Marcos
 */
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.util.DefaultUriBuilderFactory;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private String apiHost = "https://emiele-service-security.herokuapp.com/islogged";
   

   
    
@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}

@Bean
public CloseableHttpClient httpClient() {
    HttpClientBuilder builder = HttpClientBuilder.create();
    //builder.setEverything(everything); // configure it
    CloseableHttpClient httpClient = builder.build();
    return httpClient;
}

  /*
    

   
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.authenticationProvider(new MyCustomAuthProvider());
}
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {

         http.cors();


        http
            .csrf().disable()
                .authorizeRequests()
                .antMatchers("/comentarios/**", "/register", "/*", "/user/**", "/cinefilos/**", "/textoes/**", "/uploadFile/**", "/file/**").permitAll()
                .and().exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
    }
     
}
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
 
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig{
    
    
  /*
    

   
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.authenticationProvider(new MyCustomAuthProvider());
}
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {

         http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());


        http
            .csrf().disable()
                .authorizeRequests()
                .antMatchers("/comentarios/**", "/register", "/*", "/user/**", "/cinefilos/**", "/textoes/**", "/files/**", "/file/**").permitAll()
                .and().exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
    }
     */
}
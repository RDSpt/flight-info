package com.challenge.flightinfo.config;

//@EnableWebSecurity
//@Configuration
public class SecurityConfig {
//  extends
//} WebSecurityConfigurerAdapter {
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.requiresChannel().requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null).requiresSecure();
//  }

  //  @Bean
  //  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  //    http.requiresChannel().requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null).requiresSecure();
  //    http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated()).httpBasic(withDefaults());
  //    return http.build();
  //  }
  //
  //  @Bean
  //  CorsConfigurationSource corsConfigurationSource() {
  //    CorsConfiguration configuration = new CorsConfiguration();
  //    configuration.setAllowedOrigins(Arrays.asList("*","https://flight-info-web.herokuapp.com/", "https://flight-info-api.herokuapp
  //    .com/"));
  //    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
  //    configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
  //      "Access-Control-Request-Method", "Access-Control-Request-Headers", "Origin",
  //      "Cache-Control", "Content-Type"));
  //    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
  //    source.registerCorsConfiguration("/**", configuration);
  //    return source;
  //  }

}

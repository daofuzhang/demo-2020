package com.zdf.demo.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	
	  @Autowired 
	  private SsoUserDetailsService userDetailsService;
	  
	  @Autowired 
	  private AuthenticationManager authenticationManager;
	  
	  //@Autowired private DataSource dataSource;
	 
    
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// 定义了两个客户端应用的通行证
        clients.inMemory()// 使用in-memory存储
                .withClient("client_1")// client_id
                .secret(new BCryptPasswordEncoder().encode("123456"))// client_secret
                .authorizedGrantTypes("refresh_token", "authorization_code", "password")// 该client允许的授权类型 可选值包括authorization_code,password,refresh_token,implicit,client_credentials
                .scopes("all")// 允许的授权范围
                .autoApprove(true) //autoApproveScopes：设置用户是否自动Approval操作, 默认值为 false 该字段只适用于grant_type="authorization_code的情况,当用户登录成功后
                .redirectUris("http://localhost:9001/login")//加上验证回调地址 必须设置回调地址redirectUris,并且格式是http://客户端IP:端口/login的格式
                
                .and()
                .withClient("client_2")
                .secret(new BCryptPasswordEncoder().encode("123456"))
                .authorizedGrantTypes("authorization_code", "refresh_token")//最常用的grant_type组合有: "authorization_code,refresh_token"(针对通过浏览器访问的客户端); "password,refresh_token"(针对移动设备的客户端)
                .scopes("all")
                .autoApprove(true)
                .redirectUris("http://localhost:9002/login");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.authenticationManager(authenticationManager);
			endpoints.userDetailsService(userDetailsService);//若无，refresh_token会有UserDetailsService is required错误
			endpoints.accessTokenConverter(jwtAccessTokenConverter());
			endpoints.tokenStore(jwtTokenStore());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()")
		           .checkTokenAccess("isAuthenticated()")
		           .allowFormAuthenticationForClients();
	}
	
	@Bean
	public JwtTokenStore jwtTokenStore() {
	   return new JwtTokenStore(jwtAccessTokenConverter());
	}
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
	 JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
	 jwtAccessTokenConverter.setSigningKey("cjs");
	 return jwtAccessTokenConverter;
	}
    /*
	@Bean
	TokenStore tokenStore() {
	  return null;
	}
	*/

}

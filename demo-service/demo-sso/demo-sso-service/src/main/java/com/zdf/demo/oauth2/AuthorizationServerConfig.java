package com.zdf.demo.oauth2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private SsoUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DataSource dataSource;
    
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		/*
		 * clients.inMemory().withClient("client_1")
		 * .secret(passwordEncoder().encode("123456"))
		 * .authorizedGrantTypes("authorization_code", "refresh_token")
		 * .redirectUris("http://baidu.com") .scopes("all")
		 * .accessTokenValiditySeconds(7200) .refreshTokenValiditySeconds(7200) .and()
		 * .withClient("client_2") .secret(passwordEncoder().encode("123456"))
		 * .authorizedGrantTypes("password", "refresh_token")
		 * .redirectUris("http://baidu.com").scopes("all")
		 * .accessTokenValiditySeconds(7200) .refreshTokenValiditySeconds(7200);
		 */
		// 鎺堟潈鐮佹ā寮�
		// http://localhost:9901/oauth/authorize?response_type=code&client_id=client_1&redirect_uri=http://baidu.com&scope=all
		// 瀵嗙爜妯″紡锛歨ttp://localhost:9901/oauth/token
		 clients.withClientDetails(clientDetailsService() );

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		        .authenticationManager(authenticationManager)
		        .userDetailsService(userDetailsService)
		        .tokenStore(tokenStore());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()")
		           .checkTokenAccess("isAuthenticated()")
		           .allowFormAuthenticationForClients();
	}
	
	
	ClientDetailsService  clientDetailsService() {
		return new JdbcClientDetailsService(dataSource);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
	@Bean
	TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

}

package com.cy.pj.common.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import java.util.LinkedHashMap;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @Configuration 注解描述的类为一个配置对象
 * 此对象也会将交给spring容器管理
 * @author hasee
 */
@Configuration
public class SpringShiroConfig {
	/**
	 * @Bean 描述的方法其返回值会交给spring容器管理
	 * @Bean 一般应用于整合第三bean资源时
	 */
	@Bean("securityManager")
	public SecurityManager newSecurityManager(@Autowired Realm realm) {
		DefaultWebSecurityManager sManager = 
		new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		sManager.setCacheManager(newMemoryConstrainedCacheManager());
		return sManager;
	}
	
	@Bean("ShiroFilterFactory")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(
			@Autowired SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		//假如没有认证需要先访问此url
		sfBean.setLoginUrl("/doLoginUI");
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		//静态资源允许匿名访问"anon"
		map.put("/bower_components/**", "anon");
		map.put("/build/**", "anon");
		map.put("/dist/**", "anon");
		map.put("/plugins/**", "anon");
		map.put("/user/doLogin", "anon");
		map.put("/doLogout", "logout");
		//除了匿名访问的资源,其他都要认证()
		map.put("/**", "authc");
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}
	
	//授权配置
	//配置shiro 中bean对象的生命周期
	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor newLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	//2.负责为所有advisor类型的对象创建代理对象,底层aop
	@DependsOn("lifecycleBeanPostProcessor")
	@Bean
	public DefaultAdvisorAutoProxyCreator newDefaultAdvisorAutoProxyCreator(
			@Autowired SecurityManager securityManager) {
		 DefaultAdvisorAutoProxyCreator advisor = new DefaultAdvisorAutoProxyCreator();
		 return advisor;
	}
	/**
	 * 配置advisor对象
	 * */
	@Bean
	public AuthorizationAttributeSourceAdvisor newAuthorizationAttributeSourceAdvisor() {
		return new AuthorizationAttributeSourceAdvisor();
	}
	@Bean
	public MemoryConstrainedCacheManager newMemoryConstrainedCacheManager() {
		return new MemoryConstrainedCacheManager();
	}
}

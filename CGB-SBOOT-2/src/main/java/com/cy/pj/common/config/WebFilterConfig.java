package com.cy.pj.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class WebFilterConfig {//取代web.xml中filter的配置
	//注册filter对象
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean newFilterRegistrationBean() {
		
		//1.构建过滤器注册器对象
		FilterRegistrationBean fBean =
				new FilterRegistrationBean();
		//2.注册过滤器对象
		DelegatingFilterProxy filter=
				new DelegatingFilterProxy("ShiroFilterFactory");
		fBean.setFilter(filter);
		//3.进行过滤器配置
		//配置过滤器的声明周期管理(可选)由ServletContext对象负责
		fBean.setEnabled(true);//默认值就是true
		fBean.setOrder(Integer.MAX_VALUE+1);
		fBean.addUrlPatterns("/*");
		
		return fBean;
	}
}

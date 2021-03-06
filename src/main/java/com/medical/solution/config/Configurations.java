package com.medical.solution.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class Configurations {

	private String username = "root";
	private String password = "root";
	private String connectionUrl = "jdbc:mysql://localhost:3306/medical";
	private String driverName = "com.mysql.jdbc.Driver";

	@Bean
	@Qualifier("dataSource")
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(connectionUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public ExecutorService executorService(){
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10));
		threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return threadPoolExecutor;
	}
}

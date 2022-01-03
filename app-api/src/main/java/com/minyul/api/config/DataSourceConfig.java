//package com.minyul.api.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.sql.DataSource;

/**
 *  Todo : 결론적으로 DataSourceConfig가 필요가 없음. Springboot에서 자동으로 해줌 HikariCP,EntityManager 또한 Default
 *  @link : https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa
 */
//@EnableJpaRepositories(basePackages = {"com.minyul.rds"})
//@Configuration
//public class DataSourceConfig {
//
//	@Bean
//	@ConfigurationProperties("spring.datasource")
//	public DataSource buildDataSource() {
//
//		return DataSourceBuilder.create()
//						.type(HikariDataSource.class)
//						.build();
//	}
//
//	/**
//	 * 트랜잭션에 진입하는 순간 설정된 Datasource의 커넥션을 가져옴.
//	 *
//	 * 1. Ehcache같은 Cache를 사용하는 경우 실제 Database에 접근하지 않지만 불필요한 커넥션을 점유
//	 * 2. Hibernate의 영속성 컨텍스트 1차캐시(실제 Database에 접근하지 않음) 에도 불필요한 커넥션을 점유
//	 * 3. 외부 서비스(http, etc …)에 접근해서 작업을 수행한 이후에 그 결과값을 Database에 Read/Write하는
//	 * 		경우 외부 서비스에 의존하는 시간만큼 불필요한 커넥션 점유
//	 * 3 .Multi Datasource 환경에서 트랜잭션에 진입한 이후,이미 트랜잭션 진입시점에 Datasource가 결정되므로 분기가 불가능
//	 * 해결 방법 : LazyConnectionDataSourceProxy - 실제로 필요한 경우에만 커넥션 점유
//	 */
//	@Bean
//	public DataSource newsDatasource() {
//
//		return new LazyConnectionDataSourceProxy(buildDataSource());
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource newsDatasource) {
//		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//		factoryBean.setDataSource(newsDatasource);
//		factoryBean.setPackagesToScan("com.minyul.rds");
//		factoryBean.setJpaVendorAdapter(jpaVendorAdapters());
//		return factoryBean;
//	}
//
//	/**
//	 * PlatformTransactionManager 인터페이스를 구현한 트랜잭션 매니저를 통해 구체적인 트랜잭션 기술의 종류에 상관
//	 * 없이 일관된 트랜잭션 제어가 가능.
//	 *
//	 * 할 필요없음. 이유 :
//	 * Spring Boot configures Hibernate as the default JPA provider,
//	 * so it's no longer necessary to define the entityManagerFactory bean unless we want to customize it.
//	 */
////	@Bean
////	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
////		JpaTransactionManager transactionManager = new JpaTransactionManager();
////		transactionManager.setEntityManagerFactory(entityManagerFactory);
////
////		return transactionManager;
////	}
//
//	private JpaVendorAdapter jpaVendorAdapters() {
//		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
//
//		return hibernateJpaVendorAdapter;
//	}
//}

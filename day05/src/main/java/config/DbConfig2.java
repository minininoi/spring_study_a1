package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

//환경변수에 따라서 관리자와 사용자 따로 프로필 관리
@Configuration
public class DbConfig2 {
    @Configuration
    @Profile("dev") //환경변수에 따라서 빈 선택
    static class DbDevConfig{
        @Bean(destroyMethod = "close")
        public DataSource dataSource(){
            DataSource ds = new DataSource();
            System.out.println("DEV!!");
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("springdb");
            ds.setPassword("aA123456");

            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);
            ds.setTimeBetweenEvictionRunsMillis(3000);
            ds.setMinEvictableIdleTimeMillis(60000);
            return ds;
        }
        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }

        //트랜잭션
        @Bean
        public PlatformTransactionManager transactionManager(){
            DataSourceTransactionManager tm = new DataSourceTransactionManager();
            tm.setDataSource(dataSource());
            return tm;
        }

    }
    @Configuration
    @Profile("real")
    static class DbRealConfig{
        @Value("${db.username}")
        private  String username;
        @Value("${db.password}")
        private  String password;
        @Bean(destroyMethod = "close")
        public DataSource dataSource(){
            DataSource ds = new DataSource();
            System.out.println("REAL!!");
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("username");
            ds.setPassword("password");

            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);
            ds.setTimeBetweenEvictionRunsMillis(3000);
            ds.setMinEvictableIdleTimeMillis(60000);
            return ds;
        }
        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }

        //트랜잭션
        @Bean
        public PlatformTransactionManager transactionManager(){
            DataSourceTransactionManager tm = new DataSourceTransactionManager();
            tm.setDataSource(dataSource());
            return tm;
        }

    }

}

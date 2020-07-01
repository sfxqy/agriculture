package com.wisdom.agriculture;



import com.wisdom.agriculture.deviceConn.temprature.temprature;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.wisdom.agriculture.dao")
public class AgricultureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgricultureApplication.class, args);
    }


    /**
     * 启动设备
     * @return
     */
    @Bean
    public ServletRegistrationBean MyServlet1(){
        return new ServletRegistrationBean(new temprature(),"/temprature");
    }

}

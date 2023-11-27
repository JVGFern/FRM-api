package  com.frmapi.frmapiv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableFeignClients
@EnableWebMvc
public class FrmApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrmApiApplication.class, args);
    }
}

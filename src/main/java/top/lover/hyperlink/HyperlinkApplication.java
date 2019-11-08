package top.lover.hyperlink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"top.lover.hyperlink.dao","top.lover.hyperlink.controller","top.lover.hyperlink.service"})
public class HyperlinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyperlinkApplication.class, args);
    }

}

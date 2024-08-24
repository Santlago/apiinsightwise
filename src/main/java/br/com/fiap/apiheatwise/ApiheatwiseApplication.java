package br.com.fiap.apiheatwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class ApiheatwiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiheatwiseApplication.class, args);
    }

    @RequestMapping
    @ResponseBody
    public String home(){
        return "HeatWise";
    }

}

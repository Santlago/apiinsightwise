package br.com.fiap.apiinsightwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class ApiinsightwiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiinsightwiseApplication.class, args);
    }

    @RequestMapping
    @ResponseBody
    public String home(){
        return "HeatWise";
    }

}

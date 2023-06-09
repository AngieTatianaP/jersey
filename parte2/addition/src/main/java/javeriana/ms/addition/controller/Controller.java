package javeriana.ms.addition.controller;

import javeriana.ms.addition.bd.MongoDB;
import javeriana.ms.addition.logs.ResponseLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Environment environment;

    @Autowired
    MongoDB mongoDB;

    @GetMapping("/suma")
    public String add( @RequestParam int a ,  @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        mongoDB.save(user, "sum");
        String response = "Resultado:" + String.valueOf(a + b) + " Respuesta originada desde: " + port;
        return response;
    }
    
    @GetMapping("/logs")
    public ResponseLog logs(){
        String port = environment.getProperty("local.server.port");
        return mongoDB.getDocuments("sum");
    }
    
}

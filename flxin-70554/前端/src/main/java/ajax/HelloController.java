package ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    @RequestMapping("owl.do")
    public String methodOwl() {
        Owl owl = new Owl();
        return "owl";
    }

}

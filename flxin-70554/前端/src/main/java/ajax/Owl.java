package ajax;

import org.springframework.stereotype.Controller;

@Controller
public class Owl {

    String username = "猫头鹰";
    int age = 2;

    @Override
    public String toString() {
        return "Owl{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}

package ajax.z.example;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 账号注册冲突时右侧红色字体提示。
 * 假设账号：root，密码：1234。
 */

@Controller
@RequestMapping("/user")
public class SimpleWebPageController {

    @PostMapping("/login.do")
    @ResponseBody
    public ResponseResult login(String username,String password) {
        System.out.println("2222222222222");
        ResponseResult rr = new ResponseResult();
        if ("root".equals(username)) {
            if ("1234".equals(password)) {
                // 登录成功。
                rr.setState(1);
            } else {
                // 密码错误。
                rr.setState(2);
                rr.setMessage("密码错误");
            }
        } else {
            // 账号错误。
            rr.setState(3);
            rr.setMessage("账号错误");
        }
        return rr;
    }

}

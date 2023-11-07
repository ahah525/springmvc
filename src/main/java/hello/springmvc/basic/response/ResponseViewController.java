package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 1. String을 반환하는 경우 - View or HTTP 메시지
 * @ResponseBody가 없으면, View 조회 후 렌더링
 * @ResponseBody가 있으면, HTTP 메시지 바디에 입력
 * 2. void를 반환하는 경우 -> 권장X
 * URL을 논리 뷰 이름으로 사용하고 View 조회
 */
@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }
}
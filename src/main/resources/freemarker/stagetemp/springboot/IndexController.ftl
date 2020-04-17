package ${packgeName}.${beanpackge};

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	/**
	 * @Title: index
	 * @Description: 主页入口
	 * @author: generation
	 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
	 * @param 主页入口
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}

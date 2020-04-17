package ${packgeName}.framework.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**   
 * @formatClassName:  SpringContextHolder
 * @Description:TODO spring容器工具类
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		Map<String, T> beanMap = applicationContext.getBeansOfType(clazz);
		Collection<T> valueSet = beanMap.values();
		List<T> valueList = new ArrayList<T>(valueSet);
		return valueList.get(0);
	}

	public static void cleanApplicationContext() {
		applicationContext = null;
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder或者ComponentScan中能扫描到");
		}
	}

}

package com.sxt.common;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.sxt.Bean.WebBean;


/***
 * 全局拦截器-进行登录拦截
 * @author 石啸天
 *
 */
public class WebInterceptor implements Interceptor{

	WebBean wb = new WebBean();
	/**
	 * 拦截权限
	 */
	public void intercept(ActionInvocation ai) {

		//初始化公共数据
		initPublicData(ai);

		//继续执行
		ai.invoke();

	}

	/**
	 * 初始化公共数据
	 *
	 */
	private void initPublicData(ActionInvocation ai) {

		//绑定根路径
		if(wb.isEmpty()) {

			wb.setRoot(ai.getController().getRequest().getContextPath());
			//todo String
			wb.setName("我的服务网站");

		}

		//插入公用数据
		ai.getController().setAttr("web", wb);
	}

}

package com.sxt.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * 临时验证码生成工具
 *
 */
public class ValidatorFactory extends Model<ValidatorFactory> {
	public static final ValidatorFactory dao = new ValidatorFactory();
	
	/**
	 * 所有 sql 写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
	 */
	public Page<ValidatorFactory> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from blog order by id asc");
	}
}

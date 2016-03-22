package com.sxt.fileupanddown;

import com.jfinal.core.Controller;

/**
 * CommonController
 */
public class FileUpLoadController extends Controller {
	
	public void index() {
		render("/FileUpAndDownLoad/file_upload.html");
	}
}

package com.sxt.fileupanddown;

import com.jfinal.core.Controller;

/**
 * CommonController
 */
public class FileDownLoadController extends Controller {
	
	public void index() {
		render("/FileUpAndDownLoad/file_download.html");
	}
}

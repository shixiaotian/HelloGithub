package com.sxt.Bean;

/**
 * 网站数据集合
 *
 * Created by shixiaotian on 15-10-22.
 */
public class WebBean {

    //网站根
    public String root;

    //网站名称
    public String name;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *  检查是否为空
     *
     * @return Boolean
     */
    public Boolean isEmpty() {
        if(root == null || name == null) {

            return true;

        } else {

            return false;

        }
    }
}

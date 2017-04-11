package com.zero.directive;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class TestDirective implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, Map param, TemplateModel[] model, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		String url = ((SimpleScalar)param.get("url")).toString();
        if("add".equals(url)){
            body.render(env.getOut());
       }else{
           env.getOut().write("<a href='http://www.baidu.com'>没有权限</a>");
       }
	}

}

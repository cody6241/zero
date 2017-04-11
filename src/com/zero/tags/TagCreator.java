package com.zero.tags;

import java.util.List;

import com.common.SpringContextHolder;
import com.utils.StringUtil;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class TagCreator implements TemplateMethodModelEx {

	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List arg0) throws TemplateModelException {
		String beanID = ((SimpleScalar)arg0.get(0)).getAsString();
		if(StringUtil.isEmpty(beanID)){
			throw new TemplateModelException("标签beanid参数不能为空");
		}
		
		return SpringContextHolder.getBean(beanID);
	}

}

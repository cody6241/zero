package com.utils;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

public class FreeMarkerUtil {
	private FreeMarkerUtil() {
	}
	
	
	public static Configuration getFolderCfg(String pageFolder)
			throws IOException {
		Configuration cfg =getCfg();
		cfg.setDirectoryForTemplateLoading(new File(pageFolder));
		
		return cfg;

	}
	
	public static Configuration getCfg(){
		 
		Configuration  cfg = new Configuration();
		cfg.setTemplateUpdateDelay(6000);
		cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));
		
		/**
		 * 添加自定义指令
		 */
//		Map<String,TemplateDirectiveModel> directiveMap = DirectiveFactory.getCommonDirective();
//		Iterator<String> keyIter= directiveMap.keySet().iterator();
//		
//		while(keyIter.hasNext()){
//			String key = keyIter.next();
//			cfg.setSharedVariable(key, directiveMap.get(key));
//		}
		
		
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(java.util.Locale.CHINA);
		cfg.setEncoding(java.util.Locale.CHINA, "UTF-8");
		cfg.setNumberFormat("#.##");
	return cfg;
}

}

package kr.or.ddit.batch.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BasicProcessor implements ItemProcessor<String, String>{

	
	private static final Logger logger = LoggerFactory.getLogger(BasicProcessor.class);

	
	@Override
	public String process(String item) throws Exception {
		logger.debug("============Processor=============");
		logger.debug("processor : {} | {}", item, item+"_modified");
		return item + "_modified";
	}

}

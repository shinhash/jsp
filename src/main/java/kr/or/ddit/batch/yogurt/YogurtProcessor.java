package kr.or.ddit.batch.yogurt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

import kr.or.ddit.batch.yogurt.model.CycleVO;
import kr.or.ddit.batch.yogurt.model.DailyVO;

public class YogurtProcessor implements ItemProcessor<CycleVO, List<DailyVO>>{

	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	// jobLauncher를 실행하면서 두번째 인자로 넣어준 jobParameter값을 SPEL을 통해 주입
	// 단 jobParameters에 접근하기 위해서는 해당 스프링 빈의 scope를 step으로 지정해야 한다.
	@Value("#{jobParameters[ym]}")
	private String ym;
	
	private static final Logger logger = LoggerFactory.getLogger(YogurtProcessor.class);
	
	@Override
	public List<DailyVO> process(CycleVO item) throws Exception {

		// 생성 월이 2020년11월
		// cid=1, pid=100, day=2, cnt=3
		// ==>
		// cid=1, pid=100, dt20201102, cnt=3
		// cid=1, pid=100, dt20201109, cnt=3
		// cid=1, pid=100, dt20201116, cnt=3
		// cid=1, pid=100, dt20201123, cnt=3
		// cid=1, pid=100, dt20201130, cnt=3
		
		
		logger.debug("==========================================");
		logger.debug("ym : {}, item : {}", ym, item);
		logger.debug("==========================================");
		
		List<DailyVO> dailyList = new ArrayList<DailyVO>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(ym.substring(0, 4)));						// 2020
		calendar.set(Calendar.MONTH, Integer.parseInt(ym.substring(4, 6))-1);					// 11
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));	// 30
		
		
		// calendar 2020 11 30
		Date endTime = calendar.getTime();
//		String endTimestr = sdf.format(endTime);
//		int endTimeInt = Integer.parseInt(endTimestr);
		
		// 해당 월의 1일로 설정
		calendar.set(Calendar.DAY_OF_MONTH, 1);		// 2020 11 01
//		Date dt = calendar.getTime();
//		String dtStr = sdf.format(dt);
//		int dtInt = Integer.parseInt(dtStr);
		
		
		while(endTime.compareTo(calendar.getTime()) >= 0) {
			
			// calendar 날짜가 item의 애음요일과 일치할 때만 dailyVO를 생성
			if(item.getDay() == calendar.get(Calendar.DAY_OF_WEEK)) {
				DailyVO dailyVO = new DailyVO();
				
				dailyVO.setCid(item.getCid());
				dailyVO.setPid(item.getPid());
				dailyVO.setCnt(item.getCnt());
				dailyVO.setDt(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
				
				dailyList.add(dailyVO);
			}
			
			// 다음 날짜로 설정
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
//			dt = calendar.getTime();
//			dtStr = sdf.format(dt);
//			dtInt = Integer.parseInt(dtStr);
		}
		
		return dailyList;
	}
}

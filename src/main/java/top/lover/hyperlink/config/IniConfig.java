package top.lover.hyperlink.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.lover.hyperlink.dao.CsDefaultTouchRateMapper;
import top.lover.hyperlink.dao.CsDefaultTouchTimeMapper;
import top.lover.hyperlink.entity.CsDefaultTouchRate;
import top.lover.hyperlink.entity.CsDefaultTouchTime;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author qinrq
 * @description 初始化数据
 */
@Configuration
public class IniConfig {

    @Resource
    private CsDefaultTouchRateMapper csDefaultTouchRateMapper;

    @Resource
    private CsDefaultTouchTimeMapper csDefaultTouchTimeMapper;

    @Bean
    public void iniTime(){
        String sql1 = "INSERT INTO cs_default_touch_rate(N_ID, STR0, STR1, COMP_ID, CREATE_BY, CREATE_TIME, MODI_BY, " +
                "MODI_TIME, ORG_ID, SORT_NUM, STATUS, MSG_STATUS_TIME, MSG_STATUS_TIME_TYPE, MSG_UNLOAD_TIME, MSG_UNLOAD_TIME_TYPE, " +
                "PUSH_RESERV_INFO_TIME, PUSH_RESERV_INFO_TIME_TYPE, PUSH_STATUS_TIME, PUSH_STATUS_TIME_TYPE, PUSH_UN_REGISTER, " +
                "PUSH_UN_REGISTER_TYPE) VALUES (10000001, NULL, NULL, 10000000, 1, '2019-09-16 10:02:14', 1, '2019-09-16 10:02:14', " +
                "222, NULL, 1, NULL, 2, NULL, NULL, NULL, 2, 3, 1, 1, 3)";
        String sql2 = "INSERT INTO cs_default_touch_time(N_ID, STR0, STR1, COMP_ID, CREATE_BY, CREATE_TIME, MODI_BY," +
                " MODI_TIME, ORG_ID, SORT_NUM, STATUS, MSG_END_TIME, MSG_START_TIME, PUSH_END_TIME, PUSH_START_TIME) " +
                " VALUES (10000001, NULL, NULL, 10000000, 1, '2019-09-05 15:31:32', 1, '2019-09-05 15:31:32', 222, NULL, 1, '3', '2', '19', '16')";
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("N_ID",10000001l);
        List<CsDefaultTouchRate> csDefaultTouchRates = csDefaultTouchRateMapper.selectAll();
        if (csDefaultTouchRates.size() < 1){
            System.out.println("Date没有内容！！！！！！！！请插入数据");
        }else{
            System.out.println("进入判断了！！！！");
        }
        List<CsDefaultTouchTime> csDefaultTouchTimes = csDefaultTouchTimeMapper.selectByMap(map);
        if (csDefaultTouchTimes.size()<1){
            System.out.println("Time没有内容！！！！！！！！请插入数据");
        }else{
            System.out.println("进入判断了222！！！！");
        }

    }
}

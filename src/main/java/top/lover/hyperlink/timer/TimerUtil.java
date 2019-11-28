package top.lover.hyperlink.timer;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author qinrq
 */
@Component
@Configuration
@EnableScheduling
public class TimerUtil {



    //1.对安装后超过1日（默认时间）未注册的用户自动以Push的方式对其进行触达
    //@Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=6000)
    private void configureTasks() {
        System.out.println("执行静态定时任务时间: " + LocalDateTime.now());
    }

    //2.1.对注册后关闭App并超过1日（默认）未重新启动的用户自动以短信的方式对其进行触达
    //2.2.对注册后关闭App并超过12h（默认）未重新启动的用户自动以Push的方式对其进行触达

    //3.对未留资以及留资不完整的用户1小时（默认时间）后自动以Push 的方式对其进行触达
}

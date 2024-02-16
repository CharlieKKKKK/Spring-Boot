package com.vtxlab.bootcamp.bootcampsbforum.Config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledConfig {

  // @Scheduled(fixedRate = 4000)
  public void fixedRateTask() throws InterruptedException {
    System.out.println("fixedRate start:    " + System.currentTimeMillis());
    Thread.sleep(2000);
    System.out.println("fixedRate end:");
  }

  // @Scheduled(fixedDelay = 2000)
  public void fixedDelayTask() throws InterruptedException {
    System.out.println("Delay start:    " + System.currentTimeMillis());
    Thread.sleep(1000);
    System.out.println("Delay end:");
  }

  // @Scheduled(cron = "*/5 * * * * ?")
  public void cronTask() throws InterruptedException {
    System.out.println("start cron");
    Thread.sleep(10000);
    System.out.println("end cron");
  }
}

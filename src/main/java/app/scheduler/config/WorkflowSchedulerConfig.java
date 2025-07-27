package app.scheduler.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import app.scheduler.service.WorkflowJob;
import jakarta.annotation.PostConstruct;

@Configuration
public class WorkflowSchedulerConfig {

	@Autowired
	private Scheduler scheduler;

	@PostConstruct
	public void scheduleJob() throws SchedulerException {
		JobDetail jobDetail = JobBuilder.newJob(WorkflowJob.class)
				.withIdentity("myJob", "group1")
				.storeDurably()
				.build();

		Trigger trigger = TriggerBuilder.newTrigger()
				.forJob(jobDetail)
				.withIdentity("myTrigger", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")) // every 10 seconds
				.build();

		scheduler.scheduleJob(jobDetail, trigger);
	}

}

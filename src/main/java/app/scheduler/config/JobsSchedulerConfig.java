package app.scheduler.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import app.scheduler.service.WorkflowJob;
import jakarta.annotation.PostConstruct;

@Configuration
public class JobsSchedulerConfig {

	private SchedulerFactoryBean schedulerFactoryBean;

	public JobsSchedulerConfig(SchedulerFactoryBean schedulerFactoryBean) {
		this.schedulerFactoryBean = schedulerFactoryBean;
	}

	@PostConstruct
	public void scheduleJobs() throws Exception {
		JobDetail job = JobBuilder.newJob(WorkflowJob.class)
				.withIdentity("firstJob", "barclays")
				.build();
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("firstTrigger", "barclays")
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?"))
				.build();

		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
	}
}

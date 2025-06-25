package LinkedIn.Managers;

import LinkedIn.JobPost;
import LinkedIn.Notification;
import LinkedIn.Services.NotificationService;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class JobManager {
    private final List<JobPost> jobs = new CopyOnWriteArrayList<>();
    public JobPost postJob(JobPost job) {
        jobs.add(job);
        NotificationService.getInstance().notify(
            new Notification(job.getCompany(), Notification.Type.JOB_POST, job.getTitle())
        );

        return job;
    }
    public List<JobPost> listJobs() { return List.copyOf(jobs); }
}
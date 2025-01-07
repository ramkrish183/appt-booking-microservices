package com.rameshj.booking.scheduler;

import com.rameshj.booking.service.ApptBookingSchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AppointmentScheduler {

	private static final Logger log = LoggerFactory.getLogger(AppointmentScheduler.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private final ApptBookingSchedulerService apptBookingSchedulerService;

    public AppointmentScheduler(ApptBookingSchedulerService apptBookingSchedulerService) {
        this.apptBookingSchedulerService = apptBookingSchedulerService;
    }

    @Scheduled(fixedRate = 5000)
	public void updateCheckoutTime() {
		log.info("updating the checkout Time {}", dateFormat.format(new Date()));
		apptBookingSchedulerService.updateCheckoutTime();
	}

	@Scheduled(fixedRate = 10000)
	public void deleteOldAppointment() {
		log.info("deleting old appointments {}", dateFormat.format(new Date()));
		apptBookingSchedulerService.deleteOldAppointments();
	}
}
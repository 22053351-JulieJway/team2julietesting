
public class Appointments {
	protected String nric;
	protected String name;
	protected String date_of_appointment;
	protected String time_of_appointment;
	protected String status;
	protected String appointment_reschedule;
	public String getNric() {
		return nric;
	}
	public void setNric(String nric) {
		this.nric = nric;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate_of_appointment() {
		return date_of_appointment;
	}
	public void setDate_of_appointment(String date_of_appointment) {
		this.date_of_appointment = date_of_appointment;
	}
	public String getTime_of_appointment() {
		return time_of_appointment;
	}
	public void setTime_of_appointment(String time_of_appointment) {
		this.time_of_appointment = time_of_appointment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAppointment_reschedule() {
		return appointment_reschedule;
	}
	public void setAppointment_reschedule(String appointment_reschedule) {
		this.appointment_reschedule = appointment_reschedule;
	}
	public Appointments(String nric, String name, String date_of_appointment, String time_of_appointment, String status,
			String appointment_reschedule) {
		super();
		this.nric = nric;
		this.name = name;
		this.date_of_appointment = date_of_appointment;
		this.time_of_appointment = time_of_appointment;
		this.status = status;
		this.appointment_reschedule = appointment_reschedule;
	}

}

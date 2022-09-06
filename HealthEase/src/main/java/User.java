
public class User {
	
	protected String nric;
	protected String name;
	protected String health_institution;
	protected String doctor_name;
	protected String date_of_appointment;
	protected String time_of_appointment;
	protected String email;
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
	public String getHealth_institution() {
		return health_institution;
	}
	public void setHealth_institution(String health_institution) {
		this.health_institution = health_institution;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String nric, String name, String health_institution, String doctor_name, String date_of_appointment,
			String time_of_appointment, String email) {
		super();
		this.nric = nric;
		this.name = name;
		this.health_institution = health_institution;
		this.doctor_name = doctor_name;
		this.date_of_appointment = date_of_appointment;
		this.time_of_appointment = time_of_appointment;
		this.email = email;
	}

}

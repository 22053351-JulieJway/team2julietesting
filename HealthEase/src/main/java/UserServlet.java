

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	//Step 1: Prepare list of variables used for database connections
	
		private String jdbcURL = "jdbc:mysql://localhost:3306/userinfo";
		private String jdbcUsername = "root";
		private String jdbcPassword = "Sashimiold357!";
		//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
		private static final String INSERT_USERS_SQL = "INSERT INTO UserInfo" + "(nric, name, health_institution, doctor_name, date_of_appointment, time_of_appointment, email) VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
		
		private static final String SELECT_USER_BY_ID = "select nric, name, health_institution, doctor_name, date_of_appointment, time_of_appointment, email from userinfo where nric =?";
		
		//private static final String SELECT_APPOINTMENTS_BY_ID = "select nric, name, date_of_appointment, time_of_appointment, status, appointment_reschedule  from Appointments where nric =?";
		
		
		private static final String SELECT_ALL_USERS = "select * from UserInfo ";
		
		//private static final String DELETE_APPOINTMENTS_SQL = "delete from UserInfo where nric= ?;";
		private static final String DELETE_APPOINTMENTS_SQL = "DELETE FROM userinfo WHERE nric=?;";
		
		
		private static final String UPDATE_USERS_SQL = "update userinfo set nric= ?,name= ?, health_institution =?,doctor_name =?, date_of_appointment =?, time_of_appointment =?, email =? where nric = ?;";
		
		private static final String UPDATE_APPOINTMENTS_SQL = "update Appointments set nric= ?,name= ?, date_of_appointment =?,time_of_appointment =?, status =?, appointment_reschedule =? where nric = ?;";
		//Step 3: Implement the getConnection method which facilitates connection to the
		//database via JDBC
		protected Connection getConnection() {
			Connection connection = null;
			try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername,
			jdbcPassword);
			} catch (SQLException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
			return connection;
			}
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		String action = request.getServletPath();
//		try {
//		switch (action) {
//		case "/insert":
//		break;
//		case "/delete":
//		break;
//		case "/edit":
//		break;
//		case "/update":
//		break;
//		default:
//		listUsers(request, response);
//		break;
//		}
//		} catch (SQLException ex) {
//		throw new ServletException(ex);
//		}
//	}
		String action = request.getServletPath();
		try {
		switch (action) {
		case "/UserServlet/delete":
		deleteUser(request, response);
		break;
		case "/UserServlet/edit":
		showEditForm(request, response);
		break;
		case "/UserServlet/update":
		updateUser(request, response);
		break;
		case "/UserServlet/dashboard":
		listUsers(request, response);
		break;
		}
		} catch (SQLException ex) {
		throw new ServletException(ex);
		}
	}
	
	
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
			List <User> users = new ArrayList <>();
			try (Connection connection = getConnection();
			// Step 5.1: Create a statement using connection object
			PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_ALL_USERS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
			String nric = rs.getString("nric");
			String name = rs.getString("name");
			String health_institution = rs.getString("health_institution");
			String doctor_name = rs.getString("doctor_name");
			String date_of_appointment = rs.getString("date_of_appointment");
			String time_of_appointment = rs.getString("time_of_appointment");
			String email = rs.getString("email");
			users.add(new User(nric, name, health_institution, doctor_name, date_of_appointment, time_of_appointment, email));
			}
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
			// Step 5.4: Set the users list into the listUsers attribute to be pass to
			//the userManagement.jsp
			request.setAttribute("listUsers", users);
			request.getRequestDispatcher("/manageUsers.jsp").forward(request, response);
			}
	
	
			
	//method to get parameter, query database for existing user data and redirect to user
		//edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
			//get parameter passed in the URL
			String name = request.getParameter("name");
			User existingUser = new User("", "", "", "", "", "", "");
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, name);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
			name = rs.getString("nric");
			String nric = rs.getString("nric");
			String health_institution = rs.getString("health_institution");
			String doctor_name = rs.getString("doctor_name");
			String date_of_appointment = rs.getString("date_of_appointment");
			String time_of_appointment = rs.getString("time_of_appointment");
			String email = rs.getString("email");
			
			existingUser = new User(nric, name, health_institution, doctor_name, date_of_appointment,time_of_appointment, email );
			}
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
			//Step 5: Set existingUser to request and serve up the userEdit form
			request.setAttribute("users", existingUser);
			request.getRequestDispatcher("/appointmentEdit.jsp").forward(request, response);
			}
			
		
		//method to update the user table base on the form data
		private void updateUser(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException {
		//Step 1: Retrieve value from the request
			String oriNric = request.getParameter("oriNric");
		String nric = request.getParameter("nric");
		String name = request.getParameter("name");
		String health_institution = request.getParameter("health_institution");
		String doctor_name = request.getParameter("doctor_name");
		String date_of_appointment = request.getParameter("date_of_appointment");
		String time_of_appointment = request.getParameter("time_of_appointment");
		String email = request.getParameter("email");
//		String appointment_reschedule = request.getParameter("appointment_reschedule");
		
		//Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection(); PreparedStatement statement =
		connection.prepareStatement(UPDATE_USERS_SQL);) {
		statement.setString(1, nric);
		statement.setString(2, name);
		statement.setString(3, health_institution);
		statement.setString(4, doctor_name);
		statement.setString(5, date_of_appointment);
		statement.setString(6, time_of_appointment);
		statement.setString(7, email);
		statement.setString(8, oriNric);
//		statement.setString(5, appointment_reschedule);
		int i = statement.executeUpdate();
		}
		//Step 3: redirect back to UserServlet (note: remember to change the url to
		//your project name)
		// The sample uses project name as HelloWorldJaveEE. Use your own proj name if its not
		//the same.
		response.sendRedirect("http://localhost:8090/HealthEase/UserServlet/dashboard");
		}
		
		
		
		//method to delete user
		private void deleteUser(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException {
		//Step 1: Retrieve value from the request
		String name = request.getParameter("name");
		//Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection(); PreparedStatement statement =
		connection.prepareStatement(DELETE_APPOINTMENTS_SQL);) {
		statement.setString(1, name);
		int i = statement.executeUpdate();
		}
		//Step 3: redirect back to UserServlet dashboard (note: remember to change the
		//url to your project name)
		response.sendRedirect("http://localhost:8090/HealthEase/UserServlet/dashboard");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

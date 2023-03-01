package in.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.main.dto.Employee;

public class Employeeimpl implements IEmployee {

	private static final String sqlQuery = "insert into employee(`empid`,`name`,`age`,`mobile`,`email`)values(?,?,?,?,?)";

	public String addEmployee(Employee employee) {

		Connection connection = null;
		PreparedStatement pstm = null;
		String status = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql:///people";
			String username = "root";
			String password = "root123";
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {
				pstm = connection.prepareStatement(sqlQuery);
			}
			if (pstm != null) {
				pstm.setString(1, employee.getEmpid());
				pstm.setString(2, employee.getEname());
				pstm.setString(3, employee.getEage());
				pstm.setString(4, employee.getEmobile());
				pstm.setString(5, employee.getEemail());

				int rowSet = pstm.executeUpdate();

				if (rowSet == 1) {
					status = "Sucess";
				} else {
					status = "Failure";
				}
			}
		} catch (ClassNotFoundException cfe) {
			cfe.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

}

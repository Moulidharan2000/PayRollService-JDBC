package com.bridgelabz.payrollservice;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class PayrollTest {

	@Test
	public void Payrolltest() throws SQLException {
		PayrollService service = new PayrollService();
		Assert.assertEquals(true, service.Query());
	}
}

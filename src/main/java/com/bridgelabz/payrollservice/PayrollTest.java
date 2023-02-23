package com.bridgelabz.payrollservice;

import org.junit.Assert;
import org.junit.Test;

public class PayrollTest {

	@Test
	public void Payrolltest() {
		PayrollService service = new PayrollService();
		Assert.assertEquals(true, service.Query());
	}
}

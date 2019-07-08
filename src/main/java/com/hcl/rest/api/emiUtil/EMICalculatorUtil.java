package com.hcl.rest.api.emiUtil;

import java.util.List;

import com.hcl.rest.api.entity.EMIDetail;

public class EMICalculatorUtil {

	public static List<EMIDetail> getAllEmi(float principal, float rateOfInterest, float year) {
		float emi;

		rateOfInterest = rateOfInterest / (12 * 100); // one month interest
		year = year * 12; // one month period
		emi = (principal * rateOfInterest * (float) Math.pow(1 + rateOfInterest, year))
				/ (float) (Math.pow(1 + rateOfInterest, year) - 1);
		return null;

	}

}

package com.ty.mobile.dao;

import com.ty.mobile.dto.Mobile;

public class GetMobileById {

	public static void main(String[] args) {

		MobileDao dao = new MobileDao();
		Mobile mobile =dao.getMobileById(4);
		System.out.println(mobile);
	}

}

package com.trainingbasket.ems.test;

import java.io.IOException;
import java.util.ArrayList;

import com.trainingbasket.ems.beans.CEO;
import com.trainingbasket.ems.beans.Employee;
import com.trainingbasket.ems.beans.Manager;
import com.trainingbasket.ems.beans.Receptionist;
import com.trainingbasket.ems.uiservices.UiServices;
import com.trainingbasket.ems.utils.ReadUtil;

public class Runner {
	
	public Runner() {
		
	}
	
	public static void main(String... args) {
		try {
			new UiServices();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

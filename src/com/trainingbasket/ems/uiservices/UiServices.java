package com.trainingbasket.ems.uiservices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.trainingbasket.ems.beans.CEO;
import com.trainingbasket.ems.beans.Employee;
import com.trainingbasket.ems.beans.Manager;
import com.trainingbasket.ems.beans.Receptionist;
import com.trainingbasket.ems.utils.ReadUtil;

public class UiServices {

	ArrayList<Employee> employees = new ArrayList<Employee>();
	ReadUtil readUtil = null;
	String employeeMenu = "======Employee Menu=====\n1. Add a CEO\n2. Add Manager\n3. Add Receptionist";

	public UiServices() throws IOException {
		readUtil = new ReadUtil();
		processUser();
	}

	private void processUser() throws IOException {
		while (true) {
			printMenu();
			int opt = readUtil.readInt("Please make your choice from above menu",
					"Error Could not read : check the input");
			switch (opt) {
			case 1:
				readData();
				break;
			case 2:
				for (Employee employee : employees) {
					System.out.println(employee);
				}
				break;
			case 3:
				String head="ID, Name, Address, Contact Number, Salary , Department, Extenssion\n";
				
				String data=head;
				for (Employee employee : employees) {
					
					if (employee instanceof Manager ) {
						Manager m = (Manager) employee;
						data=data+m.getId()+","+m.getName()+","+m.getAddress()+","+m.getContactNumber()+","+m.getSalary()+","+m.getDepartment()+",\n";
					}
					else if (employee instanceof Receptionist)
					{
						Receptionist m = (Receptionist) employee;
						data=data+m.getId()+","+m.getName()+","+m.getAddress()+","+m.getContactNumber()+","+m.getSalary()+", ,"+m.getTelephoneExt()+"\n";
					}
					else {
						CEO m = (CEO) employee;
						data=data+m.getId()+","+m.getName()+","+m.getAddress()+","+m.getContactNumber()+","+m.getSalary()+", , \n";	
					}
				}
				Files.write(Paths.get("G:\\EmployeesRecord.csv"), data.getBytes());
				
				break;
			default:
				System.out.println("Invalid Choice");
				break;

			}
		}
	}

	private void readData() {
		System.out.println(employeeMenu);
		int opt = readUtil.readInt("Please make your choice from above menu", "Error Could not read : check the input");
		switch (opt) {
		case 1:
			CEO ceo = new CEO();
			ceo.setName(readUtil.readString("Please Enter The Name of CEO", "Error"));
			ceo.setContactNumber(readUtil.readString("Please Enter The Contact Number of CEO", "Error"));
			ceo.setAddress(readUtil.readString("Please Enter The Address of CEO", "Error"));
			ceo.setSalary(readUtil.readDouble("Please Enter The Salary of CEO", "Error"));
			employees.add(ceo);
			break;
		case 2:
			Manager manager = new Manager();
			manager.setName(readUtil.readString("Please Enter The Name of Manager", "Error"));
			manager.setContactNumber(readUtil.readString("Please Enter The Contact Number of Manager", "Error"));
			manager.setAddress(readUtil.readString("Please Enter The Address of Manager", "Error"));
			manager.setSalary(readUtil.readDouble("Please Enter The Salary of Manager", "Error"));
			manager.setDepartment(readUtil.readString("Please Ente The Department", "Err"));
			employees.add(manager);
			break;
		case 3:
			Receptionist receptionist = new Receptionist();
			receptionist.setName(readUtil.readString("Please Enter The Name of Receptionist", "Error"));
			receptionist
					.setContactNumber(readUtil.readString("Please Enter The Contact Number of Receptionist", "Error"));
			receptionist.setAddress(readUtil.readString("Please Enter The Address of Receptionist", "Error"));
			receptionist.setSalary(readUtil.readDouble("Please Enter The Salary of Receptionist", "Error"));
			receptionist.setTelephoneExt(readUtil.readString("Please Enter The Address of Receptionist", "Error"));
			employees.add(receptionist);
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
	}

	private void printMenu() {
		System.out.println("=============Main Menu================");
		System.out.println("1. Add New Employee");
		System.out.println("2. Show All  Employee");
		System.out.println("3. Save All Employees to Excel");
	}

}

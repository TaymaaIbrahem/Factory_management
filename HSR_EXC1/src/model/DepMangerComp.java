package model;

import java.util.Comparator;

public class DepMangerComp implements Comparator<DepartmentManager>{

	@Override
	public int compare(DepartmentManager o1, DepartmentManager o2) {
		// TODO Auto-generated method stub

		if(o1.getSalary().equals(o2.getSalary())) {
			if(o1.getDateOfStartWork().compareTo(o2.getDateOfStartWork())==0)
				return o1.compareTo(o2);
			 return o1.getDateOfStartWork().compareTo(o2.getDateOfStartWork());
		}
			
			
			
		return o1.getSalary().compareTo(o2.getSalary());
	}

	
	
}

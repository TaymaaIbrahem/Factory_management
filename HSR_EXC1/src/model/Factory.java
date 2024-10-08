package model;

import java.applet.Applet;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.toedter.plaf.JCalendarTheme;

import Exceptions.DepartmentAlreadyHasManager;
import Exceptions.IncorrectNumberOfSeats;
import Exceptions.PersonAlreadyExistException;
import Exceptions.PersonNotExistException;
import Exceptions.PoullutionLevelHybridVehiclesMustBeOne;
import Exceptions.PoullutionLevelNotInRange;

import Exceptions.YearOfBirthNotInRange;
import utils.Area;
import utils.Color;
import utils.Gender;	


public class Factory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//run pk 
	private int countV=0;
	private int countD=0;
	
	private HashMap<String,Employee> allEmployees;
	private HashMap<String,Employee> EmployeesByUserName;//to save user name and employee
	private HashMap<String , Employee> employeesByPhoto;//to save photo for each employee
	private HashMap<String,Customer> allCustomers;
	private HashMap<String,VehicleTransportation> allVehicleTransportation;
	private HashMap<String,Deal> allDeals;
	private HashMap<Integer,Department> allDepartments;
	

	public int getCountV() {
		return countV;
	}




	public void setCountV(int countV) {
		this.countV = countV;
	}




	public int getCountD() {
		return countD;
	}




	public void setCountD(int countD) {
		this.countD = countD;
	}
	private static Factory factory;
	private Factory() {
		allEmployees = new HashMap<String,Employee>();
		allCustomers = new HashMap<String, Customer>();
		allVehicleTransportation = new HashMap<String, VehicleTransportation>();
		allDeals = new HashMap<String, Deal>();
		allDepartments = new HashMap<Integer, Department>();
		EmployeesByUserName = new HashMap<>();
		employeesByPhoto = new HashMap<>();
		
	}

	
	

	public HashMap<String, Employee> getEmployeesByPhoto() {
		return employeesByPhoto;
	}

	public void setEmployeesByPhoto(HashMap<String, Employee> employeesByPhoto) {
		this.employeesByPhoto = employeesByPhoto;
	}

	public HashMap<String, Employee> getEmployeesByUserName() {
		return EmployeesByUserName;
	}

	public void setEmployeesByUserName(HashMap<String, Employee> employeesByUserName) {
		EmployeesByUserName = employeesByUserName;
	}

	

	public static Factory getInstance() {
		if(factory == null)
			factory = new Factory();
		return factory; 
	}

	public boolean addEmployee(Employee e) throws PersonAlreadyExistException, YearOfBirthNotInRange {
		if(e == null) {
			return false;

		}
		if(allEmployees.containsKey(e.getID()) || EmployeesByUserName.containsKey(e.getUserName()))
			throw new PersonAlreadyExistException(e);
		if(e.getYearOfBirth()<1900 ||e.getYearOfBirth()>2022 )
			throw new YearOfBirthNotInRange(e.getID());
		allEmployees.put(e.getID(), e);
		EmployeesByUserName.put(e.getUserName(), e);
		return e.getDep().getAllEmployees().add(e);

	}
	public boolean addDepartmentManager(DepartmentManager dm) throws PersonAlreadyExistException, YearOfBirthNotInRange {
		if(dm == null )
			return false;
		if(allEmployees.containsKey(dm.getID()) || EmployeesByUserName.containsKey(dm.getUserName()))
			throw new PersonAlreadyExistException(dm);
		if(dm.getYearOfBirth()<1900 ||dm.getYearOfBirth()>2022 )
			throw new YearOfBirthNotInRange(dm.getID());

		allEmployees.put(dm.getID(), dm);
		EmployeesByUserName.put(dm.getUserName(), dm);
		dm.getDep().setDepManager(dm);
		return true;
	}
	public boolean addCustomer(Customer c) throws PersonAlreadyExistException, YearOfBirthNotInRange {
		if(c == null)
			return false;
		if(allCustomers.containsKey(c.getID()))
			throw new PersonAlreadyExistException(c);
		if(c.getYearOfBirth()<1900 ||c.getYearOfBirth()>2022 )
			throw new YearOfBirthNotInRange(c.getID());

		allCustomers.put(c.getID(), c);
		return true;

	}
	public boolean addVIPCustomer(VIPCustomer vc) throws PersonAlreadyExistException, YearOfBirthNotInRange {
		if(vc == null)
			return false;
		if(allCustomers.containsKey(vc.getID()))
			throw new PersonAlreadyExistException(vc);
		if(vc.getYearOfBirth()<1900 ||vc.getYearOfBirth()>2022 )
			throw new YearOfBirthNotInRange(vc.getID());

		allCustomers.put(vc.getID(), vc);
		return true;

	}
	public boolean addCar(Car c) throws PoullutionLevelNotInRange, IncorrectNumberOfSeats {
		if(c == null)
			return false;
		if(c.getPollutionLevel()>15 |c.getPollutionLevel()<1 )
			throw new PoullutionLevelNotInRange(c.getLicensePlate());
		if(c.getNumberOfSeats()>7)
			throw new IncorrectNumberOfSeats(c.getLicensePlate());
		
		allVehicleTransportation.put(c.getLicensePlate(), c);
		return true; 


	};
	public boolean addHybridCar(HybridCar hybridCar) throws  IncorrectNumberOfSeats, PoullutionLevelHybridVehiclesMustBeOne       {
		if(hybridCar == null)
			return false;
		if(hybridCar.getPollutionLevel()!=1  )
			throw new PoullutionLevelHybridVehiclesMustBeOne(hybridCar.getLicensePlate());
		if(hybridCar.getNumberOfSeats()>7)
			throw new IncorrectNumberOfSeats(hybridCar.getLicensePlate());
		
		allVehicleTransportation.put(hybridCar.getLicensePlate(), hybridCar);
		return true; 


	}
	public boolean addVan(Van v) throws PoullutionLevelNotInRange {
		if(v == null)
			return false;
		if(v.getPollutionLevel()>15 |v.getPollutionLevel()<1 )
			throw new PoullutionLevelNotInRange(v.getLicensePlate());
		
		allVehicleTransportation.put(v.getLicensePlate(), v);
		return true;

	}
	public boolean addMotorcycle(Motorcycle m) throws PoullutionLevelNotInRange  {
		if(m == null)
			return false;
		if(m.getPollutionLevel()>15 |m.getPollutionLevel()<1 )
			throw new PoullutionLevelNotInRange(m.getLicensePlate());
		
           
		allVehicleTransportation.put(m.getLicensePlate(), m);
		return true;
	}
	public boolean addHybridMotorcycle(HybridMotorcycle hybridMotorcycle) throws  PoullutionLevelHybridVehiclesMustBeOne {
		if(hybridMotorcycle == null)
			return false;
		if(hybridMotorcycle.getPollutionLevel()!=1 )
			throw new PoullutionLevelHybridVehiclesMustBeOne(hybridMotorcycle.getLicensePlate());
		
		allVehicleTransportation.put(hybridMotorcycle.getLicensePlate(), hybridMotorcycle);
		return true;
	}
	public boolean addDepartment(Department d) {
		if(d ==null)
			return false;
		if(allDepartments.containsKey(d.getDepartmentID()))
			return false;
		allDepartments.put(d.getDepartmentID(), d);
		return true;
	} 
	public boolean addDeal(Deal d) {
		if(d == null) {
			return false;
		}

		d.getCustomer().getAllDeals().add(d);
		allDeals.put(d.getDealID(), d);
		return true;
	}


	public boolean removeCar(Car car){
		if(car == null)
			return false;
		if(!allVehicleTransportation.containsKey(car.getLicensePlate()))
			return false;
		allVehicleTransportation.remove(car.getLicensePlate());
		return true;

	}
	public boolean removeVan(Van van){

		if(van == null)
			return false;
		if(!allVehicleTransportation.containsKey(van.getLicensePlate()))
			return false;
		allVehicleTransportation.remove(van.getLicensePlate());
		return true;

	}
	public boolean removeMotorcycle(Motorcycle motorcycle){

		if(motorcycle == null)
			return false;
		if(!allVehicleTransportation.containsKey(motorcycle.getLicensePlate()))
			return false;
		allVehicleTransportation.remove(motorcycle.getLicensePlate());
		return true;

	}
	public boolean removeHybridCar(HybridCar hybridCar)

	{

		if(hybridCar == null)
			return false;
		if(!allVehicleTransportation.containsKey(hybridCar.getLicensePlate()))
			return false;
		allVehicleTransportation.remove(hybridCar.getLicensePlate());
		return true;

	}
	public boolean removeHybridMotorcycle(HybridMotorcycle HybridMotorcycle)

	{

		if(HybridMotorcycle == null)
			return false;
		if(!allVehicleTransportation.containsKey(HybridMotorcycle.getLicensePlate()))
			return false;
		allVehicleTransportation.remove(HybridMotorcycle.getLicensePlate());
		return true;

	}

	public boolean removeCustomer(Customer customer) throws PersonNotExistException{
		if(customer == null)
			throw new PersonNotExistException();
		if(!allCustomers.containsKey(customer.getID())||customer == null)
			throw new PersonNotExistException();
		allCustomers.remove(customer.getID());
		return true;

	}
	public boolean removeVIPCustomer(VIPCustomer vipCustomer)throws PersonNotExistException{

		if(vipCustomer == null)
			throw new PersonNotExistException();
		if(!allCustomers.containsKey(vipCustomer.getID()))
			throw new PersonNotExistException();
		allCustomers.remove(vipCustomer.getID());
		return true;
	}
	public boolean removeEmployee(Employee employee)throws PersonNotExistException{

		if(employee == null)
			throw new PersonNotExistException();
		if(!allEmployees.containsKey(employee.getID()))
			throw new PersonNotExistException();
		allEmployees.remove(employee.getID());
		employee.getDep().getAllEmployees().remove(employee);
		return true;

	}
	public boolean removeDepartmentManager(DepartmentManager departmentManager)throws PersonNotExistException{

		if(departmentManager == null)
			throw new PersonNotExistException();
		if(!allEmployees.containsKey(departmentManager.getID()))
			throw new PersonNotExistException();
		allEmployees.remove(departmentManager.getID());
		departmentManager.getDep().setDepManager(null);
		return true;

	}
	public boolean removeDeal(Deal deal){ 

		if(deal == null)
			return false;
		if(!allDeals.containsKey(deal.getDealID()))
			return false;
		deal.getCustomer().getAllDeals().remove(deal);
		allDeals.remove(deal.getDealID());
		return true;
	}


	public boolean removeDepartment(Department department){

		if(department == null)
			return false;
		if(!allDepartments.containsKey(department.getDepartmentID()))
			return false;
		for(Employee e: department.getAllEmployees()) {
			allEmployees.remove(e.getID());

		}
		allEmployees.remove(department.getDepManager().getID());
		allDepartments.remove(department.getDepartmentID());
		return true;

	}

	public VehicleTransportation getRealVehicleTransportation(String licensePlate){
		return allVehicleTransportation.get(licensePlate);

	}
	public HybridCar getRealHybridCar(String licensePlate){
		if(allVehicleTransportation.get(licensePlate) != null)
			return (HybridCar)allVehicleTransportation.get(licensePlate);
		return null;
	}
	public HybridMotorcycle getRealHybridMotorcycle(String licensePlate){
		if(allVehicleTransportation.get(licensePlate) != null)
			return (HybridMotorcycle)allVehicleTransportation.get(licensePlate);
		return null;
	}
	public Motorcycle getRealMotorcycle(String licensePlate){
		if(allVehicleTransportation.get(licensePlate) != null)
			return (Motorcycle)allVehicleTransportation.get(licensePlate);
		return null;
	}
	public Car getRealCar(String licensePlate){
		if(allVehicleTransportation.get(licensePlate) != null)
			return (Car)allVehicleTransportation.get(licensePlate);
		return null;
	}
	public Van getRealVan(String licensePlate){
		if(allVehicleTransportation.get(licensePlate) != null)
			return (Van)allVehicleTransportation.get(licensePlate);
		return null;
	}
	public Customer getRealCustomer(String ID){
		if(allCustomers.get(ID) != null)
			return (Customer)allCustomers.get(ID);
		return null;
	}
	public Customer getRealVIPCustomer(String ID){
		if(allCustomers.get(ID) != null)
			return (VIPCustomer)allCustomers.get(ID);
		return null;
	}
	public Employee getRealEmployee(String ID){
		if(allEmployees.get(ID) != null)
			return (Employee)allEmployees.get(ID);
		return null;
	}
	public DepartmentManager getRealDepartmentManager(String ID){
		if(allEmployees.get(ID) != null)
			return (DepartmentManager)allEmployees.get(ID);
		return null;
	}
	public Deal getRealDeal(String dealID){
		return allDeals.get(dealID);
	}
	public Department getRealDepartment(int departmentID){
		return allDepartments.get(departmentID);
	}


	//******************************
	public HashMap<Area,ArrayList<Customer>> customersByArea(){
		HashMap<Area,ArrayList<Customer>> toReturn = new HashMap<Area, ArrayList<Customer>>();
		for(Area a: Area.values()) {
			toReturn.put(a, new ArrayList<Customer>());
		}
		for(Customer c : allCustomers.values()) {
			toReturn.get(c.getArea()).add(c);
		}

		return toReturn;
	}
	public HashMap<Gender, HashMap <Integer, ArrayList<Person>>> personsByGenderAndYearOfBirth()

	{
		HashMap<Gender, HashMap <Integer, ArrayList<Person>>> toReturn = new HashMap<>();
		toReturn.put(Gender.F, new HashMap<>());
		toReturn.put(Gender.M, new HashMap<>());
		for(Person s: allCustomers.values()) {
			if(!toReturn.get(s.getGender()).containsKey(s.getYearOfBirth()))
			{
				toReturn.get(s.getGender()).put(s.getYearOfBirth(), new ArrayList<Person>());
			}
			toReturn.get(s.getGender()).get(s.getYearOfBirth()).add(s);
		}
		for(Person s: allEmployees.values()) {
			if(!toReturn.get(s.getGender()).containsKey(s.getYearOfBirth()))
			{
				toReturn.get(s.getGender()).put(s.getYearOfBirth(), new ArrayList<Person>());
			}
			toReturn.get(s.getGender()).get(s.getYearOfBirth()).add(s);
		}
		return toReturn;

	}
	public HashMap<Color, Integer> countOfVehiclesTransportationByColor(){
		HashMap<Color, Integer> toReturn = new HashMap<Color, Integer>();
		for(Color c : Color.values()) {
			toReturn.put(c, 0);
		}
		for(Deal d : allDeals.values()) {
			for(VehicleTransportation v : d.getAllVehicleTransportation()) {
				if(v != null)
					toReturn.put(v.getColor(), toReturn.get(v.getColor())+1);
			}
		}
		return toReturn;

	}
	
	
	public double avgPollutionLevelOfDeal (Deal deal) {
		
		ArrayList<VehicleTransportation> vlist = new ArrayList<>(deal.getAllVehicleTransportation());
		Predicate<VehicleTransportation> isNull = e -> (e!=null); // chick if vehicle is null
		//by using strem on vlist chick for each veicle in list if it not null get pollution level and reduce all these values in sum
		Double sum= vlist.stream().filter(isNull).mapToDouble(VehicleTransportation :: getPollutionLevel).reduce(0, (d1,d2)->(d1+d2));
		return (sum/deal.getAllVehicleTransportation().size()); //calculate avg
		
	}
	
	// check after the input and the main
	public String idOfDealWithMinAvgPollutionLevel() {
		double minAvg=Double.MAX_VALUE;
		Deal d = allDeals.get("1");
		for(Deal temp : allDeals.values()) {
			if(avgPollutionLevelOfDeal(temp)<=minAvg & temp.getDealID().compareTo(d.getDealID())>0) {
				d = temp;
				minAvg = avgPollutionLevelOfDeal(d);
			} 
		}
		if(d!=null) {
			return d.getDealID();
		}
		return "there is no deals until now";
	}
	public double avgPollutionLevelOfAllVehiclesTransportation()
	{
		double sum=0.0;
		if(allVehicleTransportation.size()==0 || allVehicleTransportation==null) {
			throw new NullPointerException();
		}
		for(VehicleTransportation v : allVehicleTransportation.values()) {
			sum += v.getPollutionLevel();
		}
		
		return (sum/allVehicleTransportation.size());

	}
	
	public double profitPerVehiclesTransportation (VehicleTransportation vehicleTransportation) {
		//by using intrface profit and lambda for each vehicle calculate diffrence between price and cost
		Profit p = (v)-> { return v.getPrice() - v.getCostOfManufacturing();};
		return p.clac(vehicleTransportation);
		
	}
	

	public boolean isGlobalStandard()
	{
		if(avgPollutionLevelOfAllVehiclesTransportation()<=5) {
			if(relativePrecentageOfHybrid()>=0.4)
				return true;
		}
		return false;
	}
	public double relativePrecentageOfHybrid() {
		int countHybrid =0;
		if(allVehicleTransportation==null || allVehicleTransportation.size()==0) {
			throw new NullPointerException();
		}
		for(VehicleTransportation v: allVehicleTransportation.values()) {
			if(v instanceof HybridCar || v instanceof HybridMotorcycle)
				countHybrid++;
		}
		return (double)countHybrid/allVehicleTransportation.size();	
	}

	public int howManyHybridVehiclesTransportationNeeded () {
		if(isGlobalStandard()==true) {
			return 0;
		}
		else {
			int countHybridVehicles=0 , countTotalVehicles = allVehicleTransportation.size() ,carsToAdd=0;
			double sumPollutionLevel=0;
            
			for(VehicleTransportation v: allVehicleTransportation.values()) {
				if(v instanceof HybridCar || v instanceof HybridMotorcycle)
					countHybridVehicles++;
				sumPollutionLevel += v.getPollutionLevel();
			}

			double rpOfHybrid = relativePrecentageOfHybrid();
			double avgPollution = avgPollutionLevelOfAllVehiclesTransportation();

			if(countTotalVehicles ==0) {
				throw new ArithmeticException();
			}
			while( !(rpOfHybrid>=0.4 && avgPollution<=5) ) {
				carsToAdd++;
				sumPollutionLevel++;
				countHybridVehicles++;
				countTotalVehicles++;
				rpOfHybrid = (double)countHybridVehicles/countTotalVehicles;
				avgPollution = sumPollutionLevel / countTotalVehicles;
			}
			return carsToAdd;
		}
	}
	//throws exception if the department has manager
	public boolean appointmentOfNewDepartmentManager(Department department) throws ParseException , DepartmentAlreadyHasManager{
		if(department== null) {
			throw new NullPointerException();
		}
		if( department.getDepManager()!=null)
			throw new DepartmentAlreadyHasManager();
		
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2025");
		Employee s=null;
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2022");
		for(Employee e: department.getAllEmployees()) {

			if(e.getDateOfStartWork().before(date)) {
				date=e.getDateOfStartWork();
				s=e;
			}}
		allEmployees.remove(s.getID());
		DepartmentManager toreturn = new DepartmentManager(s.getID(), s.getFirstName(), s.getLastName(), s.getPhoneNumber(), s.getGender(), s.getDateOfStartWork(), s.getSalary()*1.5, department,s.getYearOfBirth(),s.getUserName(),s.getPassword(), date1, 1500);
		allEmployees.put(toreturn.getID(), toreturn);

		department.setDepManager(toreturn);	
		
		return department.getAllEmployees().remove(s);
	}
	
	
	public int totalProfit() {
		double sum = 0.0;
		double toReduce=0.0;
		ArrayList<Deal> deals = new ArrayList<>(allDeals.values());
		sum= deals.stream().mapToDouble(Deal :: totalDealPrice).reduce(0,(d1,d2) -> d1+d2 );//sum the total price of all deals in factory
		ArrayList<VehicleTransportation> temp = new ArrayList<>();
		//collect all vehicles in the deals in same list
		for(Deal d : allDeals.values()) {
			temp.addAll(d.getAllVehicleTransportation());
		}
		//reduce cost of all vehicles from sum
		toReduce = temp.stream().mapToDouble(VehicleTransportation :: getCostOfManufacturing).reduce(0, (d1,d2) -> d1+d2);
		return (int)(sum - toReduce);
	}
	
	
	
	
	public List<Employee> allEmployees(int k){
		if(getAllDeals().size()<=k) {return getAllEmployees().values().stream().sorted().toList();}//if k >= size just sort all list and return it
		return getAllEmployees().values().stream().sorted().toList().subList(0, k); // sort and return subList
	}
	
	
	public ArrayList<Customer> allCustomers(){
		if(getAllCustomers()==null || getAllCustomers().values()==null) {
			throw new NullPointerException();
		}
		ArrayList<Customer> toReturn = new ArrayList<Customer>(getAllCustomers().values());
		Collections.sort(toReturn);
		return toReturn;
	}
	public HashMap<String, Employee> getAllEmployees() {
		return allEmployees;
	}

	public TreeSet<VehicleTransportation> allVehicleTransportations(){
		if(allVehicleTransportation == null) {
			throw new NullPointerException("there is now vehicles in the system !");
		}
		TreeSet<VehicleTransportation> toReturn = new TreeSet<>(new VehicleTransportationsCompare() );

		for(VehicleTransportation v : getAllVehicleTransportation().values()) {
			toReturn.add(v);
		}
		return toReturn;
	}
	
	public TreeSet<Customer> allCustomersCmp(){
		if(allCustomers == null) {
			throw new NullPointerException("there is now customers in the system !");
		}
		TreeSet<Customer> toReturn = new TreeSet<>(new CustomerComp());

		for(Customer v : getAllCustomers().values()) {
			toReturn.add(v);
		}		
		return toReturn;


	}

	public 	List<Deal> getBestsDeal(int k,ScoreCalculator score)
	{	
		if(allDeals == null) {
			throw new NullPointerException("there is now deals in the system !");
		}
		ArrayList<Deal> dealssbest=new ArrayList<Deal>(allDeals.values());
		Collections.sort(dealssbest, new CcomperitemScore(score));//sort by score !!by class comperitemScore(method sort static in class Collections
		if(getAllDeals().size()<=k) {return dealssbest;}
		else return dealssbest.subList(0, k);}// the best  k between index 0 and k (not including)!!!


	
	public ArrayList<DepartmentManager> AllBestsDepManger(){
		Function<DepartmentManager, Double> f = ((t) -> t.getSalary());//each managet map to salary
		Function<DepartmentManager, Date> l = ((t) -> t.getDateOfStartWork());//each managet map to date of start working
		Comparator<DepartmentManager> comp = Comparator.comparing(f).thenComparing(l);// sort by salary than date of start work
		
		//collect all departmentManagers an list then sort it
		List<DepartmentManager> temp1 = getAllEmployees().values().stream().filter((e) -> (e instanceof DepartmentManager)).map((e) -> ((DepartmentManager)e))
				.collect(Collectors.toList()).stream().sorted(comp).collect(Collectors.toList());
		ArrayList<DepartmentManager> temp2=new ArrayList<>(temp1);
        return temp2;		
		
		
	
		
	}

	
	public void setAllEmployees(HashMap<String, Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public HashMap<String, Customer> getAllCustomers() {
		return allCustomers;
	}

	public void setAllCustomers(HashMap<String, Customer> allCustomers) {
		this.allCustomers = allCustomers;
	}

	public HashMap<String, VehicleTransportation> getAllVehicleTransportation() {
		return allVehicleTransportation;
	}

	public void setAllVehicleTransportation(HashMap<String, VehicleTransportation> allVehicleTransportation) {
		this.allVehicleTransportation = allVehicleTransportation;
	}

	public HashMap<String, Deal> getAllDeals() {
		return allDeals;
	}

	public void setAllDeals(HashMap<String, Deal> allDeals) {
		this.allDeals = allDeals;
	}

	public HashMap<Integer, Department> getAllDepartments() {
		return allDepartments;
	}

	public void setAllDepartments(HashMap<Integer, Department> allDepartments) {
		this.allDepartments = allDepartments;
	}

	public static Factory getEnterpise() {
		return factory;
	}
	public static void setEnterpise(Factory enterpise) {
		Factory.factory = enterpise;
	}

	
	
}

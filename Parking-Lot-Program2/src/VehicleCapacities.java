import java.util.ArrayList;
public class VehicleCapacities {
	
	//Declared all the vehicles types capacity 
	private final int truckCapacity = 4;
	private final int carCapacity = 16;
	private final int vanCapacity =  14;
	private final int TotalVehicleCapacity = 34;
	
	parkingLot inLot; //Initial the object for use of the class

	//Initially no vehicle park and non is blocked 
	private int truckPark=0, carPark=0, vanPark=0, tktNumAssnVeh=0;
	private int blockedVehicles=0;
	
	public void AllTypesVehicles()
	{
		System.out.println("Total Cars capacities in the parking lot are:" + carCapacity
				           + "\nTotal Vans capacities in the parking lot are:" + vanCapacity
				           +"\nTotal Trucks capacities in the parking are:" + truckCapacity);
	}
	
	public void truckParking()
	{   
		if(truckPark == truckCapacity)
		{   
			blockedVehicles++;
			System.out.println("Speaking to Customer: There is no more space to park anymore Truck");
		}
		else 
		{
			truckPark++;
			tktNumAssnVeh++;
			inLot.findClosestParkingSpaceToPark("TRUCK", truckPark);
		}
	}
	
	public void carParking()
	{
		if(carPark == carCapacity)
		{   
			blockedVehicles++;
			System.out.println("Speaking to Customer: There is no more space to park any Car");
		}
		else
		{
			carPark++;
			tktNumAssnVeh++;
			inLot.findClosestParkingSpaceToPark("CAR", carPark);
		}
	}
	
	public void vanParking()
	{   
		if(vanPark == vanCapacity)
		{ 
			blockedVehicles++;
			System.out.println("Speaking to Customers: There is no more space to park anymore Van");
		}
		else 
		{
			vanPark++;
			tktNumAssnVeh++;
			inLot.findClosestParkingSpaceToPark("VAN", vanPark);
		}
	}
	
	public int getTotalVehicleCapacity()
	{
		return TotalVehicleCapacity;
	}

	public int gettruckPark() 
	{
		return truckPark;
	}

	public int getcarPark() 
	{
		return carPark;
	}

	public int getvanPark() 
	{
		return vanPark;
	}
	
	public int getRemainSpaceForTruck()
	{		
		return truckCapacity-truckPark;
	}
	
	public int getRemainSpaceForVan()
	{
		return vanCapacity-vanPark;		
	}
	
	public int getRemainSpaceForCar()
	{
		return carCapacity-carPark;		
	}
	
	public int getTruckCapacity() {
		return truckCapacity;
	}

	public int getCarCapacity() {
		return carCapacity;
	}

	public int getVanCapacity() {
		return vanCapacity;
	}
	
	public int NoMoreSpaceForVehicles()
	{
		return blockedVehicles;
	}
	
	public int gettktNumAssnVeh()
	{
		return tktNumAssnVeh;
	}
	
	public void graphImplementation() {
		
	ArrayList <Vertex> ThePLT = new ArrayList<Vertex>();
	
	ThePLT.add(new Vertex(0, 1, 4));
	ThePLT.add(new Vertex(0, 17, 8));
	ThePLT.add(new Vertex(0, 21, 10));
	ThePLT.add(new Vertex(0, 14, 14));
	ThePLT.add(new Vertex(1, 2, 2));
	ThePLT.add(new Vertex(2, 3, 2));
	ThePLT.add(new Vertex(3, 4, 2));
	ThePLT.add(new Vertex(4, 5, 2));
	ThePLT.add(new Vertex(5, 6, 2));
	ThePLT.add(new Vertex(6, 7, 2));
	ThePLT.add(new Vertex(7, 8, 2));
	ThePLT.add(new Vertex(8, 9, 2));
	ThePLT.add(new Vertex(9, 10, 2));
	ThePLT.add(new Vertex(10, 31, 3));
	ThePLT.add(new Vertex(31, 32, 2));
	ThePLT.add(new Vertex(32, 26, 3));
	ThePLT.add(new Vertex(17, 18, 2));
	ThePLT.add(new Vertex(18, 19, 2));
	ThePLT.add(new Vertex(19, 20, 2));
	ThePLT.add(new Vertex(20, 11, 2));
	ThePLT.add(new Vertex(11, 12, 2));
	ThePLT.add(new Vertex(12, 13, 2));
	ThePLT.add(new Vertex(13, 33, 2));
	ThePLT.add(new Vertex(33, 31, 2));
	ThePLT.add(new Vertex(21, 22, 2));
	ThePLT.add(new Vertex(22, 23, 2));
	ThePLT.add(new Vertex(23, 24, 2));
	ThePLT.add(new Vertex(24, 25, 2));
	ThePLT.add(new Vertex(25, 26, 2));
	ThePLT.add(new Vertex(14, 15, 2));
	ThePLT.add(new Vertex(15, 16, 2));
	ThePLT.add(new Vertex(16, 27, 2));
	ThePLT.add(new Vertex(27, 28, 2));
	ThePLT.add(new Vertex(28, 29, 2));
	ThePLT.add(new Vertex(29, 30, 2));
	ThePLT.add(new Vertex(30, 34, 2));
	ThePLT.add(new Vertex(34, 32, 2));
	
	int [][] graph = new int [getTotalVehicleCapacity()+1] [getTotalVehicleCapacity()+1];
	
	for(int i=0; i<ThePLT.size(); i++)
	{	
		graph [ThePLT.get(i).getStartVertex()] [ThePLT.get(i).getEndVertex()] = ThePLT.get(i).getWeight(); 
	}
	
	parkingLot theLot = new parkingLot(getCarCapacity(), getVanCapacity(), getTruckCapacity());
	theLot.DijkstarAlg(graph);
	inLot = theLot;
	}
	
	public parkingLot ArrngLot()
	{
		return inLot;
	}
}

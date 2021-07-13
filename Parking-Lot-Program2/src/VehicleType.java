import java.util.*;
public class VehicleType extends VehicleCapacities{

	private String [] VehiclesTypes = {"CAR,", "VAN,", "TRUCK"};
	
	private int NotAllowedVehicleSize=0;
	
	public void getVehiclesTypes()
	{
		List<String> a = new ArrayList<>(Arrays.asList(VehiclesTypes));
		System.out.print("Types of Vehicles are allow to park here are: ");
		a.forEach(x->{System.out.print(x);});
	}
	protected void RestrictionParking()
	{
		NotAllowedVehicleSize++;
		System.out.println("Speaking to Customer: Any Vehicle other than: "+ Arrays.toString(VehiclesTypes) + " are not allow to park here.");
	}
	
	public int getNotAllowedVehicleSize()
	{
		return NotAllowedVehicleSize;
	}
}

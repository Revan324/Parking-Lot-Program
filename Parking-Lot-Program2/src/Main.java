import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class Main {

	static Scanner ask = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Random random = new Random();
		int Range = random.nextInt(51-33)+33;
		VehicleType Types = new VehicleType();
		
		
		Types.getVehiclesTypes();
	    int TotalVehiclesCapacity = Types.getTotalVehicleCapacity();

	    System.out.println("\n");
	   
		System.out.println("Total amount Vehicles capacity is: " + TotalVehiclesCapacity);
	    System.out.println();
		Types.AllTypesVehicles();
	   
		
		String [] VehiclesWaiting1={"CAR","BUS","TRUCK","VAN","MOTORCYCLE"};
		String k = null;
		VehicleEntering en = new VehicleEntering(Range);
		en.graphImplementation(); //designing the parking lot by creating & connecting all the vertices with distances.
		for(int i=0;i<Range;i++)
		{   
			k = VehiclesWaiting1[random.nextInt(VehiclesWaiting1.length)];
			en.Enqueue(k);
		}
		
		Static(en);
		System.out.println();
	
		System.out.print("Do you want to create your own vehicles lines?, Press Y or y for Yes: ");
		String Decision = ask.next();
	
		if(Decision.toUpperCase().charAt(0)=='Y')
		{      
			System.out.println("\nCreate a line of vehicles separate by comma such as (Van,Truck,Car): ");
			String VehiclesTypes = ask.next();
			String [] StoreVehicles = VehiclesTypes.toUpperCase().split(",");
			int lengthOfLines = StoreVehicles.length;
			String c = null;
			VehicleEntering Lines1 = new VehicleEntering(lengthOfLines);
	        Lines1.graphImplementation();	
			for(int i=0; i<StoreVehicles.length; i++)
			{
				c=StoreVehicles[i];
				Lines1.Enqueue(c);
			}        
        
			Static(Lines1);
		} 
	
		System.out.println();
		System.out.println("End of Project!!!");
		en.inLot.credential();
}


public static void Static(VehicleEntering Lines)
{
    Lines.NumberOfVehicles();
	Lines.StoringVehicles();
	System.out.println();
	System.out.println("The vehicles line ordered that parked in the lot:");
    Lines.AllVehiclesEntr();
	System.out.println();
	System.out.println("The amount of Vehicles that were not allowed to park here are: "+Lines.getNotAllowedVehicleSize());
	System.out.println("The amount of Vehicles that were reject to parked here due to shortess of space is: " +Lines.NoMoreSpaceForVehicles());
	System.out.println("The amount of Car parked in the lots are: "+ Lines.getcarPark());
	System.out.println("The amount of Van parked in the lots are: "+ Lines.getvanPark());
	System.out.println("The amount of Truck parked in the lots are: "+ Lines.gettruckPark());
	System.out.println("The Remaining space left for more Truck to Park is: " +Lines.getRemainSpaceForTruck());
	System.out.println("The Remaining space left for more Van to Park is:"+Lines.getRemainSpaceForVan());
	System.out.println("The Remaining space left for more Car to Park is:"+Lines.getRemainSpaceForCar());
    System.out.println("The total amount of Vehicles parked are: " + Lines.gettktNumAssnVeh());
    System.out.print("\nDo you want to know the parking spot for any vehicle that have parked? Press y for Yes: ");
    String option = ask.next().toUpperCase();
    if(option.charAt(0)=='Y')
    {
    	 System.out.print("Enter the position(n^th number) of the vehicle that had entered the parking lot: ");
    	 int inpss = ask.nextInt();
    	 Lines.locatVehPrk(inpss);
    }
   
}

    
	
}
import java.util.stream.Stream;
import java.util.Iterator;
public class VehicleEntering extends VehicleType{
	private String [] VehiclesLines; //Once you give capacity to it, it works then only
	private int size= 0, front = 0, rear=0;
	
	private String [] vehTypesInOrder = new String [getTotalVehicleCapacity()];
	
	public VehicleEntering(int capacity)
	{
		VehiclesLines = new String [capacity];
		ResetQueue();
	}
	public void ResetQueue()
	{   
		front = 0;
	    rear = 0;
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	public void NumberOfVehicles()
	{
		long TotalVehicles = Stream.of(VehiclesLines).count();
		System.out.println("Total numbers of vehicles waiting on the line to park are:" + TotalVehicles + "\n");
	}
		
	protected void StoringVehicles()
	{
		Iterator<String> iter = Stream.of(VehiclesLines).iterator();
		while(iter.hasNext())
		{
			String checkingVehicles = iter.next();
			int lastBlockVeh = NoMoreSpaceForVehicles(); // check if any vehicles get block due to shortness
			                                               // of space
			if(checkingVehicles.equals("CAR"))
			{   
				carParking();
				if(lastBlockVeh == NoMoreSpaceForVehicles())
				{
					assgnTicketToVehicles("car");
				}
			}
			else if(checkingVehicles.equals("VAN"))
			{
				vanParking();
				
				if(lastBlockVeh == NoMoreSpaceForVehicles())
				{
					assgnTicketToVehicles("van");
				}
				
			}
			else if(checkingVehicles.equals("TRUCK"))
			{
				truckParking();
				
				if(lastBlockVeh == NoMoreSpaceForVehicles())
				{
					assgnTicketToVehicles("truck");
				}
			}
			else
			{
				RestrictionParking();
			}
		}
	}
		
		public void Enqueue(String vehicles)
		{    
			try{
			VehiclesLines[rear] = vehicles;
			rear++;
			size++;
			}
			catch (Exception e)
			{
				System.out.println("not working");
			}
		}
		
		public void assgnTicketToVehicles(String type)
		{
			if(type.toLowerCase().equals("car") )
			{
				vehTypesInOrder[gettktNumAssnVeh()] = "car";
			}
			else if(type.toLowerCase().equals("van"))
			{
				vehTypesInOrder[gettktNumAssnVeh()] = "van";
			}
			else if (type.toLowerCase().equals("truck"))
			{
				vehTypesInOrder[gettktNumAssnVeh()] = "truck";
			}
		}
		
		public void locatVehPrk(int vehNum)
		{
			if(vehNum < 1)
			{
				System.out.println("Invalid entry");
			}
			else if(vehTypesInOrder[vehNum] == null || vehNum >= vehTypesInOrder.length)
			{
				System.out.println("out of bound");
			}
			else 
			{
			  String vehType = vehTypesInOrder[vehNum];
			  int count = 0;
			
			  for(int i = 1; i<=vehNum; i++)
			  {
				 if(vehTypesInOrder[i] == vehType)
				  {count++;}
			  }
			  if(vehType.toLowerCase().equals("car"))
			  {
				  System.out.println("\nThe vehicle is a CAR and located at parking spot " + inLot.getParkLoc(count));
			  }
			  else if(vehType.toLowerCase().equals("van"))
			  {
				  count += getCarCapacity();
				  System.out.println("\nThe vehicle is a VAN and located at parking spot " + inLot.getParkLoc(count));
			  }
			  else if(vehType.toLowerCase().equals("truck"))
			  {   
				  count += getCarCapacity() + getVanCapacity();
				  System.out.println("\nThe vehicle is a TRUCK and located at parking spot " + inLot.getParkLoc(count));
			  }
			  }
		}
		public void AllVehiclesEntr()
		{
			for(int i=vehTypesInOrder.length-1; i>0; i--)
			{
				if (vehTypesInOrder[i] != null && i!=1)
					System.out.print(vehTypesInOrder[i] + " --> ");
			}
				System.out.println(vehTypesInOrder[1] + " ==> " + "Entrance");
		}
	}


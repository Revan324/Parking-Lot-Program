import java.util.*;
public class parkingLot {
 
	private int carCapacity, vanCapacity, truckCapacity;
	private int ttVehicles;
	private int [] allVisitedNode; 
	private int [] vehiclesParked; //Use to store all the parked vehicles with the indexes represent the parking spot

	public parkingLot(int carCapacity, int vanCapacity, int truckCapacity)
	{
		this.carCapacity = carCapacity;
		this.vanCapacity = vanCapacity;
		this.truckCapacity = truckCapacity;
		
		ttVehicles = (carCapacity + vanCapacity + truckCapacity + 1);
		
		allVisitedNode = new int [ttVehicles];
		vehiclesParked = new int [ttVehicles];
	}
	
	public void DijkstarAlg(int [][] grp)
	{
		int finFrAll = 0;
		int initial = 0;
		
		Map<Integer,Integer> collVer = new HashMap<Integer,Integer>();
		
		while(finFrAll<grp.length)
		{
		    if(grp[initial][finFrAll] > 0)
		    {
		    	collVer.put(finFrAll, grp[initial][finFrAll]);
		    }
			finFrAll++;
		}
		
		while (!collVer.isEmpty()) {
		  
			int srtP = collVer.get(collVer.keySet().iterator().next());  //Initialize the shortest path distance
			int srtV = collVer.keySet().iterator().next();   //Initialize the shortest vertex
		
			Set<Map.Entry<Integer, Integer>> obj = collVer.entrySet();
		
			for(Map.Entry<Integer, Integer> i: obj)
			{
				if(srtP > i.getValue())
				{
					srtV = i.getKey();           //Contain the distance 
					srtP = i.getValue();         //Contain the Vertex or Node;
				}
			}
		
			Relaxation(srtV, srtP);
			collVer.remove(srtV);
		
			for(int i=0; i<grp.length; i++)
			{
				if(grp[srtV] [i] != 0)
				{
					collVer.put(i , grp[srtV] [i] + srtP);
				}
			} 
	
		}  
	}
	
	public void Relaxation(int visitedNode, int distance)
	{
		if(allVisitedNode[visitedNode] == 0)
		{
			allVisitedNode[visitedNode] = distance;
		}
		else if(allVisitedNode[visitedNode] !=0 && allVisitedNode[visitedNode]>distance)
		{
			allVisitedNode[visitedNode] = distance;
		}
	}
	
	public void findClosestParkingSpaceToPark(String vehiclesType, int vehiclesTypeNum)   
	{
		int i = 0;
		int j = 0;
		int parkSp = 0;
		
		if(vehiclesType.toLowerCase().equals("car"))
		{
			i = 0;
			j = carCapacity + 1;
			
			if(vehiclesTypeNum == i+1) 
			{	
				parkSp = finFirPark(vehiclesTypeNum, j);
				vehiclesParked[vehiclesTypeNum] = parkSp;
			}
		}
		
		else if(vehiclesType.toLowerCase().equals("van"))
		{
			i = carCapacity;
			j = carCapacity + vanCapacity + 1;			
			vehiclesTypeNum += i; 
			
			if(vehiclesTypeNum == i+1) 
			{	
				parkSp = finFirPark(vehiclesTypeNum, j);
				vehiclesParked[vehiclesTypeNum] = parkSp;
			}
		}
		else if(vehiclesType.toLowerCase().equals("truck"))
		{
			i = carCapacity + vanCapacity;
			j = ttVehicles;			
			vehiclesTypeNum += i; 
			
			if(vehiclesTypeNum == i+1) 
			{	
				parkSp = finFirPark(vehiclesTypeNum, j);
				vehiclesParked[vehiclesTypeNum] = parkSp;
			}
		}
		
		if(vehiclesTypeNum > i+1) 
		{
			int lastParkSpot = vehiclesParked[vehiclesTypeNum - 1]; // giving me the previous vertex
			int lastParkDis = allVisitedNode[lastParkSpot];         // giving me the distance 
			int tempParkDis = 0;
			int tempParkSp = 0;
			for(int o=i+1; o<j; o++)
			{
				if(lastParkDis == allVisitedNode[o])
				{	
					int l = i+1;
					boolean found = false;
					while(vehiclesParked[l] != 0 && l <= j)
					{
						if(vehiclesParked[l] == o) {
							found = true;
							break;
						}
						l++;
					}
					if(found == false)
					{
						tempParkSp = o;
						break;
					}
				}
			
				else if(lastParkDis < allVisitedNode[o])
				{
					if(tempParkDis > lastParkDis && tempParkDis > allVisitedNode[o]) 
					{
						tempParkSp =  allVisitedNode[o];
					}
				
				else if(tempParkDis == 0)
				{
					tempParkDis = allVisitedNode[o];
					tempParkSp = o;
				}
				}
			}
		vehiclesParked[vehiclesTypeNum] = tempParkSp;		
		}
	}
	
	public int finFirPark(int strt, int end)   //find the 1st parking for each types of vehicle with the most shortest path
	{
		int firParkDis = allVisitedNode[strt];
		int firParkSp = strt;
		for(int i=strt+1; i<end; i++)
		{
			if(firParkDis > allVisitedNode[i])
			{
				firParkDis = allVisitedNode[i];
				firParkSp = i;
			}
		}
		return firParkSp;
	}
	
	public int getParkLoc(int i)
	{
		return vehiclesParked[i];
	}
	
	public void credential()
	{
		System.out.println("Created and Designed by: Mohammad R. Hassan");
	}
}

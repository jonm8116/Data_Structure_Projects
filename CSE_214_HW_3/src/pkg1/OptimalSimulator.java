//package pkg1;
//import java.util.ArrayList;
//public class OptimalSimulator {
//	//This simulator is meant to optimize the simulator
//	//defined in the previous simulator
//	/*
//	 * How to break down this problem
//	 * Pick up requests that are in the same direction 
//	 */
//	public static void simulate(double probability, int numFloors, int numElevs, int timeSim){
//		if(probability<0.0 || probability>1.0 || timeSim<0){
//			System.out.println("No simulation");
//		}
//		//variables  needed for simulation
//		OptimalElevator[] elevArray = new OptimalElevator[numElevs];
//		//RequestQueue queue = new RequestQueue();
//		ArrayList requestList = new ArrayList<Request>();
//		int posOfElevStorage = 0;
//		//Elevator elevator = new Elevator();
//		OptimalElevator elevator;
//		
//		BooleanSource elevatorRequest = new BooleanSource(probability);
//		
//		boolean debug = false;
//		
//		int timelapsed;
//		int totalWaitTime=0;
//		int totalPassengers=0;
//		//loop to initialize the array of elevators
//		for(int i=0; i<elevArray.length; i++){
//			elevArray[i] = new OptimalElevator();
//		}
//		elevator = elevArray[posOfElevStorage];
//		for(timelapsed =1; timelapsed<=timeSim; timelapsed++){
//			//Event 1: When a request has arrived
//			if(elevatorRequest.requestArrived()){
//				Request request = new Request(numFloors);
//				request.setTimeEntered(timelapsed);
//				requestList.add(request);
//				if(debug){
//					System.out.println("A request has arrived");
//				}
//			}
//			for(int i=0; i<elevArray.length; i++){
//				if(elevArray[i].getRequest() != null){
//					elevator = elevArray[i];
//					if(debug)
//						System.out.println("Taking elevator " + i);
//				}
//				if(elevArray[i].getRequest()==null && !requestList.isEmpty()){
//					elevator = elevArray[i];
//				}
//				//Event 2: If elevator is idle
//				//then elevator switches to source
//				if(elevator.getElevatorState()==0 && !requestList.isEmpty()){
//					elevator.setRequest((Request)requestList.get(0));
//					requestList.remove(0);
//					totalPassengers= totalPassengers+1;
//					//change this 
//					if(elevator.getRequest().getSourceFloor()>elevator.getCurrentFloor()){
//						elevator.setElevatorState(1);
//						elevator.setCurrentFloor(elevator.getCurrentFloor()+1);
//					}
//					else if(elevator.getRequest().getSourceFloor()==elevator.getCurrentFloor()){
//						elevator.setElevatorState(2);
//						if(debug){
//							System.out.println("The elevator has reached the passenger");
//						}
//					}
//					else{
//						elevator.setElevatorState(1);
//						elevator.setCurrentFloor(elevator.getCurrentFloor()-1);
//					}
//					/*
//					 * NEED TO FIGURE OUT HOW TO SEARCH THOURGH REQUEST QUEUE FOR FLOORS
//					 */
//				}
//				//Case 3: Dealing with TO_SOURCE
//				if(elevator.getElevatorState()==1){
//					if(elevator.getCurrentFloor()< elevator.getRequest().getSourceFloor()){
//						elevator.setCurrentFloor(elevator.getCurrentFloor()+1);
//					}
//					else if(elevator.getCurrentFloor()== elevator.getRequest().getSourceFloor()){
//						elevator.setElevatorState(2);
//						totalWaitTime += timelapsed - elevator.getRequest().getTimeEntered();
//						if(debug){
//							System.out.println("The elevator has reached its source.\nTotal wait time is " + totalWaitTime);
//						}
//					}
//					else{
//						elevator.setCurrentFloor(elevator.getCurrentFloor()-1);
//					}
//				}
//				//Event 4: Elevator gets to source and moves to destination
//				//be careful how you are using elevator state
//				if(elevator.getElevatorState()==2){
//					if(elevator.getCurrentFloor() < elevator.getRequest().getDestinationFloor()){
//						elevator.setCurrentFloor(elevator.getCurrentFloor()+1);
//					}
//					else if(elevator.getCurrentFloor()==elevator.getRequest().getDestinationFloor()){
//						elevator.setElevatorState(0);
//						elevator.setRequest(null);
//						if(debug){
//							System.out.println("The elevator reached the destination");
//						}
//					}
//					else{
//						elevator.setCurrentFloor(elevator.getCurrentFloor()-1);
//					}
//				}
//			
//			}
//		} //End of big loop 
//		//Now calculate the avg wait time 
//		int avgWaitTime = totalWaitTime / totalPassengers;
//		System.out.println("SIMULATION COMPLETE!");
//		System.out.println("Total wait time: " + totalWaitTime +"\n" + "Total Passengers: " + totalPassengers);
//		System.out.println("The average waiting time for an elevator is " + avgWaitTime + " seconds");
//	}
//}

/**
 The Habitable Zone Calculator

 Author: Xenia Beltei
 Description: Outputs the inner and outer edge of the habitable zone for a one-star or a binary stars systems.
 */
 
//Import packages
import java.util.Scanner;

public class HabitableZone
{	
	//Declaring constants
	public static final double sigma = 5.67E-8; //in W/(m^2*K^4), the Stefan-Boltzmann constant
	public static final double dt = 1/365.25; 		//Time equivalent to one mean solar day in years, needed for binary system case
    public static final double tmax = dt*500; 		//Duration of the simulation - can be a random big enough number that could provide sufficient data for the graph
    public static final double intensityEarth = 1361.8; //in W/m^2, the intensity of the sunlight received on Earth
	public static final double luminositySun = 3.83E26; //W, the absolute luminosity of the Sun
   
	public static void main(String [] args) //start of the program
	{
		Scanner kb = new Scanner(System.in); //to use the keyboard for input
		
		String answer; //declaring the variable for the answer
		
		//declaring the variables needed for further calculations
		double radiusStar1, radiusStar2, tempStar1, tempStar2, distance, innerBoundHZ, outerBoundHZ, lum; 
		
		System.out.println("Is this a binary system? (Yes or No): ");
		answer = kb.nextLine();
		
		//BINARY STAR SYSTEM CASE
		if(answer.equals("Yes")||answer.equals("yes"))
		{
			System.out.println("Please enter the radius of the star1 in meters (Use \"E\" to use the exponent of base 10) :");
			radiusStar1 = kb.nextDouble();
			System.out.println("Please enter the radius of the star2 in meters (Use \"E\" to use the exponent of base 10) :");
			radiusStar2 = kb.nextDouble();
			System.out.println("Please enter the temperature of the star1 in kelvin: ");
			tempStar1 = kb.nextDouble();
			System.out.println("Please enter the temperature of the star2 in kelvin: ");
			tempStar2 = kb.nextDouble();
			
			int imax = (int)(tmax/dt); //maximal index, length of the arrays
	
			//In astronomical units
		
			double xplan0 = 0; //the initial x-position of the planet in AU
			double xstarone0 = -0.15;  //the initial x-position of the star1 in AU
			double xstartwo0 = 0.15; //the initial x-position of the star2 in AU
		
			//The distances from the 3 bodies to the center of mass of the system
			//Center of mass of the system located at (0,0)
			double radiusPlanet = 1; 
			double radStar1 = 0.1;
			double radStar2 = 0.1;
		
			//ASSUMING CIRCULAR ORBITS
			//The initial y-positions of the three bodies in AU calculated from the general form of the equation of a circle
			double yplan0 = Math.sqrt(Math.pow(radiusPlanet,2) - Math.pow( xplan0, 2));
			double ystarone0 = Math.sqrt(Math.pow(radStar1,2) - Math.pow( (xstarone0+1), 2));
			double ystartwo0 = Math.sqrt(Math.pow(radStar2,2) - Math.pow( (xstartwo0-1), 2));
			
			//Allocate memory to store positions and accelerations for the three bodies
			double [] time = new double[imax];

			double [] xposplanet = new double [imax]; 
			double [] yposplanet = new double [imax];

			double [] xposstar1 = new double [imax];
			double [] yposstar1 = new double [imax];
			
			double [] xposstar2 = new double [imax];
			double [] yposstar2 = new double [imax];
			
			double luminosity1 = 0;
			double luminosity2 = 0;
			
			time[0] = 0; 
			
			//Initializing the positions
			xposplanet[0] = xplan0;
			xposstar1[0] = xstarone0;
			xposstar2[0] = xstartwo0;

			yposplanet[0] = yplan0;
			yposstar1[0] = ystarone0;
			yposstar2[0] = ystartwo0;
			
			//calculation of the luminosity of both stars
			luminosity1 = absoluteLuminosity(radiusStar1,tempStar1);
			
			luminosity2 = absoluteLuminosity(radiusStar2,tempStar2);
			
			time[1] = time[0] + dt;
				
			double theta = 0.1;
			double w = 0.1;
		
			//shifting the positions of the bodies into their orbits
			//calculating the first elements of the positions
			xposplanet[1] = xposplanet[0] + radiusPlanet*Math.cos(theta + w);
			xposstar1[1] = xposstar1[0] + radStar1*Math.cos(theta + w);
			xposstar2[1] = xposstar2[0] + radStar2*Math.cos(theta + w);
	
			yposplanet[1] = yposplanet[0] + radiusPlanet*Math.sin(theta + w);
			yposstar1[1] = yposstar1[0] + radStar1*Math.sin(theta + w);
			yposstar2[1] = yposstar2[0] + radStar2*Math.sin(theta + w);
			
			//incrementing theta
			double newTheta = 0.2;
		
			//The loop to get datapoints at different positions
			for(int i = 2; i < imax; i++) 
			{
				//update time
				time[i] = time[i-1] + dt;
			
				//update theta		
				newTheta = newTheta + w;
			
				//calculating new x-positions
				xposplanet[i] = xposplanet[0] + radiusPlanet*Math.cos(newTheta);
				xposstar1[i] = xposstar1[0] + radStar1*Math.cos(newTheta);
				xposstar2[i] = xposstar2[0] + radStar2*Math.cos(newTheta);
			
				//calculating new y-positions
				yposplanet[i] = yposplanet[0] + radiusPlanet*Math.sin(newTheta);
				yposstar1[i] = yposstar1[0] + radStar1*Math.sin(newTheta);
				yposstar2[i] = yposstar2[0] + radStar2*Math.sin(newTheta);
		
			}
				
			double absLum1Converted, absLum2Converted;
			
			//converting the luminosities to get them relative to the Sun's luminosity
			absLum1Converted = luminosity1/luminositySun;
			absLum2Converted = luminosity2/luminositySun;
			innerBoundHZ = innerBoundaryHZ((absLum1Converted+absLum2Converted));
			outerBoundHZ = outerBoundaryHZ((absLum1Converted+absLum2Converted));
			
			//output
			System.out.print("For stars with a radius of " + radiusStar1 + "meters for star 1 and " + radiusStar2 + "meters for star 2, ");
			System.out.print("the extended habitable zone of the two stars is between " + innerBoundHZ + "AU and " + outerBoundHZ + "AU. ");
			
		}
		
		//REGULAR, ONE STAR SYSTEM CASE
		else
		{
			System.out.println("Please enter the radius of the star in meters (Use \"E\" to use the exponent of base 10): ");
			radiusStar1 = kb.nextDouble();
			System.out.println("Please enter the temperature of the star in kelvin: ");
			tempStar1 = kb.nextDouble();
			System.out.println("Please enter the distance from the planet to the star (Use \"E\" to use the exponent of base 10): ");
			distance = kb.nextDouble();
			
			double iReceived1, iReceivedConverted, absLumConverted;
			
			//calculations for luminosity and intensity, also their convertation relative to the Sun's luminosity and Earth's R-intensity
			lum = absoluteLuminosity(radiusStar1,tempStar1);
			absLumConverted = lum/luminositySun;
			iReceived1 = intensityReceived(distance,lum);
			iReceivedConverted = iReceived1/intensityEarth;
			innerBoundHZ = innerBoundaryHZ(absLumConverted);
			outerBoundHZ = outerBoundaryHZ(absLumConverted);
			
			//output for the values of the size of the HZ
			System.out.print("For a star with a radius of " + radiusStar1 + " meters and a planet orbiting around it at a distance of " + distance + " meters ");
			System.out.print("the extended habitable zone of the star is between " + innerBoundHZ + "AU and " + outerBoundHZ + "AU. ");
			
			//output for the planet's temperature
			if(iReceivedConverted<1)
			{
				double percentPrint = iReceivedConverted*100;
				System.out.println("The planet will be cooler than the Earth. It receives " + percentPrint + "%" + " of starlight that Earth receives from the Sun.");
			}
			else if(iReceivedConverted==1)
			{	
				double percentPrint = iReceivedConverted*100;
				System.out.println("The planet will receive the same amount of starlight as the Earth.");
			}
			else
			{
				double percentPrint = iReceivedConverted*100;
				System.out.println("The planet will be hotter than the Earth. It receives " + percentPrint + "%" + " of starlight that Earth receives from the Sun.");
			}
		}
	}
	/*
     The absoluteLuminosity method returns the value for the absolute luminosity of a star
    */
	public static double absoluteLuminosity(double radius, double temperature)
	{
		return sigma*Math.pow(temperature,4)*4*Math.PI*Math.pow(radius,2);
	}
	/*
	 The intensityReceived method returns the value for the received intensity of the starlight on a planet 
	*/
	public static double intensityReceived(double distance, double luminosity)
	{
		return luminosity/(4*Math.PI*Math.pow(distance,2));
	}
	/*
	 The innerBoundaryHZ method returns a value for the inner edge of the habitable zone
	*/
	public static double innerBoundaryHZ(double luminosity)
	{
		return Math.sqrt(Math.pow(0.95,2)*luminosity);
	}
	/*
	 The outerBoundaryHZ method returns a value for the outer edge of the habitable zone
	*/
	public static double outerBoundaryHZ(double luminosity)
	{
		return Math.sqrt(Math.pow(2.4,2)*luminosity);
	}
}

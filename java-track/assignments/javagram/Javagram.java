package javagram;

import javagram.filters.*;
import java.util.ArrayList;

import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;

//comment 

public class Javagram {
	
	private static ArrayList<Filter> filterList = new ArrayList<Filter>();
	
	public static void main(String[] args) {
		
		Filter blue = new BlueFilter();
		Filter grayscale = new GrayscaleFilter();
		Filter invert = new InvertFilter();

		filterList.add(blue);
		filterList.add(grayscale);
		filterList.add(invert);

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath = null;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "Path not set";
			
			//try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				//String[] relPathParts = relPath.split("\\");
				//imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				imagePath = (dir + "\\" + relPath);
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		boolean gotIndex = false;
		Filter filter = null;
		do {
			try {
				
				int choice = displayFilterMenu(in);
				// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
				filter = getFilter(choice);
				gotIndex = true;
				
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Index out of bounds.  Please select an item from the list.");
			} catch (InputMismatchException e) {
				System.out.println("Input must be a number from the list.  Please select an item from the list.");
				in.next();
			}
			
		} while(!gotIndex);
		
					

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		String fileName = null;
		String confirmSave = null;
		boolean restart = true;
		do {
			System.out.println("The original file was called " + relPath);
			System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
			fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
			restart = false;
				if (fileName.equals(relPath))
			{
				System.out.println("Are you sure you want to overwrite? Enter 'y' for yes:");
				confirmSave = in.next();
				if(confirmSave.equals("y") || confirmSave.equals("Y"))
				{
					String absFileName = dir + File.separator + fileName;
					processed.save(absFileName);
					System.out.println("Image saved to " + absFileName);
				} else {
					System.out.println("Please enter a different file name:");
					restart = true;
				}
			} else if (fileName.equals("exit")) {
				System.out.println("Image not saved");
			} else {
				String absFileName = dir + File.separator + fileName;
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			}	
		} while(restart);
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int choice) {
		
		// TODO - create some more filters, and add logic to return the appropriate one
		return filterList.get(choice - 1);
		
	}
	
	private static int displayFilterMenu(Scanner in)
	{
		
		System.out.println("Please select a Filter:");
		for(int i = 0; i < filterList.size(); i++)
		{
			System.out.println((i+1) + ".)" + filterList.get(i));
		}
		
		int selection = in.nextInt();
		return selection;
	}

}

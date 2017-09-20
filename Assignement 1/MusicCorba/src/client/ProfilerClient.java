package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import exceptions.UndefinedFonctionException;
import profileapp.Profiler;
import profileapp.ProfilerHelper;
import tools.IOFileParsing;

public class ProfilerClient {

	private static Profiler profilerImpl = null;
	private static final String pathInputFile = "./resources/input.txt";
	private static final String pathOutputFile = "./resources/output.txt";
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		File file = new File(pathOutputFile);
		// clean output file
		if (file.exists())
			if (!file.delete())
				System.err.println("Error : Imposible to clean the output file.");
		
		try
		{
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);
	
			// get the root naming context
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			// Use NamingContextExt instead of NamingContext. This is 
			// part of the Interoperable naming Service.  
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	
			// resolve the Object Reference in Naming
			String name = "Profiler";
			profilerImpl = ProfilerHelper.narrow(ncRef.resolve_str(name));
			
			// open input file
			br = new BufferedReader(new FileReader(pathInputFile));

		    // read the line line per line
		    String line = null;
		    while ((line = br.readLine()) != null)
		    {
		    	String[] tokens = IOFileParsing.parseLineTab(line);
	    		FormatRequest fr = new FormatRequest(tokens);
	    		int times = 0;
	    		long timesExec = 0, t1 = 0, t2 = 0;
	    		
	    		
	    		// call the right function
	    		if(fr.getNameFonction().equals("getTimesPlayed"))
	    		{
	    			t1 = System.currentTimeMillis();
		    		times = profilerImpl.getTimesPlayed(fr.getSongId());
	    			t2 = System.currentTimeMillis();
	    		}
	    		else if(fr.getNameFonction().equals("getTimesPlayedByUser")){
	    			t1 = System.currentTimeMillis();
		    		times = profilerImpl.getTimesPlayedByUser(fr.getUserId(), fr.getSongId());
		    		t2 = System.currentTimeMillis();
	    		}
	    		else
	    		{
	    			throw new UndefinedFonctionException(fr.getNameFonction());
	    		}
	    		
	    		
	    		timesExec = t2 - t1;
	    		// write the result in the output file
	    		IOFileParsing.writeInOutputLine(times, fr, timesExec, pathOutputFile);
		    		
		    }
	
		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
		finally
		{
			// close the buffer
			if (br!= null)
			{
				try {br.close();}
				catch (IOException e) {e.printStackTrace();}
			}
		}
	}

}

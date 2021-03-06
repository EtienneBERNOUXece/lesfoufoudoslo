package server;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;



import profileapp.Profiler;
import profileapp.ProfilerHelper;


public class ProfileServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length != 2)
		{
			System.out.println("Usage : Server True|False <song file>" );
			return;
		}
		try{
			Boolean cache = new Boolean(args[0]);
			String songFile = args[1];
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// get reference to rootpoa & activate the POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			// create servant and register it with the ORB
			ProfileServant helloImpl = new ProfileServant(cache, songFile);

			// get object reference from the servant
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
			Profiler href = ProfilerHelper.narrow(ref);

			// get the root naming context
			org.omg.CORBA.Object objRef =
					orb.resolve_initial_references("NameService");
			// Use NamingContextExt which is part of the Interoperable
			// Naming Service (INS) specification.
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// bind the Object Reference in Naming
			String name = "Profiler";
			NameComponent path[] = ncRef.to_name( name );
			ncRef.rebind(path, href);

			System.out.println("ProfilerServer ready and waiting ...");

			// wait for invocations from clients
			orb.run();
		} 

		catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}

		System.out.println("ProfilerServer Exiting ...");	}

}

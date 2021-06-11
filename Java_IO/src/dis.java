// have class FileInputStream
import java.io.*;
class dis
{ 
	public static void main(String args[]) throws IOException 
	{ 
		// writing data
	    try(DataOutputStream dout =
	                new DataOutputStream(
	                		new FileOutputStream(
	                				"D:\\eclipse-workspace\\java_io\\data\\datainputstream.txt")))
	    {
	        dout.writeDouble(1.1);
	        dout.writeInt(55);
	    }
	      
	    catch(FileNotFoundException ex)
	    {
	        System.out.println("Cannot Open the File");
	        return;
	    }
		
	    long startTime = System.nanoTime();
		// reading data back
		try(DataInputStream dis 
				= new DataInputStream(
						new FileInputStream(
								"D:\\eclipse-workspace\\java_io\\data\\datainputstream.txt")))
		{
			// illustrating readDouble() method
			double a = dis.readDouble();
			// illustrating readInt() method
			int b = dis.readInt();
			System.out.println("Values : " + a + " " + b);
		}
		catch(FileNotFoundException e)
        {
            System.out.println("Cannot Open the File");
            return;
        }
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Time open file execution: " + duration);
	} 
} 
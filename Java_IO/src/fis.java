import java.io.*; // have class FileInputStream
class fis
{ 
	public static void main(String args[]) throws IOException 
	{ 
		long startTime = System.nanoTime();
		//attach the file to FileInputStream 
		try(FileInputStream fis= new FileInputStream("D:\\eclipse-workspace\\java_io\\data\\fileinputstream.txt")) 
		{
		//illustrating getChannel() method 
		//System.out.println(fis.getChannel()); 

		//illustrating getFD() method 
		//System.out.println(fis.getFD()); 

		//illustrating available method 
		//System.out.println("Number of remaining bytes:"+fis.available()); 

		//illustrating skip method 
		/*Original File content: 
		Welcome to FileInputStream
		*/
		//fis.skip(4); // skip "Welc" in "Welcome to FileInputStream"
		//System.out.println("FileContents :"); 
		//read characters from FileInputStream and write them 
		int ch; 
		while((ch=fis.read())!=-1) 
			System.out.print((char)ch); 
		} catch (IOException e) {
            e.printStackTrace();
        } 
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("\nTime open file execution: " + duration);
	} 
} 
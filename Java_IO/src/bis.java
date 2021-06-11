import java.io.*;
class bis {
    public static void main(String args[]) throws IOException {
    	long startTime = System.nanoTime();
        try (BufferedInputStream bis = 
        	new BufferedInputStream(
        	new FileInputStream(
        	"D:\\eclipse-workspace\\java_io\\data\\bufferedinputstream")))
        {
            // illustrating available method 
            //System.out.println("Number of remaining bytes:" + bis.available());
            // illustrating markSupported() and mark() method 
            //boolean b = bis.markSupported();
            //if (b) bis.mark(bis.available());
            // illustrating skip method 
            /*Original File content:
             * This is my first line
             * This is my second line*/
            //bis.skip(4);
            //System.out.println("FileContents :");
            // read characters from FileInputStream and 
            // write them 
            int ch;
            while ((ch = bis.read()) != -1)
                System.out.print((char) ch);
            // illustrating reset() method 
            //bis.reset();
            //while ((ch = bis.read()) != -1)
                //System.out.print((char) ch);
        } catch (IOException e) {
            e.printStackTrace();
        } 
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("\nTime open file execution: " + duration);
    }
}
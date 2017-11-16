import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class rowsMultiplicationOutToFile{
	public static void main(String[] args){
		if(args.length>2){
			System.out.println("Too much arguments!");
		} else if(args.length<2){
			System.out.println("Too few arguments!");
		} else {
			try{
				rowsMultiplicatorWithBufferedReaderOtToFile(args[0],args[1]);
			} catch(IOException e) {
				System.err.println("Bad filename, or something else :)");
				e.printStackTrace();
			}
		}
	}
	
	public static void rowsMultiplicatorWithBufferedReaderOtToFile(String inFileName, String outFileName)
	throws IOException {
		// System.out.println(inFileName);
		// System.out.println(outFileName);
		
		File input = new File(inFileName);
		File output = new File(outFileName);
		
		try( 
		BufferedReader inFile = new BufferedReader(new FileReader(input));
		//BufferedReader outFile = new BufferedReader(new FileReader(output));
		PrintWriter pw = new PrintWriter(output);
		){
			String line;
			for(line = inFile.readLine(); line != null; line = inFile.readLine()){
				String line1 =  line;
				line = inFile.readLine();
				if(line != null){
					String[] res1 = line1.split(",");
					String[] res2 = line.split(",");
					int[] tmp = new int[res1.length];
					for(int i=0; i<res1.length; ++i){
						tmp[i] = Integer.parseInt(res1[i]) * Integer.parseInt(res2[i]);
					}
					System.out.println(Arrays.toString(res1));
					System.out.println(Arrays.toString(res2));
					System.out.println("*********");
					System.out.println(Arrays.toString(tmp));
					System.out.println(" ");
					pw.println(Arrays.toString(tmp));
				}
			}
		}
	}
}
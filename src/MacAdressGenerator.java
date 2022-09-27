import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MacAdressGenerator {

	public static String toMacString(long mac) {

	    if (mac > 0xFFFFFFFFFFFFL || mac < 0)
	        throw new IllegalArgumentException("mac out of range");

	    StringBuffer m = new StringBuffer(Long.toString(mac, 16));
	    while (m.length() < 12) m.insert(0, "0");

	    for (int j = m.length() - 2; j >= 2; j-=2)
	        m.insert(j, ":");
	    return m.toString().toUpperCase();
	}

	public static void main(String[] args) throws IOException {

		File fout = new File("C:/Users/CC-Student/Desktop/mac.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	    long mac = 0x001A79000000L;

	    for (long i = 0; i < 157772160; i++) {
//	        System.out.println(toMacString(mac++));
	    	bw.write(toMacString(mac++));
	    	bw.newLine();
		}
	 
		bw.close();
	}
	
}

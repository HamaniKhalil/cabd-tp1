/*
 * TP N°		: 01
 * Version N°	: 01
 * 
 * Titre du TP	: Nested Loops
 * 
 * Date			: 19 Octobre 2018
 * 
 * Nom			: Hamani
 * Prenom		: Khalil
 * N° Etudiant	: 21810826
 * 
 * Email		: hamani_khalil@yahoo.fr
 * 
 * Remarques	: N/A
 * 
 * */

/*
 * This one is for merge algorithms :
 * 
 * - Read from file and put to char array
 * - Read from char array and put to file
 * 
 * */


package HamaniKhalilTP1;

import static HamaniKhalilTP1.SystemConfiguration.BUFFER_SIZE;
import static HamaniKhalilTP1.SystemConfiguration.FIRST_ARRAY_ELEMENT_INDEX;
import static HamaniKhalilTP1.SystemConfiguration.THE_NONE_CHARACTER;

import java.io.File;


public class HamaniKhalilNestedLoop {

	public static final void joinWithNestedLoop(String rFilename, String sFilename, String rsFilename) {
		int	sReadLevel	= 0;
		int	rReadLevel	= 0;
		
		char []	r	= FileManager.fileToArray(rFilename, rReadLevel);
		char []	s	= FileManager.fileToArray(sFilename, sReadLevel);
		
		try {			
			while(s != null) {
				while(r != null) {
					FileManager.arrayToFile(nestedLoop(s, r), rsFilename);					
					r	= FileManager.fileToArray(rFilename, ++ rReadLevel);
				}
				s	= FileManager.fileToArray(sFilename, ++ sReadLevel);
			}
			
			// Create an empty file if the join returns no row
			File	rsFile	= new File(rsFilename);
			if(!rsFile.exists()) {
				rsFile.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Supposed to merge until the char array is full
	 * */
	public static final char [] joinUntilFull() {
		/*
		 * Not yet implemented
		 * */
		return null;
	}
	
	
	/**
	 * 
	 * @param s
	 * The first array to join
	 * @param r
	 * The second array to join
	 * @return
	 * The join array between the entered arrays
	 * @throws Exception
	 * In case one, or both, of the array entries exceeds the buffer limit
	 */
	
	public static final char [] nestedLoop(char [] r, char [] s) {
		if(r.length > BUFFER_SIZE || s.length > BUFFER_SIZE) {
			return null;
		}

		char [] rs		= new char[BUFFER_SIZE];
		int		index	= 0;
		for(int i = FIRST_ARRAY_ELEMENT_INDEX; i < r.length; i ++) {
			for(int j = FIRST_ARRAY_ELEMENT_INDEX; j < s.length; j ++) {
				if(r[i] == s[j] && index < BUFFER_SIZE) {
					rs[index ++]	= r[i];
				}
			}
		}
		return rs[FIRST_ARRAY_ELEMENT_INDEX] == THE_NONE_CHARACTER ?
				null :
					rs;
	}
}

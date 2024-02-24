import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private ArrayList<RDFTriple> rdfTripleList;
    private String fileName;
 
    public ListOfNumbers () {
        // create an ArrayList of Pairs of Integers
    }
    
    public ListOfNumbers (String fileName) {
        this();
        this.fileName = fileName;	
    }
    
    public ArrayList<RDFTriple> getRdfTripleList() {
    	return this.rdfTripleList;
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		// fill the existing list with RDFTriple objects
    		// of three numbers.
            this.rdfTripleList.add(
                new RDFTriple<Integer, Integer, Integer>(number1, number2, number3)
            );
    	}
    }
    
    public void readList() throws IOException {

        this.rdfTripleList = new ArrayList<RDFTriple>();

        try (FileReader f = new FileReader(this.fileName)){
            BufferedReader in = new BufferedReader(f);
            String line = null;
            while ((line = in.readLine()) != null) {
                String[] ln = line.split(" ");
                this.rdfTripleList.add(
                    new RDFTriple<Integer, Integer, Integer>(
                        Integer.parseInt(ln[0]), 
                        Integer.parseInt(ln[1]), 
                        Integer.parseInt(ln[2])
                    )
                );
            }
        }
    }
    
    public void writeList(String fileName) {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < rdfTripleList.size(); i++) {
                out.println(rdfTripleList.get(i).getSubj() + " " + rdfTripleList.get(i).getPred()+ " " + rdfTripleList.get(i).getObj());
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            // input = new RandomAccessFile(file, "r");
            // while ((line = input.readLine()) != null) {
            //     System.out.println(line);
            // }
            return;
        } finally {
            if (input != null) {
                // input.close();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
        listOfNumbers.writeList("outFile.txt");
    }

}

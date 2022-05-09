import java.io.*;
import java.util.*;

public class csv_availity
{

    static void sortFile(String csvFile) {
        System.out.println("Hello World!");
        {
            String line = "";
            String cvsSplitBy = ",";
            List<List<String>> llp = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    llp.add(Arrays.asList(line.split(cvsSplitBy)));
                }
                llp.sort(new Comparator<List<String>>() {
                    @Override
                    public int compare(List<String> o1, List<String> o2) {
                        //return o1.get(1).compareTo(o2.get(1).thenComparing);
                        String x1 = o1.get(1);
                        String x2 = o2.get(1);
                        int sComp = x1.compareTo(x2);

                        if (sComp != 0) {
                            return sComp;
                        }

                        String y1 = o1.get(2);
                        String y2 = o2.get(2);
                        return y1.compareTo(y2);
                    }
                });
                System.out.println(llp);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    static List<List<String>> sortData(List<String> insuranceData) {
        System.out.println("Hello World!");
        {

            List<List<String>> llp = new List<String>(insuranceData) {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<String> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(String s) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends String> c) {
                    return false;
                }

                @Override
                public boolean addAll(int index, Collection<? extends String> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public void clear() {

                }

                @Override
                public boolean equals(Object o) {
                    return false;
                }

                @Override
                public int hashCode() {
                    return 0;
                }

                @Override
                public String get(int index) {
                    return null;
                }

                @Override
                public String set(int index, String element) {
                    return null;
                }

                @Override
                public void add(int index, String element) {

                }

                @Override
                public String remove(int index) {
                    return null;
                }

                @Override
                public int indexOf(Object o) {
                    return 0;
                }

                @Override
                public int lastIndexOf(Object o) {
                    return 0;
                }

                @Override
                public ListIterator<String> listIterator() {
                    return null;
                }

                @Override
                public ListIterator<String> listIterator(int index) {
                    return null;
                }

                @Override
                public List<String> subList(int fromIndex, int toIndex) {
                    return null;
                }
            };
            llp.sort((o1, o2) -> {
                //return o1.get(1).compareTo(o2.get(1).thenComparing);
                String x1 = o1.get(1);
                String x2 = o2.get(1);
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                String y1 = o1.get(2);
                String y2 = o2.get(2);
                return y1.compareTo(y2);
            });
            //System.out.println(llp);
            return (llp);
        }
    }

    public static void main(String[] args) throws Exception
    {
//parsing a CSV file into Scanner class constructor
//Scanner sc = new Scanner(new File("C:\\Users\\nq0319\\Documents\\CSVDemo.csv"));
//sc.useDelimiter(",");   //sets the delimiter pattern
//while (sc.hasNext())  //returns a boolean value
//{
//String data = sc.next();
        //System.out.println(data + "***");
//}
//sc.close();  //closes the scanner
        int i,j,k;
        String x,y,z;
        try{
            //parsing a CSV file into Scanner class constructor
            Scanner sc = new Scanner(new File("C:\\Users\\nq0319\\Documents\\CSVDemo.csv"));
//sc.useDelimiter(",");   //sets the delimiter pattern
            List<String> insurnaceCompany = new ArrayList<String>(); //This will hold all Insurance company
            List<String> insuranceRec = new ArrayList<String>(); //This will hold all Insurance company and records
//HashMap<String, String> insuranceRec = new HashMap<String, String>();
            while (sc.hasNext())  //returns a boolean value
            {
                String data = sc.next();
                String[] parts = data.split(",");
                final String lastItem = parts[parts.length - 1];
                insurnaceCompany.add(lastItem);
//System.out.println("***"+lastItem + "***");
                insuranceRec.add(data);
//System.out.println(data + "***");
            }
//System.out.println(insurnaceCompany);
//System.out.println(insuranceRec);
            List<String> uniqueInsurance = new ArrayList<String>(new HashSet<String>(insurnaceCompany));//This will hold unique Insurance company
//System.out.println(uniqueInsurance);
            sc.close();

            for (i = 0; i < uniqueInsurance.size(); i++)
            {

                // accessing each element of array
                x = uniqueInsurance.get(i);
                //System.out.println(x + "&");
                String fileName="C:\\Users\\nq0319\\Documents\\"+x+".csv";
                File f = new File(fileName);
                FileWriter w = new FileWriter(f);
                List<String> insuranceData = new ArrayList<String>();
                for (j = 0; j < insuranceRec.size(); j++)
                {

// accessing each element of array
                    y = insuranceRec.get(j);
//System.out.println(y + "&&");
                    String[] insuranceLineRec = y.split(",");
                    final String lastToken = insuranceLineRec[insuranceLineRec.length - 1];
                    final String UserId = insuranceLineRec[0];
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&"+lastToken + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                    if (x.equals(lastToken)){
                        insuranceData.add(y);
//w.write(y);
//w.write("\n");
                    }
                }

//w.flush();
                System.out.println(insuranceData);
                List<List<String>> insuranceDataSorted= sortData(insuranceData);
                System.out.println(insuranceDataSorted);
//for (k = 0; k < insuranceDataSorted.size(); k++) {
//z = insuranceDataSorted.get(k);
//System.out.println(z);
//w.write(z);
//w.write("\n");
//w.flush();


            }



        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }


    }
}
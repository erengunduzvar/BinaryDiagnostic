import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class OxygenGenRate {
    int rate;
    private static int sizeOfNums = -1;
    public OxygenGenRate() {

        ArrayList<String> ones = new ArrayList<String>();
        ArrayList<String> zeros = new ArrayList<String>();

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if(sizeOfNums==-1)
                    sizeOfNums = data.length();

                System.out.println(data);
                if(data.charAt(0) == '0')
                {
                    zeros.add(data);
                    System.out.println("Ilk biti 0");
                }
                else
                {
                    ones.add(data);
                    System.out.println("Ilk biti 1");
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if(zeros.size()>ones.size())
        {
            System.out.println("0 seçildi");
            numberSkipper(1,zeros);
        }
        else{
            System.out.println("1 seçildi");
            numberSkipper(1,ones);
        }



    }
    private void numberSkipper(int level,ArrayList<String> EliminatedNums) //function finds a most popular bit in its level
    {
        ArrayList<String> ones = new ArrayList<String>();
        ArrayList<String> zeros = new ArrayList<String>();
        System.out.println("\n\n\n\n\n\n");

        if(level == sizeOfNums)
        {
            System.out.println(EliminatedNums);
            String LastNum = EliminatedNums.get(0);
            int totalAmount = 0;

            for (int i = 0 ; i<LastNum.length() ; i++)
            {
                if(LastNum.charAt(i) == '1') //ilk eleman 0
                {
                    totalAmount += Math.pow(2,(LastNum.length()-i-1));
                }
            }
            System.out.println(totalAmount);
            rate=totalAmount;

            return;
        }

        for (String number : EliminatedNums) {
            System.out.println(number);
            if(number.charAt(level) == '0')
            {
                zeros.add(number);
                System.out.println(level+"inci biti 0");
            }
            else
            {
                ones.add(number);
                System.out.println(level+"inci biti 1");
            }
        }

        if(zeros.size()>ones.size())
        {
            System.out.println("0 seçildi");
            numberSkipper(level+1,zeros);
        }
        else{
            System.out.println("1 seçildi");
            numberSkipper(level+1,ones);
        }

    }

}

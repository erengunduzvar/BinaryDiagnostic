import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void powerConsumption() {
        //gamma rate, epsilon rate
        // power Cons = gammaRate*epsilon rate
        ArrayList<Character> gammaRate = new ArrayList<Character>();
        ArrayList<Character> epsilonRate = new ArrayList<Character>();

        System.out.println("Hello world!");
        try {
            File myObj = new File("filename.txt");

            for (int i = 0; i < 12; i++)
            {
                Scanner myReader = new Scanner(myObj);
                int oneCount = 0,zeroCount = 0;

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    //System.out.println(data);
                    char number = data.charAt(i);
                    if(number == '0')
                        zeroCount++;
                    else
                        oneCount++;
                }
                myReader.close();

                if(zeroCount > oneCount)
                {
                    gammaRate.add('0');
                    epsilonRate.add('1');
                }
                else
                {
                    gammaRate.add('1');
                    epsilonRate.add('0');
                }
                oneCount = 0;zeroCount = 0;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int level = 11;
        int epsilonRateVal = 0;
        int gammaRateVal = 0;

        for (char num:gammaRate)
        {
            gammaRateVal = (int) (gammaRateVal + ((Math.pow(2,level))* Integer.parseInt(String.valueOf(num))));
            level--;
        }
        // System.out.println(gammaRateVal);
        level = 11;

        for (char num:epsilonRate)
        {
            epsilonRateVal = (int) (epsilonRateVal + ((Math.pow(2,level))* Integer.parseInt(String.valueOf(num))));
            level--;
        }
        System.out.println("Power Consumption" + epsilonRateVal*gammaRateVal);
    }

    public static void main(String[] args) {
        powerConsumption();
        OxygenGenRate OxRa = new OxygenGenRate();
        ScrubberRate ScRa = new ScrubberRate();
        System.out.println(ScRa.rate* OxRa.rate);

    }
}

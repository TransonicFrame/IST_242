package Model;

import java.util.ArrayList;

public class Model
{

    public Model()
    {
        FootballPlayerData fpData = new FootballPlayerData();
        System.out.println("=============================================================");
        System.out.println(fpData.getHeaders().toString());
        System.out.println(fpData.getHeaders().toString()); //yes, we are running this twice for testing purposes
        System.out.println("=============================================================");
        System.out.println("  4 ==>> "+fpData.getLine(4).toString());
        System.out.println("  4 ==>> "+fpData.getLine(4).toString()); //yes, we are running this twice for testing purposes
        System.out.println("=============================================================");
        System.out.println(" 50 ==>> "+fpData.getLine(50).toString());
        System.out.println("121 ==>> "+fpData.getLine(121).toString());
        System.out.println("=============================================================");
        ArrayList<ArrayList<String>> lines = fpData.getLines(0,4);
        for (int i = 0; i < lines.size(); i++)
        {
        System.out.println(i+" - "+ lines.get(i).toString());
        }
        System.out.println("=============================================================");
    }
}

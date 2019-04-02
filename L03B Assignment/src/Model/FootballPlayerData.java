package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class FootballPlayerData implements TableData
{
    private ArrayList<FootballPlayer> players;

    public FootballPlayerData()
    {
        players = new ArrayList<>();
        loadTable();
    }

    public void ReadPlayersFromXML()
    {
        try
        {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null)
            {
                try
                {
                    fp = (FootballPlayer) decoder.readObject();
                    getPlayers().add(fp);

                } catch (ArrayIndexOutOfBoundsException theend)
                {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx) {xx.printStackTrace();}
    }

    @Override
    public void loadTable() {
        ReadPlayersFromXML();
    }

    public ArrayList getTable() {
        ArrayList<FootballPlayer> tableList = new ArrayList<>();
        for(int i = 0; i < getPlayers().size(); i++){
            tableList.add(getPlayers().get(i));
        }
        return tableList;
    }

    @Override
    public ArrayList<String> getHeaders() {
        ArrayList<String> headerList = new ArrayList<>();
        
        headerList.add("number");
        headerList.add("name");
        headerList.add("position");
        headerList.add("height");
        headerList.add("weight");
        headerList.add("hometown");
        headerList.add("state");
        headerList.add("highschool");
        
        return headerList;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        
        ArrayList<String> lineList = new ArrayList<>();
        
        lineList.add(Integer.toString(getPlayers().get(line).getNumber()));
        lineList.add(getPlayers().get(line).getName());
        lineList.add(getPlayers().get(line).getPosition());
        lineList.add(Integer.toString(getPlayers().get(line).height.getFeet()) +"'" +Integer.toString(getPlayers().get(line).height.getInches()) +"\"");
        lineList.add(Integer.toString(getPlayers().get(line).weight));
        lineList.add(getPlayers().get(line).hometown);
        lineList.add(getPlayers().get(line).state);
        lineList.add(getPlayers().get(line).highSchool);
        
        return lineList;
    }
    
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> linesList = new ArrayList<>();
        
        for(int i = firstLine; i <= lastLine; i++){
            linesList.add(getLine(i));
        }
        
        return linesList;
    }
    
    public ArrayList<FootballPlayer> getPlayers() {
        return players;
    }
    
    public void setPlayers(ArrayList<FootballPlayer> players) {
        this.players = players;
    }
}

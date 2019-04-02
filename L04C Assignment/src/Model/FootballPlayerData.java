package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class FootballPlayerData implements TableData, Displayable 
{
    private ArrayList<FootballPlayer> players;
    private int firstLine = 0;
    private int highlightedLine = 0;
    private int numberOfLines = 20;
    private int lastLine = (firstLine + numberOfLines) - 1;
    

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
        lineList.add(Integer.toString(getPlayers().get(line).getHeight().getFeet()) +"'" +Integer.toString(getPlayers().get(line).getHeight().getInches()) +"\"");
        lineList.add(Integer.toString(getPlayers().get(line).getWeight()));
        lineList.add(getPlayers().get(line).getHometown());
        lineList.add(getPlayers().get(line).getState());
        lineList.add(getPlayers().get(line).getHighSchool());
        
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

    @Override
    public int getFirstLineToDisplay() {
        return getFirstLine();
    }

    @Override
    public int getLineToHighlight() {
        return getHighlightedLine();
    }

    @Override
    public int getLastLineToDisplay() {
        return getLastLine();
    }

    @Override
    public int getLinesBeingDisplayed() {
        return getNumberOfLines();
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.setFirstLine(firstLine);
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.setHighlightedLine(highlightedLine);
    }
    
    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.setLastLine(lastLine);
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.setNumberOfLines(numberOfLines);
    }

    public int getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(int firstLine) {
        this.firstLine = firstLine;
    }

    public int getHighlightedLine() {
        return highlightedLine;
    }

    public void setHighlightedLine(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    public int getLastLine() {
        return lastLine;
    }

    public void setLastLine(int lastLine) {
        this.lastLine = lastLine;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }
}

package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FootballPlayerData implements TableData, Displayable, Sortable
{
    private ArrayList<FootballPlayer> players;
    private FootballPlayer[] playersArray;
    private int firstLine = 0;
    private int highlightedLine = 0;
    private int numberOfLines = 20;
    private int lastLine = (firstLine + numberOfLines) - 1;
    private int sortType = 0;
    private int sortField;
    
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
    
    public void populateArray(){
        setPlayersArray(new FootballPlayer[getPlayers().size()]);
        getPlayers().toArray(getPlayersArray());
    }
    
    public void rePopulateArrayList(){
        getPlayers().clear();
        for (int i = 0; i<getPlayersArray().length; i++){
            getPlayers().add(getPlayersArray()[i]);
        }
    }
    
    private Comparator<FootballPlayer> sortPlayerByNumber = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            if (o1.getNumber() < (o2.getNumber()))
            {
                return -1;
            }
            if (o1.getNumber() == (o2.getNumber()))
            {
                return 0;
            }
            return 1;
        }
    };
    
    private Comparator<FootballPlayer> sortPlayerByName = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    
    private Comparator<FootballPlayer> sortPlayerByPosition = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
           return o1.getPosition().compareTo(o2.getPosition());
        }
    };
    
    private Comparator<FootballPlayer> sortPlayerByHeight = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            if (o1.getHeight().getInches() + o1.getHeight().getFeet()*12 < (o2.getHeight().getInches() + o2.getHeight().getFeet()*12))
            {
                return -1;
            }
            if (o1.getHeight().getInches() + o1.getHeight().getFeet()*12 == (o2.getHeight().getInches() + o2.getHeight().getFeet()*12))
            {
                return 0;
            }
            return 1;
        }
    };
    
    private Comparator<FootballPlayer> sortPlayerByWeight = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            if (o1.getWeight() < (o2.getWeight()))
            {
                return -1;
            }
            if (o1.getWeight() == (o2.getWeight()))
            {
                return 0;
            }
            return 1;
        }
    };
    
    private Comparator<FootballPlayer> sortPlayerByHometown = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return o1.getHometown().compareTo(o2.getHometown());
        }
    };
    
    private Comparator<FootballPlayer> sortPlayerByState = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
           return o1.getState().compareTo(o2.getState());
        }
    };
    
    private Comparator<FootballPlayer> sortPlayerByHighschool = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer o1, FootballPlayer o2) {
            return o1.getHighSchool().compareTo(o2.getHighSchool());
        }
    };

    @Override
    public void sort(int sortType, int sortField) {
        switch (sortType) {
            case 1:
                switch (sortField) {
                    case 0:
                        Collections.sort(getPlayers(), getSortPlayerByNumber());
                        break;
                    case 1:
                        Collections.sort(getPlayers(), getSortPlayerByName());
                        break;
                    case 2:
                        Collections.sort(getPlayers(), getSortPlayerByPosition());
                        break;
                    case 3:
                        Collections.sort(getPlayers(), getSortPlayerByHeight());
                        break;
                    case 4:
                        Collections.sort(getPlayers(), getSortPlayerByWeight());
                        break;
                    case 5:
                        Collections.sort(getPlayers(), getSortPlayerByHometown());
                        break;
                    case 6:
                        Collections.sort(getPlayers(), getSortPlayerByState());
                        break;
                    case 7:
                        Collections.sort(getPlayers(), getSortPlayerByHighschool());
                        break;
                    default:
                        break;
                }   break;
            case 2:
                switch (sortField) {
                    case 0:
                        Collections.sort(getPlayers(), getSortPlayerByNumber());
                        break;
                    case 1:
                        Collections.sort(getPlayers(), getSortPlayerByName());
                        break;
                    case 2:
                        Collections.sort(getPlayers(), getSortPlayerByPosition());
                        break;
                    case 3:
                        Collections.sort(getPlayers(), getSortPlayerByHeight());
                        break;
                    case 4:
                        Collections.sort(getPlayers(), getSortPlayerByWeight());
                        break;
                    case 5:
                        Collections.sort(getPlayers(), getSortPlayerByHometown());
                        break;
                    case 6:
                        Collections.sort(getPlayers(), getSortPlayerByState());
                        break;
                    case 7:
                        Collections.sort(getPlayers(), getSortPlayerByHighschool());
                        break;
                    default:
                        break;
                }   break;
            case 3:
                switch (sortField) {
                    case 0:
                        Arrays.sort(getPlayersArray(), getSortPlayerByNumber());
                        rePopulateArrayList();
                        break;
                    case 1:
                        Arrays.sort(getPlayersArray(), getSortPlayerByName());
                        rePopulateArrayList();
                        break;
                    case 2:
                        Arrays.sort(getPlayersArray(), getSortPlayerByPosition());
                        rePopulateArrayList();
                        break;
                    case 3:
                        Arrays.sort(getPlayersArray(), getSortPlayerByHeight());
                        rePopulateArrayList();
                        break;
                    case 4:
                        Arrays.sort(getPlayersArray(), getSortPlayerByWeight());
                        rePopulateArrayList();
                        break;
                    case 5:
                        Arrays.sort(getPlayersArray(), getSortPlayerByHometown());
                        rePopulateArrayList();
                        break;
                    case 6:
                        Arrays.sort(getPlayersArray(), getSortPlayerByState());
                        rePopulateArrayList();
                        break;
                    case 7:
                        Arrays.sort(getPlayersArray(), getSortPlayerByHighschool());
                        rePopulateArrayList();
                        break;
                    default:
                        break;
                }   break;
            default:
                break;
        }
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
        this.setLastLine((firstLine + getNumberOfLines()) - 1);
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

    @Override
    public int getSortType() {
        return sortType;
    }

    @Override
    public void SetSortType(int sortType) {
        this.setSortType(sortType + 1);
    }

    @Override
    public int getSortField() {
        return sortField;
    }

    @Override
    public void SetSortField(int sortField) {
        this.setSortField(sortField);
    }
    
    public void setSortType(int sortType) {
        this.sortType = sortType;
    }
    
    public void setSortField(int sortField) {
        this.sortField = sortField;
    }
    
    public FootballPlayer[] getPlayersArray() {
        return playersArray;
    }

    public Comparator<FootballPlayer> getSortPlayerByNumber() {
        return sortPlayerByNumber;
    }

    public void setSortPlayerByNumber(Comparator<FootballPlayer> sortPlayerByNumber) {
        this.sortPlayerByNumber = sortPlayerByNumber;
    }

    public Comparator<FootballPlayer> getSortPlayerByName() {
        return sortPlayerByName;
    }

    public void setSortPlayerByName(Comparator<FootballPlayer> sortPlayerByName) {
        this.sortPlayerByName = sortPlayerByName;
    }

    public Comparator<FootballPlayer> getSortPlayerByPosition() {
        return sortPlayerByPosition;
    }

    public void setSortPlayerByPosition(Comparator<FootballPlayer> sortPlayerByPosition) {
        this.sortPlayerByPosition = sortPlayerByPosition;
    }

    public Comparator<FootballPlayer> getSortPlayerByHeight() {
        return sortPlayerByHeight;
    }

    public void setSortPlayerByHeight(Comparator<FootballPlayer> sortPlayerByHeight) {
        this.sortPlayerByHeight = sortPlayerByHeight;
    }

    public Comparator<FootballPlayer> getSortPlayerByWeight() {
        return sortPlayerByWeight;
    }

    public void setSortPlayerByWeight(Comparator<FootballPlayer> sortPlayerByWeight) {
        this.sortPlayerByWeight = sortPlayerByWeight;
    }

    public Comparator<FootballPlayer> getSortPlayerByHometown() {
        return sortPlayerByHometown;
    }

    public void setSortPlayerByHometown(Comparator<FootballPlayer> sortPlayerByHometown) {
        this.sortPlayerByHometown = sortPlayerByHometown;
    }

    public Comparator<FootballPlayer> getSortPlayerByState() {
        return sortPlayerByState;
    }

    public void setSortPlayerByState(Comparator<FootballPlayer> sortPlayerByState) {
        this.sortPlayerByState = sortPlayerByState;
    }

    public Comparator<FootballPlayer> getSortPlayerByHighschool() {
        return sortPlayerByHighschool;
    }

    public void setSortPlayerByHighschool(Comparator<FootballPlayer> sortPlayerByHighschool) {
        this.sortPlayerByHighschool = sortPlayerByHighschool;
    }

    public void setPlayersArray(FootballPlayer[] playersArray) {
        this.playersArray = playersArray;
    }
}

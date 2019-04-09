package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FootballPlayerData implements TableData, Displayable, Sortable, Searchable
{
    
    //---------------------------------Attributes-------------------------------------------------
    
    private Map<Integer, FootballPlayer> hashMapNumbers = new HashMap<>();
    private Map<String, FootballPlayer> hashMapNames = new HashMap<>();
    private Map<String, FootballPlayer> hashMapPosition = new HashMap<>();
    private Map<String, FootballPlayer> hashMapHeight = new HashMap<>();
    private Map<Integer, FootballPlayer> hashMapWeight = new HashMap<>();
    private Map<String, FootballPlayer> hashMapHometown = new HashMap<>();
    private Map<String, FootballPlayer> hashMapState = new HashMap<>();
    private Map<String, FootballPlayer> hashMapHighschool = new HashMap<>();
    private ArrayList<FootballPlayer> players;
    private FootballPlayer[] playersArray;
    private int firstLine = 0;
    private int highlightedLine = 0;
    private int numberOfLines = 20;
    private int lastLine = (firstLine + numberOfLines) - 1;
    private int sortType = 0;
    private int sortField;
    private int fieldIndex;
    private Boolean searchResult;
    private int tableMemberindex;
    private int lineCounter;
    
    //----------------------------------------Constructor---------------------------------------------
    
    public FootballPlayerData()
    {
        players = new ArrayList<>();
        loadTable();
    }
    
    //---------------------------------------XML to ArrayList-----------------------------------------

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
    
    //------------------------------------------Load Table and populate HashMaps------------------------------

    @Override
    public void loadTable() {
        ReadPlayersFromXML();
        for (int i= 0; i<getPlayers().size(); i++){
            getHashMapNumbers().put(getPlayers().get(i).getNumber(), getPlayers().get(i));
            getHashMapNames().put(getPlayers().get(i).getName(), getPlayers().get(i));
            getHashMapPosition().put(getPlayers().get(i).getPosition(), getPlayers().get(i));
            getHashMapHeight().put(getPlayers().get(i).getHeight().getFeet() +"'" +getPlayers().get(i).getHeight().getInches() +"\"", getPlayers().get(i));
            getHashMapWeight().put(getPlayers().get(i).getWeight(), getPlayers().get(i));
            getHashMapHometown().put(getPlayers().get(i).getHometown(), getPlayers().get(i));
            getHashMapState().put(getPlayers().get(i).getState(), getPlayers().get(i));
            getHashMapHighschool().put(getPlayers().get(i).getHighSchool(), getPlayers().get(i));
        }    
    }
    
    //--------------------------------------Populate/Repopulate Arrays----------------------------------
    
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
    
    //-----------------------------------------Comparators---------------------------------------------
    
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
    
    //------------------------------------------------Sort Method---------------------------------------------------

    @Override
    public void sort(int sortType, int sortField) {
        switch (sortType) {
            case 1:
                switch (sortField) {
                    case 0:
                        for (int i = 0; i < getPlayersArray().length - 1; i++){
                            int minIndex = i;
                            for (int j = i + 1; j < getPlayersArray().length; j++){
                                if (getPlayersArray()[j].getNumber() < getPlayersArray()[minIndex].getNumber()){
                                    minIndex = j;
                                }
                            }
                            
                            FootballPlayer temp = getPlayersArray()[minIndex];
                            getPlayersArray()[minIndex] = getPlayersArray()[i];
                            getPlayersArray()[i] = temp;
                            
                            rePopulateArrayList();
                        }
                        break;
                    case 1:
                        for (int i = 0; i < getPlayersArray().length - 1; i++){
                        int minIndex = i;
                            for (int j = i + 1; j < getPlayersArray().length; j++){
                                if (0 > getPlayersArray()[j].getName().compareTo(getPlayersArray()[minIndex].getName())){
                                    minIndex = j;
                                }
                            }   
                        
                            FootballPlayer temp = getPlayersArray()[minIndex];
                            getPlayersArray()[minIndex] = getPlayersArray()[i];
                            getPlayersArray()[i] = temp;

                            rePopulateArrayList();
                        }
                        break;
                    case 2:
                        for (int i = 0; i < getPlayersArray().length - 1; i++){
                        int minIndex = i;
                            for (int j = i + 1; j < getPlayersArray().length; j++){
                                if (0 > getPlayersArray()[j].getPosition().compareTo(getPlayersArray()[minIndex].getPosition())){
                                    minIndex = j;
                                }
                            }   
                        
                            FootballPlayer temp = getPlayersArray()[minIndex];
                            getPlayersArray()[minIndex] = getPlayersArray()[i];
                            getPlayersArray()[i] = temp;

                            rePopulateArrayList();
                        }
                        break;
                    case 3:
                        for (int i = 0; i < getPlayersArray().length - 1; i++){
                            int minIndex = i;
                            for (int j = i + 1; j < getPlayersArray().length; j++){
                                if (getPlayersArray()[j].getHeight().getFeet() * 12 + getPlayersArray()[j].getHeight().getInches() < getPlayersArray()[minIndex].getHeight().getFeet() * 12 + getPlayersArray()[minIndex].getHeight().getInches()){
                                    minIndex = j;
                                }
                            }
                            
                            FootballPlayer temp = getPlayersArray()[minIndex];
                            getPlayersArray()[minIndex] = getPlayersArray()[i];
                            getPlayersArray()[i] = temp;
                            
                            rePopulateArrayList();
                        }
                        break;
                    case 4:
                        for (int i = 0; i < getPlayersArray().length - 1; i++){
                            int minIndex = i;
                            for (int j = i + 1; j < getPlayersArray().length; j++){
                                if (getPlayersArray()[j].getWeight() < getPlayersArray()[minIndex].getWeight()){
                                    minIndex = j;
                                }
                            }
                            
                            FootballPlayer temp = getPlayersArray()[minIndex];
                            getPlayersArray()[minIndex] = getPlayersArray()[i];
                            getPlayersArray()[i] = temp;
                            
                            rePopulateArrayList();
                        }
                        break;
                    case 5:
                        for (int i = 0; i < getPlayersArray().length - 1; i++){
                        int minIndex = i;
                            for (int j = i + 1; j < getPlayersArray().length; j++){
                                if (0 > getPlayersArray()[j].getHometown().compareTo(getPlayersArray()[minIndex].getHometown())){
                                    minIndex = j;
                                }
                            }   
                        
                            FootballPlayer temp = getPlayersArray()[minIndex];
                            getPlayersArray()[minIndex] = getPlayersArray()[i];
                            getPlayersArray()[i] = temp;

                            rePopulateArrayList();
                        }
                        break;
                    case 6:
                        for (int i = 0; i < getPlayersArray().length - 1; i++){
                        int minIndex = i;
                            for (int j = i + 1; j < getPlayersArray().length; j++){
                                if (0 > getPlayersArray()[j].getState().compareTo(getPlayersArray()[minIndex].getState())){
                                    minIndex = j;
                                }
                            }   
                        
                            FootballPlayer temp = getPlayersArray()[minIndex];
                            getPlayersArray()[minIndex] = getPlayersArray()[i];
                            getPlayersArray()[i] = temp;

                            rePopulateArrayList();
                        }
                        break;
                    case 7:
                        for (int i = 0; i < getPlayersArray().length - 1; i++){
                        int minIndex = i;
                            for (int j = i + 1; j < getPlayersArray().length; j++){
                                if (0 > getPlayersArray()[j].getHighSchool().compareTo(getPlayersArray()[minIndex].getHighSchool())){
                                    minIndex = j;
                                }
                            }   
                        
                            FootballPlayer temp = getPlayersArray()[minIndex];
                            getPlayersArray()[minIndex] = getPlayersArray()[i];
                            getPlayersArray()[i] = temp;

                            rePopulateArrayList();
                        }
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
    
    //--------------------------------------Search Method-------------------------------------------------------
    
    @Override
    public boolean search(String searchTerm) {
        switch (getFieldIndex()) {
            case 0:
                setLineCounter(0);
                int number = Integer.parseInt(searchTerm);
                if (getHashMapNumbers().containsKey(number)){
                    for (int i=0, k=0; i<getPlayers().size(); i++){
                        if (getPlayers().get(i).getNumber()==number){
                            FootballPlayer player = getPlayers().get(i);
                            getPlayers().remove(i);
                            getPlayers().add(k++, player);
                            setLineCounter(getLineCounter() + 1);
                        }
                    }
                    setSearchResult((Boolean) true);
                }
                else {
                    setSearchResult((Boolean) false);
                }   break;
            case 1:
                if (getHashMapNames().containsKey(searchTerm)){
                    setLineCounter(0);
                    for (int i=0, k=0; i<getPlayers().size(); i++){
                        if (getPlayers().get(i).getName().equals(searchTerm)){
                            FootballPlayer player = getPlayers().get(i);
                            getPlayers().remove(i);
                            getPlayers().add(k++, player);
                            setLineCounter(getLineCounter() + 1);
                        }
                    }
                    setSearchResult((Boolean) true);
                }
                else {
                    setSearchResult((Boolean) false);
                }   break;
            case 2:
                if (getHashMapPosition().containsKey(searchTerm)){
                    setLineCounter(0);
                    for (int i=0, k=0; i<getPlayers().size(); i++){
                        if (getPlayers().get(i).getPosition().equals(searchTerm)){
                            FootballPlayer player = getPlayers().get(i);
                            getPlayers().remove(i);
                            getPlayers().add(k++, player);
                            setLineCounter(getLineCounter() + 1);
                        }
                    }
                    setSearchResult((Boolean) true);
                }
                else {
                    setSearchResult((Boolean) false);
                }   break;
            case 3:
                if (getHashMapHeight().containsKey(searchTerm)){
                    setLineCounter(0);
                    for (int i=0, k=0; i<getPlayers().size(); i++){
                        if ((getPlayers().get(i).getHeight().getFeet() +"'" +getPlayers().get(i).getHeight().getInches() +"\"").equals(searchTerm)){
                            FootballPlayer player = getPlayers().get(i);
                            getPlayers().remove(i);
                            getPlayers().add(k++, player);
                            setLineCounter(getLineCounter() + 1);
                        }
                    }
                    setSearchResult((Boolean) true);
                }
                else {
                    setSearchResult((Boolean) false);
                }   break;
            case 4:
                int weight = Integer.parseInt(searchTerm);
                if (getHashMapWeight().containsKey(weight)){
                    setLineCounter(0);
                    for (int i=0, k=0; i<getPlayers().size(); i++){
                        if (getPlayers().get(i).getWeight()==weight){
                            FootballPlayer player = getPlayers().get(i);
                            getPlayers().remove(i);
                            getPlayers().add(k++, player);
                            setLineCounter(getLineCounter() + 1);
                        }
                    }
                    setSearchResult((Boolean) true);
                }
                else {
                    setSearchResult((Boolean) false);
                }   break;
            case 5:
                if (getHashMapHometown().containsKey(searchTerm)){
                    setLineCounter(0);
                    for (int i=0, k=0; i<getPlayers().size(); i++){
                        if (getPlayers().get(i).getHometown().equals(searchTerm)){
                            FootballPlayer player = getPlayers().get(i);
                            getPlayers().remove(i);
                            getPlayers().add(k++, player);
                            setLineCounter(getLineCounter() + 1);
                        }
                    }
                    setSearchResult((Boolean) true);
                }
                else {
                    setSearchResult((Boolean) false);
                }   break;
            case 6:
                if (getHashMapState().containsKey(searchTerm)){
                    setLineCounter(0);
                    for (int i=0, k=0; i<getPlayers().size(); i++){
                        if (getPlayers().get(i).getState().equals(searchTerm)){
                            FootballPlayer player = getPlayers().get(i);
                            getPlayers().remove(i);
                            getPlayers().add(k++, player);
                            setLineCounter(getLineCounter() + 1);
                        }
                    }
                    setSearchResult((Boolean) true);
                }
                else {
                    setSearchResult((Boolean) false);
                }   break;
            case 7:
                if (getHashMapHighschool().containsKey(searchTerm)){
                    setLineCounter(0);
                    for (int i=0, k=0; i<getPlayers().size(); i++){
                        if (getPlayers().get(i).getHighSchool().equals(searchTerm)){
                            FootballPlayer player = getPlayers().get(i);
                            getPlayers().remove(i);
                            getPlayers().add(k++, player);
                            setLineCounter(getLineCounter() + 1);
                        }
                    }
                    setSearchResult((Boolean) true);
                }
                else {
                    setSearchResult((Boolean) false);
                }   break;
            default:
                break;
        }
        return getSearchResult();
    }
    
    //--------------------------------------Getters and Setters-----------------------------------------
   
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
    
    @Override
    public int getFoundIndex() {
        return getTableMemberindex();
    }

    @Override
    public void setFoundIndex(int tableMemberindex) {
        this.setTableMemberindex(tableMemberindex);
    }

    @Override
    public boolean getFound() {
        return getSearchResult();
    }

    @Override
    public void setFound(boolean searchResult) {
        this.setSearchResult((Boolean) searchResult);
    }

    @Override
    public int getSearchByField() {
        return getFieldIndex();
    }

    @Override
    public void setSearchByField(int fieldIndex) {
        this.setFieldIndex(fieldIndex);
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

    public Map<Integer, FootballPlayer> getHashMapNumbers() {
        return hashMapNumbers;
    }

    public void setHashMapNumbers(Map<Integer, FootballPlayer> hashMapNumbers) {
        this.hashMapNumbers = hashMapNumbers;
    }
    
    public Map<String, FootballPlayer> getHashMapNames() {
        return hashMapNames;
    }

    public void setHashMapNames(Map<String, FootballPlayer> hashMapNames) {
        this.hashMapNames = hashMapNames;
    }

    public Map<String, FootballPlayer> getHashMapPosition() {
        return hashMapPosition;
    }

    public void setHashMapPosition(Map<String, FootballPlayer> hashMapPosition) {
        this.hashMapPosition = hashMapPosition;
    }

    public Map<String, FootballPlayer> getHashMapHeight() {
        return hashMapHeight;
    }

    public void setHashMapHeight(Map<String, FootballPlayer> hashMapHeight) {
        this.hashMapHeight = hashMapHeight;
    }

    public Map<Integer, FootballPlayer> getHashMapWeight() {
        return hashMapWeight;
    }

    public void setHashMapWeight(Map<Integer, FootballPlayer> hashMapWeight) {
        this.hashMapWeight = hashMapWeight;
    }

    public Map<String, FootballPlayer> getHashMapHometown() {
        return hashMapHometown;
    }

    public void setHashMapHometown(Map<String, FootballPlayer> hashMapHometown) {
        this.hashMapHometown = hashMapHometown;
    }

    public Map<String, FootballPlayer> getHashMapState() {
        return hashMapState;
    }

    public void setHashMapState(Map<String, FootballPlayer> hashMapState) {
        this.hashMapState = hashMapState;
    }

    public Map<String, FootballPlayer> getHashMapHighschool() {
        return hashMapHighschool;
    }

    public void setHashMapHighschool(Map<String, FootballPlayer> hashMapHighschool) {
        this.hashMapHighschool = hashMapHighschool;
    }

    public int getFieldIndex() {
        return fieldIndex;
    }

    public void setFieldIndex(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

    public Boolean getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(Boolean searchResult) {
        this.searchResult = searchResult;
    }

    public int getTableMemberindex() {
        return tableMemberindex;
    }

    public void setTableMemberindex(int tableMemberindex) {
        this.tableMemberindex = tableMemberindex;
    }

    public int getLineCounter() {
        return lineCounter;
    }

    public void setLineCounter(int lineCounter) {
        this.lineCounter = lineCounter;
    }

    public void setPlayersArray(FootballPlayer[] playersArray) {
        this.playersArray = playersArray;
    }
}

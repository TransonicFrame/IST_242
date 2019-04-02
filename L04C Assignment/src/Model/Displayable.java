package Model;

public interface Displayable
{
  public int getFirstLineToDisplay(); 
  public int getLineToHighlight(); 
  public int getLastLineToDisplay(); 
  public int getLinesBeingDisplayed(); 

  public void setFirstLineToDisplay(int firstLine); 
  public void setLineToHighlight(int highlightedLine); 
  public void setLastLineToDisplay(int lastLine); 
  public void setLinesBeingDisplayed(int numberOfLines); 
}
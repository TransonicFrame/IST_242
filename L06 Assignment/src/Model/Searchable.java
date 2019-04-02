package Model;

public interface Searchable
{
  public boolean search(String searchTerm);

  public int getFoundIndex();
  public void setFoundIndex(int tableMemberindex);

  public boolean getFound();
  public void setFound(boolean searchResult);

  public int getSearchByField();
  public void setSearchByField(int fieldIndex);
}
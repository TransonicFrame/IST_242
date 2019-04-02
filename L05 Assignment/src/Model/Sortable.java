package Model;

public interface Sortable 
{
    public void sort(int sortType, int sortField);
    public int getSortType();
    public void SetSortType(int sortType);
    public int getSortField();
    public void SetSortField(int sortField);
}

package pro_tech.androidtasks.Models;

public class FragmentoneModel {
    String Id, Title, Url;
    int Count;

    public FragmentoneModel (){

    }

    public FragmentoneModel(String title, String url, int count) {
        Title = title;
        Url = url;
        Count = count;
    }

    public FragmentoneModel(int count) {
        Count = count;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return Url;
    }


    public void setUrl(String url) {
        Url = url;
    }
}

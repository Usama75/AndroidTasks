package pro_tech.androidtasks.Models;

public class FragmentFourModel {
    String  ImageUrl, ChannelName;

    public FragmentFourModel(){

    }

    public FragmentFourModel(String imageUrl, String channelName) {
        ImageUrl = imageUrl;
        ChannelName = channelName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }
}

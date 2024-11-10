import java.util.List;

public class Station {
    private String stationId;
    private String stationName;
    private List<PlatForm> platFormList;

    public Station(String stationId, String stationName) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.platFormList = platFormList;


    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<PlatForm> getPlatFormList() {
        return platFormList;
    }

    public void setPlatFormList(List<PlatForm> platFormList) {
        this.platFormList = platFormList;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId='" + stationId + '\'' +
                ", stationName='" + stationName + '\'' +
                ", platFormList=" + platFormList +
                '}';
    }
}

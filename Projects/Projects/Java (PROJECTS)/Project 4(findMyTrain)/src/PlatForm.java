public class PlatForm {
    private int platformNumber;
    private Train train;

    public PlatForm(int platformNumber) {
        this.platformNumber = platformNumber;
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public void setPlatformNumber(int platformNumber) {
        this.platformNumber = platformNumber;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "PlatForm{" +
                "platformNumber=" + platformNumber +
                ", train=" + train +
                '}';
    }
}

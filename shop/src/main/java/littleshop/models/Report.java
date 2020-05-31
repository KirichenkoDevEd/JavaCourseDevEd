package littleshop.models;

import java.time.LocalDate;
import java.util.Objects;

public class Report {

    private LocalDate date;
    private String storeKeeperName;
    private String info;

    public Report(String storeKeeperName, String info) {
        this.date = LocalDate.now();
        this.storeKeeperName = storeKeeperName;
        this.info = info;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStoreKeeperName() {
        return storeKeeperName;
    }

    public void setStoreKeeperName(String storeKeeperName) {
        this.storeKeeperName = storeKeeperName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Report report = (Report) o;
        return Objects.equals(date, report.date) &&
                Objects.equals(storeKeeperName, report.storeKeeperName) &&
                Objects.equals(info, report.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, storeKeeperName, info);
    }

    @Override
    public String toString() {
        return String.format("REPORT %s DATE: %s%s NAME: %s%s REPORT: %s%s",
                '\n',
                getDate(),
                '\n',
                getStoreKeeperName(),
                '\n',
                '\n',
                getInfo());
    }
}

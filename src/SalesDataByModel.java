public class SalesDataByModel {
    private String month;
    private Integer year;
    private Integer saleValue;

    public SalesDataByModel(String[] modelsInfo){
        setMonth(modelsInfo[0]);
        setYear(Integer.parseInt(modelsInfo[1]));
        setSaleValue(Integer.parseInt(modelsInfo[2]));

    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getSaleValue() {
        return saleValue;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setSaleValue(Integer saleValue) {
        this.saleValue = saleValue;
    }
}

import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesApplicationService {

    public  void  modelYearlySalesReport(List<SalesDataByModel> modelDataInfo, String teslaModel){

        System.out.println("Model " + teslaModel + " Yearly Sales Report");
        System.out.println("---------------------------");
        
        //Getting sales by year and printing them
        modelYearlySalesReport(modelDataInfo);

        //Getting the higher and lower sale value of the model
        Integer bestMonthSaleValue = modelDataInfo.stream().map(SalesDataByModel::getSaleValue).max(Integer::compare).get();
        Integer worstMonthSaleValue = modelDataInfo.stream().map(SalesDataByModel::getSaleValue).min(Integer::compare).get();

        //Getting the best and worst month on sales and printing them
        modelMonthSaleReport(modelDataInfo, teslaModel, bestMonthSaleValue,"best month");
        modelMonthSaleReport(modelDataInfo, teslaModel, worstMonthSaleValue,"worst month");
        System.out.println();
    }

    private static void modelMonthSaleReport(List<SalesDataByModel> modelDataInfo, String teslaModel,
                                       Integer saleValue, String monthCategory) {

        Optional<SalesDataByModel> modelObjBySaleValue = modelDataInfo.stream()
                .filter(model -> model.getSaleValue().equals(saleValue))
                .findAny();

        YearMonth yearMonthToParse = YearMonth.parse(modelObjBySaleValue.get().getMonth()+"-"+modelObjBySaleValue.get().getYear(),
                DateTimeFormatter.ofPattern("MMM-yy"));
        System.out.println("The "+ monthCategory + " for Model "+ teslaModel + " was: " + yearMonthToParse);
    }

    private static void modelYearlySalesReport(List<SalesDataByModel> modelDataInfo) {
        //Streaming list to get a map with the sum of all sales by year
        Map<Integer, Integer> modelYearsSales = modelDataInfo.stream()
                .collect(Collectors.groupingBy(SalesDataByModel::getYear,Collectors.summingInt(SalesDataByModel::getSaleValue)));

        for(Integer year: modelYearsSales.keySet()){
            //Parsing the current year(yy) into the format yyyy
            Year yearToParse = Year.parse(year+"", DateTimeFormatter.ofPattern("yy"));
            //Printing sales by year
            System.out.println(yearToParse.getValue() + " -> " + modelYearsSales.get(year));
        }
    }
}

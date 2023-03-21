import java.io.IOException;
import java.util.List;

public class SalesApplication {
    public static void main(String[] args) throws IOException {

        //Loading in a list every model info
        FileService loadFile = new FileService();
        List<SalesDataByModel> model3Info = loadFile.loadAllDataByModel("model3.csv");
        List<SalesDataByModel> modelSInfo = loadFile.loadAllDataByModel("modelS.csv");
        List<SalesDataByModel> modelXInfo = loadFile.loadAllDataByModel("modelX.csv");

        //Yearly sales report, best & worst month by Tesla model
        SalesApplicationService teslaModelReport = new SalesApplicationService();
        teslaModelReport.modelYearlySalesReport(model3Info,"3");
        teslaModelReport.modelYearlySalesReport(modelSInfo,"S");
        teslaModelReport.modelYearlySalesReport(modelXInfo,"X");
    }
}
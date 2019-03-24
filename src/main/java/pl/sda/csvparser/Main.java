package pl.sda.csvparser;

import javafx.scene.Parent;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Remigiusz Zudzin
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Parser parser = new Parser();
        parser.groupByCity(parser.readFile2());

        Map<String, List<RealEstate>> map = parser.readFile2().stream()
                .collect(Collectors.groupingBy(RealEstate::getCity));

    }

}

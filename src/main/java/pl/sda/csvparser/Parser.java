package pl.sda.csvparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.DoubleStream;

/**
 * @author Remigiusz Zudzin
 */
public class Parser {

    private Path file = Paths.get("File.csv");

    public void readFile() throws IOException {
        byte[] data = Files.readAllBytes(file);
        String convertData = new String(data);

        String[] dataArray = convertData.split("\\r");

        RealEstate[] realEstates = new RealEstate[dataArray.length];

        double sumPrize = 0;
        double avgPrize = 0;

        int i = 0;
        for (String line : dataArray) {
            String[] l = line.split(",");

            RealEstate realEstate = new RealEstate(
                    l[0], l[1], Integer.parseInt(l[2]),
                    l[3], Integer.parseInt(l[4]), Integer.parseInt(l[5]),
                    Integer.parseInt(l[6]), l[7], l[8],
                    Integer.parseInt(l[9]), Double.parseDouble(l[10]), Double.parseDouble(l[11])
            );
            realEstates[i] = realEstate;
            i++;
            System.out.println(l[0]);
        }
        System.out.println(realEstates.length);

        for (int j = 0; j < realEstates.length; j++) {
            sumPrize += realEstates[j].getPrice();
        }

        int realEstateLength = realEstates.length;
        avgPrize = sumPrize / realEstateLength;
        System.out.printf("%,.2f", avgPrize);

    }

    public List<RealEstate> readFile2() throws IOException {
        byte[] data = Files.readAllBytes(file);
        String convertData = new String(data);

        String[] dataArray = convertData.split("\\r");

        RealEstate[] realEstates = new RealEstate[dataArray.length];

        int i = 0;
        for (String line : dataArray) {
            String[] l = line.split(",");

            RealEstate realEstate = new RealEstate(
                    l[0], l[1], Integer.parseInt(l[2]),
                    l[3], Integer.parseInt(l[4]), Integer.parseInt(l[5]),
                    Integer.parseInt(l[6]), l[7], l[8],
                    Integer.parseInt(l[9]), Double.parseDouble(l[10]), Double.parseDouble(l[11])
            );
            realEstates[i] = realEstate;
            i++;
            System.out.println(l[0]);
        }

        List<RealEstate> realEstateList = Arrays.asList(realEstates);

        return realEstateList;
    }

    public void groupByCity(List<RealEstate> realEstates) throws IOException {
        //Map<String, List<RealEstate>>
        //klucz to miasto, a lista wartosci to nieruchomości w mieście


        //iterować się po realEstates, key = city, value = nieruchomość
        //sprawdzam czy klucz jest w mapie
//        if (map.get("Warszawa") == null) {
//            map.put("", Arrays.asList(realEstates));
//        } else {}
        //List<RealEstate> lista = map.get("warszawa");
        //lista.add(nowyelement);
        //map.put("warszawa", lista);

        Map<String, List<RealEstate>> map = new HashMap<>();

        List<RealEstate> realEstateList = new ArrayList<>();

        for (RealEstate realEstate : realEstateList) {

            if (map.containsKey(realEstate.getCity())) {
                List<RealEstate> list = map.get(realEstate.getCity());
                realEstateList.add(realEstate);
                map.put(realEstate.getCity(), list);
            } else {
                List<RealEstate> list = new ArrayList<>();
                list.add(realEstate);
                map.put(realEstate.getCity(), list);
            }
        }


    }

}

package ua.kiev.prog.week3.utils;

import org.apache.log4j.Logger;
import ua.kiev.prog.week3.domain.Company;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CSVUtils {


    public static final Logger LOGGER = Logger.getLogger(CSVUtils.class);

    public static List<Company> getCompaniesFromFile() {

        String property = ConfigLoader.getProperty("csv.db.location");
        LOGGER.info("load csv file " + property);
        List<Company> companies = new ArrayList<>();


//            return Files.lines(Paths.get(CSVUtils.class.getResource(property).toURI()), UTF_8)
//                    .map(line -> Arrays.asList(line.split(","))).
//                    filter(list -> list.size() == 2).map(list -> new Company(list.get(0), Long.valueOf(list.get(1)))).collect(toList());


        List<String> lines = null;
        try {

            lines = Files.readAllLines(Paths.get(CSVUtils.class.getResource(property).toURI()), UTF_8);
            for (String line : lines) {
                String[] strings = line.split(",");
                String name = strings[0];
                Long totalRevenue = Long.valueOf(strings[1]);
                Company company = new Company(name, totalRevenue);
                companies.add(company);
            }

        } catch (IOException | URISyntaxException e) {
            LOGGER.error("corrupted uri ", e);
            e.printStackTrace();
        }

        return companies;




//        try (InputStream is = CSVUtils.class.getResource(property).openStream();
//             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
//            return bufferedReader.lines().map(line -> Arrays.asList(line.split(","))).
//                    filter(list ->list.size()== 2).map(list -> new Company(list.get(0), Long.valueOf(list.get(1)))).collect(toList());
//        } catch (IOException e) {
//            LOGGER.error(e);
//        }

    }


}
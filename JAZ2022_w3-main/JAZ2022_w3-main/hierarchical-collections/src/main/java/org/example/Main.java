package org.example;

import org.example.model.Geography;
import org.example.model.SampleGeographiesData;
import org.example.tools.geographies.GeographyParser;
import org.example.tools.HierarchyBuilder;
import org.example.model.abstraction.IHaveHierarchicalStructure;
import org.example.tools.abstractions.IParse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        IParse<Geography> geographyParser = new GeographyParser();

        /**
         * Zacznijmy od wyodrębnienia informacji
         * o geografiach z list String'ów
         */
//        List<Geography> geographies = extracted(geographyParser);

        /**
         * A teraz zobaczmy jak by to wyglądało z zastosowaniem strumieni na kolekcjach
         */

//        List<Geography> geographiesGotFromStream = SampleGeographiesData.data
//                        .stream()
//                        //.map(geographyParser::parse)
//                        .map(line -> geographyParser.parse(line))
//                        .toList();

        /**
         * Jedną z typowych operacji na kolekcjach,
         * jest wyszukiwanie danych według jakiegoś warunku.
         * Co zrobić by z kolekcji wybrać tylko państwa?
         */
//        List<Geography> countries = getCountries(geographiesGotFromStream);


        /**
         * a tak to wygląda w wersji 'strumieniowej'
         */
//        List<Geography> countriesFromStream = geographiesGotFromStream
//                .stream()
//                .filter(geo -> geo.getType().equalsIgnoreCase("country")).toList();

        /**
         * Kolejną często spotykaną operacją jest
         * wyodrębnienie nowej kolekcji elementów
         *
         * np z kolekcji państw chcielibyśmy jedynie liste ich nazw
         */
//        List<String> countriesNames = getGeoNames(countries);

        /**
         * a tak w strumieniach
         */
//        List<String> countryNamesFromStream = countriesFromStream.stream()
//                .map(Geography::getName)
//                //.map(geo -> geo.getName())
//                .toList();

        /**
         * a co jeśli potrzebujemy jakiś wycinek (stronę)
         * elementów z kolekcji określając ilość elementów
         * do wzięcia i ilość do ominięcia
         */
//        printSomeCountries(countriesNames, 10, 3);

        /**
         * a tak w wersji strumieniowej
         */
//        countryNamesFromStream.stream()
//                .skip(10)
//                .limit(3)
//                //.forEach(System.out::println);
//                .forEach(name -> System.out.println(name));

        /**
         * a co jeśli z kolekcji musimy zbudować jeden element?
         * np chcielibyśmy połączyć wszystkie nazwy krajów
         * w jednego Stringa, gdzie nazwy są oddzielone przecinkiem
         */
//         String namesJoined = joinString(countriesNames);

        /**
         * W strumieniach można to zrobić na kilka sposobów
         */
//        String namesReducedOptional = countryNamesFromStream
//                .stream()
//                .limit(1)
//                .reduce( (s1,s2)->s1+", "+s2)
//                .orElse("");
//
//        String namesReduced = countryNamesFromStream.stream().reduce("", (s1,s2)->s1+", "+s2);
//
//
//        String namesByComa = countryNamesFromStream.stream().limit(5)
//                .collect(Collectors.joining(", "));
//
//        System.out.println(namesByComa);

        /**
         * możemy też wykonać proste operacje na liczbach
         */
//        int maxId = countries.stream()
//                .collect(Collectors.summarizingInt(geo->geo.getId()))
//                .getMax();

        /**
         * A co z grupowaniem?
         * standordowo chciałbym sobie pogrupować geografie np po type regionu
         */
//        Map<String, List<Geography>> geographiesByRegion = groupByType(geographies);

        /**
         * W strumieniach do tego najprościej korzystać z tzw. Collectorów
         */
//        Map<String, List<Geography>> geographiesByRegionType
//                =geographies.stream()
//                .collect(Collectors.groupingBy(Geography::getType));


        /**
         * Inne typowe przykłady jak:
         * -> szukanie elementów w kolekcji
         * -> sprawdzanie czy w kolekcji istnieje element który spełnia dany warunek
         * -> sprawdzanie czy wszystkie elementy w kolekcji spełniają dany warunek
         */
//        Geography africa = geographies.stream()
//                        .filter(geo->geo.getName().equalsIgnoreCase("africa"))
//                                .findFirst().orElse(null);
//        boolean hasRoot = geographies.stream().anyMatch(geo->geo.getParentId()==null);
//        boolean everyGeoHasParent = geographies.stream().allMatch(geo->geo.getParent()!=null);


        /**
         * a czy da się sortować?
         */
//        List<Geography> countriesSortedByIds = countries.stream()
//                .sorted((g1, g2)->g1.getId()-g2.getId())
//                .toList();

        /**
         * Kiedyś napisałem sobie buildera aby utworzyć relacje pomiędzy obiektami geografii
         */
//        HierarchyBuilder<Geography> geographyHierarchyBuilder = new HierarchyBuilder<>();
//        geographyHierarchyBuilder.setElements(geographies); //Niech builder przyjmie kolekcje geografii wygenerowany wcześniej
//        geographyHierarchyBuilder.buildHierarchy(); // niech zbuduje hierarchie
//        Geography rootGeography = geographyHierarchyBuilder.getRootElement();// niech zwróci rodzica wszystkichj geografii, czyli 'world'

        /**
         * a czy nie da się tego także zrobić strumieniem?
         */
//        geographies.stream()
//                .collect(Collectors.toMap(
//                        x -> x,
//                        x -> geographies
//                                .stream()
//                                .filter(geo -> geo.getParentId() != null && geo.getParentId() == x.getId())
//                                .toList()))
//                .forEach((key, value) -> {
//                    key.setChildren(value);
//                    value.forEach(childGeo -> childGeo.setParent(key));
//                });
//        System.out.println("koniec :(");
    }

    private static Map<String, List<Geography>> groupByType(List<Geography> geographies) {
        Map<String, List<Geography> >result = new HashMap<>();
        for (Geography geo : geographies) {
            String type = geo.getType();
            if(!result.containsKey(type))result.put(type, new ArrayList<>());
            result.get(type).add(geo);
        }

        return result;
    }

    private static String joinString(List<String> countriesNames) {
        StringBuilder builder = new StringBuilder();
        for (String s :
                countriesNames) {
            builder.append(s);
            builder.append(";");
        }
        return builder.toString();
    }

    private static void printSomeCountries(List<String> countriesNames, int skip, int take) {
        for (String name :
                countriesNames) {
            if(take==0)return;
            if(skip>0){skip--; continue;}
            if(take>0){take--; System.out.println(name);}
        }
    }

    private static  List<Geography> extracted(IParse<Geography> geographyParser) {
        List<Geography> geographies = new ArrayList<>();
        for (String line :
                SampleGeographiesData.data) {
            geographies.add(geographyParser.parse(line));
        }
        return geographies;
    }

    private static List<String> getGeoNames(List<Geography> countries) {
        List<String> result = new ArrayList<>();
        for (Geography geo :
                countries) {
            result.add(geo.getName());
        }
        return result;
    }

    private static List<Geography> getCountries(List<Geography> geographies) {
        List<Geography> result = new ArrayList<>();
        for (Geography geo : geographies) {
            if (geo.getType().equalsIgnoreCase("country"))
                result.add(geo);
        }
        return result;
    }
}
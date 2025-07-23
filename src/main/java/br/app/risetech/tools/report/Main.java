package br.app.risetech.tools.report;

import br.app.risetech.tools.report.Geonames.CountryInfo;
import br.app.risetech.tools.report.Geonames.StateInfo;
import br.app.risetech.tools.report.types.Countries;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public static void main(String[] args) {

    }

    public static String safeToUpperCase(Object value) {
        if (value == null) {
            return "";
        }
        return value.toString().toUpperCase();
    }

    public static String ensureNonEmpty(Object value) {
        if (value == null || value.toString().trim().isEmpty()) {
            return "";
        }
        return safeToUpperCase(value.toString());
    }

    public static String currentDate() {
        try {
            SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = targetFormat.format(new Date());

            return formatDate(formattedDate);

        } catch (Exception e) {
            return "";
        }
    }

    public static String currentDateTime() {
        try {
            SimpleDateFormat targetFormat = new SimpleDateFormat("HH:mm:ss");
            String formattedDateTime = targetFormat.format(new Date());
            return currentDate() + " - "+ formattedDateTime;
        } catch (Exception e) {
            return "";
        }
    }

    public static String formatDate(Date date) {
        return formatDate(date.toString());
    };

    public static String formatDate(Date date, String localeStr) {
        return formatDate(date.toString(), localeStr);
    };

    public static String formatDate(String dateStr) {
        return formatDate(dateStr, Locale.getDefault().toString());
    }

    public static String formatDate(String dateStr, String localeStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(dateStr);

            String[] parts = localeStr.split("_");
            Locale locale;

            if (parts.length == 2) {
                locale = new Locale(parts[0], parts[1]);
            } else {
                locale = new Locale(localeStr);
            }

            DateFormat outputFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);

            return ensureNonEmpty(outputFormat.format(date));
        } catch (Exception e) {
            return ensureNonEmpty(dateStr);
        }
    }

    public static String translator(String key, ResourceBundle bundle) {
        if (bundle == null) {
            return ensureNonEmpty(key);
        }

        try {
            if (bundle.containsKey(key)) {
                return bundle.getString(key);
            } else {
                return ensureNonEmpty(key);
            }
        } catch (Exception e) {
            return ensureNonEmpty(key);
        }
    }

    public static String mapCountry(String country) {
        if (country == null) {
            return "";
        }
        Countries c = Countries.getPerIso(country.toUpperCase());

        if(c != null) {
            return c.getName();
        }

        return "";
    }

    public static String mask(String value, String mask) {
        if (value == null || value.isEmpty() || mask == null || mask.isEmpty()) {
            return value;
        }

        String cleanValue = value.replaceAll("[^0-9a-zA-Z]", "");

        StringBuilder maskedValue = new StringBuilder();
        int valueIndex = 0;

        for (int maskIndex = 0; maskIndex < mask.length(); maskIndex++) {
            char maskChar = mask.charAt(maskIndex);

            if (maskChar == '#') {
                if (valueIndex < cleanValue.length()) {
                    maskedValue.append(cleanValue.charAt(valueIndex));
                    valueIndex++;
                } else {
                    break;
                }
            } else {
                maskedValue.append(maskChar);
            }
        }

        if (valueIndex < cleanValue.length()) {
            maskedValue.append(cleanValue.substring(valueIndex));
        }

        return maskedValue.toString();
    }

    public static String maskCPF(String data) {
        return mask(data, "###.###.###-##");
    };

    public static String maskCNPJ(String data) {
        return mask(data, "##.###.###/####-##");
    };

    public static String maskCellphone(String data) {
        String cleanValue = data.replaceAll("[^0-9a-zA-Z]", "");

        if(cleanValue.length() > 13) {
            return mask(data, " +## (##) #####-####");
        }
        return mask(data, "(##) #####-####");
    };

    public static String maskTelephone(String data) {
        String cleanValue = data.replaceAll("[^0-9a-zA-Z]", "");

        if(cleanValue.length() > 11) {
            return mask(data, " +## (##) #####-####");
        }
        return mask(data, "(##) #####-####");
    };

    public static List<String> stringToList(String data){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Usa readValue para desserializar a string JSON para um List<String>
            List<String> resultList = objectMapper.readValue(data, List.class);
            return resultList;
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao processar a string JSON: " + e.getMessage());
            return null;
        }
    }

    public static List<Map<String, List<String>>> stringToJson(String jsonData) {
        try {
            return OBJECT_MAPPER.readValue(jsonData, new TypeReference<List<Map<String, List<String>>>>() {});
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static String getNameCountry(String iso){

        try{
            List<CountryInfo> countryData;

            ObjectMapper objectMapper = new ObjectMapper();

            try (InputStream is = Main.class.getClassLoader().getResourceAsStream("geonames/countries.json")) {

                if (is == null) {
                    return "";
                }

                countryData = objectMapper.readValue(is, new TypeReference<List<CountryInfo>>() {});

                return countryData.stream()
                        .filter(countryInfo -> countryInfo.getIso3().equalsIgnoreCase(iso.trim()) ||
                                countryInfo.getIso2().equalsIgnoreCase(iso.trim()))
                        .map(CountryInfo::getNativeName)
                        .findFirst().orElse("");

            } catch (IOException e) {

                return  "";
            }
        }catch (Exception e){
            return "";
        }
    }

    public static String getNameState(String iso){

        try{
             List<StateInfo> statesData;

            ObjectMapper objectMapper = new ObjectMapper();

            try (InputStream is = Main.class.getClassLoader().getResourceAsStream("geonames/states.json")) {

                if (is == null) {
                    return "";
                }

                statesData = objectMapper.readValue(is, new TypeReference<List<StateInfo>>() {});

                return statesData.stream()
                        .filter(stateInfo -> stateInfo.getState().equalsIgnoreCase(iso.trim()))
                        .map(StateInfo::getName)
                        .findFirst().orElse("");

            } catch (IOException e) {

                return  "";
            }
        }catch (Exception e){
            return "";
        }
    }
}
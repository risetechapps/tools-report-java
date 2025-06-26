package br.app.risetech.tools.report.types;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Countries {
    AFGHANISTAN("AFG", "Afghanistan"),
    ALAND_ISLANDS("ALA", "Aland Islands"),
    ALBANIA("ALB", "Albania"),
    ALGERIA("DZA", "Algeria"),
    AMERICAN_SAMOA("ASM", "American Samoa"),
    ANDORRA("AND", "Andorra"),
    ANGOLA("AGO", "Angola"),
    ANGUILLA("AIA", "Anguilla"),
    ANTARCTICA("ATA", "Antarctica"),
    ANTIGUA_AND_BARBUDA("ATG", "Antigua and Barbuda"),
    ARGENTINA("ARG", "Argentina"),
    ARMENIA("ARM", "Armenia"),
    ARUBA("ABW", "Aruba"),
    AUSTRALIA("AUS", "Australia"),
    AUSTRIA("AUT", "Austria"),
    AZERBAIJAN("AZE", "Azerbaijan"),
    BAHRAIN("BHR", "Bahrain"),
    BANGLADESH("BGD", "Bangladesh"),
    BARBADOS("BRB", "Barbados"),
    BELARUS("BLR", "Belarus"),
    BELGIUM("BEL", "Belgium"),
    BELIZE("BLZ", "Belize"),
    BENIN("BEN", "Benin"),
    BERMUDA("BMU", "Bermuda"),
    BHUTAN("BTN", "Bhutan"),
    BOLIVIA("BOL", "Bolivia"),
    BONAIRE_SINT_EUSTATIUS_AND_SABA("BES", "Bonaire, Sint Eustatius and Saba"),
    BOSNIA_AND_HERZEGOVINA("BIH", "Bosnia and Herzegovina"),
    BOTSWANA("BWA", "Botswana"),
    BOUVET_ISLAND("BVT", "Bouvet Island"),
    BRAZIL("BRA", "Brasil"),
    BRITISH_INDIAN_OCEAN_TERRITORY("IOT", "British Indian Ocean Territory"),
    BRUNEI("BRN", "Brunei Darussalam"), // Common official name
    BULGARIA("BGR", "Bulgaria"),
    BURKINA_FASO("BFA", "Burkina Faso"),
    BURUNDI("BDI", "Burundi"),
    CAMBODIA("KHM", "Cambodia"),
    CAMEROON("CMR", "Cameroon"),
    CANADA("CAN", "Canada"),
    CAPE_VERDE("CPV", "Cabo Verde"), // Official ISO name
    CAYMAN_ISLANDS("CYM", "Cayman Islands"),
    CENTRAL_AFRICAN_REPUBLIC("CAF", "Central African Republic"),
    CHAD("TCD", "Chad"),
    CHILE("CHL", "Chile"),
    CHINA("CHN", "China"),
    CHRISTMAS_ISLAND("CXR", "Christmas Island"),
    COCOS_KEELING_ISLANDS("CCK", "Cocos (Keeling) Islands"),
    COLOMBIA("COL", "Colombia"),
    COMOROS("COM", "Comoros"),
    CONGO("COG", "Congo"), // Republic of the Congo
    COOK_ISLANDS("COK", "Cook Islands"),
    COSTA_RICA("CRI", "Costa Rica"),
    COTE_DIVOIRE("CIV", "Côte d'Ivoire"), // ISO name, removed (Ivory Coast) for conciseness
    CROATIA("HRV", "Croatia"),
    CUBA("CUB", "Cuba"),
    CURACAO("CUW", "Curaçao"),
    CYPRUS("CYP", "Cyprus"),
    CZECH_REPUBLIC("CZE", "Czechia"), // Official ISO name change
    DEMOCRATIC_REPUBLIC_OF_THE_CONGO("COD", "Congo, The Democratic Republic of the"), // Official long name
    DENMARK("DNK", "Denmark"),
    DJIBOUTI("DJI", "Djibouti"),
    DOMINICA("DMA", "Dominica"),
    DOMINICAN_REPUBLIC("DOM", "Dominican Republic"),
    ECUADOR("ECU", "Ecuador"),
    EGYPT("EGY", "Egypt"),
    EL_SALVADOR("SLV", "El Salvador"),
    EQUATORIAL_GUINEA("GNQ", "Equatorial Guinea"),
    ERITREA("ERI", "Eritrea"),
    ESTONIA("EST", "Estonia"),
    ESWATINI("SWZ", "Eswatini"), // Previously Swaziland
    ETHIOPIA("ETH", "Ethiopia"),
    FALKLAND_ISLANDS("FLK", "Falkland Islands (Malvinas)"), // Includes (Malvinas) by ISO
    FAROE_ISLANDS("FRO", "Faroe Islands"),
    FIJI_ISLANDS("FJI", "Fiji"), // Commonly just "Fiji"
    FINLAND("FIN", "Finland"),
    FRANCE("FRA", "France"),
    FRENCH_GUIANA("GUF", "French Guiana"),
    FRENCH_POLYNESIA("PYF", "French Polynesia"),
    FRENCH_SOUTHERN_TERRITORIES("ATF", "French Southern Territories"),
    GABON("GAB", "Gabon"),
    GEORGIA("GEO", "Georgia"),
    GERMANY("DEU", "Germany"),
    GHANA("GHA", "Ghana"),
    GIBRALTAR("GIB", "Gibraltar"),
    GREECE("GRC", "Greece"),
    GREENLAND("GRL", "Greenland"),
    GRENADA("GRD", "Grenada"),
    GUADELOUPE("GLP", "Guadeloupe"),
    GUAM("GUM", "Guam"),
    GUATEMALA("GTM", "Guatemala"),
    GUERNSEY("GGY", "Guernsey"), // Corrected from GUERNSEY_AND_ALDERNEY, Alderney is part of Guernsey
    GUINEA("GIN", "Guinea"),
    GUINEA_BISSAU("GNB", "Guinea-Bissau"),
    GUYANA("GUY", "Guyana"),
    HAITI("HTI", "Haiti"),
    HEARD_ISLAND_AND_MCDONALD_ISLANDS("HMD", "Heard Island and McDonald Islands"),
    HONDURAS("HND", "Honduras"),
    HONG_KONG_SAR("HKG", "Hong Kong"), // Simplified name
    HUNGARY("HUN", "Hungary"),
    ICELAND("ISL", "Iceland"),
    INDIA("IND", "India"),
    INDONESIA("IDN", "Indonesia"),
    IRAN("IRN", "Iran, Islamic Republic of"), // Official ISO name
    IRAQ("IRQ", "Iraq"),
    IRELAND("IRL", "Ireland"),
    ISRAEL("ISR", "Israel"),
    ITALY("ITA", "Italy"),
    JAMAICA("JAM", "Jamaica"),
    JAPAN("JPN", "Japan"),
    JERSEY("JEY", "Jersey"),
    JORDAN("JOR", "Jordan"),
    KAZAKHSTAN("KAZ", "Kazakhstan"),
    KENYA("KEN", "Kenya"),
    KIRIBATI("KIR", "Kiribati"),
    KOSOVO("XXK", "Kosovo"), // Non-ISO code, but widely used for Kosovo
    KUWAIT("KWT", "Kuwait"),
    KYRGYZSTAN("KGZ", "Kyrgyzstan"),
    LAOS("LAO", "Lao People's Democratic Republic"), // Official ISO name
    LATVIA("LVA", "Latvia"),
    LEBANON("LBN", "Lebanon"),
    LESOTHO("LSO", "Lesotho"),
    LIBERIA("LBR", "Liberia"),
    LIBYA("LBY", "Libya"),
    LIECHTENSTEIN("LIE", "Liechtenstein"),
    LITHUANIA("LTU", "Lithuania"),
    LUXEMBOURG("LUX", "Luxembourg"),
    MACAU_SAR("MAC", "Macao"), // Simplified name
    MADAGASCAR("MDG", "Madagascar"),
    MALAWI("MWI", "Malawi"),
    MALAYSIA("MYS", "Malaysia"),
    MALDIVES("MDV", "Maldives"),
    MALI("MLI", "Mali"),
    MALTA("MLT", "Malta"),
    MAN_ISLE_OF("IMN", "Isle of Man"), // ISO is IMN, full name is "Isle of Man"
    MARSHALL_ISLANDS("MHL", "Marshall Islands"),
    MARTINIQUE("MTQ", "Martinique"),
    MAURITANIA("MRT", "Mauritania"),
    MAURITIUS("MUS", "Mauritius"),
    MAYOTTE("MYT", "Mayotte"),
    MEXICO("MEX", "Mexico"),
    MICRONESIA("FSM", "Micronesia, Federated States of"), // Official ISO name
    MOLDOVA("MDA", "Moldova, Republic of"), // Official ISO name
    MONACO("MCO", "Monaco"),
    MONGOLIA("MNG", "Mongolia"),
    MONTENEGRO("MNE", "Montenegro"),
    MONTSERRAT("MSR", "Montserrat"),
    MOROCCO("MAR", "Morocco"),
    MOZAMBIQUE("MOZ", "Mozambique"),
    MYANMAR("MMR", "Myanmar"),
    NAMIBIA("NAM", "Namibia"),
    NAURU("NRU", "Nauru"),
    NEPAL("NPL", "Nepal"),
    NETHERLANDS("NLD", "Netherlands"),
    NEW_CALEDONIA("NCL", "New Caledonia"),
    NEW_ZEALAND("NZL", "New Zealand"),
    NICARAGUA("NIC", "Nicaragua"),
    NIGER("NER", "Niger"),
    NIGERIA("NGA", "Nigeria"),
    NIUE("NIU", "Niue"),
    NORFOLK_ISLAND("NFK", "Norfolk Island"),
    NORTH_KOREA("PRK", "Korea, Democratic People's Republic of"), // Official ISO name
    NORTH_MACEDONIA("MKD", "North Macedonia"), // Official ISO name
    NORTHERN_MARIANA_ISLANDS("MNP", "Northern Mariana Islands"),
    NORWAY("NOR", "Norway"),
    OMAN("OMN", "Oman"),
    PAKISTAN("PAK", "Pakistan"),
    PALAU("PLW", "Palau"),
    PALESTINIAN_TERRITORY_OCCUPIED("PSE", "Palestine, State of"), // ISO name is "Palestine, State of"
    PANAMA("PAN", "Panama"),
    PAPUA_NEW_GUINEA("PNG", "Papua New Guinea"),
    PARAGUAY("PRY", "Paraguay"),
    PERU("PER", "Peru"),
    PHILIPPINES("PHL", "Philippines"),
    PITCAIRN_ISLAND("PCN", "Pitcairn"), // Commonly just "Pitcairn" in ISO
    POLAND("POL", "Poland"),
    PORTUGAL("PRT", "Portugal"),
    PUERTO_RICO("PRI", "Puerto Rico"),
    QATAR("QAT", "Qatar"),
    REUNION("REU", "Réunion"),
    ROMANIA("ROU", "Romania"),
    RUSSIA("RUS", "Russian Federation"), // Official ISO name
    RWANDA("RWA", "Rwanda"),
    SAINT_HELENA("SHN", "Saint Helena, Ascension and Tristan da Cunha"), // Official ISO name
    SAINT_KITTS_AND_NEVIS("KNA", "Saint Kitts and Nevis"),
    SAINT_LUCIA("LCA", "Saint Lucia"),
    SAINT_PIERRE_AND_MIQUELON("SPM", "Saint Pierre and Miquelon"),
    SAINT_VINCENT_AND_THE_GRENADINES("VCT", "Saint Vincent and the Grenadines"),
    SAINT_BARTHELEMY("BLM", "Saint Barthélemy"),
    SAINT_MARTIN_FRENCH_PART("MAF", "Saint Martin (French part)"), // ISO name has (French part)
    SAMOA("WSM", "Samoa"),
    SAN_MARINO("SMR", "San Marino"),
    SAO_TOME_AND_PRINCIPE("STP", "Sao Tome and Principe"),
    SAUDI_ARABIA("SAU", "Saudi Arabia"),
    SENEGAL("SEN", "Senegal"),
    SERBIA("SRB", "Serbia"),
    SEYCHELLES("SYC", "Seychelles"),
    SIERRA_LEONE("SLE", "Sierra Leone"),
    SINGAPORE("SGP", "Singapore"),
    SINT_MAARTEN_DUTCH_PART("SXM", "Sint Maarten (Dutch part)"), // ISO name has (Dutch part)
    SLOVAKIA("SVK", "Slovakia"),
    SLOVENIA("SVN", "Slovenia"),
    SOLOMON_ISLANDS("SLB", "Solomon Islands"),
    SOMALIA("SOM", "Somalia"),
    SOUTH_AFRICA("ZAF", "South Africa"),
    SOUTH_GEORGIA("SGS", "South Georgia and the South Sandwich Islands"), // Official ISO name
    SOUTH_KOREA("KOR", "Korea, Republic of"), // Official ISO name
    SOUTH_SUDAN("SSD", "South Sudan"),
    SPAIN("ESP", "Spain"),
    SRI_LANKA("LKA", "Sri Lanka"),
    SUDAN("SDN", "Sudan"),
    SURINAME("SUR", "Suriname"),
    SVALBARD_AND_JAN_MAYEN_ISLANDS("SJM", "Svalbard and Jan Mayen"), // Simplified name
    SWEDEN("SWE", "Sweden"),
    SWITZERLAND("CHE", "Switzerland"),
    SYRIA("SYR", "Syrian Arab Republic"), // Official ISO name
    TAIWAN("TWN", "Taiwan, Province of China"), // Official ISO name
    TAJIKISTAN("TJK", "Tajikistan"),
    TANZANIA("TZA", "Tanzania, United Republic of"), // Official ISO name
    THAILAND("THA", "Thailand"),
    THE_BAHAMAS("BHS", "Bahamas"), // Commonly "Bahamas"
    THE_GAMBIA("GMB", "Gambia"), // Removed underscore
    TIMOR_LESTE("TLS", "Timor-Leste"),
    TOGO("TGO", "Togo"),
    TOKELAU("TKL", "Tokelau"),
    TONGA("TON", "Tonga"),
    TRINIDAD_AND_TOBAGO("TTO", "Trinidad and Tobago"),
    TUNISIA("TUN", "Tunisia"),
    TURKEY("TUR", "Turkey"),
    TURKMENISTAN("TKM", "Turkmenistan"),
    TURKS_AND_CAICOS_ISLANDS("TCA", "Turks and Caicos Islands"),
    TUVALU("TUV", "Tuvalu"),
    UGANDA("UGA", "Uganda"),
    UKRAINE("UKR", "Ukraine"),
    UNITED_ARAB_EMIRATES("ARE", "United Arab Emirates"),
    UNITED_KINGDOM("GBR", "United Kingdom"),
    UNITED_STATES("USA", "United States"),
    UNITED_STATES_MINOR_OUTLYING_ISLANDS("UMI", "United States Minor Outlying Islands"),
    URUGUAY("URY", "Uruguay"),
    UZBEKISTAN("UZB", "Uzbekistan"),
    VANUATU("VUT", "Vanuatu"),
    VATICAN_CITY_STATE("VAT", "Vatican City State (Holy See)"), // Added as common variant
    VENEZUELA("VEN", "Venezuela"),
    VIETNAM("VNM", "Viet Nam"), // Official ISO name
    VIRGIN_ISLANDS_BRITISH("VGB", "Virgin Islands (British)"),
    VIRGIN_ISLANDS_US("VIR", "Virgin Islands (U.S.)"),
    WALLIS_AND_FUTUNA_ISLANDS("WLF", "Wallis and Futuna"), // Simplified name
    WESTERN_SAHARA("ESH", "Western Sahara"),
    YEMEN("YEM", "Yemen"),
    ZAMBIA("ZMB", "Zambia"),
    ZIMBABWE("ZWE", "Zimbabwe");


    private final String iso3;
    private final String name;

    Countries(String iso3, String name) {
        this.iso3 = iso3;
        this.name = name;
    }

    public String getIso3() {
        return iso3;
    }

    public String getName() {
        return name;
    }

    private static final Map<String, Countries> MAPS_ISO = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(
                            Countries::getIso3,
                            Function.identity()
                    ))
    );


    private static final Map<String, Countries> MAPS_NAME = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(
                            pais -> pais.getName().toLowerCase(),
                            Function.identity()
                    ))
    );

    public static Countries getPerIso(String iso) {
        if (iso == null || iso.trim().isEmpty()) {
            return null;
        }
        return MAPS_ISO.get(iso.trim().toUpperCase());
    }

    public static Countries getPerName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        return MAPS_NAME.get(name.trim().toLowerCase());
    }
}

package com.dignicate.p30a.domain.automobile

interface AutomobileRepository {
    suspend fun getCompanies(limit: Int, page: Int): Result<List<Company>>
    suspend fun getCountries(): Result<List<Country>>
}

//class MockAutomobileRepository : AutomobileRepository {
//
//    private object Country {
//        val japan = listOf(
//            LocalizedString(language = "en", value = "Japan"),
//            LocalizedString(language = "ja", value = "日本")
//        )
//        val germany = listOf(
//            LocalizedString(language = "en", value = "Germany"),
//            LocalizedString(language = "ja", value = "ドイツ"),
//            LocalizedString(language = "de", value = "Deutschland")
//        )
//        val usa = listOf(
//            LocalizedString(language = "en", value = "USA"),
//            LocalizedString(language = "ja", value = "アメリカ")
//        )
//        val southKorea = listOf(
//            LocalizedString(language = "en", value = "South Korea"),
//            LocalizedString(language = "ja", value = "韓国"),
//            LocalizedString(language = "ko", value = "대한민국")
//        )
//        val italy = listOf(
//            LocalizedString(language = "en", value = "Italy"),
//            LocalizedString(language = "ja", value = "イタリア"),
//            LocalizedString(language = "it", value = "Italia")
//        )
//        val sweden = listOf(
//            LocalizedString(language = "en", value = "Sweden"),
//            LocalizedString(language = "ja", value = "スウェーデン"),
//            LocalizedString(language = "sv", value = "Sverige")
//        )
//        val india = listOf(
//            LocalizedString(language = "en", value = "India"),
//            LocalizedString(language = "ja", value = "インド"),
//            LocalizedString(language = "hi", value = "भारत")
//        )
//        val france = listOf(
//            LocalizedString(language = "en", value = "France"),
//            LocalizedString(language = "ja", value = "フランス"),
//            LocalizedString(language = "fr", value = "France")
//        )
//        val croatia = listOf(
//            LocalizedString(language = "en", value = "Croatia"),
//            LocalizedString(language = "ja", value = "クロアチア"),
//            LocalizedString(language = "hr", value = "Hrvatska")
//        )
//        val serbia = listOf(
//            LocalizedString(language = "en", value = "Serbia"),
//            LocalizedString(language = "ja", value = "セルビア"),
//            LocalizedString(language = "sr", value = "Србија")
//        )
//        val australia = listOf(
//            LocalizedString(language = "en", value = "Australia"),
//            LocalizedString(language = "ja", value = "オーストラリア")
//        )
//        val northKorea = listOf(
//            LocalizedString(language = "en", value = "North Korea"),
//            LocalizedString(language = "ja", value = "朝鮮民主主義人民共和国"),
//            LocalizedString(language = "ko", value = "조선민주주의인민공화국")
//        )
//        val iran = listOf(
//            LocalizedString(language = "en", value = "Iran"),
//            LocalizedString(language = "ja", value = "イラン"),
//            LocalizedString(language = "fa", value = "ایران")
//        )
//        val iraq = listOf(
//            LocalizedString(language = "en", value = "Iraq"),
//            LocalizedString(language = "ja", value = "イラク"),
//            LocalizedString(language = "ar", value = "العراق")
//        )
//        val syria = listOf(
//            LocalizedString(language = "en", value = "Syria"),
//            LocalizedString(language = "ja", value = "シリア"),
//            LocalizedString(language = "ar", value = "سوريا")
//        )
//        val russia = listOf(
//            LocalizedString(language = "en", value = "Russia"),
//            LocalizedString(language = "ja", value = "ロシア"),
//            LocalizedString(language = "ru", value = "Россия")
//        )
//        val ukraine = listOf(
//            LocalizedString(language = "en", value = "Ukraine"),
//            LocalizedString(language = "ja", value = "ウクライナ"),
//            LocalizedString(language = "uk", value = "Україна")
//        )
//        val belarus = listOf(
//            LocalizedString(language = "en", value = "Belarus"),
//            LocalizedString(language = "ja", value = "ベラルーシ"),
//            LocalizedString(language = "be", value = "Беларусь")
//        )
//        val israel = listOf(
//            LocalizedString(language = "en", value = "Israel"),
//            LocalizedString(language = "he", value = "ישראל"),
//            LocalizedString(language = "ja", value = "イスラエル")
//        )
//        val tunisia = listOf(
//            LocalizedString(language = "en", value = "Tunisia"),
//            LocalizedString(language = "fr", value = "Tunisie"),
//            LocalizedString(language = "ja", value = "チュニジア")
//        )
//        val nigeria = listOf(
//            LocalizedString(language = "en", value = "Nigeria"),
//            LocalizedString(language = "ig", value = "Naịjịrịa"),
//            LocalizedString(language = "ja", value = "ナイジェリア")
//        )
//        val brazil = listOf(
//            LocalizedString(language = "en", value = "Brazil"),
//            LocalizedString(language = "pt", value = "Brasil"),
//            LocalizedString(language = "ja", value = "ブラジル")
//        )
//        val argentina = listOf(
//            LocalizedString(language = "en", value = "Argentina"),
//            LocalizedString(language = "es", value = "Argentina"),
//            LocalizedString(language = "ja", value = "アルゼンチン")
//        )
//    }
//
//    private object CompanyData {
//        val allCompanies = listOf(
//            Company(
//                id = 1,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Toyota"),
//                    LocalizedString(language = "ja", value = "トヨタ")
//                ),
//                country = Country.japan,
//                foundedYear = 1937
//            ),
//            Company(
//                id = 2,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Ford"),
//                    LocalizedString(language = "ja", value = "フォード")
//                ),
//                country = Country.usa,
//                foundedYear = 1903
//            ),
//            Company(
//                id = 3,
//                name = listOf(
//                    LocalizedString(language = "en", value = "BMW"),
//                    LocalizedString(language = "ja", value = "ビー・エム・ダブリュー"),
//                    LocalizedString(language = "de", value = "BMW")
//                ),
//                country = Country.germany,
//                foundedYear = 1916
//            ),
//            Company(
//                id = 4,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Hyundai"),
//                    LocalizedString(language = "ja", value = "ヒュンダイ"),
//                    LocalizedString(language = "ko", value = "현대")
//                ),
//                country = Country.southKorea,
//                foundedYear = 1967
//            ),
//            Company(
//                id = 5,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Fiat"),
//                    LocalizedString(language = "ja", value = "フィアット"),
//                    LocalizedString(language = "it", value = "Fiat")
//                ),
//                country = Country.italy,
//                foundedYear = 1899
//            ),
//            Company(
//                id = 6,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Volvo"),
//                    LocalizedString(language = "ja", value = "ボルボ"),
//                    LocalizedString(language = "sv", value = "Volvo")
//                ),
//                country = Country.sweden,
//                foundedYear = 1927
//            ),
//            Company(
//                id = 7,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Tata Motors"),
//                    LocalizedString(language = "ja", value = "タタ・モーターズ"),
//                    LocalizedString(language = "hi", value = "टाटा मोटर्स")
//                ),
//                country = Country.india,
//                foundedYear = 1945
//            ),
//            Company(
//                id = 8,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Renault"),
//                    LocalizedString(language = "ja", value = "ルノー"),
//                    LocalizedString(language = "fr", value = "Renault")
//                ),
//                country = Country.france,
//                foundedYear = 1899
//            ),
//            Company(
//                id = 9,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Koenigsegg"),
//                    LocalizedString(language = "ja", value = "ケーニグセグ")
//                ),
//                country = Country.sweden,
//                foundedYear = 1994
//            ),
//            Company(
//                id = 10,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Pagani"),
//                    LocalizedString(language = "ja", value = "パガーニ"),
//                    LocalizedString(language = "it", value = "Pagani")
//                ),
//                country = Country.italy,
//                foundedYear = 1992
//            ),
//            Company(
//                id = 11,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Rimac"),
//                    LocalizedString(language = "ja", value = "リマック"),
//                    LocalizedString(language = "hr", value = "Rimac")
//                ),
//                country = Country.croatia,
//                foundedYear = 2009
//            ),
//            Company(
//                id = 12,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Zastava"),
//                    LocalizedString(language = "ja", value = "ザスタバ"),
//                    LocalizedString(language = "sr", value = "Застава")
//                ),
//                country = Country.serbia,
//                foundedYear = 1953
//            ),
//            Company(
//                id = 13,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Holden"),
//                    LocalizedString(language = "ja", value = "ホールデン")
//                ),
//                country = Country.australia,
//                foundedYear = 1856
//            ),
//            Company(
//                id = 14,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Saab"),
//                    LocalizedString(language = "ja", value = "サーブ")
//                ),
//                country = Country.sweden,
//                foundedYear = 1945
//            ),
//            Company(
//                id = 15,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Peugeot"),
//                    LocalizedString(language = "ja", value = "プジョー"),
//                    LocalizedString(language = "fr", value = "Peugeot")
//                ),
//                country = Country.france,
//                foundedYear = 1810
//            ),
//            Company(
//                id = 16,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Mitsuoka"),
//                    LocalizedString(language = "ja", value = "光岡自動車")
//                ),
//                country = Country.japan,
//                foundedYear = 1968
//            ),
//            Company(
//                id = 17,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Pyeonghwa Motors"),
//                    LocalizedString(language = "ja", value = "平和自動車"),
//                    LocalizedString(language = "ko", value = "평화자동차")
//                ),
//                country = Country.northKorea,
//                foundedYear = 1999
//            ),
//            Company(
//                id = 18,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Iran Khodro"),
//                    LocalizedString(language = "ja", value = "イラン・ホドロ"),
//                    LocalizedString(language = "fa", value = "ایران خودرو")
//                ),
//                country = Country.iran,
//                foundedYear = 1962
//            ),
//            Company(
//                id = 19,
//                name = listOf(
//                    LocalizedString(language = "en", value = "State Company for Automotive Industry"),
//                    LocalizedString(language = "ja", value = "国営自動車産業会社"),
//                    LocalizedString(language = "ar", value = "الشركة العامة لصناعة السيارات")
//                ),
//                country = Country.iraq,
//                foundedYear = 1976
//            ),
//            Company(
//                id = 20,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Syria Motors"),
//                    LocalizedString(language = "ja", value = "シリア・モーターズ"),
//                    LocalizedString(language = "ar", value = "سوريا موتورز")
//                ),
//                country = Country.syria,
//                foundedYear = 2007
//            ),
//            Company(
//                id = 21,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Suzuki"),
//                    LocalizedString(language = "ja", value = "スズキ")
//                ),
//                country = Country.japan,
//                foundedYear = 1909
//            ),
//            Company(
//                id = 22,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Mazda"),
//                    LocalizedString(language = "ja", value = "マツダ")
//                ),
//                country = Country.japan,
//                foundedYear = 1920
//            ),
//            Company(
//                id = 23,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Subaru"),
//                    LocalizedString(language = "ja", value = "スバル")
//                ),
//                country = Country.japan,
//                foundedYear = 1953
//            ),
//            Company(
//                id = 24,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Mitsubishi"),
//                    LocalizedString(language = "ja", value = "三菱")
//                ),
//                country = Country.japan,
//                foundedYear = 1870
//            ),
//            Company(
//                id = 25,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Isuzu"),
//                    LocalizedString(language = "ja", value = "いすゞ")
//                ),
//                country = Country.japan,
//                foundedYear = 1916
//            ),
//            Company(
//                id = 26,
//                name = listOf(
//                    LocalizedString(language = "en", value = "AvtoVAZ"),
//                    LocalizedString(language = "ja", value = "アフトヴァズ"),
//                    LocalizedString(language = "ru", value = "АвтоВАЗ")
//                ),
//                country = Country.russia,
//                foundedYear = 1966
//            ),
//            Company(
//                id = 27,
//                name = listOf(
//                    LocalizedString(language = "en", value = "GAZ"),
//                    LocalizedString(language = "ja", value = "ガズ"),
//                    LocalizedString(language = "ru", value = "ГАЗ")
//                ),
//                country = Country.russia,
//                foundedYear = 1932
//            ),
//            Company(
//                id = 28,
//                name = listOf(
//                    LocalizedString(language = "en", value = "ZAZ"),
//                    LocalizedString(language = "ja", value = "ザズ"),
//                    LocalizedString(language = "uk", value = "ЗАЗ")
//                ),
//                country = Country.ukraine,
//                foundedYear = 1923
//            ),
//            Company(
//                id = 29,
//                name = listOf(
//                    LocalizedString(language = "en", value = "BelAZ"),
//                    LocalizedString(language = "ja", value = "ベラズ"),
//                    LocalizedString(language = "be", value = "БелАЗ")
//                ),
//                country = Country.belarus,
//                foundedYear = 1948
//            ),
//            Company(
//                id = 30,
//                name = listOf(
//                    LocalizedString(language = "en", value = "UAZ"),
//                    LocalizedString(language = "ja", value = "ウアズ"),
//                    LocalizedString(language = "ru", value = "УАЗ")
//                ),
//                country = Country.russia,
//                foundedYear = 1941
//            ),
//            Company(
//                id = 31,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Autocars Co."),
//                    LocalizedString(language = "he", value = "אוטוקרס"),
//                    LocalizedString(language = "ja", value = "オートカーズ")
//                ),
//                country = Country.israel,
//                foundedYear = 1957
//            ),
//            Company(
//                id = 32,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Wallyscar"),
//                    LocalizedString(language = "fr", value = "Wallyscar"),
//                    LocalizedString(language = "ja", value = "ウォリースカー")
//                ),
//                country = Country.tunisia,
//                foundedYear = 2006
//            ),
//            Company(
//                id = 33,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Innoson Vehicle Manufacturing"),
//                    LocalizedString(language = "ig", value = "Innoson Vehicle Manufacturing"),
//                    LocalizedString(language = "ja", value = "イノソン・ビークル・マニュファクチャリング")
//                ),
//                country = Country.nigeria,
//                foundedYear = 2007
//            ),
//            Company(
//                id = 34,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Troller"),
//                    LocalizedString(language = "pt", value = "Troller"),
//                    LocalizedString(language = "ja", value = "トローラー")
//                ),
//                country = Country.brazil,
//                foundedYear = 1995
//            ),
//            Company(
//                id = 35,
//                name = listOf(
//                    LocalizedString(language = "en", value = "Zanella"),
//                    LocalizedString(language = "es", value = "Zanella"),
//                    LocalizedString(language = "ja", value = "ザネラ")
//                ),
//                country = Country.argentina,
//                foundedYear = 1948
//            ),
//        )
//    }
//
//    override suspend fun getCompanies(limit: Int, page: Int): List<Company> {
//        // Simple paging
//        return CompanyData.allCompanies.drop((page - 1) * limit).take(limit)
//    }
//}

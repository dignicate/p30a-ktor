const targetDb = db.getSiblingDB("p30a")

targetDb.country.deleteMany({})
targetDb.country.insertMany(
[
  {
    "_id": 1,
    "name": [
      {
        "language": "en",
        "value": "Japan"
      },
      {
        "language": "ja",
        "value": "日本"
      }
    ]
  },
  {
    "_id": 2,
    "name": [
      {
        "language": "en",
        "value": "Germany"
      },
      {
        "language": "ja",
        "value": "ドイツ"
      },
      {
        "language": "de",
        "value": "Deutschland"
      }
    ]
  },
  {
    "_id": 3,
    "name": [
      {
        "language": "en",
        "value": "USA"
      },
      {
        "language": "ja",
        "value": "アメリカ"
      }
    ]
  },
  {
    "_id": 4,
    "name": [
      {
        "language": "en",
        "value": "South Korea"
      },
      {
        "language": "ja",
        "value": "韓国"
      },
      {
        "language": "ko",
        "value": "대한민국"
      }
    ]
  },
  {
    "_id": 5,
    "name": [
      {
        "language": "en",
        "value": "Italy"
      },
      {
        "language": "ja",
        "value": "イタリア"
      },
      {
        "language": "it",
        "value": "Italia"
      }
    ]
  },
  {
    "_id": 6,
    "name": [
      {
        "language": "en",
        "value": "Sweden"
      },
      {
        "language": "ja",
        "value": "スウェーデン"
      },
      {
        "language": "sv",
        "value": "Sverige"
      }
    ]
  },
  {
    "_id": 7,
    "name": [
      {
        "language": "en",
        "value": "India"
      },
      {
        "language": "ja",
        "value": "インド"
      },
      {
        "language": "hi",
        "value": "भारत"
      }
    ]
  },
  {
    "_id": 8,
    "name": [
      {
        "language": "en",
        "value": "France"
      },
      {
        "language": "ja",
        "value": "フランス"
      },
      {
        "language": "fr",
        "value": "France"
      }
    ]
  },
  {
    "_id": 9,
    "name": [
      {
        "language": "en",
        "value": "Croatia"
      },
      {
        "language": "ja",
        "value": "クロアチア"
      },
      {
        "language": "hr",
        "value": "Hrvatska"
      }
    ]
  },
  {
    "_id": 10,
    "name": [
      {
        "language": "en",
        "value": "Serbia"
      },
      {
        "language": "ja",
        "value": "セルビア"
      },
      {
        "language": "sr",
        "value": "Србија"
      }
    ]
  },
  {
    "_id": 11,
    "name": [
      {
        "language": "en",
        "value": "Australia"
      },
      {
        "language": "ja",
        "value": "オーストラリア"
      }
    ]
  },
  {
    "_id": 12,
    "name": [
      {
        "language": "en",
        "value": "North Korea"
      },
      {
        "language": "ja",
        "value": "朝鮮民主主義人民共和国"
      },
      {
        "language": "ko",
        "value": "조선민주주의인민공화국"
      }
    ]
  },
  {
    "_id": 13,
    "name": [
      {
        "language": "en",
        "value": "Iran"
      },
      {
        "language": "ja",
        "value": "イラン"
      },
      {
        "language": "fa",
        "value": "ایران"
      }
    ]
  },
  {
    "_id": 14,
    "name": [
      {
        "language": "en",
        "value": "Iraq"
      },
      {
        "language": "ja",
        "value": "イラク"
      },
      {
        "language": "ar",
        "value": "العراق"
      }
    ]
  },
  {
    "_id": 15,
    "name": [
      {
        "language": "en",
        "value": "Syria"
      },
      {
        "language": "ja",
        "value": "シリア"
      },
      {
        "language": "ar",
        "value": "سوريا"
      }
    ]
  },
  {
    "_id": 16,
    "name": [
      {
        "language": "en",
        "value": "Russia"
      },
      {
        "language": "ja",
        "value": "ロシア"
      },
      {
        "language": "ru",
        "value": "Россия"
      }
    ]
  },
  {
    "_id": 17,
    "name": [
      {
        "language": "en",
        "value": "Ukraine"
      },
      {
        "language": "ja",
        "value": "ウクライナ"
      },
      {
        "language": "uk",
        "value": "Україна"
      }
    ]
  },
  {
    "_id": 18,
    "name": [
      {
        "language": "en",
        "value": "Belarus"
      },
      {
        "language": "ja",
        "value": "ベラルーシ"
      },
      {
        "language": "be",
        "value": "Беларусь"
      }
    ]
  },
  {
    "_id": 19,
    "name": [
      {
        "language": "en",
        "value": "Israel"
      },
      {
        "language": "he",
        "value": "ישראל"
      },
      {
        "language": "ja",
        "value": "イスラエル"
      }
    ]
  },
  {
    "_id": 20,
    "name": [
      {
        "language": "en",
        "value": "Tunisia"
      },
      {
        "language": "fr",
        "value": "Tunisie"
      },
      {
        "language": "ja",
        "value": "チュニジア"
      }
    ]
  },
  {
    "_id": 21,
    "name": [
      {
        "language": "en",
        "value": "Nigeria"
      },
      {
        "language": "ig",
        "value": "Naịjịrịa"
      },
      {
        "language": "ja",
        "value": "ナイジェリア"
      }
    ]
  },
  {
    "_id": 22,
    "name": [
      {
        "language": "en",
        "value": "Brazil"
      },
      {
        "language": "pt",
        "value": "Brasil"
      },
      {
        "language": "ja",
        "value": "ブラジル"
      }
    ]
  },
  {
    "_id": 23,
    "name": [
      {
        "language": "en",
        "value": "Argentina"
      },
      {
        "language": "es",
        "value": "Argentina"
      },
      {
        "language": "ja",
        "value": "アルゼンチン"
      }
    ]
  }
]
);

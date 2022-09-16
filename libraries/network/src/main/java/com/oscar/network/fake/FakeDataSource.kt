package com.oscar.network.fake

import org.intellij.lang.annotations.Language

object FakeDataSource {

    @Language("JSON")
    val marvelCharacters = """
        {
  "code": 200,
  "status": "Ok",
  "copyright": "© 2022 MARVEL",
  "attributionText": "Data provided by Marvel. © 2022 MARVEL",
  "attributionHTML": "<a href=\"http://marvel.com\">Data provided by Marvel. © 2022 MARVEL</a>",
  "etag": "0b28b17a73cbbc3ab05974159603a3b78cfc6b16",
  "data": {
    "offset": 0,
    "limit": 20,
    "total": 1562,
    "count": 20,
    "results": [
      {
        "id": 1011334,
        "name": "3-D Man",
        "description": "",
        "modified": "2014-04-29T14:18:17-0400",
        "thumbnail": {
          "path": "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
          "extension": "jpg"
        }
      },
      {
        "id": 1017100,
        "name": "A-Bomb (HAS)",
        "description": "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ",
        "modified": "2013-09-18T15:54:04-0400",
        "thumbnail": {
          "path": "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16",
          "extension": "jpg"
        }
      },
      {
       "id": 1010699,
        "name": "Aaron Stack",
        "description": "",
        "modified": "1969-12-31T19:00:00-0500",
        "thumbnail": {
          "path": "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available",
          "extension": "jpg"
        }
      },
      {
        "id": 1009146,
        "name": "Abomination (Emil Blonsky)",
        "description": "Formerly known as Emil Blonsky, a spy of Soviet Yugoslavian origin working for the KGB, the Abomination gained his powers after receiving a dose of gamma radiation similar to that which transformed Bruce Banner into the incredible Hulk.",
        "modified": "2012-03-20T12:32:12-0400",
        "thumbnail": {
          "path": "http://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04",
          "extension": "jpg"
        }
      }
    ]
  }
      }""".trimIndent()

}
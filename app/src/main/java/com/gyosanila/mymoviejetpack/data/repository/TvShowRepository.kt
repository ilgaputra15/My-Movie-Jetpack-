package com.gyosanila.mymoviejetpack.data.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gyosanila.mymoviejetpack.data.model.TvShow

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 13:51
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class TvShowRepository {

    fun getTvShowById(id: Int): TvShow? {
        val movies = getTvShowsDummy()
        return movies.find { it.id == id }
    }

    fun getTvShowsDummy(): ArrayList<TvShow> {
        val tvShows = "[\n" +
                "  {\n" +
                "    \"original_name\": \"Supernatural\",\n" +
                "    \"genre_ids\": [\n" +
                "      18,\n" +
                "      9648,\n" +
                "      10765\n" +
                "    ],\n" +
                "    \"name\": \"Supernatural\",\n" +
                "    \"popularity\": 342.774,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 2019,\n" +
                "    \"first_air_date\": \"2005-09-13\",\n" +
                "    \"backdrop_path\": \"/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 1622,\n" +
                "    \"vote_average\": 7.4,\n" +
                "    \"overview\": \"When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. \",\n" +
                "    \"poster_path\": \"/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Fear the Walking Dead\",\n" +
                "    \"genre_ids\": [\n" +
                "      18,\n" +
                "      27\n" +
                "    ],\n" +
                "    \"name\": \"Fear the Walking Dead\",\n" +
                "    \"popularity\": 182.81,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 1076,\n" +
                "    \"first_air_date\": \"2015-08-23\",\n" +
                "    \"backdrop_path\": \"/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 62286,\n" +
                "    \"vote_average\": 6.3,\n" +
                "    \"overview\": \"What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.\",\n" +
                "    \"poster_path\": \"/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"His Dark Materials\",\n" +
                "    \"genre_ids\": [\n" +
                "      18,\n" +
                "      10765\n" +
                "    ],\n" +
                "    \"name\": \"His Dark Materials\",\n" +
                "    \"popularity\": 275.216,\n" +
                "    \"origin_country\": [\n" +
                "      \"GB\"\n" +
                "    ],\n" +
                "    \"vote_count\": 24,\n" +
                "    \"first_air_date\": \"2019-11-03\",\n" +
                "    \"backdrop_path\": \"/9yKCJTOh9m3Lol2RY3kw99QPH6x.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 68507,\n" +
                "    \"vote_average\": 8.1,\n" +
                "    \"overview\": \"Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.\",\n" +
                "    \"poster_path\": \"/xOjRNnQw5hqR1EULJ2iHkGwJVA4.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Arrow\",\n" +
                "    \"genre_ids\": [\n" +
                "      80,\n" +
                "      18,\n" +
                "      9648,\n" +
                "      10759\n" +
                "    ],\n" +
                "    \"name\": \"Arrow\",\n" +
                "    \"popularity\": 246.315,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 2779,\n" +
                "    \"first_air_date\": \"2012-10-10\",\n" +
                "    \"backdrop_path\": \"/dXTyVDTIgeByvUOUEiHjbi8xX9A.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 1412,\n" +
                "    \"vote_average\": 5.8,\n" +
                "    \"overview\": \"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.\",\n" +
                "    \"poster_path\": \"/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"The Flash\",\n" +
                "    \"genre_ids\": [\n" +
                "      18,\n" +
                "      10765\n" +
                "    ],\n" +
                "    \"name\": \"The Flash\",\n" +
                "    \"popularity\": 167.681,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 2970,\n" +
                "    \"first_air_date\": \"2014-10-07\",\n" +
                "    \"backdrop_path\": \"/6ZdQTBy20HzWudZthAV7NkZWfIb.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 60735,\n" +
                "    \"vote_average\": 6.7,\n" +
                "    \"overview\": \"After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.\",\n" +
                "    \"poster_path\": \"/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"The Simpsons\",\n" +
                "    \"genre_ids\": [\n" +
                "      16,\n" +
                "      35\n" +
                "    ],\n" +
                "    \"name\": \"The Simpsons\",\n" +
                "    \"popularity\": 178.661,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 2220,\n" +
                "    \"first_air_date\": \"1989-12-17\",\n" +
                "    \"backdrop_path\": \"/f5uNbUC76oowt5mt5J9QlqrIYQ6.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 456,\n" +
                "    \"vote_average\": 7.1,\n" +
                "    \"overview\": \"Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.\",\n" +
                "    \"poster_path\": \"/yTZQkSsxUFJZJe67IenRM0AEklc.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Riverdale\",\n" +
                "    \"genre_ids\": [\n" +
                "      18,\n" +
                "      9648\n" +
                "    ],\n" +
                "    \"name\": \"Riverdale\",\n" +
                "    \"popularity\": 148.182,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 713,\n" +
                "    \"first_air_date\": \"2017-01-26\",\n" +
                "    \"backdrop_path\": \"/2IUpoKSP64r6rp2vBo0Fdk8a1UU.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 69050,\n" +
                "    \"vote_average\": 7.2,\n" +
                "    \"overview\": \"Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.\",\n" +
                "    \"poster_path\": \"/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"See\",\n" +
                "    \"genre_ids\": [\n" +
                "      18,\n" +
                "      10765\n" +
                "    ],\n" +
                "    \"name\": \"See\",\n" +
                "    \"popularity\": 182.571,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 38,\n" +
                "    \"first_air_date\": \"2019-11-01\",\n" +
                "    \"backdrop_path\": \"/8TOkxONO3TEeJRuZWb0hG7SboyV.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 80752,\n" +
                "    \"vote_average\": 7.7,\n" +
                "    \"overview\": \"A virus has decimated humankind. Those who survived emerged blind. Centuries later when twins are born with the mythic ability to see, their father must protect his tribe against a threatened queen.\",\n" +
                "    \"poster_path\": \"/g3JsScc7mQCfc3e5e5rXwu7xVVP.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"4 Blocks\",\n" +
                "    \"genre_ids\": [\n" +
                "      18\n" +
                "    ],\n" +
                "    \"name\": \"4 Blocks\",\n" +
                "    \"popularity\": 211.204,\n" +
                "    \"origin_country\": [\n" +
                "      \"DE\"\n" +
                "    ],\n" +
                "    \"vote_count\": 23,\n" +
                "    \"first_air_date\": \"2017-05-08\",\n" +
                "    \"backdrop_path\": \"/jEdce7g6VZHMoJ7DANX8NFQkVAW.jpg\",\n" +
                "    \"original_language\": \"de\",\n" +
                "    \"id\": 71641,\n" +
                "    \"vote_average\": 6.8,\n" +
                "    \"overview\": \"Based in Neukölln, Berlin Toni manages the daily business of dealing with the Arabic gangs and ends up wanting to leave his old life behind for his family, but as expected, its never that simple.\",\n" +
                "    \"poster_path\": \"/jVObyxtNxuPbG5czuKvm7pW56EV.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"The End of the F***ing World\",\n" +
                "    \"genre_ids\": [\n" +
                "      35,\n" +
                "      80,\n" +
                "      18\n" +
                "    ],\n" +
                "    \"name\": \"The End of the F***ing World\",\n" +
                "    \"popularity\": 103.516,\n" +
                "    \"origin_country\": [\n" +
                "      \"GB\"\n" +
                "    ],\n" +
                "    \"vote_count\": 334,\n" +
                "    \"first_air_date\": \"2017-10-24\",\n" +
                "    \"backdrop_path\": \"/up1HuhhJnzrJ8El0ZJqpKNf0piL.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 74577,\n" +
                "    \"vote_average\": 7.9,\n" +
                "    \"overview\": \"James is 17 and is pretty sure he is a psychopath. Alyssa, also 17, is the cool and moody new girl at school. The pair make a connection and she persuades him to embark on a darkly comedic road trip in search of her real father.\",\n" +
                "    \"poster_path\": \"/xzwwzmXbz6n2Y3fc0GbjqGiFQPm.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Rick and Morty\",\n" +
                "    \"genre_ids\": [\n" +
                "      16,\n" +
                "      35,\n" +
                "      10759,\n" +
                "      10765\n" +
                "    ],\n" +
                "    \"name\": \"Rick and Morty\",\n" +
                "    \"popularity\": 170.027,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 1432,\n" +
                "    \"first_air_date\": \"2013-12-02\",\n" +
                "    \"backdrop_path\": \"/mzzHr6g1yvZ05Mc7hNj3tUdy2bM.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 60625,\n" +
                "    \"vote_average\": 8.6,\n" +
                "    \"overview\": \"Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.\",\n" +
                "    \"poster_path\": \"/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Family Guy\",\n" +
                "    \"genre_ids\": [\n" +
                "      16,\n" +
                "      35\n" +
                "    ],\n" +
                "    \"name\": \"Family Guy\",\n" +
                "    \"popularity\": 142.929,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 1706,\n" +
                "    \"first_air_date\": \"1999-01-31\",\n" +
                "    \"backdrop_path\": \"/pH38r4TWTqq7Mcs6XAlwgzNUeJe.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 1434,\n" +
                "    \"vote_average\": 6.5,\n" +
                "    \"overview\": \"Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.\",\n" +
                "    \"poster_path\": \"/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Law & Order: Special Victims Unit\",\n" +
                "    \"genre_ids\": [\n" +
                "      80,\n" +
                "      18\n" +
                "    ],\n" +
                "    \"name\": \"Law & Order: Special Victims Unit\",\n" +
                "    \"popularity\": 156.133,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 725,\n" +
                "    \"first_air_date\": \"1999-09-20\",\n" +
                "    \"backdrop_path\": \"/cD9PxbrdWYgL7MUpD9eOYuiSe2P.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 2734,\n" +
                "    \"vote_average\": 6.5,\n" +
                "    \"overview\": \"In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.\",\n" +
                "    \"poster_path\": \"/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Grey's Anatomy\",\n" +
                "    \"genre_ids\": [\n" +
                "      18\n" +
                "    ],\n" +
                "    \"name\": \"Grey's Anatomy\",\n" +
                "    \"popularity\": 137.287,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 1101,\n" +
                "    \"first_air_date\": \"2005-03-27\",\n" +
                "    \"backdrop_path\": \"/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 1416,\n" +
                "    \"vote_average\": 6.4,\n" +
                "    \"overview\": \"Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.\",\n" +
                "    \"poster_path\": \"/jnsvc7gCKocXnrTXF6p03cICTWb.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"South Park\",\n" +
                "    \"genre_ids\": [\n" +
                "      16,\n" +
                "      35\n" +
                "    ],\n" +
                "    \"name\": \"South Park\",\n" +
                "    \"popularity\": 113.218,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 1179,\n" +
                "    \"first_air_date\": \"1997-08-13\",\n" +
                "    \"backdrop_path\": \"/mSDKNVvDfitFE6Fb6fSSl5DQmgS.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 2190,\n" +
                "    \"vote_average\": 7.8,\n" +
                "    \"overview\": \"Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado.\",\n" +
                "    \"poster_path\": \"/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"ハンターｘハンター\",\n" +
                "    \"genre_ids\": [\n" +
                "      16,\n" +
                "      35,\n" +
                "      18,\n" +
                "      10759\n" +
                "    ],\n" +
                "    \"name\": \"Hunter x Hunter\",\n" +
                "    \"popularity\": 105.974,\n" +
                "    \"origin_country\": [\n" +
                "      \"JP\"\n" +
                "    ],\n" +
                "    \"vote_count\": 162,\n" +
                "    \"first_air_date\": \"2011-10-02\",\n" +
                "    \"backdrop_path\": \"/ye4oayd3csx8psElvvQPdO2fgdD.jpg\",\n" +
                "    \"original_language\": \"ja\",\n" +
                "    \"id\": 46298,\n" +
                "    \"vote_average\": 8.2,\n" +
                "    \"overview\": \"Twelve-year-old Gon Freecss one day discovers that the father he had always been told was dead was alive and well. His Father, Ging, is a Hunter—a member of society's elite with a license to go anywhere or do almost anything. Gon, determined to follow in his father's footsteps, decides to take the Hunter Examination and eventually find his father to prove himself as a Hunter in his own right. But on the way, he learns that there is more to becoming a Hunter than previously thought, and the challenges that he must face are considered the toughest in the world.\",\n" +
                "    \"poster_path\": \"/yWBcBIO9OrF3E85C5Arols6QNnG.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"NCIS: Los Angeles\",\n" +
                "    \"genre_ids\": [\n" +
                "      80,\n" +
                "      18,\n" +
                "      9648,\n" +
                "      10759\n" +
                "    ],\n" +
                "    \"name\": \"NCIS: Los Angeles\",\n" +
                "    \"popularity\": 93.59,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 404,\n" +
                "    \"first_air_date\": \"2009-09-22\",\n" +
                "    \"backdrop_path\": \"/j4ltPl0cHMd16UO80vbxFx1Td1w.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 17610,\n" +
                "    \"vote_average\": 6.8,\n" +
                "    \"overview\": \"The exploits of the Los Angeles–based Office of Special Projects (OSP), an elite division of the Naval Criminal Investigative Service that specializes in undercover assignments.\",\n" +
                "    \"poster_path\": \"/p0doUtM8RhXcAwHs6VmMZMQKpai.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Legacies\",\n" +
                "    \"genre_ids\": [\n" +
                "      18,\n" +
                "      9648,\n" +
                "      10765\n" +
                "    ],\n" +
                "    \"name\": \"Legacies\",\n" +
                "    \"popularity\": 103.404,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 202,\n" +
                "    \"first_air_date\": \"2018-10-25\",\n" +
                "    \"backdrop_path\": \"/wblSifvXAlqAYqEUoXmhpzeau7b.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 79460,\n" +
                "    \"vote_average\": 7.9,\n" +
                "    \"overview\": \"In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.\",\n" +
                "    \"poster_path\": \"/rb64COqdpRRfWOc6gWTfC7WxzXP.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Gotham\",\n" +
                "    \"genre_ids\": [\n" +
                "      80,\n" +
                "      18,\n" +
                "      14\n" +
                "    ],\n" +
                "    \"name\": \"Gotham\",\n" +
                "    \"popularity\": 90.969,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 1200,\n" +
                "    \"first_air_date\": \"2014-09-22\",\n" +
                "    \"backdrop_path\": \"/mKBP1OCgCG0jw8DwVYlnYqVILtc.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 60708,\n" +
                "    \"vote_average\": 6.9,\n" +
                "    \"overview\": \"Before there was Batman, there was GOTHAM. \\n\\nEveryone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker? \",\n" +
                "    \"poster_path\": \"/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"original_name\": \"Batwoman\",\n" +
                "    \"genre_ids\": [\n" +
                "      80,\n" +
                "      9648,\n" +
                "      10759,\n" +
                "      10765\n" +
                "    ],\n" +
                "    \"name\": \"Batwoman\",\n" +
                "    \"popularity\": 93.197,\n" +
                "    \"origin_country\": [\n" +
                "      \"US\"\n" +
                "    ],\n" +
                "    \"vote_count\": 128,\n" +
                "    \"first_air_date\": \"2019-10-06\",\n" +
                "    \"backdrop_path\": \"/spc5mNkW2daK1ob7Z7jqNkSlKS2.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"id\": 89247,\n" +
                "    \"vote_average\": 6.1,\n" +
                "    \"overview\": \"Kate Kane, armed with a passion for social justice and a flair for speaking her mind, soars onto the streets of Gotham as Batwoman, an out lesbian and highly trained street fighter primed to snuff out the failing city's criminal resurgence. But don't call her a hero yet. In a city desperate for a savior, Kate must overcome her own demons before embracing the call to be Gotham's symbol of hope\",\n" +
                "    \"poster_path\": \"/jnaimWkIVSD9IInmZPyLYarSvvc.jpg\"\n" +
                "  }\n" +
                "]"
        val responseType = object : TypeToken<List<TvShow>>() {}.type
        return Gson().fromJson(tvShows, responseType)
    }
}
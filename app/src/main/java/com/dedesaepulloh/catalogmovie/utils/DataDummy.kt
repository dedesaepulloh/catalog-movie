package com.dedesaepulloh.catalogmovie.utils

import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.TrailerEntity
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import com.dedesaepulloh.catalogmovie.data.source.remote.response.movie.MovieResults

object DataDummy {

    fun generateDummyGenre(): List<GenreEntity> {
        val genre = ArrayList<GenreEntity>()
        genre.add(
            GenreEntity(
                28,
                "Action"
            )
        )
        return genre
    }

    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                438631,
                28,
                "Dune",
                "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                7628.716,
                "d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
                "2021-09-15",
                8.1,
                2392.0,
                "Aebz7s8EHQXxHR98J8Vw6QVGggq.jpg"
            )
        )
        return movies
    }

    fun generateDummyTrailer(): List<TrailerEntity> {
        val trailer = ArrayList<TrailerEntity>()
        trailer.add(
            TrailerEntity(
                "5e382d1b4ca676001453826d",
                438631,
                "w0HgHet0sxg",
                "YouTube",
                "Final Trailer",
                "Trailer",
                "2021-10-07 16:00:27 UTC"
            )
        )
        return trailer
    }

    fun generateDummyReview(): List<ReviewEntity> {
        val review = ArrayList<ReviewEntity>()
        review.add(
            ReviewEntity(
                "616262f133ec2600456a6d65",
                438631,
                "jxjhJHxCoKSITNttsrJ5E5LCyit.jpg",
                "RADIO1'S MR. MOVIE!-MAD AMI \uD83C\uDF20",
                10.0,
                "Radio1'sMr.Movie!-MadAmi\uD83C\uDF20",
                "2021-10-11T01:54:49.251Z",
                "RADIO1'S MR. MOVIE!-MAD AMI \uD83C\uDF20",
                "2021-10-10T03:50:09.811Z",
                "\\r\\n**FABULOUS \uD83E\uDD47\uD83E\uDD47\uD83E\uDD47\uD83E\uDD47 . . . . And , Oh , Yes . . . . Hans Zimmer's Score's Already Got \\\"OSCAR\\\" Written On It \uD83D\uDE09 ; & EXPECT A WHOLE \\\" HOST OF OTHER _MAJOR_ NOMINATIONS - AS WELL \\\"**\\r\\n\\r\\nThis Is A **- _B I G_ -** Screen - MINI - Review. Picture Viewed Oct. 07, 2021 ; At Vox Cinemas , U . A . E\\r\\n\\r\\n______________________________________________________\\r\\n\\r\\nPaul Atreides : \\\" Fear is the mind-killer. Fear is the little death that brings total obliteration. I will face my fear, and I will permit it to pass over me. When the fear has gone, there will be nothing. Only I will remain \\\".\\r\\n\\r\\n_______________________________________\\r\\n_______________\\r\\n\\r\\n**1.** If you're  one of the -Millions- of people around the world who loved Denis Villeneuve's hauntingly riveting 2015 thriller 'Sicario', ( yours truly included ) ; then strap in for 'one hell of an Interstellar ride, with an -{ EQUALLY }- **\\\" INTERSTELLAR \uD83C\uDF20 \\\"** CAST . . . . that -literally- presents itself like a Who's-who of Hollywood's \\\"Best, And Brightest\\\". This time around, the unequivocally -{ Prolific }- Academy Award nominated French Canadian director has taken acclaimed American author Frank Herbert's 1965 sci-fi thriller, ( once touted as the world's -Best- selling science fiction novel ), & turned it into a veritable masterpiece of a movie. -Make Sure- to 'keep a special eye out' for Rebecca Ferguson's completely \\\"Stunning\\\" portrayal of 'Lady Jessica Atreides' . . . . I can promise that you most certainly -Will Not- regret it. \\r\\n\\r\\n**2.** Almost needless to say, the Music, Acting , Cinematography \uD83D\uDD25 , Art-direction, C.g.i, Dramatic pacing & the sprawling, lavish Set-pieces are all, well . . . -{ \\\" Past Compare \\\" }- .\\r\\nWhen it comes to 2021's cinematic 'big budget\\\" smorgasbord : if you want to see the -Very- best Popcorn Flick \\\"Sensation\\\" of the year, it's most unequivocally going to be Bond 25 : 'No Time To Die'. But, on the -other- hand, if you're more in the mood for some -equally- magnificent **\\\"Artfilm Meets Blockbuster\\\" ( no seriously )** fare . . . that may -Well- hold you in a state of 'Absolute Rapture' from start to finish, then 'Dune' should most -Definitely- be your first choice. Just make sure to come to said movie with a { Genuinely } open and unbiased --- Heart , And Mind \uD83D\uDE43 . \\r\\n\\r\\n**3. \\\" Final Analysis \\\" :** The only -{ Pronounced }- lack you will feel, if any at all, is that of -{ Humour }‐ . . . . especially if you're someone who enjoys their big screen delights served with, well, a \\\"generous\\\" side of unrestrained -Mirth- . I counted -Literally- only about \\\"3.5\\\" barely plausible funny moments in the -Entire- flick. But the obvious reason for that is : it simply -Wouldn't- have worked within this sort of a 'Deadly Serious' dark, dramatic, & super futuristic setting ( 10,191 \\\"a.g\\\", to be precise ). So, having taken -that- aspect of the production into consideration ; it really ended up -_NOT_ - bothering me very much, AT ALL. Thus, in sum . . . . I was utterly **-{ MESMERIZED }-** by \\\" Dune : Part 1 \\\" and hence ; I chose to give it a **\\\" Wholehearted, Adoring, MEGA-APPRECIATIVE 13 Marks Out Of 10❗\\\" .**"
            )
        )
        return review
    }

    fun generateDummyGenreResponse(): List<GenresItem> {
        val genre = ArrayList<GenresItem>()
        genre.add(
            GenresItem(
                28,
                "Action"
            )
        )
        return genre
    }

    fun generateDummyMovieResponse(): List<MovieResults> {
        val movies = ArrayList<MovieResults>()
        movies.add(
            MovieResults(
                438631,
                listOf(28),
                "Dune",
                "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                7628.716,
                "d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
                "2021-09-15",
                8.1,
                2392.0,
                "Aebz7s8EHQXxHR98J8Vw6QVGggq.jpg"
            )
        )
        return movies
    }

}
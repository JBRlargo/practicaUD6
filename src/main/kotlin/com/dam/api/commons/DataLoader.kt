package com.dam.api.commons

import com.dam.api.models.Movie
import com.dam.api.models.Session
import com.dam.api.models.User
import com.dam.api.repositories.MoviesRepository
import com.dam.api.repositories.SessionsRepository
import com.dam.api.repositories.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.Month

@Component
class DataLoader: ApplicationRunner {
    @Autowired
    lateinit var moviesRepository: MoviesRepository

    @Autowired
    lateinit var sessionsRepository: SessionsRepository

    @Autowired
    lateinit var usersRepository: UsersRepository

    override fun run(args: ApplicationArguments?) {
        var movie1 = Movie("The Shawshank Redemption", "Frank Darabont", "142 min",
            "6hB3S9bIaco",
            "https://i.etsystatic.com/16821137/r/il/c8b3e3/1879586236/il_570xN.1879586236_kdtm.jpg",
            "https://screen-shot.co.uk/wp-content/uploads/2020/02/hwn4d-6A12XQP8T2V-Full-Image_GalleryBackground-en-US-1515800147091._SX1080_-e1582213326518.jpg",
            "Acusado del asesinato de su mujer, Andrew Dufresne (Tim Robbins), tras ser condenado a cadena perpetua, es enviado a la cárcel de Shawshank. Con el paso de los años conseguirá ganarse la confianza del director del centro y el respeto de sus compañeros de prisión, especialmente de Red (Morgan Freeman), el jefe de la mafia de los sobornos.",
            null
            )
        var movie2 = Movie("The Godfather", "Francis Ford Coppola", "175 min",
            "UaVTIH8mujA",
            "https://media.posterlounge.com/images/big/1878326.jpg",
            "https://i.pinimg.com/originals/d5/4d/86/d54d868ad678968d671ef8e287925c48.jpg",
            "América, años 40. Don Vito Corleone (Marlon Brando) es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York. Tiene cuatro hijos: Connie (Talia Shire), el impulsivo Sonny (James Caan), el pusilánime Fredo (John Cazale) y Michael (Al Pacino), que no quiere saber nada de los negocios de su padre. Cuando Corleone, en contra de los consejos de 'Il consigliere' Tom Hagen (Robert Duvall), se niega a participar en el negocio de las drogas, el jefe de otra banda ordena su asesinato. Empieza entonces una violenta y cruenta guerra entre las familias mafiosas.",
            null
        )
        var movie3 = Movie( "The Dark Knight", "Christopher Nolan", "152 min",
            "EXeTwQWrcwY",
            "https://static.posters.cz/image/750/posters/batman-dark-knight-joker-i13945.jpg",
            "https://m.media-amazon.com/images/M/MV5BMTkyNTI0NDM5NF5BMl5BanBnXkFtZTcwMDkzMTk2Mw@@._V1_.jpg",
            "Batman/Bruce Wayne (Christian Bale) regresa para continuar su guerra contra el crimen. Con la ayuda del teniente Jim Gordon (Gary Oldman) y del Fiscal del Distrito Harvey Dent (Aaron Eckhart), Batman se propone destruir el crimen organizado en la ciudad de Gotham. El triunvirato demuestra su eficacia, pero, de repente, aparece Joker (Heath Ledger), un nuevo criminal que desencadena el caos y tiene aterrados a los ciudadanos",
            null
        )
        var movie4 = Movie( "Pulp Fiction", "Quentin Tarantino", "154 min",
            "s7EdQ4FqbhY",
            "https://static.posters.cz/image/1300/posters/pulp-fiction-cover-i1288.jpg",
            "https://film-grab.com/wp-content/uploads/photo-gallery/22%20(847).jpg?bwg=1547379565",
            "Jules y Vincent, dos asesinos a sueldo con no demasiadas luces, trabajan para el gángster Marsellus Wallace. Vincent le confiesa a Jules que Marsellus le ha pedido que cuide de Mia, su atractiva mujer. Jules le recomienda prudencia porque es muy peligroso sobrepasarse con la novia del jefe. Cuando llega la hora de trabajar, ambos deben ponerse 'manos a la obra'. Su misión: recuperar un misterioso maletín.",
            null
        )
        var movie5 = Movie( "The Lord of the Rings: The Return of the King", "Peter Jackson", "201 min",
            "h-9RYiqyqjk",
            "https://i.etsystatic.com/10683147/r/il/fd0952/3350989948/il_570xN.3350989948_l91u.jpg",
            "https://m.media-amazon.com/images/M/MV5BMTMwOTc2MDI5NF5BMl5BanBnXkFtZTcwNzk2MTk2Mw@@._V1_.jpg",
            "Las fuerzas de Saruman han sido destruidas, y su fortaleza sitiada. Ha llegado el momento de decidir el destino de la Tierra Media, y, por primera vez, parece que hay una pequeña esperanza. El interés del señor oscuro Sauron se centra ahora en Gondor, el último reducto de los hombres, cuyo trono será reclamado por Aragorn. Sauron se dispone a lanzar un ataque decisivo contra Gondor. Mientras tanto, Frodo y Sam continuan su camino hacia Mordor, con la esperanza de llegar al Monte del Destino.",
            null
        )
        var movie6 = Movie( "The Matrix", "The Wachowskis", "136 min",
            null,
            "https://i.ebayimg.com/images/g/QFQAAOSwAQpfjaA6/s-l1600.jpg",
            "https://film-grab.com/wp-content/uploads/2017/01/thematrix041.jpg",
            "Thomas Anderson es un brillante programador de una respetable compañía de software. Pero fuera del trabajo es Neo, un hacker que un día recibe una misteriosa visita...",
            null
        )

        val user1 = User(1, "Pedrito", "jltrgd@gmail.com", null, "static/profilepics/meme.jpg")
        val user2 = User(2, "Pepito", "example@example.com", "49e36d262cb0021f41e289094f921f476db3f764", "static/profilepics/default.svg")
        val user3 = User(3, "Juanillo", "example2@example.com", "123456", "static/profilepics/8627e-16714354564128-1920.jpg")

        movie1 = moviesRepository.save(movie1)
        movie2 = moviesRepository.save(movie2)
        movie3 = moviesRepository.save(movie3)
        movie4 = moviesRepository.save(movie4)
        movie5 = moviesRepository.save(movie5)
        movie6 = moviesRepository.save(movie6)

        val session1 = Session(1, movie1, 1, LocalDate.of(2023, Month.MARCH, 3))
        val session2 = Session(2, movie2, 2, LocalDate.of(2023, Month.MARCH, 3))
        val session3 = Session(3, movie3, 1, LocalDate.of(2023, Month.MARCH, 4))
        val session4 = Session(4, movie4, 2, LocalDate.of(2023, Month.MARCH, 4))
        val session5 = Session(5, movie5, 1, LocalDate.of(2023, Month.MARCH, 5))
        val session6 = Session(6, movie6, 2, LocalDate.of(2023, Month.MARCH, 5))
        val session7 = Session(7, movie1, 1, LocalDate.of(2023, Month.MARCH, 6))
        val session8 = Session(8, movie2, 2, null)
        val session9 = Session(9, movie3, 1, LocalDate.of(2023, Month.MARCH, 7))
        val session10 = Session(10, movie4, 2, LocalDate.of(2023, Month.MARCH, 7))
        val session11 = Session(11, movie5, 1, LocalDate.of(2023, Month.MARCH, 8))
        val session12 = Session(12, movie1, 2, LocalDate.of(2023, Month.MARCH, 8))
        val session13 = Session(13, movie2, 1, LocalDate.of(2023, Month.MARCH, 9))
        val session14 = Session(14, movie3, 2, LocalDate.of(2023, Month.MARCH, 9))
        val session15 = Session(15, movie4, 1, LocalDate.of(2023, Month.MARCH, 10))
        val session16 = Session(16, movie1, 2, LocalDate.of(2023, Month.MARCH, 10))
        val session17 = Session(17, movie2, 1, LocalDate.of(2023, Month.MARCH, 11))
        val session18 = Session(18, movie3, 2, LocalDate.of(2023, Month.MARCH, 11))
        val session19 = Session(19, movie4, 1, LocalDate.of(2023, Month.MARCH, 12))
        val session20 = Session(20, movie5, 2, LocalDate.of(2023, Month.MARCH, 12))
        val session21 = Session(21, movie1, 1, LocalDate.of(2023, Month.MARCH, 13))
        val session22 = Session(22, movie2, 2, LocalDate.of(2023, Month.MARCH, 13))
        val session23 = Session(23, movie3, 1, LocalDate.of(2023, Month.MARCH, 14))
        val session24 = Session(24, movie4, 2, LocalDate.of(2023, Month.MARCH, 14))
        val session25 = Session(25, movie5, 1, LocalDate.of(2023, Month.MARCH, 15))
        val session26 = Session(26, movie6, 2, LocalDate.of(2023, Month.MARCH, 15))
        val session27 = Session(27, movie1, 1, LocalDate.of(2023, Month.MARCH, 16))
        val session28 = Session(28, movie2, 2, LocalDate.of(2023, Month.MARCH, 16))
        val session29 = Session(29, movie3, 1, LocalDate.of(2023, Month.MARCH, 17))
        val session30 = Session(30, movie4, 2, LocalDate.of(2023, Month.MARCH, 17))

        usersRepository.save(user1)
        usersRepository.save(user2)
        usersRepository.save(user3)

        sessionsRepository.save(session1)
        sessionsRepository.save(session2)
        sessionsRepository.save(session3)
        sessionsRepository.save(session4)
        sessionsRepository.save(session5)
        sessionsRepository.save(session6)
        sessionsRepository.save(session7)
        sessionsRepository.save(session8)
        sessionsRepository.save(session9)
        sessionsRepository.save(session10)
        sessionsRepository.save(session11)
        sessionsRepository.save(session12)
        sessionsRepository.save(session13)
        sessionsRepository.save(session14)
        sessionsRepository.save(session15)
        sessionsRepository.save(session16)
        sessionsRepository.save(session17)
        sessionsRepository.save(session18)
        sessionsRepository.save(session19)
        sessionsRepository.save(session20)
        sessionsRepository.save(session21)
        sessionsRepository.save(session22)
        sessionsRepository.save(session23)
        sessionsRepository.save(session24)
        sessionsRepository.save(session25)
        sessionsRepository.save(session26)
        sessionsRepository.save(session27)
        sessionsRepository.save(session28)
        sessionsRepository.save(session29)
        sessionsRepository.save(session30)
    }
}
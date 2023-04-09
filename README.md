Project name: movie_review.
A movie review platform.


Action performed:
    a.	Search a movie by title
    b.	Rate and add review for a movie
    c.	Search a top 5 movie by genre

Tech Stacks:
Springboot,Java8,Hibernate/Jpa.

Entity:
    Movie:{
        Id,
        title,
        genre,
        rating,
        <reviews>
        Release date
        Length
        Cast
        }
    Review: {
        Id,
        movieTitle,
        rating,
        review
        Userid,
        createdAt,
        }
		

Entity relation: One movie can contain many reviews  -> One to many relationship.


APIs:
    Admin:
        addMovie ->POST  --> priority
        updateMovie ->
        deleteMovie ->
    ..movie/
    SearchByTitle -> GET
        ../movie/:title
    AddReview -> POST
         ../review/
    SearchByGenre -> GET
         ../genre/:genre



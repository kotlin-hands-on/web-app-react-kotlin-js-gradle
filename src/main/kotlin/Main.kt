import kotlinx.browser.document
import react.dom.html.ReactHTML.p


fun main() {

    data class Video(
        val id: Int,
        val title: String,
        val speaker: String,
        val videoUrl: String
    )

    val unwatchedVideos = listOf(
        Video(1, "Opening Keynote", "Andrey Breslav", "https://youtu.be/PsaFVLr8t4E"),
        Video(2, "Dissecting the stdlib", "Huyen Tue Dao", "https://youtu.be/Fzt_9I733Yg"),
        Video(5, "Kotlin and Spring Boot", "Nicolas Frankel", "https://youtu.be/pSiZVAeReeg"),
        Video(3, "Kotlin and Spring Boot", "Nicolas Frankel", "https://youtu.be/pSiZVAeReeg")
    )

    val watchedVideos = listOf(
        Video(4, "Creating Internal DSLs in Kotlin", "Venkat Subramaniam", "https://youtu.be/JzTeAM8N1-o")
    )

    for (video in unwatchedVideos) {
        p {
            +"${video.speaker}: ${video.title}"
        }
    }
    for (video in watchedVideos) {
        p {
            +"${video.speaker}: ${video.title}"
        }
    }

    val container = document.getElementById("root") ?: error("Couldn't find root container!")

//    render(Fragment.create {
//        h1 {
//            +"Hello, React+Kotlin/JS!"
//        }
//        div {
//            h3 {
//                +"Videos to watch"
//            }
//            p {
//                +"John Doe: Building and breaking things"
//            }
//            p {
//                +"Jane Smith: The development process"
//            }
//            p {
//                +"Matt Miller: The Web 7.0"
//            }
//
//            h3 {
//                +"Videos watched"
//            }
//            p {
//                +"Tom Jerry: Mouseless development"
//            }
//        }
//        div {
//            h3 {
//                +"John Doe: Building and breaking things"
//            }
//            img {
//                src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
//            }
//        }
//    }, container)
}
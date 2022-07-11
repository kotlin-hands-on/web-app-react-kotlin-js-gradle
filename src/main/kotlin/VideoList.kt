import kotlinx.browser.window
import react.*
import react.dom.*
import react.dom.html.ReactHTML.p

external interface VideoListProps : Props {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit
}

val VideoList = FC<VideoListProps> { props ->
    for (video in props.videos) {
        p {
            key = video.id.toString()
            onClick = {
                props.onSelectVideo(video)
            }
            if (video == props.selectedVideo) {
                +"▶ "
            }
            +"${video.speaker}: ${video.title}"
        }
    }
}
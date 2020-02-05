import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import styled.*

external interface VideoPlayerProps : RProps {
    var video: Video
    var onWatchedButtonPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
}

class VideoPlayer(props: VideoPlayerProps) : RComponent<VideoPlayerProps, RState>(props) {
    override fun RBuilder.render() {
        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3 {
                +"${props.video.speaker}: ${props.video.title}"
            }
            styledButton {
                css {
                    display = Display.block
                    backgroundColor = if (props.unwatchedVideo) Color.lightGreen else Color.red
                }
                attrs {
                    onClickFunction = {
                        props.onWatchedButtonPressed(props.video)
                    }
                }
                if (props.unwatchedVideo) {
                    +"Mark as watched"
                } else {
                    +"Mark as unwatched"
                }
            }
            styledDiv {
                css {
                    display = Display.flex
                    marginBottom = 10.px
                }
                emailShareButton {
                    attrs.url = props.video.videoUrl
                    emailIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }

                telegramShareButton {
                    attrs.url = props.video.videoUrl
                    telegramIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }
            }
            reactPlayer {
                attrs.url = props.video.videoUrl
            }
        }
    }
}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit): ReactElement {
    return child(VideoPlayer::class) {
        this.attrs(handler)
    }
}
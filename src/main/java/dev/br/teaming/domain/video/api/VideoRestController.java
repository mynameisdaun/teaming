package dev.br.teaming.domain.video.api;

import dev.br.teaming.domain.player.domain.vo.PlayerTag;
import dev.br.teaming.domain.video.application.VideoService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/video")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RestController
public class VideoRestController {
    private final VideoService videoService;

    @GetMapping
    public ResponseEntity<?> findAll(final HttpRequest request) {
        PlayerTag playerTag = new PlayerTag("#YLUPG8PJP");
        return ResponseEntity.ok(videoService.findAllByPlayerTag(playerTag));
    }


}

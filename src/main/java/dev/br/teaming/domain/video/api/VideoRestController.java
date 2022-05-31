package dev.br.teaming.domain.video.api;

import dev.br.teaming.domain.player.domain.vo.PlayerTag;
import dev.br.teaming.domain.video.application.VideoService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/api/video")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RestController
public class VideoRestController {
    private final VideoService videoService;

    @GetMapping
    public ResponseEntity<?> findAll(final HttpServletRequest request) {
        PlayerTag playerTag = new PlayerTag("#YLUPG8PJP");
        return ResponseEntity.ok(videoService.findAllByPlayerTag(playerTag));
    }

    @PostMapping("/manualUpdate")
    public ResponseEntity<?> manualUpdate(final HttpServletRequest request) {
        String keyword = "홀릿";
        return ResponseEntity.ok(videoService.manualVideoUpdate(keyword));
    }
}

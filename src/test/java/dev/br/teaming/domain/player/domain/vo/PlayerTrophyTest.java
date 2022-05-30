package dev.br.teaming.domain.player.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTrophyTest {

    static Stream<Arguments> wrong_trophies_list() {
        return Stream.of(
                Arguments.of(1, -1),
                Arguments.of(-1, 1)
        );
    }

    @DisplayName(value = "트로피를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final int currentTrophy = 10;
        final int highestTrophy = 100;
        //when
        final PlayerTrophy playerTrophy = new PlayerTrophy(currentTrophy, highestTrophy);
        //then
        assertThat(playerTrophy).isNotNull();
        assertThat(playerTrophy.getCurrentTrophy()).isEqualTo(10);
        assertThat(playerTrophy.getHighestTrophy()).isEqualTo(100);
    }

    @DisplayName(value = "트로피의 각 개수는 0이상이어야 한다")
    @MethodSource("wrong_trophies_list")
    @ParameterizedTest
    void create_fail_wrong_trophy(final int currentTrophy, final int highestTrophy) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new PlayerTrophy(currentTrophy, highestTrophy))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "최고 트로피 갯수는 항상 현재 트로피 갯숙보다 같거나 커야 한다")
    @Test
    void create_invalid_trophy_highest_should_gt_current() throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new PlayerTrophy(20, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

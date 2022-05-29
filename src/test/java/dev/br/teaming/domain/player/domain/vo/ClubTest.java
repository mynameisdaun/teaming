package dev.br.teaming.domain.player.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ClubTest {

    @DisplayName(value = "클럽 정보를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String clubTag = "#LGPVQV";
        final String clubName = "다운클럽";
        //when
        final Club club = new Club(clubTag, clubName);
        //then
        assertThat(club).isNotNull();
        assertThat(club.getClubTag()).isEqualTo("#LGPVQV");
        assertThat(club.getClubName()).isEqualTo("다운클럽");
    }

    @DisplayName(value = "클럽 Tag는 빈 값이 될 수 없고, #으로 시작해야 한다")
    @ValueSource(strings = {"", " ", "LGPVQV"})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_club_tag(final String tag) throws Exception {
        //given&&when&&then
        final String clubName = "다운클럽";
        assertThatThrownBy(() -> new Club(tag, clubName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "클럽명은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String name) throws Exception {
        //given&&when&&then
        final String clubTag = "#LGPVQV";
        assertThatThrownBy(() -> new Club(clubTag, name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

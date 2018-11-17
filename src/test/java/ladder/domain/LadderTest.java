package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리_한줄_생성() {
        Ladder ladder = new Ladder();
        int result = ladder.generateLadder(1, 4);
        assertThat(result).isEqualTo(1);
    }
}

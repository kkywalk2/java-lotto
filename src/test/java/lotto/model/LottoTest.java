package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

    @DisplayName("lotto 번호와 당첨 번호가 주어졌을 때 일치하는 카운트를 반환하는지 검증")
    @ParameterizedTest
    @MethodSource("matchParameter")
    void matchTest(Lotto lotto, Lotto winningNnumber, int expected) {
        assertThat(lotto.matchCount(winningNnumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchParameter() {
        List<LottoNumber> pickedLottoNumbers = Arrays.asList(new LottoNumber(1),
                                                             new LottoNumber(2),
                                                             new LottoNumber(3),
                                                             new LottoNumber(4),
                                                             new LottoNumber(5),
                                                             new LottoNumber(6));

        return Stream.of(Arguments.of(new Lotto(pickedLottoNumbers),
                                      new Lotto(Arrays.asList(new LottoNumber(1),
                                                              new LottoNumber(2),
                                                              new LottoNumber(3),
                                                              new LottoNumber(4),
                                                              new LottoNumber(5),
                                                              new LottoNumber(6))),
                                      6),
                         Arguments.of(new Lotto(pickedLottoNumbers),
                                      new Lotto(Arrays.asList(new LottoNumber(1),
                                                              new LottoNumber(2),
                                                              new LottoNumber(3),
                                                              new LottoNumber(4),
                                                              new LottoNumber(5),
                                                              new LottoNumber(7))),
                                      5),
                         Arguments.of(new Lotto(pickedLottoNumbers),
                                      new Lotto(Arrays.asList(new LottoNumber(1),
                                                              new LottoNumber(2),
                                                              new LottoNumber(3),
                                                              new LottoNumber(4),
                                                              new LottoNumber(9),
                                                              new LottoNumber(10))),
                                      4),
                         Arguments.of(new Lotto(pickedLottoNumbers),
                                      new Lotto(Arrays.asList(new LottoNumber(1),
                                                              new LottoNumber(2),
                                                              new LottoNumber(3),
                                                              new LottoNumber(8),
                                                              new LottoNumber(9),
                                                              new LottoNumber(10))),
                                      3),
                         Arguments.of(new Lotto(pickedLottoNumbers),
                                      new Lotto(Arrays.asList(new LottoNumber(36),
                                                              new LottoNumber(22),
                                                              new LottoNumber(15),
                                                              new LottoNumber(17),
                                                              new LottoNumber(26),
                                                              new LottoNumber(44))),
                                      0));
    }

    @DisplayName("Lotto와 bonus number가 주어졌을 때 해당 number를 포함하고 있는지 반환하는지 검증")
    @ParameterizedTest
    @CsvSource({ "3, true", "7, false" })
    void containsTest(int bonusNumber, boolean expected) {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1),
                                              new LottoNumber(2),
                                              new LottoNumber(3),
                                              new LottoNumber(4),
                                              new LottoNumber(5),
                                              new LottoNumber(6)));
        assertThat(lotto.contains(new LottoNumber(bonusNumber))).isEqualTo(expected);
    }
}
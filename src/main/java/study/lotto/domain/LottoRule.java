package study.lotto.domain;

import java.util.*;

public class LottoRule {
    private static final int LOTTO_NUMBER_TOTAL = 6;

    private LottoRule() {
    }

    public static boolean isComplianceNumberRule(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) ||
                lottoNumbers.size() != LOTTO_NUMBER_TOTAL) {
            return false;
        }

        Set<Integer> uniqLottoNumbers = new HashSet<>(lottoNumbers);
        return uniqLottoNumbers.size() == LOTTO_NUMBER_TOTAL;
    }

    public static LottoRank getWinningRank(LottoTicket lottoTicket,
                                           LottoWinningNumber lottoWinningNumber) {
        List<LottoNumber> matches = lottoWinningNumber.getMatches(lottoTicket);

        return LottoRank.matchCountOf(matches.size());
    }
}
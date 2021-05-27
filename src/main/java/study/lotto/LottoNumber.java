package study.lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {


    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static void validateLottoNumber(int number){
        if (!LottoGame.AVAILABLE_LOTTONUMBERS.contains(number)) {
            throw new IllegalArgumentException("잘못된 로또 번호입니다");
        }
    }

    public int value() {
        return lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LottoNumber)) {
            return false;
        }
        LottoNumber l = (LottoNumber) obj;
        return lottoNumber == l.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (this.lottoNumber < lottoNumber.lottoNumber) {
            return -1;
        }
        if (this.lottoNumber > lottoNumber.lottoNumber) {
            return 1;
        }
        return 0;
    }

}

package racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import racingcar.constants.Message

/**
 * Car 클래스 테스트 클래스
 * Created by Jaesungchi on 2022.05.12..
 */
class CarTest {

    @Test
    fun `차량 이름이 5글자가 넘어갈 경우엔 에러가 발생한다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Car("abcdefg")
        }.withMessageMatching(Message.ExceptionMessage.CANNOT_NAME_EXCEED_5_CHARACTERS)
    }

    @ParameterizedTest
    @EmptySource
    fun `차량 이름이 빈칸인 경우엔 에러가 발생한다`(source: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Car(source)
        }.withMessageMatching(Message.ExceptionMessage.CANNOT_NAME_BE_BLANK)
    }

    @Test
    fun `차량은 전진하는 점수일때 전진한다`() {
        val car = Car("link")
        car.playOneRound(true)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `차량은 전진하는 점수가 아니라면 전진하지않는다`() {
        val car = Car("link")
        car.playOneRound(false)
        assertThat(car.position).isEqualTo(0)
    }
}
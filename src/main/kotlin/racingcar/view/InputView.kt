package racingcar.view

import racingcar.domain.Car

class InputView {
    fun askHowManyCars(): List<Car> {
        val cars = input(HOW_MANY_CAR)
        try {
            val names = cars!!.split(",").map { it.trim() }
            return names.map { Car(it) }
        } catch (e: Car.NameLengthOverflowException) {
            throw SetupFailException(ERROR_CAR_NAME_OVERFLOW)
        } catch (e: Exception) {
            throw SetupFailException(CAR_NUMBER_ERROR)
        }
    }

    fun askHowManyTurns(): Int {
        val turns = input(HOW_MANY_TURN)
        try {
            return turns?.toInt()!!
        } catch (e: Exception) {
            throw SetupFailException(TURN_NUMBER_ERROR)
        }
    }

    private fun input(message: String?): String? {
        if (message != null) {
            println(message)
        }
        return readLine()
    }

    class SetupFailException(override val message: String) : Exception()
}
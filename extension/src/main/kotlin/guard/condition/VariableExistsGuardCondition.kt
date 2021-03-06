package io.holunda.camunda.bpm.data.guard.condition

import io.holunda.camunda.bpm.data.factory.VariableFactory
import io.holunda.camunda.bpm.data.guard.GuardViolation
import java.util.*

/**
 * Condition to check if the variable exists.
 * @param variableFactory factory to work on.
 * @param local flag indicating if local or global scope is required.
 */
class VariableExistsGuardCondition<T>(
  variableFactory: VariableFactory<T>,
  local: Boolean = false
) : VariableGuardCondition<T>(variableFactory, local) {

  override fun evaluate(option: Optional<T>) =
    if (option.isPresent) {
      super.evaluate(option)
    } else {
      listOf(GuardViolation(
        condition = this,
        option = option,
        message = "Expecting$localLabel variable '${variableFactory.name}' to be set, but it was not found.")
      )
    }
}

/**
 * Creation extension for the condition.
 * @param local is the variable should be local.
 * @return instance of [VariableExistsGuardCondition] on current factory.
 */
fun <T> VariableFactory<T>.exists(local: Boolean = false) = VariableExistsGuardCondition(this, local)

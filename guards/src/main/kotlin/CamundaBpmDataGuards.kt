package io.holunda.camunda.bpm.data.guard

import io.holunda.camunda.bpm.data.factory.VariableFactory
import io.holunda.camunda.bpm.data.guard.condition.exists
import io.holunda.camunda.bpm.data.guard.condition.hasOneOfValues
import io.holunda.camunda.bpm.data.guard.condition.hasValue
import io.holunda.camunda.bpm.data.guard.condition.notExists

/**
 * Guard creation methods.
 */
@Suppress("unused")
object CamundaBpmDataGuards {

  /**
   * Creates exists condition.
   */
  fun <T> exists(variableFactory: VariableFactory<T>, local: Boolean = false) = variableFactory.exists(local)

  /**
   * Creates not exists condition.
   */
  fun <T> notExists(variableFactory: VariableFactory<T>, local: Boolean = false) = variableFactory.notExists(local)

  /**
   * Creates has value condition.
   */
  fun <T> hasValue(variableFactory: VariableFactory<T>, value: T, local: Boolean = false) = variableFactory.hasValue(value, local)

  /**
   * Creates has value condition.
   */
  fun <T> hasOneOfValues(variableFactory: VariableFactory<T>, values: Set<T>, local: Boolean = false) = variableFactory.hasOneOfValues(values, local)
}



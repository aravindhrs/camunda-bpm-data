package io.holunda.camunda.bpm.data.adapter.basic;

import io.holunda.camunda.bpm.data.adapter.ValueWrapperUtil;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.variable.value.TypedValue;

import java.util.Optional;

/**
 * Read write adapter for task service access.
 *
 * @param <T> type of value.
 */
public class ReadWriteAdapterTaskService<T> extends AbstractBasicReadWriteAdapter<T> {

  private final TaskService taskService;
  private final String taskId;

  /**
   * Constructs the adapter.
   *
   * @param taskService  task service to use.
   * @param taskId       id of the task to read from and write to.
   * @param variableName name of the variable.
   * @param clazz        class of the variable.
   */
  public ReadWriteAdapterTaskService(TaskService taskService, String taskId, String variableName, Class<T> clazz) {
    super(variableName, clazz);
    this.taskService = taskService;
    this.taskId = taskId;
  }

  @Override
  public Optional<T> getOptional() {
    return Optional.ofNullable(getOrNull(taskService.getVariable(taskId, variableName)));
  }

  @Override
  public void set(T value, boolean isTransient) {
    taskService.setVariable(taskId, variableName, getTypedValue(value, isTransient));
  }

  @Override
  public void setLocal(T value, boolean isTransient) {
    final TypedValue typedValue = ValueWrapperUtil.getTypedValue(clazz, value, isTransient);
    taskService.setVariableLocal(taskId, variableName, getTypedValue(value, isTransient));
  }

}
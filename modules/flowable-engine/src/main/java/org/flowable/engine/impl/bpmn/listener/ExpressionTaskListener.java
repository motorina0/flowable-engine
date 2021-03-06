/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.flowable.engine.impl.bpmn.listener;

import org.flowable.engine.delegate.DelegateTask;
import org.flowable.engine.delegate.Expression;
import org.flowable.engine.delegate.TaskListener;

/**
 * @author Joram Barrez
 */
public class ExpressionTaskListener implements TaskListener {

  protected Expression expression;

  public ExpressionTaskListener(Expression expression) {
    this.expression = expression;
  }

  public void notify(DelegateTask delegateTask) {
    expression.getValue(delegateTask);
  }

  /**
   * returns the expression text for this task listener. Comes in handy if you want to check which listeners you already have.
   */
  public String getExpressionText() {
    return expression.getExpressionText();
  }

}

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
package org.flowable.standalone.cfg;

import java.util.List;

import org.flowable.engine.ManagementService;
import org.flowable.engine.common.impl.Page;
import org.flowable.engine.impl.AbstractQuery;
import org.flowable.engine.impl.TaskQueryProperty;
import org.flowable.engine.impl.interceptor.CommandContext;

/**
 * @author Bassam Al-Sarori
 * 
 */
public class CustomTaskQuery extends AbstractQuery<CustomTaskQuery, CustomTask> {

  private static final long serialVersionUID = 1L;

  protected boolean unOwned;
  protected String taskId;
  protected String owner;

  public CustomTaskQuery(ManagementService managementService) {
    super(managementService);
  }

  public CustomTaskQuery taskId(String taskId) {
    this.taskId = taskId;
    return this;
  }

  public CustomTaskQuery taskOwner(String owner) {
    this.owner = owner;
    return this;
  }

  public CustomTaskQuery orderByTaskPriority() {
    return orderBy(TaskQueryProperty.PRIORITY);
  }

  public CustomTaskQuery unOwned() {
    unOwned = true;
    return this;
  }

  public boolean getUnOwned() {
    return unOwned;
  }

  @SuppressWarnings("unchecked")
  public List<CustomTask> executeList(CommandContext commandContext, Page page) {
    return commandContext.getDbSqlSession().selectList("selectCustomTaskByQueryCriteria", this);
  }

  public long executeCount(CommandContext commandContext) {
    return (Long) commandContext.getDbSqlSession().selectOne("selectCustomTaskCountByQueryCriteria", this);
  }
}

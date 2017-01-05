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
package org.flowable.engine.impl.cmd;

import java.io.Serializable;
import java.util.List;

import org.flowable.engine.impl.interceptor.Command;
import org.flowable.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.persistence.entity.IdentityLinkEntity;
import org.flowable.engine.impl.persistence.entity.TaskEntity;
import org.flowable.engine.task.IdentityLink;
import org.flowable.engine.task.IdentityLinkType;

/**
 * @author Joram Barrez
 * @author Falko Menge
 */
public class GetIdentityLinksForTaskCmd implements Command<List<IdentityLink>>, Serializable {

  private static final long serialVersionUID = 1L;
  protected String taskId;

  public GetIdentityLinksForTaskCmd(String taskId) {
    this.taskId = taskId;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<IdentityLink> execute(CommandContext commandContext) {
    TaskEntity task = commandContext.getTaskEntityManager().findById(taskId);

    return (List) task.getIdentityLinks();
  }

}

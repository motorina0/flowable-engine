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
package org.flowable.rest.dmn.service.api.repository;

import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.flowable.dmn.api.DecisionTable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yvo Swillens
 */
@RestController
@Api(tags = { "Decision Tables" }, description = "Manage Decision Tables")
public class DecisionTableResourceDataResource extends BaseDecisionTableResource {

  @ApiOperation(value = "Get a decision table resource content", tags = {"Decision Tables"})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Indicates both decision table and resource have been found and the resource data has been returned."),
      @ApiResponse(code = 404, message = "Indicates the requested decision table was not found or there is no resource with the given id present in the decision table. The status-description contains additional information.")
  })
  @RequestMapping(value = "/dmn-repository/decision-tables/{decisionTableId}/resourcedata", method = RequestMethod.GET, produces = "application/json")
  public byte[] getDecisionTableResource(@ApiParam(name = "decisionTableId") @PathVariable String decisionTableId, HttpServletResponse response) {
    DecisionTable decisionTable = geDecisionTableFromRequest(decisionTableId);
    return getDeploymentResourceData(decisionTable.getDeploymentId(), decisionTable.getResourceName(), response);
  }
}

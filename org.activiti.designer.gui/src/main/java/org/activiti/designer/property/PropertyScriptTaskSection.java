/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.designer.property;

import org.activiti.bpmn.model.ScriptTask;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class PropertyScriptTaskSection extends ActivitiPropertySection implements ITabbedPropertyConstants {

	private Combo scriptFormatCombo;
	private String[] scriptFormats = new String[] {"javascript", "groovy"};
	private Text scriptText;
	
	@Override
  public void createFormControls(TabbedPropertySheetPage aTabbedPropertySheetPage) {
	  scriptFormatCombo = createCombobox(scriptFormats, 0);
    createLabel("Script language", scriptFormatCombo);
    scriptText = createTextControl(true);
    createLabel("Script", scriptText);
  }

  @Override
  protected Object getModelValueForControl(Control control, Object businessObject) {
    ScriptTask task = (ScriptTask) businessObject;
    if (control == scriptFormatCombo) {
      return task.getScriptFormat();
      
    } else if (control == scriptText) {
      return task.getScript();
    }
    return null;
  }

  @Override
  protected void storeValueInModel(Control control, Object businessObject) {
    ScriptTask task = (ScriptTask) businessObject;
    if (control == scriptFormatCombo) {
      task.setScriptFormat(scriptFormats[scriptFormatCombo.getSelectionIndex()]);
      
    } else if (control == scriptText) {
      task.setScript(scriptText.getText());
    }
  }
}
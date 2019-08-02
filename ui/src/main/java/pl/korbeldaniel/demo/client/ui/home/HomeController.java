package pl.korbeldaniel.demo.client.ui.home;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import java.lang.String;
import pl.korbeldaniel.demo.client.DemoContext;
import pl.korbeldaniel.demo.client.event.StatusChangeEvent;
import pl.korbeldaniel.demo.client.model.MyModel;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 *
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
@Controller(
    route = "/application/",
    selector = "content",
    componentInterface = IHomeComponent.class,
    component = HomeComponent.class
)
public class HomeController extends AbstractComponentController<DemoContext, IHomeComponent, HTMLElement> implements IHomeComponent.Controller {
  private MyModel model;

  public HomeController() {
  }

  @Override
  public void start() {
    // Here we simulate the creation of a model.
    // In the real world we would do a server call or
    // something else to get the data.
    model = new MyModel("This value is set using the edit method! The value is >>" + "Home" + "<<");
    // 
    // now, move the data out of the model into the widgets - that's what we do next
    component.edit(model);
    // update the statusbar at the bottom of the screen
    eventBus.fireEvent(new StatusChangeEvent("active screen: >>Home<<"));
  }

  /**
   * The mayStop method will be called by the framework in
   * case a navigation event occured.
   *
   * It is up to this method to decide if the navigation event
   * will be executed or not.
   *
   * this is a good place to validate the entered data and
   * move it into the model.
   */
  @Override
  public String mayStop() {
    // check if there are changes
    if (component.isDirty()) {
      // are you sure? :-)
      if (DomGlobal.window.confirm("Do you really want to cancel?")) {
        // ok, but before, we check the entered data (type safety and required fields)
        if (component.isValid()) {
          // move the data into the model
          component.flush(model);
          // navigate!
          return null;
        } else {
          return "Please correct the error!";
        }
      }
    } else {
      return null;
    }
    return null;
  }
}

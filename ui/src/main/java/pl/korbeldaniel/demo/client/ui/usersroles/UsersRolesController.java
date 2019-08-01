package pl.korbeldaniel.demo.client.ui.usersroles;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;
import java.lang.Override;
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
    route = "/application/users/roles",
    selector = "content",
    componentInterface = IUsersRolesComponent.class,
    component = UsersRolesComponent.class
)
public class UsersRolesController extends AbstractComponentController<DemoContext, IUsersRolesComponent, HTMLElement> implements IUsersRolesComponent.Controller {
  private MyModel model;

  public UsersRolesController() {
  }

  @Override
  public void start() {
    // Here we simulate the creation of a model.
    // In the real world we would do a server call or
    // something else to get the data.
    model = new MyModel("This value is set using the edit method! The value is >>" + "UsersRoles" + "<<");
    // 
    // now, move the data out of the model into the widgets - that's what we do next
    component.edit(model);
    // update the statusbar at the bottom of the screen
    eventBus.fireEvent(new StatusChangeEvent("active screen: >>UsersRoles<<"));
  }
}

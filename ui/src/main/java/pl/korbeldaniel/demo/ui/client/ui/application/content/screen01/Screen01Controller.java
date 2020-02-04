package pl.korbeldaniel.demo.ui.client.ui.application.content.screen01;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;
import java.lang.Override;

import pl.korbeldaniel.demo.ui.client.MyModel;
import pl.korbeldaniel.demo.ui.client.UiContext;
import pl.korbeldaniel.demo.ui.client.event.StatusChangeEvent;


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
    route = "/application/screen01",
    selector = "content",
    componentInterface = IScreen01Component.class,
    component = Screen01Component.class
)
public class Screen01Controller extends AbstractComponentController<UiContext, IScreen01Component, HTMLElement> implements IScreen01Component.Controller {
  private MyModel model;

  public Screen01Controller() {
  }

  @Override
  public void start() {
    // Here we simulate the creation of a model.
    // In the real world we would do a server call or
    // something else to get the data.
    model = new MyModel("This value is set using the edit method! The value is >>" + "Screen01" + "<<  ??");

    //
    // now, move the data out of the model into the widgets - that's what we do next
    component.edit(model);
    // update the statusbar at the bottom of the screen
    eventBus.fireEvent(new StatusChangeEvent("active screen: >>Screen01<<"));
  }
}

package pl.korbeldaniel.demo.client.ui.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;
import java.lang.Override;
import java.lang.String;
import pl.korbeldaniel.demo.client.DemoContext;

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
    selector = "navigation",
    componentInterface = INavigationComponent.class,
    component = NavigationComponent.class
)
public class NavigationController extends AbstractComponentController<DemoContext, INavigationComponent, HTMLElement> implements INavigationComponent.Controller {
  public NavigationController() {
  }

  @Override
  public void doNavigateTo(String target) {
    switch (target) {
      case "/":
      router.route("/application/");
      break;
      case "users":
      router.route("/application/users");
      break;
      case "users/roles":
      router.route("/application/users/roles");
      break;
    }
  }
}

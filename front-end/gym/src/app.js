import { render, page } from "./lib.js";
import { homePage } from "./view/home.js";
import { registerPage } from "./view/register.js";

const root = document.querySelector("#root");

page(decorateContext);
page("/", homePage);
page("/register", registerPage);
page("/login", () => console.log("login page"));
page("/basket", () => console.log("basket page"));

page.start();

function decorateContext(ctx, next) {
  ctx.render = (content) => render(content, root);

  next();
}

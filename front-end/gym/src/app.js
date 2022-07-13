import { logout } from "./api/api.js";
import { render, page } from "./lib.js";
import { getUserData } from "./util.js";
import { homePage } from "./view/home.js";
import { loginPage } from "./view/login.js";
import { registerPage } from "./view/register.js";

const root = document.querySelector("#root");
document.getElementById("logoutBtn").addEventListener("click", onLogout);

page(decorateContext);
page("/", homePage);
page("/register", registerPage);
page("/login", loginPage);
page("/basket", () => console.log("basket page"));

updateUserNav();
page.start();

function decorateContext(ctx, next) {
  ctx.render = (content) => render(content, root);
  ctx.updateUserNav = updateUserNav;

  next();
}

function updateUserNav() {
  const userData = getUserData();

  //TODO: Code the logic for admin later on... Till now I have only for user and guest

  if (userData) {
    document.querySelector(".navigation--user").style.display = "block";
    document.querySelector(".navigation--guest").style.display = "none";
  } else {
    document.querySelector(".navigation--user").style.display = "none";
    document.querySelector(".navigation--guest").style.display = "block";
  }
}

async function onLogout() {
  logout();
  updateUserNav();
  page.redirect("/");
}

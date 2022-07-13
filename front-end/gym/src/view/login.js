import { html } from "../lib.js";
import { createSubmitHandler } from "../util.js";

const loginTemplate = () => html`
  <section id="hero">
    <img src="/imgs/hero.jpg" class="img--bg" alt="Background poster" />

    <form @submit=${onSubmit} class="hero__form--login">
      <h1 class="hero__form--login__title">Sign In</h1>

      <label for="username"></label>
      <input
        class="hero__form--login__field"
        type="text"
        name="username"
        placeholder="Username"
        value=""
      />

      <label for="password"></label>
      <input
        class="hero__form--login__field"
        type="password"
        name="password"
        placeholder="Password"
        value=""
      />

      <button type="submit" class="hero__login--submit btn">Submit</button>
    </form>
    <p class="hero__login--register">
      New to Krastev's Gym? <a href="/register">Sign up now.</a>
    </p>
  </section>

  <div class="divider"></div>
`;

export function loginPage(ctx) {
  ctx.render(
    loginTemplate(createSubmitHandler(onSubmit, "username", "password"))
  );

  async function onSubmit(data) {
    await login(data.email, data.password);

    ctx.updateUserNav();
    ctx.page.redirect("/");
  }
}

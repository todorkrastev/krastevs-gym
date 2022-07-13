import { html } from "../lib.js";
import { createSubmitHandler } from "../util.js";

const loginTemplate = () => html`
  <section id="hero">
    <img src="/imgs/hero.jpg" class="img--bg" alt="Background poster" />

    <form @submit=${(onSubmit, errorMsg, username)} class="hero__form--login">
      <h1 class="hero__form--login__title">Sign In</h1>

      ${errorMsg ? html`<p class="error--msg">${errorMsg}</p>` : null}

      <label for="username"></label>
      <input
        class="hero__form--login__field"
        type="text"
        name="username"
        placeholder="Username"
        .values=${username}
      />

      <label for="password"></label>
      <input
        class="hero__form--login__field"
        type="password"
        name="password"
        placeholder="Password"
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
  update();

  function update(errorMsg = "", username = "") {
    ctx.render(
      loginTemplate(
        createSubmitHandler(onSubmit, "username", "password"),
        errorMsg,
        username
      )
    );
  }

  async function onSubmit(data) {
    try {
      await login(data.username, data.password);

      ctx.updateUserNav();
      ctx.page.redirect("/");
    } catch (err) {
      // The errors that are sent from the server do not have field error, the errors have field message
      // The procedure for the form is vice versa
      const message = err.message || err.error.message;
      update(message, data.username);
    }
  }
}

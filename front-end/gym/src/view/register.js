import { html } from "../lib.js";
import { createSubmitHandler } from "../util.js";

const registerTemplate = (onSubmit, errors, values) => html`
  <section id="hero">
    <img src="/imgs/hero.jpg" class="img--bg" alt="Background poster" />

    <form @submit=${onSubmit} class="hero__form--register">
      <h1 class="hero__form--register__title">Register</h1>
      <label for="username"></label>
      <input
        class="hero__form--register__field"
        type="text"
        name="username"
        placeholder="Username"
        .value=${values.username}
      />
      <label for="email"></label>
      <input
        class="hero__form--register__field"
        type="email"
        name="email"
        placeholder="Email"
        .value=${values.email}
      />
      <label for="password"></label>
      <input
        class="hero__form--register__field"
        type="password"
        name="password"
        placeholder="Password"
        .value=${values.password}
      />
      <label for="repeatPassword"></label>
      <input
        class="hero__form--register__field"
        type="password"
        name="repeatPassword"
        placeholder="Repeat Password"
        .value=${values.repeatPassword}
      />
      <button type="submit" class="hero__register--submit btn">Submit</button>
    </form>
    <p class="hero__register--terms">
      By creating an account you agree to our
      <a href="/termsandprivacy">Terms & Privacy.</a>
    </p>
    <p class="hero__register--login">
      Already have an account? <a href="/login">Sign in.</a>
    </p>
  </section>

  <div class="divider"></div>
`;

export function registerPage(ctx) {
  ctx.render(
    registerTemplate(
      createSubmitHandler(
        onSubmit,
        "username",
        "email",
        "password",
        "repeatPassword"
      )
    )
  );

  async function onSubmit(data) {}
}

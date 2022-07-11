import { html } from "../lib.js";

const loginTemplate = () => html`
  <section id="hero">
    <img src="/imgs/hero.jpg" class="img--bg" alt="Background poster" />

    <form method="POST" class="hero__form--login">
      <h1 class="hero__form--login__title">Sign In</h1>

      <input
        name="username"
        class="hero__form--login__field"
        placeholder="Username"
        type="text"
        minlength="1"
        maxlength="50"
        required
        value=""
      />

      <input
        name="password"
        class="hero__form--login__field"
        placeholder="Password"
        type="password"
        minlength="6"
        maxlength="62"
        required
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
  ctx.render(loginTemplate());
}
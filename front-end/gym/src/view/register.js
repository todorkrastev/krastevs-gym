import { html } from "../lib.js";

const registerTemplate = () => html`
  <section id="hero">
    <img src="/imgs/hero.jpg" class="img--bg" alt="Background poster" />

    <form method="POST" class="hero__form--register">
      <h1 class="hero__form--register__title">Register</h1>
      <input
        name="email"
        class="hero__form--register__field"
        placeholder="Email"
        type="email"
        minlength="5"
        maxlength="50"
        required
        value=""
      />
      <input
        name="password"
        class="hero__form--register__field"
        placeholder="Password"
        type="password"
        minlength="6"
        maxlength="62"
        required
        value=""
      />
      <input
        name="password"
        class="hero__form--register__field"
        placeholder="Repeat Password"
        type="password"
        minlength="6"
        maxlength="62"
        required
        value=""
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
  ctx.render(registerTemplate());
}

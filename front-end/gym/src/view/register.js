import { register } from "../api/api.js";
import { input } from "../common/input.js";
import { html } from "../lib.js";
import { createSubmitHandler } from "../util.js";

const registerTemplate = (onSubmit, errorMsg, errors, values) => html`
  <section id="hero">
    <img src="/imgs/hero.jpg" class="img--bg" alt="Background poster" />

    <form @submit=${onSubmit} class="hero__form--register">
      <h1 class="hero__form--register__title">Register</h1>
      ${errorMsg ? html`<p class="error--msg">${errorMsg}</p>` : null}
      ${input(
        "username",
        "hero__form--register__field",
        "text",
        "username",
        "Username",
        values.username,
        errors.username
      )}
      <!-- <label for="username"></label>
      <input
        class="hero__form--register__field"
        type="text"
        name="username"
        placeholder="Username"
        .value=${values.username}
      /> -->
      ${input(
        "email",
        "hero__form--register__field",
        "email",
        "email",
        "Email",
        values.email,
        errors.email
      )}
      <!-- <label for="email"></label>
      <input
        class="hero__form--register__field"
        type="email"
        name="email"
        placeholder="Email"
        .value=${values.email}
      /> -->
      ${input(
        "password",
        "hero__form--register__field",
        "password",
        "password",
        "Password",
        values.password,
        errors.password
      )}
      <!-- <label for="password"></label>
      <input
        class="hero__form--register__field"
        type="password"
        name="password"
        placeholder="Password"
        .value=${values.password}
      /> -->
      ${input(
        "repeatPassword",
        "hero__form--register__field",
        "password",
        "repeatPassword",
        "Repeat Password",
        values.repeatPassword,
        errors.repeatPassword
      )}
      <label for="repeatPassword"></label>
      <!-- <input
        class="hero__form--register__field"
        type="password"
        name="repeatPassword"
        placeholder="Repeat Password"
        .value=${values.repeatPassword}
      /> -->
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
  update();

  // check functionality of class error in css -> styles -> components

  function update(errorMsg, errors = {}, values = {}) {
    ctx.render(
      registerTemplate(
        createSubmitHandler(
          onSubmit,
          "username",
          "email",
          "password",
          "repeatPassword"
        ),
        errorMsg,
        errors,
        values
      )
    );
  }

  async function onSubmit(data, event) {
    try {
      const missing = Object.entries(data).filter(([k, v]) => v == "");
      if (missing.length > 0) {
        const errors = missing.reduce(
          (a, [k]) => Object.assign(a, { [k]: true }),
          {}
        );
        throw {
          error: new Error("All fields are required!"),
          errors,
        };
      }
      if (data.password != data.repeatPassword) {
        throw {
          error: new Error("Passwords do not match!"),
          errors: {
            password: true,
            repeatPassword: true,
          },
        };
      }

      await register(data.username, data.email, data.password);
      event.target.reset();
      ctx.updateUserNav();
      ctx.page.redirect("/");
    } catch (err) {
      // The errors that are sent from the server do not have field error, the errors have field message
      // The procedure for the form is vice versa
      const message = err.message || err.error.message;
      update(message, err.errors, data);
    }
  }
}

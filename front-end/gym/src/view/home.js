import { html } from "../lib.js";

const homeTemplate = () => html`
  <section id="hero">
    <img src="/imgs/hero.jpg" class="img--bg" alt="Background poster" />

    <h1 class="hero__title">NO EXCUSES!</h1>
    <h2 class="hero__subtitle">GET FIT NOW</h2>

    <form class="hero__form" action="">
      <input
        type="email"
        name="email"
        class="form__input input"
        placeholder="Email address"
        minlength="5"
        maxlength="50"
      />
      <button href="/" class="form__btn btn">Free-trial day</button>
    </form>

    <p class="form__suffix">Only new members are eligible for this offer.</p>

    <a href="/register" class="member__btn btn"> Become a member </a>
  </section>

  <div class="divider"></div>

  <section class="info section">
    <div class="info__wrapper">
      <h2 class="info__title">Free Weights</h2>
      <p class="info__description">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil saepe
        deleniti ipsa dignissimos totam.
      </p>

      <div class="info__buttons">
        <button class="info__button edit">Edit</button>
        <button class="info__button delete">Delete</button>
      </div>
    </div>

    <img class="info__poster" src="/imgs/weights.jpg" alt="Section poster" />
  </section>

  <div class="divider"></div>
`;

export function homePage(ctx) {
  ctx.render(homeTemplate());
}

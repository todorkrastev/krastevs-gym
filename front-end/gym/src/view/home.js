import { getAllActivities } from "../api/data.js";
import { html, until } from "../lib.js";

const homeTemplate = (activitiesPromise) => html`
  <section id="hero">
    <img src="/imgs/hero.jpg" class="img--bg" alt="Background poster" />

    <h1 class="hero__title">NO EXCUSES!</h1>
    <h2 class="hero__subtitle">GET FIT NOW</h2>

    <form class="hero__form" action="">
      <label for="email"></label>
      <input
        class="form__input input"
        type="email"
        name="email"
        placeholder="Email address"
      />
      <button href="/" class="form__btn btn">Free-trial day</button>
    </form>

    <p class="form__suffix">Only new members are eligible for this offer.</p>

    <a href="/register" class="member__btn btn"> Become a member </a>
  </section>

  <div class="divider"></div>

  ${until(activitiesPromise, html`<p class="spinner">Loading &hellip;</p>`)}
`;

const activityPreviewCard = (activity) => html`
  <section class="info section">
    <div class="info__wrapper">
      <h2 class="info__title">${activity.title}</h2>
      <p class="info__description">${activity.shortDescription}</p>

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
  ctx.render(homeTemplate(loadActivities()));
}

async function loadActivities() {
  const activities = await getAllActivities();

  return activities.map(activityPreviewCard);
}

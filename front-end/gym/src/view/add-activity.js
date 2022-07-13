import { addActivity } from "../api/data.js";
import { input } from "../common/input.js";
import { html, classMap } from "../lib.js";
import { createSubmitHandler } from "../util.js";

const addActivityTemplate = (
  onSubmit,
  errorMsg,
  errors,
  values
) => html` <section id="hero">
    <img src="/imgs/hero.jpg" class="img--bg" alt="Background poster" />

    <h1 class="hero__form--add-activity__title">Add an Activity</h1>

    <form @submit=${onSubmit} class="hero__form--add-activity">
      ${errorMsg ? html`<p class="error--msg">${errorMsg}</p>` : null}
      ${input(
        "title",
        "hero__form--add-activity__field",
        "text",
        "title",
        "Title",
        values.title,
        errors.title
      )}
      <!-- <label for="title"></label>
      <input
        class="hero__form--add-activity__field"
        type="text"
        name="title"
        placeholder="Title"
        .value=${values.title}
      /> -->
      ${input(
        "description",
        "hero__form--add-activity__field textarea",
        "textarea",
        "description",
        "Description",
        values.description,
        errors.description
      )}
      <!-- <label for="description"></label>
      <textarea
        class="hero__form--add-activity__field textarea"
        type="textarea"
        name="description"
        placeholder="Description"
        rows="3"
        .value=${values.description}
      ></textarea> -->
      <div class="hero__form--add-activity__file__container">
        <label
          class="hero__form--add-activity__file__container file title"
          for="file"
          >Choose picture to upload</label
        >
        <input
          class="hero__form--add-activity__file__container file btn"
          class=${classMap({ error: hasError })}
          type="file"
          id="file"
          name="file"
          multiple
          .value=${values.picture}
        />
      </div>

      <div class="hero__form--add-activity__divider"></div>

      <button type="submit" class="hero__add-activity--submit btn">
        Submit
      </button>
    </form>
  </section>

  <div class="divider"></div>`;

export function addActivityPage(ctx) {
  update();

  function update(errorMsg = "", errors = {}, values = {}) {
    ctx.render(
      addActivityTemplate(
        createSubmitHandler(onSubmit, "title", "description", "file"),
        errorMsg,
        errors,
        values
      )
    );
  }

  async function onSubmit(data) {
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

      // const result = await addActivity(data);
      // ctx.page.redirect("/activities/" + result._id);

      ctx.page.redirect("/");
    } catch (err) {
      // The errors that are sent from the server do not have field error, the errors have field message
      // The procedure for the form is vice versa
      const message = err.message || err.error.message;
      update(message, err.errors, data);
    }
  }
}

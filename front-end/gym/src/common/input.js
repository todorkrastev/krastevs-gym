import { html } from "../lib.js";

export const input = (label, type, value, hasError) => html`
  <label for=${label}></label>
  <input
    class="hero__form--register__field"
    type=${type}
    name="username"
    placeholder="Username"
    .value=${values.username}
  />
`;

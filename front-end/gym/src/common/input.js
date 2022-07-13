import { html, classMap } from "../lib.js";

// may be the code below will not work properly
//  <label for=${label}></label>
// check when the back-end server is ready to use

export const input = (
  label,
  clazz,
  type,
  name,
  placeholder,
  value = "",
  hasError
) => html`
  <label for=${label} class=${classMap({ error: hasError })}></label>
  <input
    class=${clazz}
    type=${type}
    name=${name}
    placeholder=${placeholder}
    .value=${value.username}
  />
`;

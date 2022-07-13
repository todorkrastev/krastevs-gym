import * as api from "./api.js";

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

const endpoints = {
  activities: "/",
  addActivity: "/activities/add",
};

export async function getAllActivities() {
  return api.get(endpoints.activities);
}

export async function addActivity(activity) {
  return api.post(endpoints.addActivity, activity);
}

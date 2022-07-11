import * as api from './api.js';

export async function getAllActivities() {
    return api.get('/activities');
}
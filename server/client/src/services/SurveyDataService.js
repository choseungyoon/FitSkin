import http from "../http-common";

class SurveyDataService {
  getForm() {
    return http.get("/survey/form");
  }

  insertResult(data) {
    return http.post("/survey/result", { result: data });
  }

  getResult(data) {
    return http.get(`/survey/result?id=${data}`);
  }
}

export default new SurveyDataService();

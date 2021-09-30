import http from "../http-common";

class SurveyDataService {
  getForm() {
    return http.get("/survey/form");
  }

  getResult(data) {
    return http.post("/survey/result", { result: data });
  }
}

export default new SurveyDataService();

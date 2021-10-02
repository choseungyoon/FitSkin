import http from "../http-common";

class SurveyDataService {
  getForm() {
    return http.get("/survey/form");
  }

  insertResult(data, email) {
    return http.post("/survey/result", { result: data, user: email });
  }

  getResult(data) {
    return http.get(`/survey/result?id=${data}`);
  }

  getAllResult(data) {
    return http.get(`/survey/result/all?email=${data}`);
  }
}

export default new SurveyDataService();
